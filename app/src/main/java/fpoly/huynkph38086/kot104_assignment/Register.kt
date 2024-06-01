package fpoly.huynkph38086.kot104_assignment

import android.app.Activity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import fpoly.huynkph38086.kot104_assignment.ui.theme.KOT104_AssignmentTheme

class Register : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KOT104_AssignmentTheme {
                Greeting4(this)
            }
        }
    }
}

@Composable
fun Greeting4(activity: Activity) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray),
        contentAlignment = Alignment.Center,
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp),
            colors = CardDefaults.cardColors(containerColor =
            Color.White),
            elevation = CardDefaults.cardElevation(defaultElevation =
            4.dp)
        ) {
            RegisterScreen(activity)
        }
    }
}

@Composable
fun RegisterScreen(activity: Activity) {
    var un by remember { mutableStateOf("") }
    var pw by remember { mutableStateOf("") }
    var showDialog by remember { mutableStateOf(false) }
    var dialogMessage by remember { mutableStateOf("") }

    if (showDialog) {
        DialogComponent(
            onConfirmation = { showDialog = false },
            dialogTitle = "Notification",
            dialogMessage = dialogMessage
        )
    }

    Column (
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Đăng ký", fontSize = 48.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(36.dp))

        TextField(
            value = un,
            onValueChange = { un = it },
            label = { Text(text = "Username", fontSize = 16.sp) },
            maxLines = 1
        )
        Spacer(modifier = Modifier.height(24.dp))

        TextField(
            value = pw,
            onValueChange = { pw = it },
            label = { Text(text = "Password", fontSize = 16.sp) },
            maxLines = 1,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password
            ),
            visualTransformation = PasswordVisualTransformation()
        )
        Spacer(modifier = Modifier.height(24.dp))

        Button(onClick = {
            if (un.isNotBlank() && pw.isNotBlank()) {
                Toast.makeText(activity, "Đăng nhập thành công",
                    Toast.LENGTH_LONG).show()
                activity.finish()
            } else {
                Toast.makeText(activity, "Vui lòng không để trống",
                    Toast.LENGTH_LONG).show()
            }
        },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.DarkGray,
                contentColor = Color.White)) {
            Text(text = "Register", fontSize = 16.sp)
        }
        Spacer(modifier = Modifier.height(24.dp))

        Button(onClick = {
            activity.finish()
        }) {
            Text(text = "Cancel", fontSize = 16.sp)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview4() {
    KOT104_AssignmentTheme {
        Greeting4(Register())
    }
}