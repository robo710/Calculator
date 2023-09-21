package com.sonchan.haesungcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sonchan.haesungcalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        val binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        var output1 = 0.0
        var input1 = 0
        var text1 = ""
        binding.backSpace.setOnClickListener {
            if (input1 != 0){
                input1 /= 10
                binding.input.text = input1.toString()
            }
        }
        fun add(a : Int){
            input1 = input1 * 10 + a
            binding.input.text = (input1 .toString())
        }
        fun sign(a : String){
            text1 = a
            output1 = input1.toDouble()
            input1 = 0
            binding.output.text = output1.toString()
            binding.input.text = input1.toString()
            when (text1) {
                "/" -> binding.check.text = "÷"
                "*" -> binding.check.text = "X"
                "-" -> binding.check.text = "-"
                "+" -> binding.check.text = "+"
                "%" -> binding.check.text = "%"
            }
        }
        fun commend(){
            binding.input.text = input1.toString()
            binding.output.text = output1.toString()
            when (text1) {
                "/" -> binding.check.text = "÷"
                "*" -> binding.check.text = "X"
                "-" -> binding.check.text = "-"
                "+" -> binding.check.text = "+"
                "%" -> binding.check.text = "%"
                "" -> binding.check.text = ""
            }
        }
        val buttons = listOf(
            binding.a0, binding.a1, binding.a2, binding.a3, binding.a4,
            binding.a5, binding.a6, binding.a7, binding.a8, binding.a9
        )

        for (i in 0..9) {
            buttons[i].setOnClickListener {
                add(i)
            }
        }
        binding.slash.setOnClickListener {
            sign("/")
        }
        binding.multiful.setOnClickListener {
            sign("*")
        }
        binding.minus.setOnClickListener {
            sign("-")
        }
        binding.plus.setOnClickListener {
            sign("+")
        }
        binding.percent.setOnClickListener {
            sign("%")
        }
        binding.equal.setOnClickListener {
            when (text1) {
                "/" -> output1 = output1 / input1
                "*" -> output1 = output1 * input1
                "-" -> output1 = output1 -input1
                "+" -> output1 = output1 + input1
                "%" -> output1 = output1 % input1
            }
            commend()
        }
        binding.c.setOnClickListener {
            input1 = 0
            output1 = input1.toDouble()
            text1 =""
            commend()
        }
        binding.ce.setOnClickListener {
            text1 =""
            commend()
        }
    }
}
