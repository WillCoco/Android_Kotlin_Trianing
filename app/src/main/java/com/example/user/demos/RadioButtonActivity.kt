package com.example.user.demos

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast



class RadioButtonActivity : AppCompatActivity() {
    var radgroup: RadioGroup? = null
    var btnchange: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_radio_button)

        radgroup = findViewById<RadioGroup>(R.id.radioGroup)
        btnchange = findViewById<View>(R.id.btnpost) as Button

        //第一种获得单选按钮值的方法
        //为radioGroup设置一个监听器:setOnCheckedChanged()
        var text : CharSequence = "女"
        radgroup!!.setOnCheckedChangeListener(object : RadioGroup.OnCheckedChangeListener {
            override fun onCheckedChanged(group: RadioGroup, checkedId: Int) {
                val radbtn = findViewById<View>(checkedId) as RadioButton
                text = radbtn.text
            }
        })
        btnchange!!.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View) {
                Toast.makeText(applicationContext, "按钮组值发生改变,你选了" + text, Toast.LENGTH_LONG).show()
            }
        })



//        val radgroup = findViewById<View>(R.id.radioGroup) as RadioGroup
//        //为radioGroup设置一个监听器:setOnCheckedChanged()
//        btnchange.setOnClickListener(object : View.OnClickListener {
//            override fun onClick(v: View) {
//                for (i in 0 until radgroup.childCount) {
//                    val rd = radgroup.getChildAt(i) as RadioButton
//                    if (rd.isChecked) {
//                        Toast.makeText(applicationContext, "点击提交按钮,获取你选择的是:" + rd.text, Toast.LENGTH_LONG).show()
//                        break
//                    }
//                }
//            }
//        })
    }

}
