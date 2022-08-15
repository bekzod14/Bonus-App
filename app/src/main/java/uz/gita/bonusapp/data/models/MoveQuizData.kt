package uz.gita.bonusapp.data.models

data class MoveQuizData(
    val question: String,
    val answers: List<String>
):QuizData()