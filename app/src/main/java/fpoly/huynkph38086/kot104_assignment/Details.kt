package fpoly.huynkph38086.kot104_assignment

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import fpoly.huynkph38086.kot104_assignment.ui.theme.KOT104_AssignmentTheme

class Details : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KOT104_AssignmentTheme {
                Greeting5(this)
            }
        }
    }
}

@Composable
fun Greeting5(activity: Activity) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
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
            DetailsScreen(activity)
        }
    }
}

@Composable
fun DetailsScreen(activity: Activity) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        Image(
            painter = painterResource(id = R.drawable.ghe),
            contentDescription = "ghe",
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
        )
        Spacer(modifier = Modifier.height(24.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Ghế",
                fontSize = 36.sp,
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                //fontStyle = FontStyle.Italic,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier = Modifier.width(16.dp))

            Text(text = "3000$",
                fontSize = 24.sp,
                color = Color.Red,
                //fontWeight = FontWeight.Bold,
                fontStyle = FontStyle.Italic,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Mô tả các thứ...")
        Spacer(modifier = Modifier.height(16.dp))

        Spacer(modifier = Modifier.weight(1f))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(onClick = { activity.finish() },
                colors = ButtonDefaults
                    .buttonColors(containerColor = Color.LightGray),
                shape = RoundedCornerShape(24.dp),
                border = BorderStroke(1.dp, Color.DarkGray)) {
                Text(text = "Quai lại", color = Color.Black)
            }
            Spacer(modifier = Modifier.width(16.dp))

            Button(onClick = {
                startActivity(
                    activity,
                    Intent(activity, Cart::class.java),
                    null
                )
            },
                modifier = Modifier.weight(1f),
                colors = ButtonDefaults
                    .buttonColors(containerColor = Color.Cyan),
                shape = RoundedCornerShape(24.dp),
                border = BorderStroke(1.dp, Color.Black)) {
                Text(text = "Thêm giỏ hàng", color = Color.Black)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview5() {
    KOT104_AssignmentTheme {
        Greeting5(Details())
    }
}