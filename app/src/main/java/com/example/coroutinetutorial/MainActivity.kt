package com.example.coroutinetutorial

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*lifecycleScope.launch(Dispatchers.IO) {
            delay(3000)
            Log.d(TAG, "coroutine 1: ${Thread.currentThread().name}")
            withContext(Dispatchers.Main) {
                Log.d(TAG, "coroutine 2: ${Thread.currentThread().name}")
            }
        }

        Log.d(TAG, "onCreate: ${Thread.currentThread().name}")*/

        lifecycleScope.launch {
            myFunc()
        }
    }

    suspend fun myFunc(): String {
        delay(3000)
        myFunc2()
        return "Hello"
    }

    suspend fun myFunc2(): String {
        delay(3000)
        return "Halo"
    }
}