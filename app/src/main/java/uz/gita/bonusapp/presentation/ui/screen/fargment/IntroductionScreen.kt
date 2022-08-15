package uz.gita.bonusapp.presentation.ui.screen.fargment

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import uz.gita.bonusapp.R
import uz.gita.bonusapp.adapter.FragmentAdpter
import uz.gita.bonusapp.data.PageData
import uz.gita.bonusapp.presentation.ui.viewmodel.IntroductionViewModel
import uz.gita.bonusapp.presentation.ui.viewmodel.impl.IntroductionViewModelImpl

class IntroductionScreen : Fragment(R.layout.screen_introduction) {
    private val viewModel: IntroductionViewModel by viewModels<IntroductionViewModelImpl>()
    private lateinit var btnNext: Button
    private lateinit var tab_layout: TabLayout
    private val list: ArrayList<PageData> = arrayListOf(
        PageData(
            R.drawable.ic_launcher_foreground, "page_1"
        ),
        PageData(
            R.drawable.ic_launcher_background, "page_2"
        ),
        PageData(
            R.drawable.ic_launcher_background, "page_3"
        )
    )
    private val adapter: FragmentAdpter by lazy { FragmentAdpter(this, list) }
    private lateinit var viewPager2: ViewPager2
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.openMenuScreenLiveData.observe(this) {
            findNavController().navigate(IntroductionScreenDirections.actionIntroductionScreenToMenuScreen())
        }
        viewModel.slidePageLiveData.observe(this) {
            viewPager2.setCurrentItem(it, true)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnNext = view.findViewById(R.id.next_button)
        tab_layout = view.findViewById(R.id.tab_intro)

        viewPager2 = view.findViewById(R.id.viewpiger)
        viewPager2.adapter = adapter
        btnNext.setOnClickListener {
            viewModel.next(viewPager2.currentItem)
        }
        TabLayoutMediator(tab_layout, viewPager2) { tab, posittion ->
        }.attach()

    }


}