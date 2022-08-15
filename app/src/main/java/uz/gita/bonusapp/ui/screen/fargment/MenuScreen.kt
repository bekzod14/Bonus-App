package uz.gita.bonusapp.ui.screen.fargment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import uz.gita.bonusapp.R

class MenuScreen : Fragment(R.layout.menu_screen) {

    private lateinit var btnStart: Button

    private val navController by lazy { findNavController() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        btnStart = view.findViewById(R.id.btnStart)

        btnStart.setOnClickListener {
            navController.navigate(MenuScreenDirections.actionMenuScreenToQuizScreen())
        }

    }


}