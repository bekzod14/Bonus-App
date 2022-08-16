package uz.gita.bonusapp.presentation

import androidx.lifecycle.LiveData
import uz.gita.bonusapp.data.models.TrueFalseQuizData

interface TrueFalseViewModel {

    val textQuizLiveData: LiveData<String>

    fun setQuestion(data: TrueFalseQuizData)

    fun selectTrue()

    fun selectFalse()
}