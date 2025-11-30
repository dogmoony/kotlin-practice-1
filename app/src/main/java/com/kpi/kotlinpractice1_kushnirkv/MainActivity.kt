package com.kpi.kotlinpractice1_kushnirkv

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
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
                    GreetingScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun GreetingScreen(modifier: Modifier = Modifier) {
    var name by remember { mutableStateOf("") }
    var greetingText by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text("Enter your name: ")

        Spacer(modifier = Modifier.height(8.dp))

        TextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Name") }
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            greetingText = if (name.isNotBlank()) {
                "Hi, $name!"
            } else {
                "Please, enter your name."
            }
        }) {
            Text("Greet!")
        }

        Spacer(modifier = Modifier.height(16.dp))

        if (greetingText.isNotEmpty()) {
            Text(greetingText)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    KotlinPractice1KushnirKVTheme {
        GreetingScreen(modifier = Modifier)
    }
}