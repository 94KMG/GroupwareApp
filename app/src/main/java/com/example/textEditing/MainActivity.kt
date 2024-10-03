package com.example.textEditing

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.textEditing.ui.theme.GroupwareAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GroupwareAppTheme {
                AssignmentScreen()
            }
        }
    }
}

@Composable
fun SizeScreen() {
    var fontSize by remember {
        mutableStateOf(18f)
    }
    Column(
        modifier = Modifier.padding(32.dp)
    ) {
        Text(
            text = "Your note here",
            fontSize = fontSize.sp
        )
        Slider(
            value = fontSize,
            onValueChange = { fontSize = it },
            valueRange = 12f..30f
        )
    }
}

@Composable
fun ColorAdjuster() {
    var redValue by remember { mutableStateOf(1f) }  // Value from 0f to 1f
    var greenValue by remember { mutableStateOf(0f) }
    var blueValue by remember { mutableStateOf(0f) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        // Display the text with the color dynamically controlled by the sliders
        Text(
            text = "Text with adjustable color",
            fontSize = 24.sp,
            color = Color(redValue, greenValue, blueValue)
        )

        // Slider for adjusting the Red channel
        Text("Red: ${redValue}")
        Slider(
            value = redValue,
            onValueChange = { redValue = it },
            valueRange = 0f..1f // The value range for colors is between 0 and 1
        )

        // Slider for adjusting the Green channel
        Text("Green: ${greenValue}")
        Slider(
            value = greenValue,
            onValueChange = { greenValue = it },
            valueRange = 0f..1f
        )

        // Slider for adjusting the Blue channel
        Text("Blue: ${blueValue}")
        Slider(
            value = blueValue,
            onValueChange = { blueValue = it },
            valueRange = 0f..1f
        )
    }
}

@Composable
fun AssignmentScreen() {
    var notes by remember { mutableStateOf(listOf("Note 1", "Note 2", "Note 3")) }
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        LazyColumn(
            modifier = Modifier.padding(64.dp)
        ) {
            items(notes.size) { index ->
                Text(
                    text = notes[index],
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { /* Handle item click */ }
                )
            }
        }
        // Example: Button to rearrange notes
        Button(onClick = {
            notes = notes.reversed() // Simple reverse order
        }) {
            Text("Reverse Notes")
        }

    }


   


}