package com.ltts.simple_calculator

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    var isNewOp=true
    var dot=false
    fun buttonNumberEvent(view: View)
    {
        if(isNewOp)
        {
            etShowNumber.setText("")
        }
        isNewOp=false
        val buttonSelect= view as Button
        var buClickValue:String=etShowNumber.text.toString()
        when(buttonSelect.id)
        {
            button0.id->
            {
                buClickValue+="0"
            }
            button1.id->
            {
                buClickValue+="1"
            }
            button2.id->
            {
                buClickValue+="2"
            }
            button3.id->
            {
                buClickValue+="3"
            }
            button4.id->
            {
                buClickValue+="4"
            }
            button5.id->
            {
                buClickValue+="5"
            }
            button6.id->
            {
                buClickValue+="6"
            }
            button7.id->
            {
                buClickValue+="7"
            }
            button8.id->
            {
                buClickValue+="8"
            }
            button9.id->
            {
                buClickValue+="9"
            }
            buttonDot.id->
            {
                if(dot==false)
                {
                    buClickValue += "."
                }
                dot=true
            }
            buPlusMinus.id->
            {
                buClickValue="-" + buClickValue
            }
        }
        etShowNumber.setText(buClickValue)
    }
    var op="X"
    var oldNumber=""

    fun buOpEvent(view: View)
    {
        val buSelect= view as Button
        when(buSelect.id)
        {
            buMul.id->
            {
                op="X"
            }
            buDiv.id->
            {
                op="÷"
            }
            buSub.id->
            {
                op="-"
            }
            buSum.id->
            {
                op="+"
            }
        }
        oldNumber=etShowNumber.text.toString()
        isNewOp=true
        dot=false
    }

    fun buEqualEvent(view: View)
    {
        val newNumber=etShowNumber.text.toString()
        var finalNumber:Double?=null
        when(op)
        {
            "X"->
            {
                finalNumber=oldNumber.toDouble() * newNumber.toDouble()
            }
            "÷"->
            {
                finalNumber=oldNumber.toDouble() / newNumber.toDouble()
            }
            "-"->
            {
                finalNumber=oldNumber.toDouble() - newNumber.toDouble()
            }
            "+"->
            {
                finalNumber=oldNumber.toDouble() + newNumber.toDouble()
            }
        }
        etShowNumber.setText(finalNumber.toString())
        isNewOp=true
    }

    fun buPercentEvent(view: View)
    {
        val number=(etShowNumber.text.toString().toDouble())/100
        etShowNumber.setText(number.toString())
        isNewOp=true
    }

    fun buCleanEvent(view: View)
    {
        etShowNumber.setText("")
        isNewOp=true
        dot=false
    }
}