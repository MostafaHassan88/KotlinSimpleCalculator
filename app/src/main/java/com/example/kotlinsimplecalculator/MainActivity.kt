package com.example.kotlinsimplecalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var storedNumber : Double? = null
    var operation : Int? = null
    var shouldResetField: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       // txtResult;
    }

    fun onNumberBtnClick(view:View){
        var number : Int = 0
        when(view.id){
            R.id.btn0 -> number = 0
            R.id.btn1 -> number = 1
            R.id.btn2 -> number = 2
            R.id.btn3 -> number = 3
            R.id.btn4 -> number = 4
            R.id.btn5 -> number = 5
            R.id.btn6 -> number = 6
            R.id.btn7 -> number = 7
            R.id.btn8 -> number = 8
            R.id.btn9 -> number = 9
        }

        if(!txtResult.text.toString().equals("0") && !shouldResetField){
            txtResult.text = txtResult.text.toString()+ number.toString()
        }else{
            txtResult.text = number.toString()
            if(shouldResetField){
                shouldResetField = false
            }
        }
    }
    fun onBtnDotClick(view:View){
        txtResult.text = txtResult.text.toString()+ "."
    }

    fun onBtnClearClick(view:View){
        txtResult.text = "0"
        this.operation = null
        storedNumber = null
    }

    fun onBtnDividedClick(view:View){
        doCalculationForOperation(4)
    }

    fun onBtnTimesClick(view:View){
        doCalculationForOperation(3)
    }

    fun onBtnMinusClick(view:View){
        doCalculationForOperation(2)
    }

    fun onBtnPlusClick(view:View){
        doCalculationForOperation(1)
    }

    fun doCalculationForOperation(operation : Int){
        shouldResetField = true
        if(this.operation == null){
            this.operation = operation
            storedNumber = txtResult.text.toString().toDouble()
        }else{
            if(!txtResult.text.toString().equals("0")){
                when(this.operation){
                    1 ->  roundResult(storedNumber?.plus(txtResult.text.toString().toDouble()))
                    2 -> roundResult(storedNumber?.minus(txtResult.text.toString().toDouble()))
                    3 -> roundResult(storedNumber?.times(txtResult.text.toString().toDouble()))
                    4 -> roundResult(storedNumber?.div(txtResult.text.toString().toDouble()))
                }
            }
            if(operation == 5) {
                this.operation = null
                storedNumber = null
            }else{
                this.operation = operation
                storedNumber = txtResult.text.toString().toDouble()
            }
        }

    }

    fun roundResult(d:Double?){
       if(d != null && Math.floor(d) == d){
           txtResult.text = d.toInt().toString()
       }else{
           txtResult.text = d.toString()
       }
    }

    fun onBtnEqualClick(view:View){
        doCalculationForOperation(5)
    }
}
