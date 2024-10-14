/*****************************************************************************
 * Name: BSD Project 24/09/23
 * File: Monitoring.kt
 * Author: Huck Kim , taehyuck.kim@brique.co.kr
 *
 * Description: Logging req from client : Call logging
 *
 *******************************************************************************/
package com.example.plugins

import io.ktor.server.application.*
import io.ktor.server.plugins.calllogging.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.slf4j.event.*

fun Application.configureMonitoring() {
    install(CallLogging) {
        level = Level.INFO
        filter { call -> call.request.path().startsWith("/") }
    }
}
