package kotlinexamples

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

class ReifiedPlayground {
    data class User(val name: String)
    companion object {

        // 1. Type check
        inline fun <reified T> isType(value: Any): Boolean {
            return value is T
        }

        // 2. Safe cast
        inline fun <reified T> safeCast(value: Any): T? {
            return value as? T
        }

        // 3. Filter list by type
        inline fun <reified T> filterByType(list: List<Any>): List<T> {
            return list.filter { it is T }.map { it as T }
        }

        // 4. Print type info
        inline fun <reified T> printTypeInfo(value: T) {
            println("Value: $value, Type: ${T::class.simpleName}")
        }

        // 5. Fake parser
        inline fun <reified T> fakeParse(json: String): T {
            println("Parsing into: ${T::class.simpleName}")
            return when (T::class) {
                String::class -> json as T
                Int::class -> json.length as T
                else -> throw IllegalArgumentException("Unsupported type")
            }
        }

        inline fun <reified T> parse(json: String): T {
            println("Parsing into: ${T::class.simpleName}")

            return when (T::class) {
                User::class -> User(json) as T
                String::class -> json as T
                else -> throw IllegalArgumentException("Unsupported type")
            }
        }

        @JvmStatic
        fun main(args: Array<String>) {

            println("---- Example 1: isType ----")
            println(isType<String>("Hello"))  // true
            println(isType<Int>("Hello"))     // false

            println("\n---- Example 2: safeCast ----")
            val a = safeCast<String>("Kotlin")
            val b = safeCast<Int>("Kotlin")
            println(a)  // Kotlin
            println(b)  // null

            println("\n---- Example 3: filterByType ----")
            val items = listOf(1, "Hello", 2, "World", 3)
            val strings = filterByType<String>(items)
            val ints = filterByType<Int>(items)
            println(strings) // [Hello, World]
            println(ints)    // [1, 2, 3]

            println("\n---- Example 4: printTypeInfo ----")
            printTypeInfo("Hello")
            printTypeInfo(42)

            println("\n---- Example 5: fakeParse ----")
            val str: String = fakeParse("hello")
            val num: Int = fakeParse("hello")
            println(str) // hello
            println(num) // 5


            // 🔥 No <User> written explicitly
            val user: User = parse("Harsh")
            val user1: String = parse("Harsh")

            println(user) // User(name=Harsh)
            println(user1) // User(name=Harsh)


        }
    }






}