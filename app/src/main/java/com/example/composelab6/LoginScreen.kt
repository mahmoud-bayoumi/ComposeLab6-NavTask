package com.example.composelab6


import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
@Composable
fun LoginScreen(
    registeredUser: String,
    registeredPass: String,
    onLoginSuccess: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current

    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Welcome Back",
            fontSize = 28.sp
        )

        Spacer(modifier = Modifier.height(24.dp))

        CustomTextField(username, "Username") {
            username = it
        }

        Spacer(modifier = Modifier.height(12.dp))

        CustomTextField(password, "Password") {
            password = it
        }

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(50),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF6750A4)
            ),
            onClick = {
                when {
                    username.isBlank() || password.isBlank() ->
                        Toast.makeText(
                            context,
                            "Please fill all fields",
                            Toast.LENGTH_SHORT
                        ).show()

                    username == registeredUser && password == registeredPass -> {
                        Toast.makeText(
                            context,
                            "Login successful ✅",
                            Toast.LENGTH_SHORT
                        ).show()
                        onLoginSuccess(username)
                    }

                    else ->
                        Toast.makeText(
                            context,
                            "Invalid credentials ❌",
                            Toast.LENGTH_SHORT
                        ).show()
                }
            }
        ) {
            Text("Login", color = Color.White)
        }
    }
}