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
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
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

class Cart : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KOT104_AssignmentTheme {
                Greeting6(this)
            }
        }
    }
}

@Composable
fun Greeting6(activity: Activity) {
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
            CartScreen(activity, 3000.0)
        }
    }
}

@Composable
fun CartScreen(activity: Activity, donGia: Double) {
    var soluong by rememberSaveable { mutableIntStateOf(1) }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        soluong = itemCart(soluong)
        Spacer(modifier = Modifier.weight(1f))
        Text(text = "Tổng tiền: ${donGia * soluong}",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(0.dp, 8.dp),

        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(onClick = { activity.finish() },
                colors = ButtonDefaults
                    .buttonColors(containerColor = Color.LightGray),
                shape = RoundedCornerShape(24.dp),
                border = BorderStroke(1.dp, Color.DarkGray)
            ) {
                Text(text = "Quay lai", color = Color.Black)
            }
            Spacer(modifier = Modifier.width(16.dp))

            Button(onClick = {
                startActivity(
                    activity,
                    Intent(activity, Payment::class.java),
                    null
                )
            },
                modifier = Modifier.weight(1f),
                colors = ButtonDefaults
                    .buttonColors(containerColor = Color.Green),
                shape = RoundedCornerShape(24.dp),
                border = BorderStroke(1.dp, Color.Black)
            ) {
                Text(text = "Thanh toán", color = Color.Black)
            }
        }
    }
}

@Composable
fun itemCart(soluong: Int = 1): Int {
    var sl = soluong
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .padding(8.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.ghe),
            contentDescription = "ghe",
            modifier = Modifier
                .size(100.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))

        Column(
            modifier = Modifier
                .fillMaxHeight()
                .weight(1f),
            verticalArrangement = Arrangement.SpaceAround
        ) {
            Text(text = "Ghế",
                modifier = Modifier.padding(1.dp),
                fontSize = 24.sp,
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                //fontStyle = FontStyle.Italic,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

            Text(text = "3000$",
                modifier = Modifier.padding(1.dp),
                fontSize = 24.sp,
                color = Color.Red,
                //fontWeight = FontWeight.Bold,
                fontStyle = FontStyle.Italic,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
        Spacer(modifier = Modifier.width(8.dp))

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.baseline_keyboard_arrow_up_24),
                contentDescription = "cong",
                modifier = Modifier
                    .size(30.dp)
                    .clickable { sl++ }
            )
            Text(text = "$soluong", fontSize = 18.sp)
            Image(
                painter = painterResource(id = R.drawable.baseline_keyboard_arrow_down_24),
                contentDescription = "cong",
                modifier = Modifier
                    .size(30.dp)
                    .clickable { if (sl > 0) sl-- }
            )
        }
    }
    return sl
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview6() {
    KOT104_AssignmentTheme {
        Greeting6(Cart())
    }
}