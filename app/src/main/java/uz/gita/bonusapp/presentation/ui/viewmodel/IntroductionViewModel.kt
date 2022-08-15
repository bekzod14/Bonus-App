package uz.gita.bonusapp.presentation.ui.viewmodel

import androidx.lifecycle.LiveData

interface IntroductionViewModel {
    val openMenuScreenLiveData:LiveData<Unit>
    val slidePageLiveData:LiveData<Int>
    fun next(position:Int)

}