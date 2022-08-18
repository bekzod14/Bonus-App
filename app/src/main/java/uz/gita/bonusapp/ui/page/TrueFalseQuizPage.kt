package uz.gita.bonusapp.ui.page

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import uz.gita.bonusapp.R
import uz.gita.bonusapp.data.models.TrueFalseQuizData
import uz.gita.bonusapp.presentation.SharedViewModel
import uz.gita.bonusapp.presentation.TrueFalseViewModel
import uz.gita.bonusapp.presentation.impl.SharedViewModelImpl
import uz.gita.bonusapp.presentation.impl.TrueFalseViewModelImpl

class TrueFalseQuizPage : Fragment(R.layout.page_true_false) {

    private val viewModel: TrueFalseViewModel by viewModels<TrueFalseViewModelImpl>()
    private lateinit var txtQuiz: TextView
    private lateinit var btnTrue: AppCompatButton
    private lateinit var btnFalse: AppCompatButton
    private val sharedViewModel: SharedViewModel by activityViewModels<SharedViewModelImpl>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.setQuestion(arguments?.getSerializable("quiz") as TrueFalseQuizData)
        view.apply {
            txtQuiz = findViewById(R.id.textView)
            btnFalse = findViewById(R.id.btnFalse)
            btnTrue = findViewById(R.id.btnTrue)
        }
        viewModel.variantLiveData.observe(viewLifecycleOwner, variantObserver)
        viewModel.textQuizLiveData.observe(viewLifecycleOwner) {
            txtQuiz.text = it
        }
        btnTrue.setOnClickListener {
            viewModel.selectTrue()
        }
        btnFalse.setOnClickListener {
            viewModel.selectFalse()
        }
    }

    private val variantObserver = Observer<Boolean> {
        sharedViewModel.setAnswer(it)
    }

}