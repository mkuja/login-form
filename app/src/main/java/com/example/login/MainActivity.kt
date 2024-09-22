package com.example.login

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Lock
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
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
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.login.ui.theme.LoginTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LoginTheme(darkTheme = false) {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(
                        modifier = Modifier
                            .padding(innerPadding)
                            .fillMaxWidth(),
                        horizontalAlignment = Alignment.Start
                    ) {
                        Greeting(
                            name = "Login",
                            modifier = Modifier.padding(16.dp)
                        )
                        LoginField(
                            modifier = Modifier
                                .padding(8.dp, 12.dp)
                                .fillMaxWidth()
                            )
                        PasswordField(
                            modifier = Modifier
                                .padding(8.dp, 12.dp)
                                .fillMaxWidth()
                        )
                        Button(
                            onClick = {},
                            shape = RoundedCornerShape(5.dp),
                            modifier = Modifier
                                .padding(12.dp)
                                .fillMaxWidth()
                                .shadow(3.dp)
                        ) {
                            Text("Login")
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun LoginField(modifier: Modifier = Modifier) {
    var login by remember { mutableStateOf(TextFieldValue()) }

    OutlinedTextField(
        login,
        onValueChange = { a: TextFieldValue -> login = a },
        label = { Text("Login") },
        trailingIcon = { Icon(Icons.Rounded.Person, "Your login") },
        modifier = modifier,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
    )
}

@Composable
fun PasswordField(modifier: Modifier = Modifier) {
    var password by remember { mutableStateOf(TextFieldValue()) }

    OutlinedTextField(
        password,
        onValueChange = { a: TextFieldValue -> password = a },
        label = { Text("Password") },
        trailingIcon = { Icon(Icons.Rounded.Lock, "Your password") },
        visualTransformation = PasswordVisualTransformation(),
        modifier = modifier,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
    )
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = name,
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp,
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LoginTheme {
        Greeting("Android")
    }
}