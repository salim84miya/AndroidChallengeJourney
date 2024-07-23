package com.example.intentservice

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.intentservice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.startBtn.setOnClickListener {
            Intent(this,MyIntentService::class.java).also {
                startService(it)
                binding.tvService.text = "Service Running"
            }
        }

        binding.stopBtn.setOnClickListener {
            MyIntentService.stopService()
            binding.tvService.text = "Service Stopped"

        }



    }
}