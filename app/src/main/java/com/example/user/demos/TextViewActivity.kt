package com.example.user.demos

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.widget.TextView

class TextViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_text_view)

        val toolbar = findViewById<Toolbar>(R.id.common_toolbar_top)
        setSupportActionBar(toolbar)
        getSupportActionBar()?.setTitle("TextView")

        val tView = findViewById<TextView>(R.id.text_view_drawable)
        val drawable = tView.getCompoundDrawables();
        drawable[1].setBounds(0, 0, 100, 100)
        tView.setCompoundDrawables(drawable[0], drawable[1], drawable[2], drawable[3])
    }
}
