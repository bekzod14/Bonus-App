package uz.gita.bonusapp.ui.adapter

import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import uz.gita.bonusapp.data.models.*
import uz.gita.bonusapp.ui.page.InputQuizPage
import uz.gita.bonusapp.ui.page.MoveQuizPage
import uz.gita.bonusapp.ui.page.SelectionQuizPage
import uz.gita.bonusapp.ui.page.TrueFalseQuizPage

class QuizPageAdapter(fa: FragmentActivity, private val quizzes: List<QuizData>) :
    FragmentStateAdapter(fa) {

    override fun getItemCount() = quizzes.size

    override fun createFragment(position: Int): Fragment {
        val page = when (quizzes[position]) {
            is MoveQuizData -> {
                MoveQuizPage()
            }
            is TrueFalseQuizData -> {
                TrueFalseQuizPage()
            }
            is SelectionQuizData -> {
                SelectionQuizPage()
            }
            is InputQuizData -> {
                InputQuizPage()
            }
        }
        page.arguments = bundleOf(Pair("quiz", quizzes[position]))
        return page
    }
}