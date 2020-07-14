// This file was automatically generated from serialization-guide.md by Knit tool. Do not edit.
package kotlinx.serialization.example.exampleBuiltin05

import kotlinx.serialization.*
import kotlinx.serialization.json.*

// @Serializable annotation is not need for a enum classes
enum class Status { SUPPORTED }
        
@Serializable
class Repository(val name: String, val status: Status) 

fun main() {
    val data = Repository("kotlinx.serialization", Status.SUPPORTED)
    println(Json.encodeToString(data))
}