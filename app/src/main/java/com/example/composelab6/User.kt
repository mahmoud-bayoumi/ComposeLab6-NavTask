package com.example.composelab6

import kotlinx.serialization.Serializable

@Serializable
data class User(
    val username: String,
    val password: String
)