package com.example.practicumtest

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.practicumtest.databinding.ActivitySplashBinding

/**
 * --- MULTIPURPOSE SPLASH SCREEN ---
 * This is the landing page. It is interchangeable by updating the Logo and Text in XML.
 */
class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // --- STEP 1: INITIALIZE ---
        android.util.Log.d("AppLifecycle", "SplashActivity Created")
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set up button navigation
        setupStartButton()
        setupExitButton()
    }

    // --- STEP 2: NAVIGATION ---
    private fun setupStartButton() {
        binding.btnStart.setOnClickListener {
            android.util.Log.d("UserAction", "Start Button Clicked on Splash")
            // Move from SplashActivity to MainActivity.
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            
            // finish() ensures the user can't go 'back' into the splash screen.
            finish()
        }
    }

    // --- STEP 3: EXIT ---
    private fun setupExitButton() {
        binding.btnExitSplash.setOnClickListener {
            android.util.Log.d("UserAction", "Exit Button Clicked on Splash")
            // Close the app.
            finishAffinity()
        }
    }
}
