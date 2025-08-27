package com.example.unitconverter

import android.R.attr.onClick
import android.R.attr.text
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.unitconverter.ui.theme.UnitConverterTheme
import kotlin.math.roundToInt

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UnitConverterTheme {
                unitconverter()

        }
    }
}
@Preview(showBackground = true)
@Composable

fun unitconverter( ){
    var inputValue  by remember { mutableStateOf("") }
    var outputValue by remember { mutableStateOf("") }
    var inputUnit by remember { mutableStateOf("Meter") }
    var outputUnit by remember { mutableStateOf("Meter") }
    var iExpanded by remember { mutableStateOf(false) }
    var oExpanded by remember { mutableStateOf(false) }
    val converSionFactor = remember { mutableStateOf(1.00) }
    val oConversionFactor = remember { mutableStateOf(1.00) }

    fun ConvertUnit(){
        //  ?: = elvis operator
        val inputValueDouble = inputValue.toDoubleOrNull() ?: 0.0
        val result = (inputValueDouble * converSionFactor.value * 100.0 /
                oConversionFactor.value).roundToInt()/100
        outputValue = result.toString()
    }




    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally){
        Text(text = "Unit Converter", style = MaterialTheme.typography.headlineLarge)
        OutlinedTextField(value = inputValue,
            onValueChange = {  inputValue = it},
            label = {Text("Enter Value ")}
        )
        Spacer(modifier = Modifier.padding(10.dp))

        Row {

            Box(){
                Button(onClick = {
                    iExpanded = true
                }) {
                    Text(text = inputUnit)
                    Icon(
                        Icons.Filled.ArrowDropDown, contentDescription = null)

                }
                DropdownMenu(expanded = iExpanded , onDismissRequest = {
                    iExpanded = false
                } ) {
                    DropdownMenuItem( onClick = {
                        iExpanded = false
                        inputUnit = "Centimeter"
                        converSionFactor.value = 0.01
                        ConvertUnit()


                    }, text = {
                        Text("Centimeter")},

                    )
                     DropdownMenuItem( onClick = {
                         iExpanded = false
                         inputUnit = "Meter"
                         converSionFactor.value = 1.0
                         ConvertUnit()
                     }, text = {
                        Text("Meter")
                    }
                    )
                     DropdownMenuItem( onClick = {
                         iExpanded = false
                         inputUnit = "Feet"
                         converSionFactor.value = 0.3048
                         ConvertUnit()},
                         text = {
                        Text("Feet")
                    }
                    )
                     DropdownMenuItem( onClick = {
                         iExpanded = false
                         inputUnit = "Milimeter"
                         converSionFactor.value = 0.001
                         ConvertUnit()
                     }, text = {
                        Text("Milimeter")
                    }
                    )

                }

            }

            Spacer(modifier = Modifier.padding(10.dp))

            Box(){
                Button(onClick = {
                    oExpanded = true
                }) {
                    Text(text = outputUnit)
                    Icon(
                        Icons.Filled.ArrowDropDown, contentDescription = null)

                }
                DropdownMenu(expanded = oExpanded, onDismissRequest = {
                    oExpanded = false
                } ) {
                    DropdownMenuItem( onClick = {
                        oExpanded = false
                        outputUnit = "Centimeter"
                        oConversionFactor.value = 0.01
                        ConvertUnit()

                    }, text = {
                        Text("Centimeter")
                    }
                    )
                    DropdownMenuItem( onClick = {
                        oExpanded = false
                        outputUnit = "Meter"
                        oConversionFactor.value = 1.00
                        ConvertUnit()

                    }, text = {
                        Text("Meter")
                    }
                    )
                    DropdownMenuItem( onClick = {
                        oExpanded = false
                        outputUnit = "Feet"
                        oConversionFactor.value = 0.30
                        ConvertUnit()
                    }, text = {
                        Text("Feet")
                    }
                    )
                    DropdownMenuItem( onClick = {
                        oExpanded = false
                        outputUnit = "Milimeter"
                        oConversionFactor.value = 0.001
                        ConvertUnit()
                    }, text = {
                        Text("Milimeter")
                    }
                    )

                }

            }










        }
        Spacer(modifier = Modifier.padding(10.dp))
        Text(
            text = "Result: $outputValue $outputUnit",
            style = MaterialTheme.typography.headlineLarge,
        )

    }

    }
}
