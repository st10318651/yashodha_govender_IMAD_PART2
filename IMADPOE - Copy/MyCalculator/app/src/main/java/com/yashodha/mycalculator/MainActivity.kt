package com.yashodha.mycalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlin.math.pow
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {

    private lateinit var Number1EditText: EditText
    private lateinit var Number2EditText: EditText
    private lateinit var AdditionButton: Button
    private lateinit var SubtractionButton: Button
    private lateinit var MultiplicationButton: Button
    private lateinit var DivisionButton: Button
    private lateinit var SquareRootButton: Button
    private lateinit var PowerButton: Button
    private lateinit var ResultTextView: TextView
    //the UI elements are declared in the code above.


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Number1EditText = findViewById(R.id.Number1EditText)
        Number2EditText = findViewById(R.id.Number2EditText)
        AdditionButton = findViewById(R.id.AdditionButton)
        SubtractionButton = findViewById(R.id.SubtractionButton)
        MultiplicationButton = findViewById(R.id.MultiplicationButton)
        DivisionButton = findViewById(R.id.DivisionButton)
        SquareRootButton = findViewById(R.id.squareRootButton)
        PowerButton = findViewById(R.id.PowerButton)
        ResultTextView = findViewById(R.id.ResultTextView)
        //The UI elements are initialized using the findViewById function in the code above.


        AdditionButton.setOnClickListener { performOperation("+") }
        SubtractionButton.setOnClickListener { performOperation("-") }
        MultiplicationButton.setOnClickListener { performOperation("*") }
        DivisionButton.setOnClickListener { performOperation("/") }
        SquareRootButton.setOnClickListener { performSquareRoot() }
        PowerButton.setOnClickListener { performPower() }
    }

    private fun performOperation(operator: String) {
        val Number1 = Number1EditText.text.toString().toDouble()
        val Number2 = Number2EditText.text.toString().toDouble()

        //This code reads the values from both editText fields.

        when (operator) {
            "+" -> displayResult("$Number1 + $Number2 = ${Number1 + Number2}")
            "-" -> displayResult("$Number1 - $Number2 = ${Number1 - Number2}")
            "*" -> displayResult("$Number1 * $Number2 = ${Number1 * Number2}")
            "/" -> {
                if (Number2 == 0.0) {
                    displayResult("Error: Division by 0 is not allowed")
                } else {
                    displayResult("$Number1 / $Number2 = ${Number1 / Number2}")
                }
            }
        }
    }

    private fun performSquareRoot() {
        val Number1 = Number1EditText.text.toString().toDouble()

        if (Number1 < 0) {
            val result = sqrt(-Number1)
            displayResult("sqrt($Number1) = ${result}i")
        } else {
            val result = sqrt(Number1)
            displayResult("sqrt($Number1) = $result")
        }
    }

    private fun performPower() {
        val Number1 = Number1EditText.text.toString().toDouble()
        val Number2 = Number2EditText.text.toString().toInt()

        val result = Number1.pow(Number2)
        displayResult("$Number1^$Number2 = $result")
    }

    private fun displayResult(result: String) {
        ResultTextView.text = result
    }
}

//changes:
//i have changed the format of the calculator and added in a editText[my calculator]
//i have increased the font size
//i have also added in comments


//Reference list:
//https://youtube/Zi1XgFTUH9k
//https://youtube/v24Bhk7wQI8
//https://youtube/VAXwjQH4YYg
//https://youtube/htX-J2cdeP
//https://www.w3schools.com/


