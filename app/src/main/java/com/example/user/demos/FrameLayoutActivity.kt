package com.example.user.demos

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.view.View.OnTouchListener
import android.widget.FrameLayout
import com.example.user.drawable.DrawableView

class FrameLayoutActivity : AppCompatActivity() {

     override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_frame_layout)
        val frame = findViewById(R.id.frame_layout) as FrameLayout
        val drawable = DrawableView(this@FrameLayoutActivity)
        //添加触摸事件监听器
        drawable.setOnTouchListener(object : View.OnTouchListener {
         override fun onTouch(v: View?, event: MotionEvent?): Boolean {
             if ((event?.x is Number && event?.y is Number)) {
                 drawable.bitmapX = event.x - 150
                 drawable.bitmapY = event.y - 150
                 //调用重绘方法
                 drawable.invalidate()
             }

             return true
             return v?.onTouchEvent(event) ?: true
         }
        })

        frame.addView(drawable)
    }
}
