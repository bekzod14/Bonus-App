package uz.gita.bonusapp.utils

import androidx.recyclerview.widget.DiffUtil

// Created by Jamshid Isoqov an 8/19/2022
class MovePageItemCallBack(private val oldList: List<String>, private val newList: List<String>) :
    DiffUtil.Callback() {
    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) =
        oldList[oldItemPosition] == newList[newItemPosition]

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int) =
        oldList[oldItemPosition] == newList[newItemPosition]
}