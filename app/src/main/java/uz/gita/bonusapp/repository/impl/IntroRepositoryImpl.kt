package uz.gita.bonusapp.repository.impl

import uz.gita.bonusapp.repository.IntroRepository
import uz.gita.bonusapp.repository.MySharedPref

class IntroRepositoryImpl : IntroRepository {


    private val sharedPref = MySharedPref.getInstance()



    override fun getFirstOpen(): Boolean {
        return sharedPref.getFirstOpen()
    }

    override fun setFirstOpen() {
        sharedPref.setFirstOpen()
    }
}