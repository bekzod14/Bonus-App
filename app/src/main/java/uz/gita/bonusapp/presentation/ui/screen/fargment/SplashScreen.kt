package uz.gita.bonusapp.presentation.ui.screen.fargment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import uz.gita.bonusapp.R
import uz.gita.bonusapp.presentation.ui.viewmodel.SplashScreenViewModel
import uz.gita.bonusapp.presentation.ui.viewmodel.impl.SplashScreenViewModelImpl

class SplashScreen : Fragment(R.layout.splash_screen) {

    private val viewModel : SplashScreenViewModel by viewModels<SplashScreenViewModelImpl>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.openIntroductionScreenLiveData.observe(this){
            findNavController().navigate(SplashScreenDirections.actionSplashScreenToIntroductionScreen())
        }
        viewModel.openMenuScreenLiveData.observe(this){
            findNavController().navigate(SplashScreenDirections.actionSplashScreenToMenuScreen())
        }
    }
}