package com.example.recyclerviewexample.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewexample.databinding.LayoutHeaderBinding
import com.example.recyclerviewexample.databinding.LayoutItemBinding
import se.emilsjolander.stickylistheaders.StickyListHeadersAdapter

class UserAdapter(
    private val context: Context
) : BaseAdapter(), StickyListHeadersAdapter {

    private var listUsers: MutableList<String> = mutableListOf()

    @SuppressLint("NotifyDataSetChanged")
    fun setData(list: MutableList<String>) {
        this.listUsers = list
        notifyDataSetChanged()
    }

    override fun getCount(): Int {
        return listUsers.size
    }

    override fun getItem(i: Int): Any {
        return listUsers[i]
    }

    // Header
    override fun getHeaderId(position: Int): Long {
        val firstChar = listUsers[position].firstOrNull()
        return firstChar?.toInt()?.toLong() ?: -1L // -1L hoặc một giá trị thích hợp nếu không có ký tự nào
    }

    override fun getHeaderView(position: Int, convertView: View?, viewGroup: ViewGroup?): View {
        val headerViewHolder: HeaderViewHolder
        val binding: LayoutHeaderBinding

        if (convertView == null) {
            binding = LayoutHeaderBinding.inflate(LayoutInflater.from(context), viewGroup, false)
            headerViewHolder = HeaderViewHolder(binding)
            binding.root.tag = headerViewHolder
        } else {
            binding = LayoutHeaderBinding.bind(convertView)
            headerViewHolder = convertView.tag as HeaderViewHolder
        }
        headerViewHolder.bindData(listUsers[position])

        return binding.root
    }

    // Item
    override fun getItemId(i: Int): Long {
        return i.toLong()
    }

    override fun getView(i: Int, view: View?, viewGroup: ViewGroup?): View {
        val itemViewHolder: ItemViewHolder
        val binding: LayoutItemBinding

        if (view == null) {
            binding = LayoutItemBinding.inflate(LayoutInflater.from(context), viewGroup, false)
            itemViewHolder = ItemViewHolder(binding)
            binding.root.tag = itemViewHolder
        } else {
            binding = LayoutItemBinding.bind(view)
            itemViewHolder = view.tag as ItemViewHolder
        }

        itemViewHolder.bindData(listUsers[i])

        return binding.root
    }

    inner class HeaderViewHolder(private val binding: LayoutHeaderBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bindData(item: String) {
            binding.tvHeader.text = item
        }
    }

    inner class ItemViewHolder(private val binding: LayoutItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bindData(item: String) {
            binding.tvItem.text = item
        }
    }
}