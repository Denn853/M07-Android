package com.example.apuntesclase.screens

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.example.apuntesclase.R

class MainActivity : ComponentActivity() {

    val btChangeScreen by lazy { findViewById<Button>(R.id.bt_changeScreen) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.start_screen)

        btChangeScreen.setOnClickListener {

            val toast = Toast(this)
            toast.duration = Toast.LENGTH_LONG
            toast.setText("Soy un toast muy molon")

            toast.show()

        }
    }
}
