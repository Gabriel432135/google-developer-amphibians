package com.example.amphibians

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.amphibians.data.AmphibiansRepository
import com.example.amphibians.model.Amphibian
import kotlinx.coroutines.launch
import java.io.IOException

class AmphibiansViewModel(private val amphibiansRepository: AmphibiansRepository) : ViewModel() {
    sealed interface AmphibiansUiState {
        data class Success(val amphibians: List<Amphibian>) : AmphibiansUiState
        object Error : AmphibiansUiState
        object Loading : AmphibiansUiState
    }

    companion object{
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as AmphibiansApplication)
                val amphibiansRepository = application.container.amphibiansRepository
                AmphibiansViewModel(amphibiansRepository = amphibiansRepository)
            }
        }
    }

    var amphibiansUiState: AmphibiansUiState by mutableStateOf(AmphibiansUiState.Loading)
        private set

    init{
        getAmphibiansPictures()
    }

    fun getAmphibiansPictures() {
        viewModelScope.launch {
            amphibiansUiState = AmphibiansUiState.Loading
            amphibiansUiState = try {
                val list = amphibiansRepository.getAmphibians()
                AmphibiansUiState.Success(list)
            } catch (e: IOException) {
                AmphibiansUiState.Error
            }
        }
    }
}