package com.home.guess

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val secretNumber = SecretNumber()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("MainActivity", "The secret number is: ${secretNumber.secret}")
    }

    fun check(view : View) {
        val n = ed_number.text.toString().toInt()
        Log.d("MainActivity", "The number is: $n")
        var diff = secretNumber.validate(n)
        var message = "Good~You got it!!!"

        if (diff < 0) {
            message = "Bigger"
        } else if (diff > 0) {
            message = "Smaller"
        }
//        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
        AlertDialog.Builder(this)
            .setTitle("message")
            .setMessage(message)
            .setPositiveButton("ok", null)
            .show()

    }
}
