package uz.gita.bonusapp.repository.impl

import uz.gita.bonusapp.data.models.*
import uz.gita.bonusapp.repository.QuestionRepository

class QuestionRepositoryImpl : QuestionRepository {
    override fun getQuestions(): List<QuizData> = listOf(
        InputQuizData("2+2=", "4"),
        TrueFalseQuizData("5*5=24", false),
        InputQuizData("3+2=", "5"),
        MoveQuizData("Sonlarni tartiblang", listOf("1", "2", "3", "4", "5")),
        InputQuizData("4+4=", "8"),
        SelectionQuizData("book ni manosi", "kitob", "ruchka", "qalam", "telefon", "kitob"),
        TrueFalseQuizData("Kun issiqmi", true),
        MoveQuizData("Harflarni tartiblang", listOf("A", "E", "G", "Y", "Z")),
        InputQuizData("2+1=", "3"),
        TrueFalseQuizData("5*5=25", true)
    )
}