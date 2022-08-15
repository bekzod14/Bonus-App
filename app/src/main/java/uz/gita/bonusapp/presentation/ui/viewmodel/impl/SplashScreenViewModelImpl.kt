package uz.gita.bonusapp.presentation.ui.viewmodel.impl

import androidx.lifecycle.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import uz.gita.bonusapp.presentation.ui.viewmodel.SplashScreenViewModel
import uz.gita.bonusapp.repository.Repository

class SplashScreenViewModelImpl:SplashScreenViewModel, ViewModel() {

    private val repository=Repository
    override val openIntroductionScreenLiveData = MutableLiveData<Unit>()
    override val openMenuScreenLiveData = MutableLiveData<Unit>()

    init {
        viewModelScope.launch {
            delay(2000)
            if (repository.isFirst()){
                repository.secondOpen()
                openIntroductionScreenLiveData.value=Unit
            }
            else{
                openMenuScreenLiveData.value=Unit
            }
        }
    }
}