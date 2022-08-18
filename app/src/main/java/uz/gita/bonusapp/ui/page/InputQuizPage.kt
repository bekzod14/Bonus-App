package uz.gita.bonusapp.ui.page

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import uz.gita.bonusapp.R
import uz.gita.bonusapp.data.models.InputQuizData
import uz.gita.bonusapp.databinding.PageInputBinding
import uz.gita.bonusapp.presentation.InputViewMOdel
import uz.gita.bonusapp.presentation.impl.InputViewMOdelImpl

class InputQuizPage : Fragment(R.layout.page_input) {

    private lateinit var binding:PageInputBinding

    private val viewModel:InputViewMOdel by viewModels<InputViewMOdelImpl>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = PageInputBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.setQuiz(arguments?.getSerializable("quiz")as InputQuizData)
        viewModel.textQuizLiveData.observe(viewLifecycleOwner){
            binding.txtQuestion.text = it
        }

        viewModel.userAnswer(binding.editAnswer.text.toString())
    }


}