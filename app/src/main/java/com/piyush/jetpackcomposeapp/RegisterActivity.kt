package com.piyush.jetpackcomposeapp

import android.os.Bundle
import android.util.Log
import android.widget.Toast
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

class RegisterActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Register()
        }
    }
}

@Composable
fun Register() {

    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }


    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            text = "Register Screen",
        )
        Spacer(modifier = Modifier.padding(16.dp))
        TextField( value = name, onValueChange = { name = it })

        Spacer(modifier = Modifier.padding(16.dp))
        TextField(value = email, onValueChange = { email = it })

        Spacer(modifier = Modifier.padding(16.dp))
        TextField(value = password, onValueChange = { password = it })

        Spacer(modifier = Modifier.padding(16.dp))
        TextField(value = confirmPassword, onValueChange = { confirmPassword = it })

        Spacer(modifier = Modifier.padding(16.dp))

        Button(onClick = {
            if (name.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty() && confirmPassword.isNotEmpty()) {
               Log.d("Register", "Name: $name, Email: $email, Password: $password, Confirm Password: $confirmPassword")
            } else {
                Log.d("Register", "Please fill all the fields")
            }

        }) {
            Text(text = "Submit")
        }

    }
}

@Preview(showBackground = true)
@Composable
fun RegisterPreview() {
        Register()
}