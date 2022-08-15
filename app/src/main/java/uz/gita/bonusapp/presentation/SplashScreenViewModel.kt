package uz.gita.bonusapp.presentation

import androidx.lifecycle.LiveData

interface SplashScreenViewModel {

    val openIntroductionScreenLiveData: LiveData<Unit>
    val openMenuScreenLiveData: LiveData<Unit>
}