package uz.gita.bonusapp.presentation

import androidx.lifecycle.LiveData
import uz.gita.bonusapp.data.models.InputQuizData

interface InputViewMOdel {

    val textQuizLiveData:LiveData<String>

    fun setQuiz(inputQuizData: InputQuizData)

    fun userAnswer(answer:String)
}