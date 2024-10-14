/*****************************************************************************
 * Name: BSD Project 24/09/23
 * File: NatureRoute.kt
 * Author: Huck Kim , taehyuck.kim@brique.co.kr
 *
 * Description: Define Route.extension function design : interface : Route Class
 * Add the design extension Route.fdc(), Route.be() etc.... and calls it in Routing.kt
 *******************************************************************************/

package com.example.routes

import com.example.data.Picture
import com.example.data.PictureReq
import io.ktor.http.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

private const val BASE_URL = "http://192.168.0.28:4040"

// add extension function to Route Class

fun Route.naturePicture() {
    get("/picture") {
        //Read param
        val id = call.parameters["id"] ?: "-1"

        // Generation of Picture object to send client
        val pictureData = getPictureData(Integer.parseInt(id))
        if (pictureData == null) {
            // 404 error with No object
            //  call.respond(HttpStatusCode.BadRequest)
            call.response.status(HttpStatusCode.BadRequest)
        } else {
            // response according to object
            // call.respond(HttpStatusCode.OK, pictureData)
            call.respond(HttpStatusCode.OK, mapOf("data" to pictureData))
        }
    }
    post(path = "/picture") {
        // getting body
        val pictureRequest = call.receive<PictureReq>()

        val pictureData = getPictureData(pictureRequest.pictureId)
        if (pictureData == null) {
            call.respond(HttpStatusCode.BadRequest)
        } else {
            call.respond(HttpStatusCode.OK, pictureData)
        }
    }
}

private fun getPictureData(id: Int): Picture? {
    return when (id) {
        0 -> Picture("Beautiful nature", "No address!!", "$BASE_URL/nature/nature1.jpg")
        1 -> Picture("Beautiful nature", "Forest", "$BASE_URL/nature/nature2.jpg")
        2 -> Picture("Beautiful nature", " Trees ", "$BASE_URL/nature/nature3.jpg")
        3 -> Picture("Beautiful nature", " Twilight ", "$BASE_URL/nature/nature4.jpg")
        4 -> Picture("Beautiful nature", " Twilight ", "$BASE_URL/nature/nature5.jpg")
        else -> null
    }
}

val a = listOf("a", 1)