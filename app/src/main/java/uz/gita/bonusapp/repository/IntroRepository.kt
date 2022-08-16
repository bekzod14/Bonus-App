package uz.gita.bonusapp.repository

interface IntroRepository {
    fun getFirstOpen():Boolean

    fun setFirstOpen()
}