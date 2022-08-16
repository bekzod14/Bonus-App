package uz.gita.bonusapp.data.models

data class InputQuizData(
    val question: String,
    val answer: String
):QuizData(){
    override val type: String
        get() = "Input"

}
