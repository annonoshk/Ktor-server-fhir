/*****************************************************************************
 * Name: BSD Project
 * File: Routing.kt
 * Author: Huck Kim , taehyuck.kim@brique.co.kr
 *
 * Description: Design Ktor based server routing functionality
 *
 *******************************************************************************/
package com.example.plugins

import com.example.data.PictureReq
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.http.content.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.server.plugins.statuspages.*
import com.example.routes.naturePicture
import io.ktor.server.request.*

fun Application.configureRouting() {
    install(StatusPages) {
        exception<IllegalStateException> { call, cause ->
            call.respondText("App in illegal state as ${cause.message}")
        }
    }
    routing {
        staticResources("/mycontent","mycontent")

        get("/") {
            call.respondText("Hello BSD !")
        }
        //Static plugin. Try to access `/static/index.html`
        static("/static") {
            resources("static")
        }
        get("/fdc") { //HK_240923_for_test
            val text = "<h1> FDC From BRIQUE </h1>"
            val type = ContentType.parse("text/html")
            call.respondText(text, type)
        }
        get("/be") { //HK_240923_for_test
            val text = "<h1> BE From BRIQUE </h1>"
            val type = ContentType.parse("text/html")
            call.respondText(text, type)
        }
        get("/picture") {
            naturePicture() //HK_240923_For_readability_define_extension_function_of_Route_class
        }
    }
}
