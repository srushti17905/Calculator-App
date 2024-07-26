package com.example.firstapp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform