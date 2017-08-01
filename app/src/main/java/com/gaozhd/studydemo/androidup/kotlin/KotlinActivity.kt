package com.gaozhd.studydemo.androidup.kotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

import com.gaozhd.studydemo.R
import kotlinx.android.synthetic.main.layout_kotlin.*

class KotlinActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_kotlin)
        kotlin_tv.text = "123456";
        kotlin_btn.setOnClickListener {
            Toast.makeText(this, "123456", Toast.LENGTH_LONG).show();
        }
    }
}
