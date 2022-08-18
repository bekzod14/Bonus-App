package uz.gita.bonusapp.presentation.impl

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import uz.gita.bonusapp.data.models.TrueFalseQuizData
import uz.gita.bonusapp.presentation.TrueFalseViewModel

class TrueFalseViewModelImpl : TrueFalseViewModel, ViewModel() {

    private lateinit var question: TrueFalseQuizData
    override val textQuizLiveData =  MutableLiveData<String>()
    override fun setQuestion(data: TrueFalseQuizData) {
        textQuizLiveData.value = data.question
        question = data
    }


    override fun selectTrue() {

    }

    override fun selectFalse() {

    }
}