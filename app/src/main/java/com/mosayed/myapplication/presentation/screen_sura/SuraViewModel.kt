package com.mosayed.myapplication.presentation.screen_sura

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mosayed.myapplication.domain.model.Sura
import com.mosayed.myapplication.domain.usecase.GetSuraListRemoteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class SuraViewModel @Inject constructor(
    private val getSuraListRemoteUseCase: GetSuraListRemoteUseCase,
) : ViewModel() {
    private val _state = MutableStateFlow(SuraUiState())
    val state = _state.asStateFlow()

    init {
        getDate()
    }

    private fun getDate() {
        viewModelScope.launch {
            try {
                _state.update { it.copy(isLoading = true) }
                val suraList = getSuraListRemoteUseCase()
                _state.update { it.copy(isLoading = false,suraList = suraList.toUiState()) }
            }catch (e: Exception){
                _state.update { it.copy(isLoading = false,error = e.message ?: "Unknown Error") }
            }
        }
    }
}

private fun List<Sura>.toUiState(): List<SuraUiState.SuraItem> {
    return map {
        SuraUiState.SuraItem(
            suraNumber = it.number,
            name = it.name,
            numberOfAyahs = it.numberOfAyahs,
            revelationType = it.revelationType
        )
    }
}