package uz.gita.bonusapp.presentation.impl

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import uz.gita.bonusapp.data.models.SelectionQuizData
import uz.gita.bonusapp.presentation.SelectionViewModel

class SelectionViewModelImpl : SelectionViewModel, ViewModel() {
    override val quizLiveData = MutableLiveData<SelectionQuizData>()
    override val answerLiveData = MutableLiveData<Boolean>()

    override fun setQuiz(selectionQuizData: SelectionQuizData) {
        quizLiveData.value = selectionQuizData
    }

    override fun userAnswer(answer: String) {
        answerLiveData.postValue(answer == quizLiveData.value!!.answer)
    }
}