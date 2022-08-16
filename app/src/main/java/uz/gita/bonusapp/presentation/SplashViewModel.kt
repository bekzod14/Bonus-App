package uz.gita.bonusapp.presentation

import androidx.lifecycle.LiveData

interface SplashViewModel {

    val openIntroductionScreenLiveData: LiveData<Unit>
    val openMenuScreenLiveData: LiveData<Unit>
}