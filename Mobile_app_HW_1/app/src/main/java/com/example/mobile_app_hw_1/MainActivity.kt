package com.example.mobile_app_hw_1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
//import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val input = findViewById<EditText>(R.id.inputNumber)
        val button = findViewById<Button>(R.id.myButton)
        val output = findViewById<TextView>(R.id.outputText)


        button.setOnClickListener {
            val myInput = input.text.toString().toInt()
            val myResult = integerToEnglish(myInput)
            output.text = myResult
            Toast.makeText(this, myResult, Toast.LENGTH_SHORT).show()
        }
    }

        fun integerToEnglish(n: Int): String {
            val ones = arrayOf("", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
                "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen")
            val tens = arrayOf("", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety")

            fun convert(num: Int): String {
                if (num<0 || num > 999999999)
                    return ("Please input number between 0 to 999.999.999 interval")
                return when {
                    num < 20 -> ones[num]
                    num < 100 -> tens[num / 10] + (if (num % 10 != 0) " " + convert(num % 10) else "")
                    num < 1000 -> ones[num / 100] + " hundred" + (if (num % 100 != 0) " " + convert(num % 100) else "")
                    else -> integerToEnglish(num / 1000) + " thousand" + (if (num % 1000 != 0) " " + convert(num % 1000) else "")
                }
            }
            return if (n == 0) "zero" else convert(n)
        }


    }


