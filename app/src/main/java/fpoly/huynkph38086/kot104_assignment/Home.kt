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
import fpoly.huynkph38086.kot104_assignment.thu_vien_rieng.upTo
import fpoly.huynkph38086.kot104_assignment.ui.theme.KOT104_AssignmentTheme

class Home : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KOT104_AssignmentTheme {
                Greeting3(this)
            }
        }
    }
}

@Composable
fun NAV() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(24.dp),
        colors = CardDefaults.cardColors(containerColor =
        Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation =
        4.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Button(onClick = { /*TODO*/ },
                colors = ButtonDefaults
                    .buttonColors(containerColor = Color.White)
            ) {
                Text(text = "*nav, dang thiet ke", color = Color.Black)
            }
        }
    }
}

@Composable
fun Greeting3(activity: Activity) {
    var trang = 1
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        NAV()
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp, 0.dp, 24.dp, 24.dp),
            colors = CardDefaults.cardColors(containerColor =
            Color.White),
            elevation = CardDefaults.cardElevation(defaultElevation =
            4.dp)
        ) {
            HomeScreen(activity, trang)
            Spacer(modifier = Modifier.weight(1f))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp, 0.dp, 12.dp, 12.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Button(onClick = { if(trang > 1) trang-- },
                    colors = ButtonDefaults
                        .buttonColors(containerColor = Color.White)
                ) {
                    Text(text = "<",
                        fontSize = 24.sp,
                        color = Color.Black
                    )
                }
                Text(text = "$trang",
                    fontSize = 24.sp,
                    color = Color.Black
                )
                Button(onClick = { trang++ },
                colors = ButtonDefaults
                    .buttonColors(containerColor = Color.White)
                ) {
                    Text(text = ">",
                        fontSize = 24.sp,
                        color = Color.Black
                    )
                }
            }
        }
    }
}

@Composable
fun HomeScreen(activity: Activity, trang: Int) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp, 16.dp, 16.dp, 0.dp)
    ) {
        C(0, trang, activity)
        C(1, trang, activity)
    }
}

@Composable
fun C(i: Int, t: Int, activity: Activity) {
    Column(
        modifier = Modifier
            .fillMaxWidth(if (i == 0) 0.5f else 1f)
    ) {
        for(j in 0 upTo 3)
            ItemHome(i+j*2+(t-1)*8, activity)
    }
}

@Composable
fun ItemHome(i: Int, activity: Activity) {
    Button(
        onClick = {
            startActivity(
                activity,
                Intent(activity, Details::class.java),
                null
            )
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        colors = ButtonDefaults
            .buttonColors(containerColor = Color.White),
        shape = RoundedCornerShape(16.dp),
        border = BorderStroke(1.dp, Color.Black),
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = 10.dp,
            pressedElevation = 15.dp,
            disabledElevation = 0.dp
        )
    ) {
        Column {
            Image(
                painter = painterResource(id = R.drawable.ghe),
                contentDescription = "ghe",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .padding(1.dp)
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "Ghế",
                    modifier = Modifier.padding(1.dp),
                    fontSize = 16.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    //fontStyle = FontStyle.Italic,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )

                Text(text = "3000$",
                    modifier = Modifier.padding(1.dp),
                    fontSize = 16.sp,
                    color = Color.Red,
                    //fontWeight = FontWeight.Bold,
                    fontStyle = FontStyle.Italic,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview3() {
    KOT104_AssignmentTheme {
        Greeting3(Home())
    }
}