package com.example.coroutinetutorial

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

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

        /*lifecycleScope.launch {
            myFunc()
        }*/

        /*val job = lifecycleScope.launch(Dispatchers.IO) {
            repeat(5) {
                Log.d("Leraedon", "코루틴 !!!")
                delay(1000)
            }
        }

        lifecycleScope.launch {
            delay(2000)
            job.cancel()
            Log.d("Leraedon", "코루틴 취소")
        }*/

        /*repeat(50) {
            lifecycleScope.launch(Dispatchers.Default) {
                Log.d("Leraedon", Thread.currentThread().name)
            }
        }*/

        lifecycleScope.launch(Dispatchers.IO){
            val time = measureTimeMillis {
                val result1 = async { network1() }
                val result2 = async { network2() }
                Log.d("Leraedon", "결과 1: ${result1.await()}")
                Log.d("Leraedon", "결과 2: ${result2.await()}")
            }
            Log.d("Leraedon", "시간: $time")
        }
    }

    suspend fun network1(): String {
        delay(2000)
        return "result 1"
    }
    suspend fun network2(): String {
        delay(2000)
        return "result 2"
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
