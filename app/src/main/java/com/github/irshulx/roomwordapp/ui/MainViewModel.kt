package com.github.irshulx.roomwordapp.ui

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.github.irshulx.roomwordapp.model.Blog
import com.github.irshulx.roomwordapp.repository.MainRepository
import com.github.irshulx.roomwordapp.utils.DataState
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch


class MainViewModel @ViewModelInject constructor(
    private val mainRepository: MainRepository,
    @Assisted private val savedStateHandle: SavedStateHandle): ViewModel(){
    private val _dataState: MutableLiveData<DataState<List<Blog>>> = MutableLiveData()
    val dataState: LiveData<DataState<List<Blog>>>
        get() = _dataState

    fun setStateEvent(mainStateEvent: MainStateEvent) {
        viewModelScope.launch {
            when(mainStateEvent) {
                is MainStateEvent.getBlogEvents ->
                    mainRepository.getBlogs().onEach {
                        _dataState.value = it
                    }.launchIn(viewModelScope)

            is MainStateEvent.None -> {
                //not using
            }
            }
        }
    }
}

sealed class MainStateEvent {
    object  getBlogEvents: MainStateEvent()
    object  None : MainStateEvent()
}