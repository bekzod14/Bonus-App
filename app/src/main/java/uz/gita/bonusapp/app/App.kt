package uz.gita.bonusapp.app

import android.app.Application
import uz.gita.bonusapp.repository.MySharedPer
import uz.gita.bonusapp.repository.Repository

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        MySharedPer.init(this)

    }
}