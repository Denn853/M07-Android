package com.example.apuntesclase.screens

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.activity.ComponentActivity
import com.example.apuntesclase.R

class SecondScreen : ComponentActivity() {

    companion object {
        public const val ExtraTextKey = "testString"
    }

    val backButton by lazy { findViewById<ImageButton>(R.id.back_bt) }
    val secondText by lazy { findViewById<TextView>(R.id.second_screen_text) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_screen)

        backButton.setOnClickListener {
            finish()
        }

        secondText.text = intent.getStringExtra(ExtraTextKey)
    }
}