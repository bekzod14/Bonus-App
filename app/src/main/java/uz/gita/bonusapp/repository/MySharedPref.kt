package uz.gita.bonusapp.repository

import android.content.Context
import android.content.SharedPreferences

class MySharedPref private constructor() {


    companion object {
        private var pref: SharedPreferences? = null
        private var editor: SharedPreferences.Editor? = null

        private var sharedPref: MySharedPref? = null
        fun getInstance() = sharedPref!!
        fun init(context: Context) {
            if (sharedPref == null) {
                sharedPref = MySharedPref()
                pref = context.getSharedPreferences("shared", Context.MODE_PRIVATE)
                editor = pref!!.edit()

            }

        }
    }
    fun getFirstOpen(): Boolean {
        return pref!!.getBoolean("isFirst", false)
    }

    fun setFirstOpen() {
        editor!!.putBoolean("isFirst", true).apply()
    }
}