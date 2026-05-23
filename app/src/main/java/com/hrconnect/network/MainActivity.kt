package com.hrconnect.network

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import logcat.LogPriority.INFO
import logcat.logcat

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        logcat(INFO) { "onCreate" }
        setContent {}
    }

    override fun onStart() {
        super.onStart()
        logcat(INFO) { "onStart" }
    }

    override fun onResume() {
        super.onResume()
        logcat(INFO) { "onResume" }
    }

    override fun onPause() {
        super.onPause()
        logcat(INFO) { "onPause" }
    }

    override fun onStop() {
        super.onStop()
        logcat(INFO) { "onStop" }
    }

    override fun onDestroy() {
        super.onDestroy()
        logcat(INFO) { "onDestroy" }
    }
}