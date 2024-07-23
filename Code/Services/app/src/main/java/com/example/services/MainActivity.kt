package com.example.services

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.services.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.startBtn.setOnClickListener {
            Intent(this,MyService::class.java).also {
                startService(it)
                binding.tvService.text = "Service Started"
            }
        }

        binding.stopBtn.setOnClickListener {
            Intent(this,MyService::class.java).also {
                stopService(it)
                binding.tvService.text = "Service Stopped"
            }
        }

        binding.submitBtn.setOnClickListener {
            Intent(this,MyService::class.java).also {
                val data = binding.ed.text.toString()
                it.putExtra("EXTRA_DATA",data)
                startService(it)
            }
        }

    }
}