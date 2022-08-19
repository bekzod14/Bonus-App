package uz.gita.bonusapp.app

import android.app.Application
import timber.log.Timber
import uz.gita.bonusapp.BuildConfig
import uz.gita.bonusapp.repository.MySharedPref

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        MySharedPref.init(this)

        if (BuildConfig.DEBUG){
            Timber.plant(Timber.DebugTree())
        }
    }
}