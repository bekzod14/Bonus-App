package uz.gita.bonusapp.adapter

import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import uz.gita.bonusapp.data.PageData
import uz.gita.bonusapp.presentation.ui.page.Intropage

class FragmentAdpter(fragment: Fragment, val list:ArrayList<PageData>):FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int {
     return   list.size
    }

    override fun createFragment(position: Int): Fragment {
     val page = Intropage()
        page.arguments= bundleOf(Pair("data",list[position]))
     return page

    }
}