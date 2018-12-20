package com.example.user.demos

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import android.R.attr.orientation
import android.content.res.Configuration
import android.content.pm.ActivityInfo
import android.util.Log
import android.view.View
import android.widget.Button


class ConfigurationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_configuration)

        val txtResult = findViewById(R.id.txtResult) as TextView
        val status = StringBuffer()
        //①获取系统的Configuration对象
        val cfg = resources.configuration
        //②想查什么查什么
        status.append("densityDpi:" + cfg.densityDpi + "\n")
        status.append("fontScale:" + cfg.fontScale + "\n")
        status.append("hardKeyboardHidden:" + cfg.hardKeyboardHidden + "\n")
        status.append("keyboard:" + cfg.keyboard + "\n")
        status.append("keyboardHidden:" + cfg.keyboardHidden + "\n")
        status.append("locale:" + cfg.locale + "\n")
        status.append("mcc:" + cfg.mcc + "\n")
        status.append("mnc:" + cfg.mnc + "\n")
        status.append("navigation:" + cfg.navigation + "\n")
        status.append("navigationHidden:" + cfg.navigationHidden + "\n")
        status.append("orientation:" + cfg.orientation + "\n")
        status.append("screenHeightDp:" + cfg.screenHeightDp + "\n")
        status.append("screenWidthDp:" + cfg.screenWidthDp + "\n")
        status.append("screenLayout:" + cfg.screenLayout + "\n")
        status.append("smallestScreenWidthDp:" + cfg.densityDpi + "\n")
        status.append("touchscreen:" + cfg.densityDpi + "\n")
        status.append("uiMode:" + cfg.densityDpi + "\n")
        txtResult.text = status.toString()

        val btn = findViewById(R.id.btncahange) as Button
        btn.setOnClickListener(object : View.OnClickListener {

            override fun onClick(v: View) {
                val config = resources.configuration
                //如果是横屏的话切换成竖屏
                if (config.orientation == Configuration.ORIENTATION_LANDSCAPE) {
                    this@ConfigurationActivity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)
                }
                //如果竖屏的话切换成横屏

                if (config.orientation == Configuration.ORIENTATION_PORTRAIT) {
                    this@ConfigurationActivity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE)
                }
            }
        })
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        Log.i("dskfj11h", "sdlka")
        val screen = if (newConfig.orientation === Configuration.ORIENTATION_LANDSCAPE) "横屏" else "竖屏"
        Toast.makeText(this@ConfigurationActivity, "系统屏幕方向发生改变 \n 修改后的方向为$screen", Toast.LENGTH_SHORT).show()
    }
}
