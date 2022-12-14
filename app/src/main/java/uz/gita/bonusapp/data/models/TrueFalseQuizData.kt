package uz.gita.bonusapp.data.models

data class TrueFalseQuizData(
    val question: String,
    val answer: Boolean
) : QuizData() {
    override val type: String
        get() = "True/False"
}