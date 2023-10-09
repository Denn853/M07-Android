package com.example.apuntesclase

import android.app.ActionBar.LayoutParams
import android.content.Context
import android.media.VolumeShaper
import android.media.VolumeShaper.Operation
import android.os.Bundle
import android.os.CpuUsageInfo
import android.util.Log
import android.view.ViewGroup
import android.view.ViewParent
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Space
import android.widget.TextView
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
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.app.NavUtils
import com.example.apuntesclase.ui.theme.ApuntesClaseTheme
import java.util.Scanner

class MainActivity : ComponentActivity() {

    /* Colors
    enum class Colors(val text: String, val number: Int, val color: Color) {
        Red("Rojo", 0, Color(225, 0,0)),
        Blue("Azul", 1, Color(0,0,255)),
        Green("Verde", 2, Color(0,255,0));

        fun WithAlpha(alpha: Float) : Color {
            return this.color.copy(alpha = alpha)
        }
    }*/

    /* Maths and Button
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
    } */

    /* Enums and Switches
    enum class Animals(){
        Dog, Cat, Panda, Fox
    }

    open class Fruit(val name: String = "FrutaGenerica") {

    }

    class Apple() : Fruit ("Manzana") {
        fun AppleFunc() {

        }
    }

    class Banana() : Fruit ("Banana") {
        fun BananaFunc() {

        }
    }*/


    // Funcionamiento Interno Calculaora
    enum class Operation(val operation: (a: Int, b: Int) -> Int, var char: String) {
        Add({a, b -> a + b}, "+"),
        Sub({a, b -> a - b}, "-"),
        Mul({a, b -> a * b}, "*"),
        Div({a, b -> a / b}, "/");

        fun Operate(a: Int, b: Int) : Int {
            return this.operation(a, b)
        }
    }

    var A: Int? = null;
    var B: Int? = null;
    var Op: Operation? = null;


    /*UI*/
    class ButtonsRow(var linearLayout: LinearLayout, val context: Context) {
        var buttons: MutableList<Button> = mutableListOf()

        fun AddButtonToRow(text: String) : Button {
            var bt = Button(context)
            bt.text = text

            bt.layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT, 1.0f)

            linearLayout.addView(bt)
            buttons.add(bt)

