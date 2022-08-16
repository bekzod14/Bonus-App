package uz.gita.bonusapp.presentation.impl

import androidx.lifecycle.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import uz.gita.bonusapp.presentation.SplashViewModel
import uz.gita.bonusapp.repository.IntroRepository
import uz.gita.bonusapp.repository.impl.IntroRepositoryImpl

class SplashScreenViewModelImpl: SplashViewModel, ViewModel() {

    private val introRepository:IntroRepository = IntroRepositoryImpl()
    override val openIntroductionScreenLiveData = MutableLiveData<Unit>()
    override val openMenuScreenLiveData = MutableLiveData<Unit>()

    init {
        viewModelScope.launch {
            delay(2000)
            if (!introRepository.getFirstOpen()){
                introRepository.setFirstOpen()
                openIntroductionScreenLiveData.value=Unit
            }
            else{
                openMenuScreenLiveData.value=Unit
            }
        }
    }
}