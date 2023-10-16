package com.example.apuntesclase.screens

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
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
            //builder.setMessage("Mensaje todavia mas molon del Dialogo")

            builder.setPositiveButton("Aceptar") { dialog, witch ->
                dialog.dismiss()
            }

            //builder.setCancelable(false) //para que si le da fuera del cuadrado NO se cierre
            builder.setOnCancelListener {
                val toast = Toast(this)
                toast.setText("Cancel Dialog")
                toast.show()
            }

            builder.setNegativeButton("Soy EMO :(") { dialog, whitch ->
                dialog.dismiss()
            }

            builder.setNeutralButton("Soy Neutral") { dialog, whitch ->
                dialog.dismiss()
            }

            val options = arrayOf("Respuesta 1", "Respuesta 2", "Respuesta 3", "Respuesta 4")
            val selectedResponses = booleanArrayOf(false, false, false, false)

            /*builder.setMultiChoiceItems(options, selectedResponses) { dialog, whitch, isChecked ->
                selectedResponses[whitch] = isChecked
            }*/

            val input = EditText(this)
            input.hint = "Escribe Aquí"
            builder.setView(input)

            val dialog = builder.create()
            dialog.show()

        }
    }
}
