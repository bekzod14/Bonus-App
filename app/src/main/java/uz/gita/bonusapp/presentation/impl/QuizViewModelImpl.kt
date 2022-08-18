package uz.gita.bonusapp.presentation.impl

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import uz.gita.bonusapp.data.models.QuizData
import uz.gita.bonusapp.data.models.QuizResultData
import uz.gita.bonusapp.presentation.QuizViewModel
import uz.gita.bonusapp.repository.QuestionRepository
import uz.gita.bonusapp.repository.impl.QuestionRepositoryImpl

class QuizViewModelImpl : QuizViewModel, ViewModel() {

    private val repository: QuestionRepository = QuestionRepositoryImpl()
    private val quizzes: ArrayList<QuizData> = arrayListOf()

    private var correct: Int = 0

    private var currentPosition = 0
    override val quizzesLiveData = MutableLiveData<List<QuizData>>()

    override val nextQuizLiveData = MutableLiveData<Int>()
    override val finishQuizLiveData = MutableLiveData<QuizResultData>()
    override val restartQuizLiveData = MutableLiveData<Unit>()
    override val quitQuizLiveData = MutableLiveData<Unit>()

    override val quizCountLiveData = MutableLiveData<String>()
    override val quizTypeLiveData = MutableLiveData<String>()

    override fun next() {
        if (quizzes.size - 1 != currentPosition) {
            nextQuizLiveData.value = (++currentPosition)
            quizCountLiveData.value = "${currentPosition + 1}/${quizzes.size}"
            quizTypeLiveData.value = quizzes[currentPosition].type
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

    override fun addCorrect() {
        correct++
    }

    init {
        quizzes.addAll(repository.getQuestions())
        quizzesLiveData.value = quizzes

        quizCountLiveData.value = "${currentPosition + 1}/${quizzes.size}"
        quizTypeLiveData.value = quizzes[currentPosition].type
    }
}