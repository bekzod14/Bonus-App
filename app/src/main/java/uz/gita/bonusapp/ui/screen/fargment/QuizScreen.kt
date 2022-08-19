package uz.gita.bonusapp.ui.screen.fargment

import android.app.AlertDialog
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import timber.log.Timber
import uz.gita.bonusapp.R
import uz.gita.bonusapp.presentation.QuizViewModel
import uz.gita.bonusapp.presentation.SharedViewModel
import uz.gita.bonusapp.presentation.impl.QuizViewModelImpl
import uz.gita.bonusapp.presentation.impl.SharedViewModelImpl
import uz.gita.bonusapp.ui.adapter.QuizPageAdapter

class QuizScreen : Fragment(R.layout.screen_quiz) {

    private val navController by lazy { findNavController() }
    private val viewModel: QuizViewModel by viewModels<QuizViewModelImpl>()
    private val sharedViewModel: SharedViewModel by activityViewModels<SharedViewModelImpl>()

    private var adapter: QuizPageAdapter? = null
    private lateinit var pagerQuiz: ViewPager2
    private lateinit var btnNext: Button
    private lateinit var txtQuizNumber: TextView
    private lateinit var txtQuizType: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.quitQuizLiveData.observe(this) {
            navController.navigateUp()
        }
        sharedViewModel.answerLiveData.observe(this, answerObserver)

        viewModel.finishQuizLiveData.observe(this) {
            AlertDialog.Builder(requireContext())
                .setTitle("Result")
                .setMessage("All: ${it.count} Correct: ${it.correct} Incorrect: ${it.incorrect}")
                .setPositiveButton("Restart") { d, _ ->
                    viewModel.restart()
                    d.dismiss()
                }
                .setNeutralButton("Quit") { d, _ ->
                    viewModel.quit()
                    d.dismiss()
                }.show()
        }

        viewModel.restartQuizLiveData.observe(this) {

        }

        viewModel.nextQuizLiveData.observe(this) {
            pagerQuiz.setCurrentItem(it, true)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        pagerQuiz = view.findViewById(R.id.pagerQuiz)
        btnNext = view.findViewById(R.id.btnNext)
        txtQuizNumber = view.findViewById(R.id.txtQuizNumber)
        txtQuizType = view.findViewById(R.id.txtQuizType)

        pagerQuiz.isUserInputEnabled = false

        btnNext.setOnClickListener {
            Timber.d(sharedViewModel.answerLiveData.value.toString())
            if (sharedViewModel.answerLiveData.value!!) viewModel.addCorrect()
            btnNext.isEnabled = false
            viewModel.next()
        }

        viewModel.quizCountLiveData.observe(viewLifecycleOwner) {
            txtQuizNumber.text = it
        }
        viewModel.quizTypeLiveData.observe(viewLifecycleOwner) {
            txtQuizType.text = it
        }

        viewModel.quizzesLiveData.observe(viewLifecycleOwner) {
            adapter = QuizPageAdapter(requireActivity(), it)
            pagerQuiz.adapter = adapter
        }
    }

    private val answerObserver = Observer<Boolean> {
        btnNext.isEnabled = true
    }
}