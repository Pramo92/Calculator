package com.example.calculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    var ans = 0.0
    var op  ="none"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




    }

    fun buttonClick(view: View){

        val add = findViewById<Button>(R.id.add)
        val sub = findViewById<Button>(R.id.sub)
        val mul = findViewById<Button>(R.id.mul)
        val div = findViewById<Button>(R.id.div)


        add.setOnClickListener{
            performOperation("Addition")
        }
        sub.setOnClickListener {
            performOperation( "Subtraction")
        }
        mul.setOnClickListener {
            performOperation( "Multiplication")
        }
        div.setOnClickListener {
            performOperation("Division")
        }



    }
    fun performOperation(s:String){
        val num1 = findViewById<View>(R.id.num1) as EditText
        val num2 = findViewById<View>(R.id.num2) as EditText
        when (s){

            "Addition" -> ans = num1.text.toString().toDouble() + num2.text.toString().toDouble()
            "Subtraction" -> ans = num1.text.toString().toDouble() - num2.text.toString().toDouble()
            "Multiplication" -> ans = num1.text.toString().toDouble() * num2.text.toString().toDouble()
            "Division" ->
            {
                val secondNum = num2.text.toString().toDouble()

                if (secondNum != 0.0) {
                    ans = num1.text.toString().toDouble() / num2.text.toString().toDouble()
                } else {
                    println("Cannot divide by zero")
                    return
                }
            }
        }

        val bundle = Bundle()
        bundle.putString("num1",num1.text.toString())
        bundle.putString("num2",num2.text.toString())
        bundle.putString("op",s)
        bundle.putString("answer",ans.toString())


        val gotoNewScreen = Intent(applicationContext,NewScreen::class.java)
        gotoNewScreen.putExtras(bundle)
        startActivity(gotoNewScreen)
    }
}