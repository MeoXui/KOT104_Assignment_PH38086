package fpoly.huynkph38086.kot104_assignment

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import fpoly.huynkph38086.kot104_assignment.ui.theme.KOT104_AssignmentTheme

var tong_tien = 0.0

class Payment : ComponentActivity() {
    private var tt = tong_tien

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        tt = 3000.0
        tong_tien = tt
        setContent {
            KOT104_AssignmentTheme {
                Greeting7(this)
            }
        }
    }
}

@Composable
fun Greeting7(activity: Activity) {
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
            colors = CardDefaults.cardColors(
                containerColor =
                Color.White
            ),
            elevation = CardDefaults.cardElevation(
                defaultElevation =
                4.dp
            )
        ) {
            PaymentScreen(activity)
        }
    }
}

@Composable
fun PaymentScreen(activity: Activity = Payment()) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        Text(text = "Tổng tiền: ${tong_tien}$",
            fontSize = 33.sp
        )
        Spacer(modifier = Modifier.height(24.dp))
        Button(onClick = { activity.finish() },
            colors = ButtonDefaults
                .buttonColors(containerColor = Color.LightGray),
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(24.dp),
            border = BorderStroke(1.dp, Color.DarkGray)
        ) {
            Text(text = "Quay lai",
                fontSize = 28.sp,
                color = Color.Black
            )
        }
        Spacer(modifier = Modifier.height(24.dp))
        Button(onClick = {
            activity.finish()
            startActivity(
                activity,
                Intent(activity, Home::class.java),
                null
            )
        },
            colors = ButtonDefaults
                .buttonColors(containerColor = Color.Yellow),
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(24.dp),
            border = BorderStroke(1.dp, Color.DarkGray)
        ) {
            Text(text = "Xác nhận",
                fontSize = 28.sp,
                color = Color.Black
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview7() {
    KOT104_AssignmentTheme {
        Greeting7(Payment())
    }
}