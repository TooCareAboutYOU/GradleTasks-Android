package com.gradle.tasks.android

import android.media.MediaDrm
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gradle.tasks.android.databinding.ActivityMainBinding
import java.util.UUID

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val stringBuilder: StringBuilder by lazy { StringBuilder() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        stringBuilder.append("jni_json：${stringFromJNI()}").append("\n")
        try {
            val WIDEVINE_UUID = UUID(-0x121074568629b532L, -0x5c37d8232ae2de13L)
            val mediaDrm = MediaDrm(WIDEVINE_UUID)
            val widevineId = mediaDrm.getPropertyByteArray(MediaDrm.PROPERTY_DEVICE_UNIQUE_ID)
            val sb = StringBuilder()
            widevineId.forEach {
                sb.append(String.format("%02x", it))
            }
            stringBuilder.append("唯一标识：$sb")
        } catch (e: Exception) {
            e.printStackTrace()
        }

        binding.sampleText.text = stringBuilder.toString()
    }

    companion object {
        init {
            System.loadLibrary("android")
            System.loadLibrary("jsoncpp")
        }
    }

    external fun stringFromJNI(): String

}