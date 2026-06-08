package com.example.practicumtest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.practicumtest.databinding.ActivityDetailedViewBinding

/**
 * MULTIPURPOSE DETAILED VIEW TEMPLATE
 * This activity displays detailed data retrieved from the previous screen.
 */
class DetailedViewActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailedViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // STEP 1: INITIALIZE VIEW BINDING
        // binding = ActivityDetailedViewBinding.inflate(layoutInflater)
        // setContentView(binding.root)

        // STEP 2: RETRIEVE DATA FROM INTENT
        // Fetch the parallel arrays passed from the previous activity.
        processIncomingData()

        // STEP 3: SETUP BACK NAVIGATION
        // Logic to return the user to the Main Screen.
        setupBackButton()
    }

    // STEP 2 (Detailed): Data Retrieval and Display Logic
    private fun processIncomingData() {
        // Retrieve arrays using the specific keys defined in MainActivity
        val keys = intent.getStringArrayExtra("KEY_DAYS")
        val values1 = intent.getDoubleArrayExtra("KEY_MIN")
        val values2 = intent.getDoubleArrayExtra("KEY_MAX")
        val descriptions = intent.getStringArrayExtra("KEY_CONDITIONS")

        // DISPLAY LOGIC: Use a StringBuilder to format all data into a readable list.
        val output = StringBuilder()
        
        // LOOP: Iterate through the arrays to build a summary string
        if (keys != null && values1 != null && values2 != null && descriptions != null) {
            for (i in keys.indices) {
                // This structure is interchangeable for any data (Weather, Marks, Inventory, etc.)
                output.append("Item: ${keys[i]}\n")
                output.append("Value 1: ${values1[i]}\n")
                output.append("Value 2: ${values2[i]}\n")
                output.append("Notes: ${descriptions[i]}\n\n")
            }
        }

        // Apply the formatted string to a TextView (e.g., txtDisplay)
        // binding.txtDisplay.text = output.toString()
    }

    // STEP 3 (Detailed): Back Navigation Logic
    private fun setupBackButton() {
        // Replace 'btnBack' with your button ID in XML
        /*
        binding.btnBack.setOnClickListener {
            // finish() closes this activity and returns to the previous one in the stack.
            finish()
        }
        */
    }
}
