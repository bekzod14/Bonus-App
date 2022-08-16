package uz.gita.bonusapp.repository

import uz.gita.bonusapp.data.models.QuizData

interface QuestionRepository {

    fun getQuestions(): List<QuizData>


}