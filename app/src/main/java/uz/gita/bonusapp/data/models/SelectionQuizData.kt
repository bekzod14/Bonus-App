package uz.gita.bonusapp.data.models

data class SelectionQuizData(
    val question: String,
    val variant1: String,
    val variant2: String,
    val variant3: String,
    val variant4: String,
    val answer: String
):QuizData()
