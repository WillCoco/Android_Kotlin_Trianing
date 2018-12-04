package com.example.user.demos.Layout

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar
import android.util.Log
import android.view.MenuItem
import android.widget.*
import com.example.user.demos.MainActivity
import com.example.user.demos.R

class LayoutActivity : AppCompatActivity() {
    val layouts = arrayOf(
            "LinearLayout",
            "RelativeLayout",
            "AbsoluteLayout",
            "TableLayout",
            "FrameLayout",
            "GridLayout"
    )
    val actives = arrayOf(
            LinearLayoutActivity::class.java,
            RelativeLayoutActivity::class.java,
            AbsoluteLayoutActivity::class.java,
            TableLayoutActivity::class.java,
            FrameLayoutActivity::class.java,
            GridLayoutActivity::class.java
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_layout)

        val toolbar = findViewById<Toolbar>(R.id.common_toolbar_top)
        setSupportActionBar(toolbar)

        getSupportActionBar()?.setTitle("layout")
        getSupportActionBar()?.setDisplayHomeAsUpEnabled(true)

        val list = findViewById<ListView>(R.id.layouts)

        val adapter = ArrayAdapter(this, R.layout.simple_list_item_1, layouts)
        list.adapter = adapter

        list.onItemClickListener = AdapterView.OnItemClickListener() {
            parent, view, position, id ->
//            val row = parent.getItemAtPosition(position) as Map<String, Any>
            val active = actives[position] as Class<*>

            val intent = Intent(this@LayoutActivity, active)
            startActivity(intent)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem) : Boolean {
        Log.i("Tag6661", "${android.R.id.home} ${item.getItemId().toString()}")
        when (item.getItemId()) {
            android.R.id.home -> returnHome(this)
            else ->
            return true
        }
        return super.onOptionsItemSelected(item);
    }

   fun returnHome(context: Context) {
        val intent = Intent(this@LayoutActivity, MainActivity::class.java);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        context.startActivity(intent)
    }
}
