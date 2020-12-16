package com.github.irshulx.roomwordapp.Coroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.irshulx.roomwordapp.R
import kotlinx.android.synthetic.main.activity_coroutines.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CoroutinesActivity : AppCompatActivity() {
    private val RESULT_1 = "Result1"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coroutines)

        button.setOnClickListener {
            CoroutineScope(IO).launch {
                fakeApiRequest()
            }
        }
    }

    private fun setText(input:String) {
        val newText = text.text.toString() + "\n$input"
        text.text = newText
    }

    private suspend fun setTextOnMainThread(input: String) {
        withContext(Main) {
            setText(input)
        }
    }

    private suspend fun fakeApiRequest(){
        val result1 = getResult1FromApi()
        setTextOnMainThread(result1)
    }

    private suspend fun getResult1FromApi():String{
        logThread("getResult1FromApi")
        delay(1000)
        return RESULT_1
    }

    private suspend fun logThread(methodName:String){
        println("debug: ${methodName}: ${Thread.currentThread().name}")
    }


}