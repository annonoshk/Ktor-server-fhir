/*****************************************************************************
 * Name: BSD Project 24/09/23
 * File: Picture.kt
 * Author: Huck Kim , taehyuck.kim@brique.co.kr
 *
 * Description: Picture class to send data to client : HTTP GET method
 *
 *******************************************************************************/

package com.example.data

import kotlinx.serialization.Serializable

@Serializable
data class Picture(
    val title: String,
    val location: String,
    val imageUrl: String,
)