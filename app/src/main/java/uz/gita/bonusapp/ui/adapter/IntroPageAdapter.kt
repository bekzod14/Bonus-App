package uz.gita.bonusapp.ui.adapter

import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import uz.gita.bonusapp.data.IntroPageData
import uz.gita.bonusapp.ui.page.Intropage

class IntroPageAdapter(fragment: Fragment, val list:ArrayList<IntroPageData>):FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int {
     return   list.size
    }

    override fun createFragment(position: Int): Fragment {
     val page = Intropage()
        page.arguments= bundleOf(Pair("data",list[position]))
     return page

    }
}