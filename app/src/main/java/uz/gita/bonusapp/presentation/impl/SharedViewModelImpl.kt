package uz.gita.bonusapp.presentation.impl

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import uz.gita.bonusapp.presentation.SharedViewModel

class SharedViewModelImpl : SharedViewModel,ViewModel() {

    override val answerLiveData: MutableLiveData<Boolean> = MutableLiveData()

    override fun setAnswer(answer: Boolean) {
        answerLiveData.postValue(answer)
    }
}