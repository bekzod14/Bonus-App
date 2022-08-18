package uz.gita.bonusapp.presentation

import androidx.lifecycle.LiveData
import uz.gita.bonusapp.data.models.InputQuizData

interface InputViewModel {

    val textQuizLiveData: LiveData<String>

    val answerLiveData: LiveData<Boolean>

    fun setQuiz(inputQuizData: InputQuizData)

    fun userAnswer(answer: String)
}