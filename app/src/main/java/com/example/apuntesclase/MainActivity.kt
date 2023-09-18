package com.example.apuntesclase

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.apuntesclase.ui.theme.ApuntesClaseTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ApuntesClaseTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    PrintOnScreen("dennys👽", "🦇")
                }
            }
        }
    }
}

@Composable
fun PrintOnScreen(name: String?, name2: String?, modifier: Modifier = Modifier) {

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
}
