package fpoly.huynkph38086.kot104_assignment.nav

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import fpoly.huynkph38086.kot104_assignment.R
import fpoly.huynkph38086.kot104_assignment.models.ChiTietGioHang
import fpoly.huynkph38086.kot104_assignment.models.NoiThat

@Composable
fun ItemHome(item: NoiThat, onClick: (id: String) -> Unit) {
    Button(
        onClick = { onClick(item.id) },
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
                painter = painterResource(id = item.anh as Int),
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
                Text(text = item.ten,
                    modifier = Modifier.padding(1.dp),
                    fontSize = 16.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    //fontStyle = FontStyle.Italic,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )

                Text(text = item.gia.toString(),
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

@Composable
fun ItemCart(item: ChiTietGioHang, sl: Int, onPlus: () -> Unit, onMinus: () -> Unit) {
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .padding(8.dp)
    ) {
        Image(
            painter = painterResource(id = item.noiThat.anh as Int),
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
            Text(text = item.noiThat.ten,
                modifier = Modifier.padding(1.dp),
                fontSize = 24.sp,
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                //fontStyle = FontStyle.Italic,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

            Text(text = "${item.noiThat.gia}",
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
                    .clickable { onPlus() }
            )
            Text(text = "$sl", fontSize = 18.sp)
            Image(
                painter = painterResource(id = R.drawable.baseline_keyboard_arrow_down_24),
                contentDescription = "cong",
                modifier = Modifier
                    .size(30.dp)
                    .clickable { onMinus() }
            )
        }
    }
}