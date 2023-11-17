package com.discordtime.whatudoing

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class MainViewModel : ViewModel() {
    private val _state = MutableStateFlow(StateUI())
    val state = _state.asStateFlow()

    fun setState(newState : StateUI){
        _state.update {newState}
    }
}

data class StateUI(
    val name: String = "Fulano",
    val age: Int = 0,
    val motherName: String = "Fulana"
)
