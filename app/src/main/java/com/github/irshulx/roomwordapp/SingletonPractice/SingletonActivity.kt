package com.github.irshulx.roomwordapp.SingletonPractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStore
import com.github.irshulx.roomwordapp.R
import com.github.irshulx.roomwordapp.SingletonPractice.models.ExampleSingleton
import com.github.irshulx.roomwordapp.SingletonPractice.viewmodel.SingletonPracticeViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class SingletonActivity : AppCompatActivity() {
    private lateinit var singletonPracticeViewModel: SingletonPracticeViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_singleton)
        val singleton =
            ExampleSingleton.userSingleton
        println("DEBUG ${singleton}")

        singletonPracticeViewModel = ViewModelProvider(this).get(SingletonPracticeViewModel::class.java)
        singletonPracticeViewModel.user.observe(this, Observer {
            print("DEBUG ${it}")
        })

        val parentJob = CoroutineScope(IO).launch {

        }

        singletonPracticeViewModel.setUserId("1")
    }

    override fun onDestroy() {
        super.onDestroy()
        singletonPracticeViewModel.cancelJobs()
    }
}