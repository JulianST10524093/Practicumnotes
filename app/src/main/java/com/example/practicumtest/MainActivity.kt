package com.example.practicumtest

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.practicumtest.databinding.ActivityMainBinding

/**
 * --- MULTIPURPOSE MAIN SCREEN TEMPLATE ---
 * This code is built to be "Bulletproof" and "Interchangeable".
 * 
 * HOW TO CHANGE THIS FOR DIFFERENT QUESTIONS:
 * 1. Change the names and values in the arrays below (e.g., Change "Monday" to "Product A").
 * 2. Update the labels in the strings (e.g., Change "Average Temp" to "Average Sales").
 * 3. Ensure your XML IDs match the binding calls (e.g., binding.btnCalculate).
 */
class MainActivity : AppCompatActivity() {

    // --- STEP 1: THE DATA (PARALLEL ARRAYS) ---
    // Why use arrays? To store multiple pieces of information of the same type.
    // Why "Parallel"? Because index 0 in 'categories' matches index 0 in 'dataValues1', etc.
    
    // CHANGE THESE to suit your specific question (Weather, Grades, Shopping, etc.)
    private var categories = arrayOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
    private var dataValues1 = doubleArrayOf(12.0, 15.0, 10.0, 12.0, 11.0, 10.0, 10.0) // e.g., Min Temp or Price
    private var dataValues2 = doubleArrayOf(25.0, 29.0, 22.0, 24.0, 23.0, 18.0, 16.0) // e.g., Max Temp or Stock
    private var extraInfo = arrayOf("Sunny", "Sunny", "Cloudy", "Rainy", "Cloudy", "Raining", "Cold") // e.g., Conditions or Description

    // Binding variable connects this code to activity_main.xml
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // --- STEP 2: INITIALIZE THE SCREEN ---
        // inflate() prepares the layout, and setContentView() puts it on the screen.
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize our buttons and logic
        Log.d("AppLifecycle", "MainActivity Created - Initializing UI")
        setupCalculateButton()
        setupClearButton()
        setupDetailedViewButton()
        setupExitButton()
    }

    // --- STEP 3: CALCULATIONS (THE LOOP) ---
    // This function calculates the average. It is "Bulletproof" because it handles empty arrays.
    private fun setupCalculateButton() {
        binding.btnCalculate.setOnClickListener {
            Log.d("UserAction", "Calculate Button Clicked")
            // A loop is used to go through each number and add it to a total.
            var total = 0.0
            for (value in dataValues2) {
                total += value
            }

            // Calculate average: Total divided by the number of items.
            // Check if not empty to avoid "Division by Zero" error.
            val average = if (dataValues2.isNotEmpty()) total / dataValues2.size else 0.0

            // UPDATE UI: Show the result.
            // String.format("%.1f", ...) rounds to 1 decimal place.
            binding.txtAverage.text = "Average: ${String.format("%.1f", average)}"

            // LOGGING: Prints info to the Logcat (helps for debugging).
            Log.d("AppDebug", "Calculated Sum: $total, Average: $average")
        }
    }

    // --- STEP 4: RESET / CLEAR LOGIC ---
    // This allows the user to wipe the data and start over.
    private fun setupClearButton() {
        binding.btnClear.setOnClickListener {
            Log.d("UserAction", "Clear Button Clicked")
            // A loop is used to set every number in the arrays back to zero.
            for (i in dataValues1.indices) {
                dataValues1[i] = 0.0
                dataValues2[i] = 0.0
            }

            // Update UI to show data is cleared
            binding.txtAverage.text = "Average: 0.0"
            Toast.makeText(this, "All data has been cleared.", Toast.LENGTH_SHORT).show()
            Log.d("AppDebug", "All array data reset to 0.0")
        }
    }

    // --- STEP 5: NAVIGATION (PASSING DATA) ---
    // This moves us to the next screen and takes our data arrays with us.
    private fun setupDetailedViewButton() {
        binding.btnDetailed.setOnClickListener {
            Log.d("UserAction", "Navigating to Detailed View")
            // Intent is like an envelope that carries data to another activity.
            val intent = Intent(this, DetailedViewActivity::class.java)

            // 'putExtra' puts the data into the envelope using a unique "Key".
            intent.putExtra("KEY_CAT", categories)
            intent.putExtra("KEY_VAL1", dataValues1)
            intent.putExtra("KEY_VAL2", dataValues2)
            intent.putExtra("KEY_EXTRA", extraInfo)

            // Send the envelope and change screens.
            Log.d("AppDebug", "Data packaged into Intent. Array size: ${categories.size}")
            startActivity(intent)
        }
    }

    // --- STEP 6: EXIT ---
    // Closes everything.
    private fun setupExitButton() {
        binding.btnExit.setOnClickListener {
            Log.d("UserAction", "Exit Button Clicked - Closing App")
            // finishAffinity() closes all activities in the app.
            finishAffinity()
        }
    }
}
