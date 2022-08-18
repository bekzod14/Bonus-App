package uz.gita.bonusapp.presentation.impl

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import uz.gita.bonusapp.data.models.InputQuizData
import uz.gita.bonusapp.presentation.InputViewMOdel

class InputViewMOdelImpl : InputViewMOdel,ViewModel() {
    private lateinit var question:InputQuizData
    override val textQuizLiveData = MutableLiveData<String>()


    override fun setQuiz(inputQuizData: InputQuizData) {
       textQuizLiveData.value = inputQuizData.question
        question = inputQuizData
    }

    override fun userAnswer(answer: String) {

    }
}