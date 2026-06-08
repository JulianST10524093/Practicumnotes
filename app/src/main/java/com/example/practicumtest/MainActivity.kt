package com.example.practicumtest

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.practicumtest.databinding.ActivityMainBinding

/**
 * MAIN SCREEN: MULTIPURPOSE TEMPLATE
 * This code is designed to be easily modified for any situation (Weather, Grades, etc.)
 */
class MainActivity : AppCompatActivity() {

    // STEP 1: DECLARE DATA (PARALLEL ARRAYS)
    // Parallel arrays store related information at the same index position.
    // Modify these values to change the application's "situation".
    private var categories = arrayOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
    private var dataValues1 = doubleArrayOf(12.0, 15.0, 10.0, 12.0, 11.0, 10.0, 10.0)
    private var dataValues2 = doubleArrayOf(25.0, 29.0, 22.0, 24.0, 23.0, 18.0, 16.0)
    private var conditions = arrayOf("Sunny", "Sunny", "Cloudy", "Rainy", "Cloudy", "Raining", "Cold")

    // Binding variable allows us to access UI elements without using 'findViewById'
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // STEP 2: INITIALIZE BINDING
        // Connects this Kotlin file to activity_main.xml
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // STEP 3: SETUP CALCULATIONS
        // This function holds the logic for processing the numeric data in the arrays.
        setupCalculateButton()

        // STEP 4: SETUP RESET LOGIC
        // This function allows the user to clear the inputs and re-input data.
        setupClearButton()

        // STEP 5: SETUP NAVIGATION
        // This function handles moving the data to the Detailed View screen.
        setupDetailedViewButton()

        // STEP 6: SETUP EXIT
        // Completely closes the application.
        setupExitButton()
    }

    // --- LOGIC FUNCTIONS ---

    private fun setupCalculateButton() {
        binding.btnCalculate.setOnClickListener {
            // STEP 3.1: LOOP FOR SUMMATION
            // We use a loop to iterate through the array and find the total sum.
            var total = 0.0
            for (value in dataValues2) {
                total += value
            }

            // STEP 3.2: CALCULATE AVERAGE
            // Use 'size' to divide the total by the number of items.
            val average = if (dataValues2.isNotEmpty()) total / dataValues2.size else 0.0

            // STEP 3.3: UPDATE UI
            // String.format("%.1f", average) ensures only 1 decimal place is shown.
            binding.txtAverage.text = "Average: ${String.format("%.1f", average)}"

            // STEP 3.4: LOGGING
            // Logging demonstrates understanding and helps with debugging.
            Log.d("LogicInfo", "Sum: $total, Count: ${dataValues2.size}, Average: $average")
        }
    }

    private fun setupClearButton() {
        binding.btnClear.setOnClickListener {
            // STEP 4.1: RESET ARRAYS
            // A loop is used here to clear every position in the parallel arrays.
            for (i in dataValues1.indices) {
                dataValues1[i] = 0.0
                dataValues2[i] = 0.0
            }

            // STEP 4.2: RESET UI & FEEDBACK
            binding.txtAverage.text = "Average: 0.0"
            Toast.makeText(this, "Data has been reset.", Toast.LENGTH_SHORT).show()
        }
    }

    private fun setupDetailedViewButton() {
        binding.btnDetailed.setOnClickListener {
            // STEP 5.1: CREATE INTENT
            // Intents are used to transition between activities.
            val intent = Intent(this, DetailedViewActivity::class.java)

            // STEP 5.2: ATTACH DATA
            // We 'put' the parallel arrays into the intent using unique keys.
            intent.putExtra("KEY_CATEGORIES", categories)
            intent.putExtra("KEY_VAL1", dataValues1)
            intent.putExtra("KEY_VAL2", dataValues2)
            intent.putExtra("KEY_COND", conditions)

            // STEP 5.3: START NAVIGATION
            startActivity(intent)
        }
    }

    private fun setupExitButton() {
        binding.btnExit.setOnClickListener {
            // STEP 6.1: EXIT SYSTEM
            // finishAffinity() closes all activities in the stack.
            finishAffinity()
        }
    }
}
