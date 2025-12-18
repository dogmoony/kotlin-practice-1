package com.kpi.kotlinpractice1_kushnirkv

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kpi.kotlinpractice1_kushnirkv.ui.theme.KotlinPractice1KushnirKVTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KotlinPractice1KushnirKVTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    FuelTask1Screen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun FuelTask1Screen(modifier: Modifier = Modifier) {
    var hInput by remember { mutableStateOf("") }
    var resultText by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top
    ) {
        Text("Завдання 1: склад палива",
            style = MaterialTheme.typography.titleLarge)

        Spacer(modifier = Modifier.height(8.dp))

        Text(text = "H\u209A (Водень на робочу масу), %")

        androidx.compose.material3.TextField(
            value = hInput,
            onValueChange = { hInput = it },
            label = { androidx.compose.material3.Text(text = "H\u209A") },
            singleLine = true,
            keyboardOptions = androidx.compose.foundation.text.KeyboardOptions(keyboardType = androidx.compose.ui.text.input.KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            //тут будуть обчислення
            resultText = "Результат"
        }) {
            Text("Розрахувати")
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text(text = resultText)
    }
}

@Composable
fun KeyboardOpeitons(keyboardType: KeyboardType) {
    TODO("Not yet implemented")
}

@Preview(showBackground = true)
@Composable
fun FuelTask1Preview() {
    KotlinPractice1KushnirKVTheme {
        FuelTask1Screen(modifier = Modifier)
    }
}