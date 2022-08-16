package uz.gita.bonusapp.app

import android.app.Application
import uz.gita.bonusapp.repository.MySharedPref

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        MySharedPref.init(this)

    }
}