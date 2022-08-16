package uz.gita.bonusapp.presentation

import androidx.lifecycle.LiveData
import uz.gita.bonusapp.data.models.QuizData
import uz.gita.bonusapp.data.models.QuizResultData

interface QuizViewModel {
    val quizzesLiveData:LiveData<List<QuizData>>
    val nextQuizLiveData: LiveData<Int>
    val finishQuizLiveData: LiveData<QuizResultData>
    val restartQuizLiveData: LiveData<Unit>
    val quitQuizLiveData: LiveData<Unit>

    fun next()

    fun restart()

    fun quit()
}