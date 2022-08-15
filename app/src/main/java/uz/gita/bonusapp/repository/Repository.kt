package uz.gita.bonusapp.repository

object Repository {
    private val mySharedPreferences=MySharedPer.getSharedPer()
    fun isFirst():Boolean{
        return mySharedPreferences.isFirstOpen()
    }
    fun secondOpen(){
        mySharedPreferences.second()
    }
}