            return bt
        }
    }

    class ButtonsGrid(var parent: LinearLayout, val context: Context) {

        val baseLinearLayout: LinearLayout
        private var rows: MutableList<ButtonsRow> = mutableListOf()

        init {
            baseLinearLayout = LinearLayout(context)
            baseLinearLayout.orientation = LinearLayout.VERTICAL

            parent.addView(baseLinearLayout)
        }

        fun AddNewRow() {
            val linearLayout = LinearLayout(context)
            linearLayout.layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT, 1.0f)

            baseLinearLayout.addView(linearLayout)
            rows.add(ButtonsRow(linearLayout, context))
        }

        fun GetRow(index: Int) : ButtonsRow? {

            if(index >= rows.count() || index < 0) {
                return null
            }

            return rows[index]
        }
    }

    val result: TextView by lazy { findViewById(R.id.startScreen_Result) }
    val buttonsContainer: LinearLayout by lazy { findViewById(R.id.startScreen_ButtonsContainer) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /*setContent {
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

                        /*Enums
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
                        MyButton.Click()*/

                        /*When(Switch)
                        var animal = Animals.Fox

                        when (animal) {
                            Animals.Dog -> PrintOnScreen(name = "Es un perro")
                            Animals.Cat -> PrintOnScreen(name = "Es un gato")
                            Animals.Panda -> PrintOnScreen(name = "Es un panda")
                            Animals.Fox -> PrintOnScreen(name = "Es un zorro")
                        }

                        var fruit: Fruit? = Banana()

                        when(fruit) {
                            is Banana -> {
                                fruit.BananaFunc()
                                PrintOnScreen(name = "Es una Banana")
                            }

                            is Apple -> {
                                fruit.AppleFunc()
                                PrintOnScreen(name = "Es una Manzana")
                            }

                            else -> {
                                PrintOnScreen(name = "Es Null")
                            }
                        }

                        val str = "Lunes"

                        when(str) {
                            "Lunes" -> PrintOnScreen(name = "Es Lunes")
                            "Martes" -> PrintOnScreen(name = "Es Martes")
                            "Miercoles" -> PrintOnScreen(name = "Es Miercoles")

                            else -> PrintOnScreen(name = "No se que dia es")
                        }


                        val numberDay = when(str) {
                            "Lunes" -> 0
                            "Martes" -> 1
                            "Miercoles" -> 2

                            else -> -1
                        }
                        
                        PrintOnScreen(name = numberDay.toString())*/
                    }
                }
            }
        }*/
        setContentView(R.layout.start_screen)

        // Color por codigo
        buttonsContainer.setBackgroundColor(resources.getColor(R.color.newColor))

        // Texto por codigo
        result.text = getString(R.string.random_text)

        // Padding por codigo
        val lowPadding = resources.getDimension(R.dimen.padding_low)
        /*val bt = Button(this)
        bt.text = "Botón creado por código"
        bt.layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )*/

        //buttonsContainer.addView(bt)

        val btGrid = ButtonsGrid(buttonsContainer, this)

        /*btGrid.AddNewRow()

        btGrid.GetRow(1)?.AddButtonToRow("1")?.setOnClickListener { result.text = "1" }
        btGrid.GetRow(1)?.AddButtonToRow("2")?.setOnClickListener { result.text = "2" }
        btGrid.GetRow(1)?.AddButtonToRow("3")?.setOnClickListener { result.text = "3" }
        btGrid.GetRow(1)?.AddButtonToRow("+")?.setOnClickListener { result.text = "+" }*/

        var names: MutableList<MutableList<String>> = mutableListOf()
        names.add(mutableListOf("AC", "( )", "%", "/"))
        names.add(mutableListOf("7", "8", "9", "*"))
        names.add(mutableListOf("4", "5", "6", "-"))
        names.add(mutableListOf("1", "2", "3", "+"))
        names.add(mutableListOf("0", ".", "DEL", "="))

        for (y in names.indices) { // FILAS

            btGrid.AddNewRow()

            var row: ButtonsRow? = btGrid.GetRow(y)

            for (x in names[y].indices) { // COLUMNAS
                row?.AddButtonToRow(names[y][x])?.setOnClickListener {

                    when(names[y][x]) {

                        "AC" -> {
                            A = null
                            B = null
                            Op = null
                            result.text = ""
                        }

                        "1","2","3","4","5","6","7","8","9","0" -> {
                            NumberPress(names[y][x].toInt())
                        }

                        "+" -> { OperationPress(Operation.Add) }

                        "-" -> { OperationPress(Operation.Sub) }

                        "*" -> { OperationPress(Operation.Mul) }

                        "/" -> { OperationPress(Operation.Div) }

                        "=" -> {
                            A?.let { a ->
                                B?.let { b ->
                                    val resultNum = Op?.Operate(a, b)
                                    result.text = resultNum.toString()
                                    A = resultNum
                                    B = null
                                    Op = null
                                }
                            }
                        }

                        else -> result.text = names[y][x]
                    }

                }

            }
        }
    }
    fun NumberPress(num: Int) {
        if(Op == null) {
            A?.let { a ->
                A = (a * 10) + num
            } ?: run {
                A = num
            }

            result.text = A.toString()
        }
        else {
            B?.let { b ->
                B = (b * 10) + num
            } ?: run {
                B = num
            }

            result.text = A.toString() + Op?.char + B.toString()
        }
    }

    fun OperationPress(op: Operation) {
        if(A != null && B == null) {
            Op = op
            result.text = A.toString() + Op?.char
        }
    }

}
    fun resetTextAndCounter() {

    }

/* @Composable
//fun PrintOnScreen(name: String, color: MainActivity.Colors, modifier: Modifier = Modifier) {
fun PrintOnScreen(name: String, modifier: Modifier = Modifier) {

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
        //color = color.WithAlpha(1.0f)
    )
}*/
