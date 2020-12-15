package com.github.irshulx.roomwordapp.SingletonPractice.models

object ExampleSingleton {
    val userSingleton : User by lazy {
        User("irshu@outlook.com","irshu","thumb.png")
    }
}