package com.srikant.vconnect

import android.app.Application
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.zegocloud.uikit.prebuilt.call.ZegoUIKitPrebuiltCallService
import com.zegocloud.uikit.prebuilt.call.invite.ZegoUIKitPrebuiltCallInvitationConfig

class LoginActivity : AppCompatActivity() {

    private lateinit var myuserid: EditText
    private lateinit var lgbtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        myuserid = findViewById(R.id.myuserid)
        lgbtn = findViewById(R.id.login)

        lgbtn.setOnClickListener {
            val userId = myuserid.text.toString().trim()

            if (userId.isNotEmpty()) {
                setupZegoUiKit(userId) // Initialize before navigating

                // Create Intent to move to MainActivity
                val intent = Intent(this@LoginActivity, MainActivity::class.java)
                intent.putExtra("userId", userId) // Pass userId as String
                startActivity(intent)
                finish() // Close LoginActivity after moving to MainActivity
            } else {
                myuserid.error = "User ID cannot be empty"
            }
        }
    }

    private fun setupZegoUiKit(userId: String) {
        // Get the application context as Application
        val app = application as Application

        // Your credentials
        val appID: Long = 230179812
        val appSign: String = "38b1e70dce36f927de3ba50d41fc2f92e1630460e830dffd724ea955d8c73d98"

        // Convert user ID to lowercase (optional for consistency)
        val userID = userId.lowercase()
        val userName = userID

        // Initialize call invitation config
        val callInvitationConfig = ZegoUIKitPrebuiltCallInvitationConfig()

        // Initialize ZegoUIKitPrebuiltCallService
        ZegoUIKitPrebuiltCallService.init(app, appID, appSign, userID, userName, callInvitationConfig)
    }

    override fun onDestroy() {
        super.onDestroy()
        // Ensure safe uninitialization
        try {
            ZegoUIKitPrebuiltCallService.unInit()
        } catch (e: Exception) {
            e.printStackTrace() // Log any potential errors
        }
    }
}
