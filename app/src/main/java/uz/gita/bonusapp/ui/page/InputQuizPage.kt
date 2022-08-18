package uz.gita.bonusapp.ui.page

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import uz.gita.bonusapp.R
import uz.gita.bonusapp.data.models.InputQuizData
import uz.gita.bonusapp.databinding.PageInputBinding
import uz.gita.bonusapp.presentation.InputViewModel
import uz.gita.bonusapp.presentation.SharedViewModel
import uz.gita.bonusapp.presentation.impl.InputViewModelImpl
import uz.gita.bonusapp.presentation.impl.SharedViewModelImpl

class InputQuizPage : Fragment(R.layout.page_input) {

    private lateinit var binding: PageInputBinding

    private val viewModel: InputViewModel by viewModels<InputViewModelImpl>()

    private val sharedViewModel: SharedViewModel by activityViewModels<SharedViewModelImpl>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = PageInputBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        viewModel.setQuiz(arguments?.getSerializable("quiz") as InputQuizData)

        viewModel.textQuizLiveData.observe(viewLifecycleOwner) {
            binding.txtQuestion.text = it
        }

        viewModel.answerLiveData.observe(viewLifecycleOwner, answerObserver)

        binding.editAnswer.doOnTextChanged { text, _, _, _ ->
            if (text?.toString()?.isNotEmpty() == true) {
                viewModel.userAnswer(text.toString())
            }
        }


    }

    private val answerObserver = Observer<Boolean> {
        sharedViewModel.setAnswer(it)
    }


}