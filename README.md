# Practicum Weather App - Debugging & Maintenance Guide

This project is a multipurpose Android template using **Parallel Arrays**, **Loops**, and **Navigation**. Below are common bugs you might encounter during development and how to fix them.

---

### 1. "Unresolved reference: ActivityMainBinding" (or other Binding classes)
**Problem:** The IDE highlights your binding variable in red and won't compile.
*   **Cause:** Android Studio hasn't generated the binding classes yet, or they are out of sync.
*   **Fix:** 
    1. Go to **Build > Clean Project**.
    2. Then go to **Build > Rebuild Project**.
    3. Ensure `viewBinding { enabled = true }` is present in your `build.gradle (:app)` file under the `android` block.

### 2. "Unresolved reference: btnCalculate" (or any ID)
**Problem:** You can't access a button or text view from your Kotlin code.
*   **Cause:** The ID you used in the XML file does not match the name you are typing in Kotlin, or you are looking in the wrong layout.
*   **Fix:** 
    1. Check `activity_main.xml` and ensure the `android:id="@+id/btnCalculate"` matches exactly.
    2. Remember that ViewBinding converts "snake_case" (btn_calculate) to "camelCase" (btnCalculate).

### 3. App Crashes when clicking "View Detailed Logs"
**Problem:** The app closes immediately when trying to navigate.
*   **Cause:** Usually a `NullPointerException` because the Intent keys don't match.
*   **Fix:** 
    1. In `MainActivity.kt`, check the key used: `intent.putExtra("KEY_VAL1", dataValues1)`.
    2. In `DetailedViewActivity.kt`, ensure you use the **exact same key**: `intent.getDoubleArrayExtra("KEY_VAL1")`.
    3. If the keys are different, the data won't transfer, and the app might crash.

### 4. "IndexOutOfBoundsException"
**Problem:** The app crashes during a loop.
*   **Cause:** Your **Parallel Arrays** do not have the same number of items.
*   **Fix:** 
    1. Count the items in every array in `MainActivity.kt`.
    2. If `days` has 7 items, then `minTemps`, `maxTemps`, and `conditions` **must** also have exactly 7 items.

### 5. App won't start / "Activity Not Found"
**Problem:** The app crashes as soon as it launches or tries to move to a new screen.
*   **Cause:** You created a new Activity class but forgot to add it to the `AndroidManifest.xml`.
*   **Fix:** 
    1. Open `AndroidManifest.xml`.
    2. Ensure there is an `<activity android:name=".DetailedViewActivity" />` tag inside the `<application>` block for every screen you have.

### 6. "NumberFormatException" (Empty Input Bug)
**Problem:** The app crashes when you click "Calculate" and the input box is empty.
*   **Cause:** The code is trying to convert an empty string "" into a number.
*   **Fix:** 
    1. Use a check before converting: `val value = binding.edtInput.text.toString().toDoubleOrNull() ?: 0.0`.
    2. The `?: 0.0` ensures that if the input is empty, it just uses `0.0` instead of crashing.

---

### Quick Maintenance Tips:
*   **Logging:** If something isn't working, use `Log.d("DebugTag", "Variable value: $variable")` and check the **Logcat** tab at the bottom of Android Studio.
*   **Git Commits:** Commit your code every time you get a feature working (e.g., "Main screen finished", "Loop calculation fixed"). This is a requirement for your practicum!
