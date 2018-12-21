package com.example.user.demos

import android.content.Context
import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ProgressBar
import android.widget.TextView
import android.view.View
import android.widget.Button
import android.widget.Toast


class AsyncTaskActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_async_task)

        val txttitle = findViewById<TextView>(R.id.txttitle)
        val pgbar = findViewById<ProgressBar>(R.id.pgbar)
        val btnupdate = findViewById<Button>(R.id.btnupdate)
        btnupdate.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View) {
                val myTask = MyAsyncTask(this@AsyncTaskActivity, txttitle, pgbar)
                myTask.execute()
            }
        })
    }
}

class DelayOperator {
    //延时操作,用来模拟下载
    fun delay(ms: Long) {
        try {
            Thread.sleep(ms)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }

    }
}


class MyAsyncTask (sContext: Context, text: TextView, pgBar: ProgressBar): AsyncTask<String,Int,String>() {

    var progressBar: ProgressBar = pgBar
    var textView: TextView = text
    var context: Context = sContext

    var i = 0
    //任务执行之前开始调用此方法，可以在这里显示进度对话框。
    override fun onPreExecute() {
        super.onPreExecute()
        Log.d("duke", "开始")
    }


    //此方法在后台线程 执行，完成任务的主要工作，通常需要较长的时间。
    override fun doInBackground(vararg p0: String?): String {

        while (i < 100) {
            i = i + 10
            DelayOperator().delay(10)
            publishProgress(i)
        }
        return "完成"
    }

    //更新UI
    override fun onProgressUpdate(vararg values: Int?) {
        super.onProgressUpdate(*values)
        //若有复杂逻辑，可以增加异常捕捉
        progressBar.progress = values?.get(0) ?: 0
        textView.text = values[0].toString() + "% 进度"
    }

    //任务执行完了后执行
    override fun onPostExecute(result: String?) {
        super.onPostExecute(result)

        Toast.makeText(context, "进程结束", Toast.LENGTH_LONG).show()
    }
}