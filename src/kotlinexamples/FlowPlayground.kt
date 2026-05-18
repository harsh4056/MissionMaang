package kotlinexamples

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

class FlowPlayground {

    // 🔹 1. Basic Flow
    fun simpleFlow(): Flow<Int> = flow {
        for (i in 1..5) {
            delay(500)
            println("Emitting $i on ${Thread.currentThread().name}")
            emit(i)
        }
    }

    // 🔹 2. Flow with operators
    fun transformedFlow(): Flow<String> {
        return simpleFlow()
            .filter { it % 2 == 0 }
            .map { "Number $it" }

    }

    // 🔹 3. FlowOn (change upstream thread)
    fun flowWithContext(): Flow<Int> {
        return flow {
            emit(1)
            emit(2)
        }.flowOn(Dispatchers.IO)
    }

    // 🔹 4. Buffer (parallel processing)
    fun bufferedFlow(): Flow<Int> {
        return simpleFlow()
            .buffer()
            .map {
                delay(1000) // simulate slow consumer
                it * 2
            }
    }

    // 🔹 5. Combine two flows
    fun combinedFlow(): Flow<String> {
        val flow1 = flow {
            emit("A")
            delay(500)
            emit("B")
        }

        val flow2 = flow {
            delay(300)
            emit(1)
            delay(500)
            emit(2)
        }

        return flow1.combine(flow2) { a, b ->
            "$a$b"
        }
    }

    // 🔹 6. StateFlow (holds latest value)
    val stateFlow = MutableStateFlow(0)

    fun updateStateFlow() = CoroutineScope(Dispatchers.Default).launch {
        for (i in 1..5) {
            delay(300)
            stateFlow.value = i
        }
    }

    // 🔹 7. SharedFlow (event based)
    val sharedFlow = MutableSharedFlow<String>()

    fun emitSharedFlow() = CoroutineScope(Dispatchers.Default).launch {
        listOf("One", "Two", "Three").forEach {
            delay(400)
            sharedFlow.emit(it)
        }
    }
}

fun main() = runBlocking {
    val playground = FlowPlayground()

    /*println("==== Simple Flow ====")
    playground.simpleFlow().collect {
        println("Collected $it on ${Thread.currentThread().name}")
    }

    println("\n==== Transformed Flow ====")
    playground.transformedFlow().collect {
        println(it)
    }*/

    println("\n==== Buffered Flow ====")
    playground.bufferedFlow().collect {
        println("Buffered result $it")
    }

   /* println("\n==== Combined Flow ====")
    playground.combinedFlow().collect {
        println("Combined: $it")
    }*/
    flow {
        println("Emit on: ${Thread.currentThread().name}")
        emit(1)
    }
        .flowOn(Dispatchers.IO)
        .collect {
            println("Collect $it on: ${Thread.currentThread().name}")
        }
    println("\n==== StateFlow ====")
    val job1 = launch {
        playground.stateFlow.collect {
            println("StateFlow: $it")
        }
    }
    playground.updateStateFlow()
    delay(2000)
    job1.cancel()

    println("\n==== SharedFlow ====")
    val job2 = launch {
        playground.sharedFlow.collect {
            println("SharedFlow: $it")
        }
    }
    playground.emitSharedFlow()
    delay(2000)
    job2.cancel()
}