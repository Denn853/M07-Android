package com.example.apuntesclase.screens

import android.app.AlertDialog
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

            var builder = AlertDialog.Builder(this)
            builder.setTitle("Titulo molon del Dialogo")
            builder.setMessage("Mensaje todavia mas molon del Dialogo")

            builder.setPositiveButton("Aceptar") { dialog, witch ->
                dialog.dismiss()
            }

            //builder.setCancelable(false) //para que si le da fuera del cuadrado NO se cierre
            builder.setOnCancelListener {
                val toast = Toast(this)
                toast.setText("Cancel Dialog")
                toast.show()
            }

            builder.setNegativeButton("Soy EMO :(") { dialog, witch ->
                dialog.dismiss()
            }

            builder.setNeutralButton("Soy Neutral") { dialog, witch ->
                dialog.dismiss()
            }

            val dialog = builder.create()
            dialog.show()

        }
    }
}
