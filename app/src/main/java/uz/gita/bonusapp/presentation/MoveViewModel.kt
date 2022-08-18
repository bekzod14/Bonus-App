package uz.gita.bonusapp.presentation

import androidx.lifecycle.LiveData
import uz.gita.bonusapp.data.models.MoveQuizData

// Created by Jamshid Isoqov an 8/18/2022
interface MoveViewModel {

    val question: LiveData<MoveQuizData>

    val answerLiveData: LiveData<Boolean>

    fun setQuestion(moveQuizData: MoveQuizData)

    fun setMoveAnswer(list: List<String>)


}