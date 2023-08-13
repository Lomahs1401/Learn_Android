package com.example.recyclerviewexample.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import com.example.recyclerviewexample.databinding.LayoutItemChildBinding
import com.example.recyclerviewexample.databinding.LayoutItemGroupBinding
import com.example.recyclerviewexample.model.GroupObject
import com.example.recyclerviewexample.model.ItemObject
import java.util.Locale

class ExpandableListViewAdapter(
    private val context: Context,
    private var listGroup: MutableList<GroupObject>,
    private var listItems: MutableMap<GroupObject, MutableList<ItemObject>>
) : BaseExpandableListAdapter() {

    override fun getGroupCount(): Int {
        return listGroup.size
    }

    override fun getChildrenCount(groupPosition: Int): Int {
        return listItems[listGroup[groupPosition]]!!.size
    }

    override fun getGroup(groupPosition: Int): Any {
        return listGroup[groupPosition]
    }

    override fun getChild(groupPosition: Int, childPosition: Int): Any {
        return listItems[listGroup[groupPosition]]!![childPosition]
    }

    override fun getGroupId(groupPosition: Int): Long {
        val groupObject = listGroup[groupPosition]
        return groupObject.id.toLong()
    }

    override fun getChildId(groupPosition: Int, childPosition: Int): Long {
        val itemObject = listItems[listGroup[groupPosition]]!![childPosition]
        return itemObject.id.toLong()
    }

    override fun hasStableIds(): Boolean {
        return false
    }

    override fun getGroupView(
        groupPosition: Int,
        isExpanded: Boolean,
        convertView: View?,
        parent: ViewGroup?
    ): View {
        val groupBinding = LayoutItemGroupBinding.inflate(LayoutInflater.from(context), parent, false)
        val groupObject = listGroup[groupPosition]
        groupBinding.tvGroup.text = groupObject.name.toUpperCase(Locale.ROOT)
        return groupBinding.root
    }

    override fun getChildView(
        groupPosition: Int,
        childPosition: Int,
        isExpanded: Boolean,
        convertView: View?,
        parent: ViewGroup?
    ): View {
        val childBinding = LayoutItemChildBinding.inflate(LayoutInflater.from(context), parent, false)
        val itemObject = listItems[listGroup[groupPosition]]!![childPosition]
        childBinding.tvItem.text = itemObject.name
        return childBinding.root
    }

    override fun isChildSelectable(p0: Int, p1: Int): Boolean {
        return true
    }
}