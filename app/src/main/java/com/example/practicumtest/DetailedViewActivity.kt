package com.example.practicumtest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.practicumtest.databinding.ActivityDetailedViewBinding

/**
 * DETAILED VIEW: MULTIPURPOSE TEMPLATE
 * This screen displays a comprehensive log of all the data from the parallel arrays.
 */
class DetailedViewActivity : AppCompatActivity() {

    // View Binding for activity_detailed_view.xml
    private lateinit var binding: ActivityDetailedViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // STEP 1: INITIALIZE VIEW BINDING
        // Connects the Kotlin code to the XML layout elements.
        binding = ActivityDetailedViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // STEP 2: PROCESS INCOMING DATA
        // Retrieves the arrays passed from MainActivity and displays them.
        displayDetailedData()

        // STEP 3: SETUP BACK NAVIGATION
        // Logic to return to the previous screen.
        setupBackButton()
    }

    // --- DISPLAY & NAVIGATION ---

    private fun displayDetailedData() {
        // STEP 2.1: EXTRACT ARRAYS FROM INTENT
        // Using the exact same keys we used in MainActivity to 'put' the data.
        val categories = intent.getStringArrayExtra("KEY_CATEGORIES")
        val val1 = intent.getDoubleArrayExtra("KEY_VAL1")
        val val2 = intent.getDoubleArrayExtra("KEY_VAL2")
        val notes = intent.getStringArrayExtra("KEY_COND")

        // STEP 2.2: BUILD DISPLAY STRING
        // StringBuilder is more efficient than standard String concatenation in loops.
        val detailedLog = StringBuilder()

        // STEP 2.3: LOOP THROUGH DATA
        // Check for null to prevent app crashes if data wasn't sent correctly.
        if (categories != null && val1 != null && val2 != null && notes != null) {
            for (i in categories.indices) {
                // Formatting the data for each item/day
                detailedLog.append("Item: ${categories[i]}\n")
                detailedLog.append("Min Temp: ${val1[i]}°C\n")
                detailedLog.append("Max Temp: ${val2[i]}°C\n")
                detailedLog.append("Condition: ${notes[i]}\n\n")
                detailedLog.append("----------------------------\n\n")
            }
        }

        // STEP 2.4: APPLY TO UI
        // Put the entire built string into the TextView.
        binding.txtDetailedData.text = detailedLog.toString()
    }

    private fun setupBackButton() {
        // STEP 3.1: BTN CLICK LISTENER
        binding.btnBack.setOnClickListener {
            // STEP 3.2: CLOSE CURRENT ACTIVITY
            // This automatically takes the user back to MainActivity.
            finish()
        }
    }
}
