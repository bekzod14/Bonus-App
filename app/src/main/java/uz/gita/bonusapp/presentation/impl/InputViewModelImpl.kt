package uz.gita.bonusapp.presentation.impl

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import uz.gita.bonusapp.data.models.InputQuizData
import uz.gita.bonusapp.presentation.InputViewModel

class InputViewModelImpl : InputViewModel, ViewModel() {

    private lateinit var question: InputQuizData

    override val textQuizLiveData = MutableLiveData<String>()

    override val answerLiveData: MutableLiveData<Boolean> = MutableLiveData()


    override fun setQuiz(inputQuizData: InputQuizData) {
        textQuizLiveData.value = inputQuizData.question
        question = inputQuizData
    }

    override fun userAnswer(answer: String) {
        answerLiveData.postValue(answer == question.answer)
    }
}