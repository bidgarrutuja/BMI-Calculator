package com.example.bmicalculator

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.bmicalculator.databinding.ActivityMainBinding
import kotlin.math.pow

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.calculator.setOnClickListener{
            calculateBMI()
        }

    }
    private fun calculateBMI(){
        val weight = binding.weightEdit.text.toString().toFloatOrNull()
        val height = binding.heightEdit.text.toString().toFloatOrNull()
        if(weight!=null && height!=null){
            val bmi = weight/(height/100).pow(2)
            val bmiresult = String.format("%.2f",bmi)
            val bmicategory = when{
                bmi<18.5-> "Under Weight"
                bmi<25 -> "Normal Weight"
                bmi<30 -> "Over Weight"
                else -> "Obese"
            }
            binding.resulttext.text = "BMI: $bmiresult\nCategory:$bmicategory"
        }else{
            binding.resulttext.text = "Invalid Input"
        }
    }
}