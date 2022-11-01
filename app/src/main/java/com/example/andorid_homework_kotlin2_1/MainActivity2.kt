package com.example.andorid_homework_kotlin2_1

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.andorid_homework_kotlin2_1.databinding.ActivityMain2Binding
import com.example.andorid_homework_kotlin2_1.databinding.ActivityMainBinding

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding
    private var sugar = "無糖"
    private var iceOpt = "去冰"

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main2)

        binding.radioGroup.setOnCheckedChangeListener(){
            _,
            i -> when(i){
                binding.radioButton1.id -> sugar = "無糖"
                binding.radioButton2.id -> sugar = "少糖"
                binding.radioButton3.id -> sugar = "半糖"
                binding.radioButton4.id -> sugar = "全糖"
            }
        }

        binding.radioGroup2.setOnCheckedChangeListener(){
            _,
            i-> when(i){
                binding.radioButton5.id -> iceOpt = "去冰"
                binding.radioButton6.id -> iceOpt = "微冰"
                binding.radioButton7.id -> iceOpt = "少冰"
                binding.radioButton8.id -> iceOpt = "正常冰"
            }
        }

        binding.btnSend.setOnClickListener{

            val drink = binding.edDrink.text.toString()
            val intent = Intent()
            val bundle = Bundle()

            with(bundle){
                putString("sugar",sugar)
                putString("drink",drink)
                putString("ice",iceOpt)
            }

            intent.putExtras(bundle)
            setResult(101,intent)
            finish()

        }
    }


}


