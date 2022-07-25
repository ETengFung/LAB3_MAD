package com.example.lab3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lab3.databinding.ActivityMainBinding
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {
    //TODO2
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //TODO3
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btncal.setOnClickListener{
            val age = binding.ageSpinner.selectedItemPosition
            val gender = binding.rdgGender.checkedRadioButtonId
            val smoker = binding.ansSmoke.isChecked

            var chargeOnAge = 0
            chargeOnAge = when(age){
                0 -> 60
                1 -> 70
                2 -> 90
                3 -> 120
                4,5 -> 150
                else -> 0
            }
            var chargeOnGender = 0
            if(gender == binding.rdbMale.id){
                chargeOnGender = when(age){
                    0 -> 0
                    1 -> 50
                    2 -> 100
                    3 -> 150
                    4,5 -> 200
                    else -> 0
                }
            }
            var chargeOnSmoker = 0
            if(smoker){
                chargeOnSmoker = when(age){
                    0 -> 0
                    1 -> 100
                    2 -> 150
                    3 -> 200
                    4 -> 250
                    5 -> 300
                    else -> 0
                }
            }

            var premium = chargeOnAge + chargeOnGender + chargeOnSmoker
            binding.calculateResult.text = premium.toString()
        }
        binding.btnreset.setOnClickListener{
            var premium = 8000000000
            binding.calculateResult.text = premium.toString()
        }
    }
}