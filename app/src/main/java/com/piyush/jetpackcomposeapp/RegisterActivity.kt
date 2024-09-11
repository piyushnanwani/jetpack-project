package com.piyush.jetpackcomposeapp

import android.content.Intent
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
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import com.piyush.jetpackcomposeapp.ui.theme.JetPackComposeAppTheme
import kotlinx.coroutines.launch

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

    // Access context from the current composition
    val context = LocalContext.current

    // Use a coroutine scope if any asynchronous operations are required
    val coroutineScope = rememberCoroutineScope()

    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }

    Column(modifier = Modifier
        .padding(16.dp)
    ) {
        // add margin top above below mentioned text
        Spacer(modifier = Modifier.padding(16.dp))
        Text(
            text = "Register Screen",
        )
        Spacer(modifier = Modifier.padding(16.dp))
        // create a textfield with placeholder name

        TextField( value = name, onValueChange = { name = it }, placeholder = { Text("Enter Name") })

        Spacer(modifier = Modifier.padding(16.dp))
        TextField(value = email, onValueChange = { email = it },  placeholder = { Text("Enter Email") })

        Spacer(modifier = Modifier.padding(16.dp))
        TextField(value = password, onValueChange = { password = it },  placeholder = { Text("Enter Password") }, visualTransformation = PasswordVisualTransformation())

        Spacer(modifier = Modifier.padding(16.dp))
        TextField(value = confirmPassword, onValueChange = { confirmPassword = it },  placeholder = { Text("Enter Confirm Password") },  visualTransformation = PasswordVisualTransformation())

        Spacer(modifier = Modifier.padding(16.dp))

        Button(onClick = {

            if (name.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty() && confirmPassword.isNotEmpty()) {
               Log.d("Register", "Name: $name, Email: $email, Password: $password, Confirm Password: $confirmPassword")

                coroutineScope.launch {
                    // Create the intent and start the activity
                    val intent = Intent(context, MainActivity::class.java)
                    ContextCompat.startActivity(context, intent, null)
                }

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