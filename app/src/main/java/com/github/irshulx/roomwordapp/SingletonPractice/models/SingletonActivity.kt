package com.github.irshulx.roomwordapp.SingletonPractice.models

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.irshulx.roomwordapp.R

class SingletonActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_singleton)
        val singleton = ExampleSingleton.userSingleton
        println("DEBUG ${singleton}")
    }
}