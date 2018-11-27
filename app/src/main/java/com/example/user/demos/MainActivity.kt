package com.example.user.demos

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.SimpleAdapter
import java.util.*

class MainActivity : AppCompatActivity() {
    private val demoNames = arrayOf(
            "布局",
            "TextView",
            "Button",
            "EditView",
            "自定义View"
    )

    private val actives = arrayOf(
            LayoutActivity::class.java,
            EmptyActivity::class.java,
            EmptyActivity::class.java,
            EmptyActivity::class.java,
            EmptyActivity::class.java
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val listData = ArrayList<Map<String, Any>>()
        for ((index, _) in demoNames.withIndex()) {
            val item = TreeMap<String, Any>()
            item["title"] = demoNames[index]
            item["active"] = actives[index]
            listData.add(item)
        }


        val list = findViewById<ListView>(R.id.list_view)

        // 包装为ArrayAdapter
        val adapter = SimpleAdapter(this, listData, R.layout.simple_list_item_2, arrayOf("title"), intArrayOf(R.id.list_item_title))

        // 设置adapter
        list.adapter = adapter

        // 监听事件
        list.onItemClickListener = AdapterView.OnItemClickListener() {
            parent, view, position, id ->
                val row = parent.getItemAtPosition(position) as Map<String, Any>
                val active = row["active"] as Class<*>

                val intent = Intent(this@MainActivity, active)
                startActivity(intent)
        }
    }
}
