package uz.gita.bonusapp.ui.page

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import uz.gita.bonusapp.R
import uz.gita.bonusapp.data.models.SelectionQuizData
import uz.gita.bonusapp.presentation.SelectionViewModel
import uz.gita.bonusapp.presentation.SharedViewModel
import uz.gita.bonusapp.presentation.impl.SelectionViewModelImpl
import uz.gita.bonusapp.presentation.impl.SharedViewModelImpl

class SelectionQuizPage : Fragment(R.layout.screen_selection) {
    private lateinit var tvQuestion: TextView
    private lateinit var tvVar1: TextView
    private lateinit var tvVar2: TextView
    private lateinit var tvVar3: TextView
    private lateinit var tvVar4: TextView
    private val viewModel: SelectionViewModel by viewModels<SelectionViewModelImpl>()
    private val sharedViewModel: SharedViewModel by activityViewModels<SharedViewModelImpl>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        view.apply {
            tvQuestion = findViewById(R.id.tv_question)
            tvVar1 = findViewById(R.id.tv_var1)
            tvVar2 = findViewById(R.id.tv_var2)
            tvVar3 = findViewById(R.id.tv_var3)
            tvVar4 = findViewById(R.id.tv_var4)
        }

        viewModel.setQuiz(requireArguments().getSerializable("quiz") as SelectionQuizData)

        viewModel.quizLiveData.observe(viewLifecycleOwner) {
            tvQuestion.text = it.question
            tvVar1.text = it.variant1
            tvVar2.text = it.variant2
            tvVar3.text = it.variant3
            tvVar4.text = it.variant4
        }

        tvVar1.setOnClickListener {
            viewModel.userAnswer(tvVar1.text.toString())
        }

        tvVar2.setOnClickListener {
            viewModel.userAnswer(tvVar2.text.toString())
        }

        tvVar3.setOnClickListener {
            viewModel.userAnswer(tvVar3.text.toString())
        }

        tvVar4.setOnClickListener {
            viewModel.userAnswer(tvVar4.text.toString())
        }

        viewModel.answerLiveData.observe(viewLifecycleOwner) {
            sharedViewModel.setAnswer(it)
        }

    }
}