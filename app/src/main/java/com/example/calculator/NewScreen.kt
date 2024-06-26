package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class NewScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.interface2)

        val i = intent
        val num1 = i.getStringExtra("num1")
        val num2 = i.getStringExtra("num2")
        val op = i.getStringExtra("op")
        val ans = i.getStringExtra("answer")

        val enum1 = findViewById<View>(R.id.num1) as TextView
        val enum2 = findViewById<View>(R.id.num2) as TextView
        val eop = findViewById<View>(R.id.op) as TextView
        val eans = findViewById<View>(R.id.ans) as TextView


        enum1.text = num1
        enum2.text= num2
        eop.text=op
        eans.text=ans

    }
}