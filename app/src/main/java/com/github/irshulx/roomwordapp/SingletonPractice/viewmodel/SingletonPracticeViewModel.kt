package com.github.irshulx.roomwordapp.SingletonPractice.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.github.irshulx.roomwordapp.MVIBlogs.DI.RepositoryModule
import com.github.irshulx.roomwordapp.SingletonPractice.models.User
import com.github.irshulx.roomwordapp.SingletonPractice.repository.SingletonPracticeRepository

class SingletonPracticeViewModel:ViewModel() {
    private val _userId:MutableLiveData<String> = MutableLiveData()
    val user : LiveData<User> = Transformations.switchMap(_userId){
        SingletonPracticeRepository.getUser(it)
    }

    fun setUserId(userId:String) {
        val update = userId
        if(_userId.value != update){
            _userId.value = update
        }
    }

    fun cancelJobs() {
        SingletonPracticeRepository.cancelJobs()
    }
}