package uz.gita.bonusapp.presentation.impl

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import uz.gita.bonusapp.data.models.QuizData
import uz.gita.bonusapp.data.models.QuizResultData
import uz.gita.bonusapp.presentation.QuizViewModel
import uz.gita.bonusapp.repository.QuestionRepository
import uz.gita.bonusapp.repository.impl.QuestionRepositoryImpl

class QuizViewModelImpl : QuizViewModel, ViewModel() {

    private val repository: QuestionRepository = QuestionRepositoryImpl()
    private val quizzes: List<QuizData> = emptyList()

    private var correct: Int = 0

    private var currentPosition = 0
    override val quizzesLiveData = MutableLiveData<List<QuizData>>()

    override val nextQuizLiveData = MutableLiveData<Int>()
    override val finishQuizLiveData = MutableLiveData<QuizResultData>()
    override val restartQuizLiveData = MutableLiveData<Unit>()
    override val quitQuizLiveData = MutableLiveData<Unit>()


    override fun next() {
        if (quizzes.size - 1 != currentPosition) {
            nextQuizLiveData.value = (++currentPosition)
        } else {
            finishQuizLiveData.value = QuizResultData(quizzes.size, correct, quizzes.size - correct)
        }
    }

    override fun restart() {
        restartQuizLiveData.value = Unit
    }

    override fun quit() {
        quitQuizLiveData.value = Unit
    }

    init {
        quizzesLiveData.value = repository.getQuestions()
    }
}