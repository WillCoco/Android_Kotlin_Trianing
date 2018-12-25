package com.example.user.demos

import android.app.Notification
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.sip.SipSession
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class NotificationActivity : AppCompatActivity() {
    var LargeBitmap: Bitmap? = null
    var mNManager: NotificationManager? = null
    var notify1: Notification? = null
    var NOTIFYID_1: Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notification)

        // 创建大图标
        LargeBitmap = BitmapFactory.decodeResource(this.resources, R.drawable.logo)
        mNManager = this.getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        bindView()
    }

    fun bindView() {
        var btnShow = findViewById<Button>(R.id.btn_show_normal)
        var btnClose = findViewById<Button>(R.id.btn_close_normal)
        btnShow.setOnClickListener(object: View.OnClickListener {
            override fun onClick(v: View?) {
                //定义一个PendingIntent点击Notification后启动一个Activity
                val it = Intent()
                val pit = PendingIntent.getActivity(this@NotificationActivity, 0, it, 0)

                //设置图片,通知标题,发送时间,提示方式等属性
                val mBuilder = Notification.Builder(this@NotificationActivity)
                mBuilder.setContentTitle("叶良辰")                        //标题
                    .setContentText("我有一百种方法让你呆不下去~")      //内容
//                            .setSubText("——记住我叫叶良辰")                    //内容下面的一小段文字
                    .setTicker("收到叶良辰发送过来的信息~")             //收到信息后状态栏显示的文字信息
                    .setWhen(System.currentTimeMillis())           //设置通知时间
                    .setSmallIcon(R.drawable.logo)            //设置小图标
                    .setLargeIcon(LargeBitmap)                     //设置大图标
                    .setDefaults(Notification.DEFAULT_LIGHTS or Notification.DEFAULT_VIBRATE)    //设置默认的三色灯与振动器
//                            .setSound(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.biaobiao))  //设置自定义的提示音
                    .setAutoCancel(true)                           //设置点击后取消Notification
                    .setContentIntent(pit)                        //设置PendingIntent

                notify1 = mBuilder.build()
                mNManager!!.notify(NOTIFYID_1, notify1)
            }
        })

        btnClose.setOnClickListener(object: View.OnClickListener {
            override fun onClick(v: View?) {
                //除了可以根据ID来取消Notification外,还可以调用cancelAll();关闭该应用产生的所有通知
                mNManager!!.cancel(NOTIFYID_1)
            }
        })
    }
}
