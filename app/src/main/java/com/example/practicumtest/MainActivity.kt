package com.example.practicumtest

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.practicumtest.databinding.ActivityMainBinding

/**
 * MULTIPURPOSE MAIN SCREEN TEMPLATE
 * This activity handles data management, calculations using loops, and navigation.
 */
class MainActivity : AppCompatActivity() {

    // STEP 1: DECLARE DATA STRUCTURES (Parallel Arrays)
    // These arrays are "parallel" because the same index (e.g., 0) refers to the same item (e.g., Monday) across all arrays.
    // To change the "situation", simply change the values or array types here.
    private var days = arrayOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
    private var minTemps = doubleArrayOf(12.0, 15.0, 10.0, 12.0, 11.0, 10.0, 10.0)
    private var maxTemps = doubleArrayOf(25.0, 29.0, 22.0, 24.0, 23.0, 18.0, 16.0)
    private var weatherConditions = arrayOf("Sunny", "Sunny", "Cloudy", "Rainy", "Cloudy", "Raining", "Cold")

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // STEP 2: INITIALIZE VIEW BINDING
        // This connects our Kotlin code to the XML layout (activity_main.xml).
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // STEP 3: LOGIC FOR CALCULATIONS (Using a Loop)
        // This block calculates the average of a specific array. It can be reused for any numeric data.
        setupCalculateButton()

        // STEP 4: LOGIC FOR CLEARING DATA
        // This allows users to reset the inputs, fulfilling the "re-input" requirement.
        setupClearButton()

        // STEP 5: NAVIGATION TO DETAILED VIEW
        // We package the arrays into an Intent to send them to the next screen.
        setupDetailedViewButton()

        // STEP 6: EXIT FUNCTIONALITY
        // Closes the application entirely.
        setupExitButton()
    }

    // STEP 3 (Detailed): Calculation Function
    private fun setupCalculateButton() {
        // Replace 'btnCalculate' with your button ID in XML
        /*
        binding.btnCalculate.setOnClickListener {
            var sum = 0.0
            // LOOP: Iterates through each value to find the sum
            for (value in maxTemps) {
                sum += value
            }
            // Formula: Sum / Count
            val average = if (maxTemps.isNotEmpty()) sum / maxTemps.size else 0.0
            
            // DISPLAY: Show result in a TextView (e.g., txtAverage)
            binding.txtAverage.text = "Average: ${String.format("%.2f", average)}"
            
            // LOGGING: Helps with debugging and shows understanding
            android.util.Log.d("LogicCheck", "Calculated Sum: $sum, Average: $average")
        }
        */
    }

    // STEP 4 (Detailed): Clear Function
    private fun setupClearButton() {
        // Replace 'btnClear' with your button ID in XML
        /*
        binding.btnClear.setOnClickListener {
            // LOOP: Resets all values in the parallel arrays
            for (i in maxTemps.indices) {
                maxTemps[i] = 0.0
                minTemps[i] = 0.0
            }
            Toast.makeText(this, "Data cleared. Ready for new input.", Toast.LENGTH_SHORT).show()
        }
        */
    }

    // STEP 5 (Detailed): Navigation Function
    private fun setupDetailedViewButton() {
        // Replace 'btnDetailed' with your button ID in XML
        /*
        binding.btnDetailed.setOnClickListener {
            val intent = Intent(this, DetailedViewActivity::class.java)
            // Passing parallel arrays to the next activity
            intent.putExtra("KEY_DAYS", days)
            intent.putExtra("KEY_MIN", minTemps)
            intent.putExtra("KEY_MAX", maxTemps)
            intent.putExtra("KEY_CONDITIONS", weatherConditions)
            startActivity(intent)
        }
        */
    }

    // STEP 6 (Detailed): Exit Function
    private fun setupExitButton() {
        // Replace 'btnExit' with your button ID in XML
        /*
        binding.btnExit.setOnClickListener {
            finishAffinity()
        }
        */
    }
}
