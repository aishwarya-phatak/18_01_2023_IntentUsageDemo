package com.example.a18_01_2023_intentusagedemo

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.StrictMode
import com.example.a18_01_2023_intentusagedemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        StrictMode.setVmPolicy(
            StrictMode.VmPolicy.Builder().build()
        )
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnShowImage.setOnClickListener {
            var intent = Intent("in.bitcode.media.SHOW")
           // intent.action = "in.bitcode.media.SHOW"

            intent.setDataAndType(
                Uri.parse(binding.edtPath.text.toString()),
                "image/jpeg"
            )
            startActivity(intent)
        }

        binding.btnShowImageINGal.setOnClickListener {
            var intent = Intent(Intent.ACTION_VIEW)
            intent.setDataAndType(
                Uri.parse(binding.edtPath.text.toString()),
                "image/jpeg"
            )
            startActivity(intent)

        }
        binding.btnAudioPlay.setOnClickListener {
            var intent = Intent(Intent.ACTION_VIEW)
            intent.setDataAndType(
                Uri.parse(binding.edtPath.text.toString()),
                "audio/mp3"
            )
            startActivity(intent)
        }
        binding.btnVideoPlay.setOnClickListener {
            var intent = Intent(Intent.ACTION_VIEW)
            intent.setDataAndType(
                Uri.parse(binding.edtPath.text.toString()),
                "video/mp4"
            )
            startActivity(intent)
        }

        binding.btnOpenWebsite.setOnClickListener {
            var intent = Intent("android.intent.action.VIEW")
            intent.data = Uri.parse(binding.edtPath.text.toString())
        }
        binding.btnShare.setOnClickListener {
            var intent = Intent(Intent.ACTION_SEND)
            intent.type = "image/*"
            startActivityForResult(intent,1)
        }
        binding.btnCall.setOnClickListener{
            var intent = Intent(Intent.ACTION_CALL)
            intent.data = Uri.parse(binding.edtPath.text.toString())
            startActivity(intent)
        }
    }
}