package uz.gita.bonusapp.ui.screen.fargment

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import uz.gita.bonusapp.R
import uz.gita.bonusapp.presentation.SplashViewModel
import uz.gita.bonusapp.presentation.impl.SplashScreenViewModelImpl

class SplashScreen : Fragment(R.layout.splash_screen) {

    private val viewModel : SplashViewModel by viewModels<SplashScreenViewModelImpl>()
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