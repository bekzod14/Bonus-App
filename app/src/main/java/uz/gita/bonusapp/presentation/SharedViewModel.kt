package uz.gita.bonusapp.presentation

import androidx.lifecycle.LiveData

interface SharedViewModel {

    val answerLiveData: LiveData<Boolean>

    fun setAnswer(answer: Boolean)

}