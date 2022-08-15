package uz.gita.bonusapp.presentation.ui.page

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import uz.gita.bonusapp.R
import uz.gita.bonusapp.data.PageData

class Intropage:Fragment(R.layout.page_screen) {
    private lateinit var textview:TextView
    private lateinit var img:ImageView
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        textview =view.findViewById(R.id.text_page)
        img =view.findViewById(R.id.img_page)
        var pageData:PageData=arguments?.get("data")as PageData
        textview.text= pageData.text
        img.setImageResource(pageData.img)

    }
}