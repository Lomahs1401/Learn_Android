package com.example.recyclerviewexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.recyclerviewexample.adapter.UserAdapter
import com.example.recyclerviewexample.databinding.ActivityStickyListHeadersListViewBinding

class StickyListHeadersListViewActivity : AppCompatActivity() {
    private val binding: ActivityStickyListHeadersListViewBinding by lazy {
        ActivityStickyListHeadersListViewBinding.inflate(layoutInflater)
    }

    private val userAdapter: UserAdapter by lazy {
        UserAdapter(context = applicationContext)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        userAdapter.setData(getListUser())
        binding.listUser.adapter = userAdapter
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
