package com.example.practicumtest

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.practicumtest.databinding.ActivitySplashBinding

/**
 * SPLASH SCREEN: MULTIPURPOSE TEMPLATE
 * This is the first screen the user sees. It handles branding and entry logic.
 */
class SplashActivity : AppCompatActivity() {

    // View Binding for activity_splash.xml
    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // STEP 1: INITIALIZE VIEW BINDING
        // Connects the Kotlin code to the XML layout elements.
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // STEP 2: SETUP NAVIGATION
        // Logic to move the user from the Splash Screen to the Main Screen.
        setupEnterAppButton()

        // STEP 3: SETUP EXIT LOGIC
        // Logic to exit the application from the start.
        setupExitAppButton()
    }

    // --- NAVIGATION FUNCTIONS ---

    private fun setupEnterAppButton() {
        // STEP 2.1: BTN CLICK LISTENER
        binding.btnStart.setOnClickListener {
            // STEP 2.2: CREATE INTENT
            // Explicit intent to go to MainActivity.
            val intent = Intent(this, MainActivity::class.java)
            
            // STEP 2.3: TRIGGER TRANSITION
            startActivity(intent)
            
            // STEP 2.4: CLOSE SPLASH
            // We call finish() so the user can't click 'back' to see the splash screen again.
            finish()
        }
    }

    private fun setupExitAppButton() {
        // STEP 3.1: BTN CLICK LISTENER
        binding.btnExitSplash.setOnClickListener {
            // STEP 3.2: KILL APP
            finishAffinity()
        }
    }
}
