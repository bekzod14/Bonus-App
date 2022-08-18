package uz.gita.bonusapp.ui.page

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import uz.gita.bonusapp.data.models.MoveQuizData
import uz.gita.bonusapp.databinding.PageMoveBinding
import uz.gita.bonusapp.presentation.MoveViewModel
import uz.gita.bonusapp.presentation.SharedViewModel
import uz.gita.bonusapp.presentation.impl.MoveViewModelImpl
import uz.gita.bonusapp.presentation.impl.SharedViewModelImpl
import uz.gita.bonusapp.ui.adapter.MovePageAdapter

class MoveQuizPage : Fragment() {

    private var _binding: PageMoveBinding? = null
    private val binding: PageMoveBinding get() = _binding!!

    private val viewModel: MoveViewModel by viewModels<MoveViewModelImpl>()
    private val sharedViewModel: SharedViewModel by activityViewModels<SharedViewModelImpl>()

    private val adapter: MovePageAdapter by lazy {
        MovePageAdapter()
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = PageMoveBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.answerLiveData.observe(viewLifecycleOwner, answerObserver)
        viewModel.question.observe(viewLifecycleOwner, questionObserver)
        binding.listQuiz.adapter = adapter
        val args = arguments?.getSerializable("quiz") as MoveQuizData
        viewModel.setQuestion(args)

        val touchHelper =
            object : ItemTouchHelper.SimpleCallback(ItemTouchHelper.UP or ItemTouchHelper.DOWN, 0) {
                override fun onMove(
                    recyclerView: RecyclerView,
                    viewHolder: RecyclerView.ViewHolder,
                    target: RecyclerView.ViewHolder
                ): Boolean {
                    adapter.onMove(viewHolder.adapterPosition, target.adapterPosition)
                    viewModel.setMoveAnswer(adapter.list)
                    return true
                }

                override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {}

            }
        val itemTouchHelper = ItemTouchHelper(touchHelper)
        itemTouchHelper.attachToRecyclerView(binding.listQuiz)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private val questionObserver = Observer<MoveQuizData> {
        adapter.submitList(it.answers.shuffled())
    }

    private val answerObserver = Observer<Boolean> {
        sharedViewModel.setAnswer(it)
    }

}