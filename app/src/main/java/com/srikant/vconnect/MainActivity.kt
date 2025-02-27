package com.srikant.vconnect

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.zegocloud.uikit.prebuilt.call.invite.widget.ZegoSendCallInvitationButton
import com.zegocloud.uikit.service.defines.ZegoUIKitUser

class MainActivity : AppCompatActivity() {

    private lateinit var targetUserIdInput: EditText
    private lateinit var myUserIdText: TextView
    private lateinit var videoCallButton: ZegoSendCallInvitationButton
    private lateinit var voiceCallButton: ZegoSendCallInvitationButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize UI elements
        targetUserIdInput = findViewById(R.id.targetuserIdInput)
        myUserIdText = findViewById(R.id.myusedidtext)
        videoCallButton = findViewById(R.id.videocall)
        voiceCallButton = findViewById(R.id.voicecall)

        // Get user ID from intent
        val myUserId = intent.getStringExtra("userId") ?: "Unknown User"
        myUserIdText.text = "Hi $myUserId,\nWhom do you want to call?"

        // Listen for input changes
        targetUserIdInput.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val targetUserId = targetUserIdInput.text.toString().trim()
                if (targetUserId.isNotEmpty()) {
                    startVideoCall(targetUserId)
                    startVoiceCall(targetUserId)
                }
            }

            override fun afterTextChanged(s: Editable?) {}
        })
    }

    private fun startVideoCall(targetUserId: String) {
        val targetUserName = targetUserId

        // Configure Video Call button
        videoCallButton.setIsVideoCall(true)
        videoCallButton.resourceID = "zego_uikit_call"
        videoCallButton.setInvitees(listOf(ZegoUIKitUser(targetUserId, targetUserName)))

        // Show toast for confirmation
        Toast.makeText(this, "Video Call button set for $targetUserId", Toast.LENGTH_SHORT).show()
    }

    private fun startVoiceCall(targetUserId: String) {
        val targetUserName = targetUserId

        // Configure Voice Call button
        voiceCallButton.setIsVideoCall(false)
        voiceCallButton.resourceID = "zego_uikit_call"
        voiceCallButton.setInvitees(listOf(ZegoUIKitUser(targetUserId, targetUserName)))

        // Show toast for confirmation
        Toast.makeText(this, "Voice Call button set for $targetUserId", Toast.LENGTH_SHORT).show()
    }
}
