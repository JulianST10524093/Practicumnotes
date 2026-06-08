package com.example.practicumtest

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.practicumtest.databinding.ActivitySplashBinding

/**
 * MULTIPURPOSE SPLASH SCREEN TEMPLATE
 * This is the entry point of the app, containing branding and basic navigation.
 */
class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // STEP 1: INITIALIZE LAYOUT
        // Inflate the layout using View Binding to access UI elements.
        // binding = ActivitySplashBinding.inflate(layoutInflater)
        // setContentView(binding.root)

        // STEP 2: SETUP NAVIGATION TO MAIN SCREEN
        // Logic to transition from the Splash Screen to the Application Main Screen.
        setupStartButton()

        // STEP 3: SETUP EXIT LOGIC
        // Logic to close the application from the initial screen.
        setupExitButton()
    }

    // STEP 2 (Detailed): Navigation Logic
    private fun setupStartButton() {
        // Replace 'btnStart' with your button ID in XML
        /*
        binding.btnStart.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            // finish() ensures the user cannot return to the splash screen using the back button.
            finish()
        }
        */
    }

    // STEP 3 (Detailed): Exit Logic
    private fun setupExitButton() {
        // Replace 'btnExit' with your button ID in XML
        /*
        binding.btnExit.setOnClickListener {
            finishAffinity()
        }
        */
    }
}
