package com.example.andorid_homework_kotlin2_1

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import com.example.andorid_homework_kotlin2_1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    //private lateinit var activityResultLauncher: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //setContentView(R.layout.activity_main)

        binding.btnChoice.setOnClickListener{
            val intent = Intent(this,MainActivity2::class.java)
            startActivityForResult(intent,1)
            //activityResultLauncher.launch(intent)
        }

//        activityResultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
//            result ->
//            if(result.resultCode == 101 && result.data != null){
//                result.data?.extras?.let {
//                    binding.tvMeal.text = "飲料: ${it.getString("drink")}\n\n甜度: ${it.getString("sugar")}\n\n冰塊: ${it.getString("ice")}\n\n"
//                }
//            }
//        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        data?.extras?.let {
            binding.tvMeal.text = "飲料: ${it.getString("drink")}\n\n甜度: ${it.getString("sugar")}\n\n冰塊: ${it.getString("ice")}\n\n"
        }
    }

}