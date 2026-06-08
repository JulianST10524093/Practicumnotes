package com.example.practicumtest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.practicumtest.databinding.ActivityDetailedViewBinding

/**
 * --- MULTIPURPOSE DETAILED VIEW ---
 * This screen receives the parallel arrays and displays them in a list format.
 * 
 * INTERCHANGEABILITY:
 * The text "Item", "Value 1", etc., can be changed in the loop to suit any topic.
 */
class DetailedViewActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailedViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        // --- STEP 1: INITIALIZE ---
        android.util.Log.d("AppLifecycle", "DetailedViewActivity Created")
        binding = ActivityDetailedViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Run the logic to pull data from the Intent and display it.
        displayDetailedData()

        // Set up the back button logic.
        setupBackButton()
    }

    // --- STEP 2: DATA PROCESSING (THE LOOP) ---
    private fun displayDetailedData() {
        android.util.Log.d("AppDebug", "Starting data processing for Detailed View")
        // Retrieve the data arrays from the Intent using the keys we created in MainActivity.
        val categories = intent.getStringArrayExtra("KEY_CAT")
        val val1 = intent.getDoubleArrayExtra("KEY_VAL1")
        val val2 = intent.getDoubleArrayExtra("KEY_VAL2")
        val extra = intent.getStringArrayExtra("KEY_EXTRA")

        // StringBuilder is used to build one big string containing all our information.
        val report = StringBuilder()

        // THE LOOP: We check if the data exists, then go through every item.
        if (categories != null && val1 != null && val2 != null && extra != null) {
            android.util.Log.d("AppDebug", "Data received successfully. Items count: ${categories.size}")
            for (i in categories.indices) {
                // Formatting: Change these labels (Item, Min, Max) to suit your question!
                report.append("Day/Item: ${categories[i]}\n")
                report.append("Value 1: ${val1[i]}\n")
                report.append("Value 2: ${val2[i]}\n")
                report.append("Details: ${extra[i]}\n")
                report.append("----------------------------\n\n")
            }
        } else {
            android.util.Log.e("AppDebug", "Error: Some data was null in Intent")
        }

        // Apply the final string to our TextView.
        binding.txtDetailedData.text = report.toString()
        android.util.Log.d("AppDebug", "Report generated and displayed")
    }

    // --- STEP 3: GO BACK ---
    private fun setupBackButton() {
        binding.btnBack.setOnClickListener {
            android.util.Log.d("UserAction", "Back Button Clicked - Returning to Main")
            // finish() simply closes this activity and reveals the previous one.
            finish()
        }
    }
}
