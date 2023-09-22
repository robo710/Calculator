package com.sonchan.haesungcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.sonchan.haesungcalculator.databinding.ActivityMainBinding
import com.sothree.slidinguppanel.SlidingUpPanelLayout

class MainActivity : AppCompatActivity() {
    val binding = ActivityMainBinding.inflate(layoutInflater)
    var answer = 0.0
    var output1 = 0.0
    var input1 = 0
    var text1 = ""
    var time = 0

    val buttons = listOf(
        binding.a0, binding.a1, binding.a2, binding.a3, binding.a4,
        binding.a5, binding.a6, binding.a7, binding.a8, binding.a9
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        for (i in 0..9) {
            buttons[i].setOnClickListener {
                add(i)
            }
        }
        binding.backSpace.setOnClickListener {
            if (input1 != 0){
                input1 /= 10
                binding.input.text = input1.toString()
            }
            else{
                time = 0
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
                "/" -> answer = output1 / input1
                "*" -> answer = output1 * input1
                "-" -> answer = output1 -input1
                "+" -> answer = output1 + input1
                "%" -> answer = output1 % input1
            }
            time++
            commend()
        }
        binding.c.setOnClickListener {
            input1 = 0
            output1 = input1.toDouble()
            answer = output1
            text1 =""
            time = 0
            commend()
        }
        binding.ce.setOnClickListener {
            text1 =""
            time = 0
            commend()
        }
        binding.dot.setOnClickListener {
            input1.toDouble()
        }
        binding.listBtn.setOnClickListener {
        }
    }

    // 패널의 상태가 변했을 때
    fun onPanelStateChanged(
        panel: View?,
        previousState: SlidingUpPanelLayout.PanelState?,
        newState: SlidingUpPanelLayout.PanelState?
    ) {
        if (newState == SlidingUpPanelLayout.PanelState.COLLAPSED) {
            binding.listBtn.text = "리스트 열기"
        } else if (newState == SlidingUpPanelLayout.PanelState.EXPANDED) {
            binding.listBtn.text = "리스트 닫기"
        }
    }

    fun add(a : Int){
        input1 = input1 * 10 + a
        binding.input.text = (input1 .toString())
    }

    fun sign(a : String){
        text1 = a
        if(time == 0){
            output1 = input1.toDouble()
        }
        else{
            output1 = answer
        }
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
        if(time == 0){
            binding.answer.text = ""
        }
        else{
            binding.answer.text = answer.toString()
        }
        output1 = answer
    }
}
