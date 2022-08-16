package uz.gita.bonusapp.presentation

import androidx.lifecycle.LiveData

interface IntroductionViewModel {
    val openMenuScreenLiveData:LiveData<Unit>
    val slidePageLiveData:LiveData<Int>
    fun next(position:Int)

}