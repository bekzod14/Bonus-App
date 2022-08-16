package uz.gita.bonusapp.data.models

import java.io.Serializable

sealed class QuizData : Serializable {
    abstract val type: String
}