package com.gradle.tasks.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gradle.tasks.android.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.sampleText.text = stringFromJNI()
    }


    /**
     * ---------------------------------------------------------------------------------------------
     *
     * ---------------------------------------------------------------------------------------------
     * description： JNI
     */
    companion object {
        init {
            System.loadLibrary("android")
        }
    }

    external fun stringFromJNI(): String

}