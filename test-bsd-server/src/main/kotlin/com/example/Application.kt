package com.example

import com.example.plugins.*
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*

//HK_0923_start_setting

fun main() {
    embeddedServer(
        Netty,
        port = 4040, // This is the port on which Ktor is listening
        host = "192.168.0.33",
        module = Application::module
    ).start(wait = true)
}
/*
fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}
*/
fun Application.module() {
    configureSerialization()
    configureMonitoring()
    configureHTTP()
    configureSecurity()
    configureRouting()
}
