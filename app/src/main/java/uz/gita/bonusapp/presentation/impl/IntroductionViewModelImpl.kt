package uz.gita.bonusapp.presentation.impl

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import uz.gita.bonusapp.presentation.IntroductionViewModel

class IntroductionViewModelImpl : IntroductionViewModel, ViewModel() {
    override val openMenuScreenLiveData = MutableLiveData<Unit>()
    override val slidePageLiveData = MutableLiveData<Int>()


    override fun next(position: Int) {
        if (position == 2) {
            openMenuScreenLiveData.value = Unit
        } else {
            slidePageLiveData.value = position + 1
        }
    }
}