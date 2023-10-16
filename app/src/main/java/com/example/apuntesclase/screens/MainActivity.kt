package com.example.apuntesclase.screens

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import com.example.apuntesclase.R

class MainActivity : ComponentActivity() {

    val btChangeScreen by lazy { findViewById<Button>(R.id.bt_changeScreen) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.start_screen)

        btChangeScreen.setOnClickListener {
            val newIntent = Intent(this, SecondScreen::class.java)
            newIntent.putExtra(SecondScreen.ExtraTextKey, "Cadena de texto transferida")

            this.startActivity(newIntent)
            overridePendingTransition(R.anim.enter_from_right, R.anim.exit_to_left)
        }
    }
}
