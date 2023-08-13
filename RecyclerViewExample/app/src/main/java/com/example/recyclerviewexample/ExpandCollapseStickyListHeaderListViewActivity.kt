package com.example.recyclerviewexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.recyclerviewexample.adapter.UserAdapter
import com.example.recyclerviewexample.databinding.ActivityExpandCollapseStickyListHeaderListViewBinding

class ExpandCollapseStickyListHeaderListViewActivity : AppCompatActivity() {
    private val binding: ActivityExpandCollapseStickyListHeaderListViewBinding by lazy {
        ActivityExpandCollapseStickyListHeaderListViewBinding.inflate(layoutInflater)
    }

    private val userAdapter: UserAdapter by lazy {
        UserAdapter(context = applicationContext)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        userAdapter.setData(getListUser())
        binding.listExpandable.setAdapter(userAdapter)

        binding.listExpandable.setOnHeaderClickListener { l, header, itemPosition, headerId, currentlySticky ->
            if (binding.listExpandable.isHeaderCollapsed(headerId)) {
                binding.listExpandable.expand(headerId)
            } else {
                binding.listExpandable.collapse(headerId)
            }
        }
    }

    private fun getListUser(): MutableList<String> {
        return mutableListOf(
            "Ayaka",
            "Amber",
            "Arataki Itto",
            "Ayato",
            "Aether",
            "Albedo",
            "Aloy",
            "Alhaitham",

            "Beidou",
            "Bennett",
            "Barbara",
            "Baizhu",

            "Collei",
            "Cyno",
            "Chongyun",
            "Candace",

            "Diluc",
            "Diona",
            "Dori",
            "Dehya",

            "Eula",

            "Faruzan",
            "Fischl",

            "Gorou",
            "Ganyu",

            "Hutao",

            "Jean",

            "Kirara",
            "Kuki Shinobu",
            "Kujou Sara",
            "Klee",
            "Kaveh",
            "Keqing",
            "Kaeya",
            "Kazuha",

            "Lumine",
            "Lisa",
            "Layla",

            "Mona",
            "Mika",

            "Noelle",
            "Ningguang",
            "Nilou",
            "Nahida",

            "Qiqi",

            "Raiden Shogun",
            "Razor",
            "Rosaria",

            "Sayu",
            "Sangonomiya Kokomi",
            "Shinkanoin Heizou",
            "Sucrose",
            "Shenhe",

            "Tartalia",
            "Thoma",
            "Tighnari",

            "Venti",

            "Wanderer",

            "Xiangling",
            "Xingqiu",
            "Xiao",
            "Xinyan",

            "Yunjin",
            "Yaoyao",
            "Yoimiya",
            "Yanfei",
            "Yae Miko",
            "Yelan",

            "Zhongli",
        )
    }
}