package uz.gita.bonusapp.presentation

import androidx.lifecycle.LiveData
import uz.gita.bonusapp.data.models.SelectionQuizData

interface SelectionViewModel {
    val quizLiveData: LiveData<SelectionQuizData>
    val answerLiveData: LiveData<String>

    fun setQuiz(selectionQuizData: SelectionQuizData)
    fun userAnswer(answer: String)
}