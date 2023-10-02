package com.example.apuntesclase

import android.os.Bundle
import android.os.CpuUsageInfo
import android.util.Log
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.ripple.RippleAlpha
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.apuntesclase.ui.theme.ApuntesClaseTheme

class MainActivity : ComponentActivity() {

    enum class Colors(val text: String, val number: Int, val color: Color) {
        Red("Rojo", 0, Color(225, 0,0)),
        Blue("Azul", 1, Color(0,0,255)),
        Green("Verde", 2, Color(0,255,0));

        fun WithAlpha(alpha: Float) : Color {
            return this.color.copy(alpha = alpha)
        }
    }

    enum class Operations(val operation: (Int, Int) -> Int) {
        Add({a, b -> a + b}),
        Subtract({a, b -> a - b});
    }

    class Bt() { //Button

        var listeners: MutableList<(Bt) -> Unit> = mutableListOf()

        fun AddOnClickListener(OnClickListener: (Bt) -> Unit) {
            listeners.add(OnClickListener)
        }

        fun Click() {
            for (listener in listeners) {
                listener(this);
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ApuntesClaseTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    Column() {

                        /* For's type
                        //For normal
                        for (i in 1 .. 5) {
                            PrintOnScreen("dennys 👽🦇")
                        }

                        Spacer(modifier = Modifier.height(16.dp))

                        //For each
                        val names = listOf("Pepe", "Pepa", "Pedro", "Paula")

                        for (name in names) {
                            PrintOnScreen(name)
                        }

                        Spacer(modifier = Modifier.height(16.dp))

                        //
                        for (i in names.indices) {
                            PrintOnScreen("index: " + i.toString())
                        }

                        Spacer(modifier = Modifier.height(16.dp))

                        //For early acces
                        names.forEach {name ->
                            PrintOnScreen(name)
                        }

                        Spacer(modifier = Modifier.height(16.dp))

                        //For early acces
                        names.forEachIndexed { index, name ->
                            PrintOnScreen(name + " " + index.toString())
                        }*/

                        /*Enums*/
                        PrintOnScreen(name = "Algo de color", color = Colors.Green)

                        //Sumar
                        var mathFunction: Operations = Operations.Add

                        //Restar
                        //var mathFunction: Operations = Operations.Subtract
                        var result = mathFunction.operation(1, 5)

                        PrintOnScreen(name = result.toString(), color = Colors.Blue)

                        //Boton
                        val MyButton = Bt()

                        MyButton.AddOnClickListener {bt ->
                            Log.v("Click", "Botón Pulsado")
                        }

                        //Llamada a la función
                        MyButton.Click()

                    }
                }
            }
        }
    }
}

@Composable
fun PrintOnScreen(name: String, color: MainActivity.Colors, modifier: Modifier = Modifier) {

    /*val name = name?.let{
        val name2 = name2?.let {
            Text(
                text = "Hello ${name.uppercase()} ${name.uppercase()}",
                modifier = modifier
            )
        } ?: run {
            Log.e("Null", "Name2 is null")
        }?: run {
            Log.e("Null", "Name is null")
        }*/

    /*var NewName: String? = "hola"
    NewName = "Dylan"

    val name = name ?: run {
        Log.e("Null", "Name is null")
        return
    }

    val name2 = name2 ?: run {
        Log.e("Null", "Name is null")
        return

    Text(
        text = "Hello ${name.uppercase()} ${name2.uppercase()}",
        modifier = modifier
    )*/

    Text(
        text = "Hello ${name.uppercase()}",
        modifier = Modifier,
        color = color.WithAlpha(1.0f)
    )
}
