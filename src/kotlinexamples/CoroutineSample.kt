package kotlinexamples

import kotlinx.coroutines.*
import java.util.concurrent.Executors

class Coroutine {
    suspend fun callParallelly() =runBlocking {
        val r1 = async { api1() }
        val r2 = async { api2() }

        val result1 = r1.await()
        val result2 = r2.await()

    }


    suspend fun callParallelly2() =runBlocking {
        val r1 = launch { api1() }
        val r2 = launch { api2() }

        r1.join()
        r2.join()

    }

    suspend fun api1(): String {

        println("API1 start")
        println("Running in thread ${Thread.currentThread().name}")
        delay(1010)
        println("API1 end")
        return "result1"
    }

    suspend fun api2(): String {

        println("API2 start")
        println("Running in thread ${Thread.currentThread().name}")
        delay(1000)
        println("API2 end")
        return "result2"
    }
    suspend fun api3(): String{

        return "result3";
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>)=runBlocking {
            val call=Coroutine()
            call.callParallelly2()
            println("Done")






        }
    }
}

