/*****************************************************************************
 * Name: BSD Project 24/09/23
 * File: Serialization.kt
 * Author: Huck Kim , taehyuck.kim@brique.co.kr
 *
 * Description: For use json format between Server and client Restful API  : Content nego.
 *
 *******************************************************************************/

package com.example.plugins

import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureSerialization() {
    install(ContentNegotiation) {
        json()
    }
    routing {
        get("/json/kotlinx-serialization") {
                call.respond(mapOf("hello" to "world"))
            }
    }
}
