package com.example.recyclerviewexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.recyclerviewexample.adapter.ExpandableListViewAdapter
import com.example.recyclerviewexample.databinding.ActivityExpandCollapseListViewBinding
import com.example.recyclerviewexample.model.GroupObject
import com.example.recyclerviewexample.model.ItemObject

class ExpandCollapseListViewActivity : AppCompatActivity() {
    private val binding: ActivityExpandCollapseListViewBinding by lazy {
        ActivityExpandCollapseListViewBinding.inflate(layoutInflater)
    }

    private var listGroups: MutableList<GroupObject> = mutableListOf()
    private var listItems: MutableMap<GroupObject, MutableList<ItemObject>> = mutableMapOf()

    private val expandableListViewAdapter: ExpandableListViewAdapter by lazy {
        ExpandableListViewAdapter(this, listGroups, listItems)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        listItems = getListItems()
        listGroups = listItems.keys.toMutableList()

        binding.listExpandable.setAdapter(expandableListViewAdapter)

        binding.listExpandable.setOnGroupExpandListener {
            Toast.makeText(this, listGroups[it].name + " Expand", Toast.LENGTH_SHORT).show()
        }

        binding.listExpandable.setOnGroupCollapseListener {
            Toast.makeText(this, listGroups[it].name + " Collapse", Toast.LENGTH_SHORT).show()
        }
    }

    private fun getListItems(): MutableMap<GroupObject, MutableList<ItemObject>> {
        val listMap: MutableMap<GroupObject, MutableList<ItemObject>> = mutableMapOf()

        val groupObject1 = GroupObject(1, "Group 1")
        val groupObject2 = GroupObject(2, "Group 2")
        val groupObject3 = GroupObject(3, "Group 3")

        val objectList1: MutableList<ItemObject> = mutableListOf()
        objectList1.add(ItemObject(1, "Item 1"))
        objectList1.add(ItemObject(2, "Item 2"))
        objectList1.add(ItemObject(3, "Item 3"))

        val objectList2: MutableList<ItemObject> = mutableListOf()
        objectList2.add(ItemObject(4, "Item 4"))
        objectList2.add(ItemObject(5, "Item 5"))
        objectList2.add(ItemObject(6, "Item 6"))

        val objectList3: MutableList<ItemObject> = mutableListOf()
        objectList3.add(ItemObject(7, "Item 7"))
        objectList3.add(ItemObject(8, "Item 8"))
        objectList3.add(ItemObject(9, "Item 9"))

        listMap[groupObject1] = objectList1
        listMap[groupObject2] = objectList2
        listMap[groupObject3] = objectList3

        return listMap
    }
}