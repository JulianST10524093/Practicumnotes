app src main java.kt or androidmanifest for xml
.
The Simple Difference
•
XML File (The Skeleton): Used for Design. This is where you place buttons, text boxes, and images. It defines what the app looks like.
•
KT File (The Brain): Used for Logic. This is where you write the code for calculations, button clicks, and moving between screens. It defines what the app does.
🛠️ How to Add a New Screen (Short Version)
1.
Create: Right-click your package folder -> New > Activity > Empty Views Activity. (This creates both the .kt and .xml at once).
2.
Manifest: Open AndroidManifest.xml and ensure the new <activity android:name=".YourName" /> is inside the <application> tag.
3.
Binding: Copy the 3 lines of "Binding" code from MainActivity.kt into your new .kt file to connect the design to the logic.
Quick Cheat Sheet
•
Want to change colors or text size? -> Go to the XML.
•
Want to change a math formula? -> Go to the KT.
•
App crashing when switching screens? -> Go to the Manifest.
# Practicum Assessment - Multipurpose App Template

This project is a high-quality, professional-grade template designed for Android Practicum assessments. It uses **Parallel Arrays**, **Loops**, **Intents**, and **View Binding**.

---

## 🛠️ How to Adapt for Different Questions
1.  **Change Data**: In `MainActivity.kt` (**STEP 1**), update the names and numbers in the arrays.
2.  **Change Labels**: In `DetailedViewActivity.kt` (**THE LOOP**), update the `report.append` labels (e.g., change "Min Temp" to "Grade").
3.  **Update Info**: In `activity_splash.xml`, put your **Name** and **Student Number** in the TextView.

---

## 📈 Recommendation 1: Professional Logging (MASTERED)
The code is now equipped with detailed `Log.d` statements. 
*   **What it does**: It prints "UserAction" and "AppDebug" messages to the Logcat tab.
*   **Why it matters**: It proves you understand the app's internal logic and data flow.
*   **Tip**: Show these logs to your lecturer as proof of a working solution.

---

## 💾 Recommendation 2: GitHub Workflow
The assessment requires consistent GitHub usage. Follow this plan:
1.  **Start**: Create repo and push the initial project.
2.  **Middle**: Commit after finishing each screen (Splash, Main, Detailed).
3.  **End**: Commit after adding final styles and the app icon.
*   **Commit Message Example**: `feat: Implement bulletproof average calculation loop`

---

## 🎨 Recommendation 3: UI/UX Polishing
To get the highest marks for "User-Friendly Design":
*   **Padding**: All layout files now have `padding="16dp"` to ensure text doesn't touch the screen edges.
*   **Colors**: You should go to `res/values/themes.xml` and pick a unique color for your buttons.
*   **Icon**: Right-click `res` folder -> `New` -> `Image Asset` to create a custom app icon.

---

## 📊 Recommendation 4: PowerPoint Tips
To create a "Story" in your presentation:
1.  **Logic Focus**: Don't just show the button; show the **Code** for the loop next to it.
2.  **Explain "Parallel"**: Explain that `index 0` is always Monday/Subject A in all arrays.
3.  **Show Errors**: Take a screenshot of your "Clear Data" Toast message as proof of error handling.

---

## 🧪 Recommendation 5: Testing Checklist (Bulletproof)
Before submitting, run these "Edge Case" tests:
- [ ] **Empty Input**: Click Calculate without typing anything (Should not crash!).
- [ ] **Clear Logic**: Click Clear, then Calculate (Should show 0.0).
- [ ] **Navigation**: Go to Detailed View, then click Back (Should return to Main safely).
- [ ] **Exit**: Click Exit on both screens to ensure the app closes completely.

---

## 🛠️ Debugging Guide (Quick Fixes)
*   **Red Code?** Go to `Build > Clean Project` then `Build > Rebuild Project`.
*   **Crash on Navigation?** Check your Intent Keys. They must be identical in both Kotlin files.
*   **Wrong Calculation?** Ensure your `for` loop is targeting the correct array index.
