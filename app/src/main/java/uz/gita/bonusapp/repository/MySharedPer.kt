package uz.gita.bonusapp.repository

import android.content.Context
import android.content.SharedPreferences

class MySharedPer private constructor(){


    companion object{
        private var sharedPreferences:SharedPreferences?=null
        private var mySharedPer:MySharedPer ?= null
        fun init(context: Context){
            if (mySharedPer==null) {
                mySharedPer= MySharedPer()
                sharedPreferences = context.getSharedPreferences("myShared", Context.MODE_PRIVATE)

            }
        }
        fun getSharedPer()= mySharedPer!!

    }


    fun isFirstOpen():Boolean{
        return  sharedPreferences!!.getBoolean("isFirst",true)
    }
    fun second(){
        sharedPreferences!!.edit().putBoolean("isFirst",false).apply()
    }
}