package com.github.irshulx.roomwordapp.SingletonPractice.repository

import androidx.lifecycle.LiveData
import com.github.irshulx.roomwordapp.SingletonPractice.api.MyRetrofitBuilder
import com.github.irshulx.roomwordapp.SingletonPractice.models.User
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main

object SingletonPracticeRepository {
    var job: CompletableJob ? = null
    fun getUser(userId:String):LiveData<User> {
        job = Job()

        return object : LiveData<User>() {
            override fun onActive() {
                super.onActive()
                job?.let {
                    CoroutineScope(IO + it).launch {
                        val user = MyRetrofitBuilder.apiService.getUser(userId)
                        withContext(Main) {
                            value = user
                            it.complete()
                        }
                    }
                }
            }
        }
    }

    fun cancelJobs(job:Job?) {
        job?.cancel()
    }
}