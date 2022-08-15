package uz.gita.bonusapp.presentation.ui.viewmodel.impl

import androidx.lifecycle.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import uz.gita.bonusapp.presentation.ui.viewmodel.SplashScreenViewModel

class SplashScreenViewModelImpl:SplashScreenViewModel, ViewModel() {

    override val splashLiveData: MutableLiveData<Unit> = MutableLiveData()

    init {
        viewModelScope.launch {
            delay(2000)
            splashLiveData.value = Unit
        }
    }
}