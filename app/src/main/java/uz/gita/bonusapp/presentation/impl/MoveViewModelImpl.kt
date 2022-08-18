package uz.gita.bonusapp.presentation.impl

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import uz.gita.bonusapp.data.models.MoveQuizData
import uz.gita.bonusapp.presentation.MoveViewModel

class MoveViewModelImpl : MoveViewModel, ViewModel() {

    override val question: MutableLiveData<MoveQuizData> = MutableLiveData()
    override val answerLiveData: MutableLiveData<Boolean> = MutableLiveData()

    override fun setQuestion(moveQuizData: MoveQuizData) {
        question.postValue(moveQuizData)
    }

    override fun setMoveAnswer(list: List<String>) {
        val ans = question.value!!.answers
        for (i in ans.indices) {
            if (ans[i] != list[i]) {
                answerLiveData.postValue(false)
                return
            }
        }
        answerLiveData.postValue(true)
    }
}