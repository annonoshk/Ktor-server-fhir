/*****************************************************************************
 * Name: BSD Project 24/09/23
 * File: BeTemp.kt
 * Author: Huck Kim , taehyuck.kim@brique.co.kr
 *
 * Description: Define data class for be
 *
 *******************************************************************************/

package com.example.data
import kotlinx.serialization.Serializable

@Serializable
data class FdcTemp(val temp1: String, val temp2: String)