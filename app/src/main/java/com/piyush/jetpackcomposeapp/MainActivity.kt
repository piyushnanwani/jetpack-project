package com.piyush.jetpackcomposeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.piyush.jetpackcomposeapp.ui.theme.JetPackComposeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TodoScreen()
        }

    }
}

@Composable
fun TodoScreen() {

    var newTodo by remember { mutableStateOf("") }

    var todoList by remember {mutableStateOf(listOf<String>())}

    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            text = "Todo App",
        )
        Spacer(modifier = Modifier.padding(16.dp))

        TextField(value = newTodo, onValueChange = { newTodo = it } )

        Spacer(modifier = Modifier.padding(16.dp))

        Button(onClick = {
            if (newTodo.isNotEmpty()) {
                todoList = todoList + newTodo
                newTodo = ""
            }

        }) {
            Text(text = "Add Todo")
        }

        Spacer(modifier = Modifier.padding(16.dp))

        for (task in todoList) {
            Text(text = "Task: $task")
        }

    }
}

@Preview(showBackground = true)
@Composable
fun TodoScreenPreview() {
    TodoScreen()
}