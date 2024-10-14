/*****************************************************************************
 * Name: BSD Project 24/09/23
 * File: Picture.kt
 * Author: Huck Kim , taehyuck.kim@brique.co.kr
 *
 * Description: data class to receive id from client : HTTP POST method
 *
 *******************************************************************************/

package com.example.data

import kotlinx.serialization.Serializable

@Serializable
data class PictureReq(val pictureId: Int)
