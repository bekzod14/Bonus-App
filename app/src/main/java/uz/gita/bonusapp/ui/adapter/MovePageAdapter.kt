package uz.gita.bonusapp.ui.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import uz.gita.bonusapp.R
import uz.gita.bonusapp.databinding.ListItemMoveBinding
import uz.gita.bonusapp.utils.MovePageItemCallBack
import uz.gita.bonusapp.utils.extensions.inflate

// Created by Jamshid Isoqov an 8/18/2022
class MovePageAdapter : RecyclerView.Adapter<MovePageAdapter.ViewHolder>() {

    var list: List<String> = emptyList()

    inner class ViewHolder(private val binding: ListItemMoveBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind() {
            binding.tvName.text = list[adapterPosition]
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(ListItemMoveBinding.bind(parent.inflate(R.layout.list_item_move)))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.onBind()

    override fun getItemCount(): Int = list.size

    fun onMove(from: Int, to: Int) {
        val newList = ArrayList<String>()
        newList.addAll(list)
        val old = newList.removeAt(from)
        newList.add(to, old)
        list = newList
        notifyItemMoved(from, to)
    }

    fun submitList(list: List<String>) {
        val diffUtil = MovePageItemCallBack(this.list, list)
        val result = DiffUtil.calculateDiff(diffUtil)
        val newList = ArrayList<String>()
        newList.addAll(list)
        this.list = newList
        result.dispatchUpdatesTo(this)
    }

}