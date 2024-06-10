package fpoly.huynkph38086.kot104_assignment.nav

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.rememberLazyStaggeredGridState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import fpoly.huynkph38086.kot104_assignment.R
import fpoly.huynkph38086.kot104_assignment.models.HoaDon
import fpoly.huynkph38086.kot104_assignment.ui.theme.KOT104_AssignmentTheme
import java.time.LocalDateTime

enum class Screen(val route: String) {
    Login("Login"),
    Register("Register"),
    Home("Home"),
    Details("Details"),
    Cart("Cart"),
    Payment("Payment"),
    History("History"),
}

@Composable
fun LoginScreen(navController: NavController, viewModel: VModel) {
    val context = LocalContext.current
    var un by remember { mutableStateOf("") }
    var pw by remember { mutableStateOf("") }

    Column (
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Đăng nhập", fontSize = 48.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(36.dp))

        Image(
            painter = painterResource(
                id = R.drawable.logo
            ),
            contentDescription = "Logo",
            modifier = Modifier.fillMaxWidth(0.8f)
        )
        Spacer(modifier = Modifier.height(24.dp))

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

//                RememberMeSwitch()
//                Spacer(modifier = Modifier.height(24.dp))

        Button(onClick = {
            if (un.isNotBlank() && pw.isNotBlank()) {
                val tk = viewModel.getUserBy(un)
                if (tk == null) Toast.makeText(context, "Tài khoản không tồn tại",
                    Toast.LENGTH_LONG).show()
                else if (tk.check(pw)) {
                    viewModel.currentUser = tk
                    viewModel.newCart()
                    navController.navigate(Screen.Home.route)
                    Toast.makeText(context, "Đăng nhập thành công",
                        Toast.LENGTH_LONG).show()
                } else Toast.makeText(context, "Sai mật khẩu",
                    Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(
                    context, "Vui lòng không để trống",
                    Toast.LENGTH_LONG
                ).show()
            }},
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.DarkGray,
                contentColor = Color.White)
        ) {
            Text(text = "Login", fontSize = 16.sp)
        }
        Spacer(modifier = Modifier.height(24.dp))

        Button(onClick = {navController.navigate(Screen.Register.route)}) {
            Text(text = "Register", fontSize = 16.sp)
        }
    }
}

@Composable
fun RememberMeSwitch() {
    var isChecked by remember { mutableStateOf(false) }

    Row(
        Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Switch(
            checked = isChecked,
            onCheckedChange = { isChecked = it }
        )
        Text("Remember Me?", modifier = Modifier.padding(start =
        12.dp))
    }
}

@Composable
fun RegisterScreen(navController: NavController, viewModel: VModel) {
    val context = LocalContext.current
    var un by remember { mutableStateOf("") }
    var pw by remember { mutableStateOf("") }

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
                val tk = viewModel.getUserBy(un)
                if (tk != null) Toast.makeText(context, "Tài khoản đã tồn tại",
                    Toast.LENGTH_LONG).show()
                else if (viewModel.addUser(un, pw)) {
                    Toast.makeText(context, "Đăng ký thành công",
                        Toast.LENGTH_LONG).show()
                    navController.popBackStack()
                } else Toast.makeText(context, "Đăng ký thất bại",
                    Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(context, "Vui lòng không để trống",
                    Toast.LENGTH_LONG).show()
            }
        },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.DarkGray,
                contentColor = Color.White)) {
            Text(text = "Register", fontSize = 16.sp)
        }
        Spacer(modifier = Modifier.height(24.dp))

        Button(onClick = { navController.popBackStack() }) {
            Text(text = "Cancel", fontSize = 16.sp)
        }
    }
}

@Composable
fun HomeScreen(navController: NavController, viewModel: VModel) {
    val list = viewModel.products

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        LazyVerticalStaggeredGrid(
            columns = StaggeredGridCells.Fixed(2),
            state = rememberLazyStaggeredGridState(),
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            verticalItemSpacing = 4.dp,
            contentPadding = PaddingValues(0.dp)
        ) {
            items(list.size) { index ->
                ItemHome(item = list[index],
                    onClick = {navController.navigate("${Screen.Details.route}/${it}")}
                )
            }
        }
        Spacer(modifier = Modifier.weight(1f))

        Nav(navController)
    }
}

@Composable
fun DetailsScreen(navController: NavController, viewModel: VModel, id: String?) {
    val item = viewModel.getProductBy(id)
    //val isEditing = id != null

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        Image(
            painter = painterResource(id = item?.anh as Int),
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

        Text(text = item.mota)
        Spacer(modifier = Modifier.height(16.dp))

        Spacer(modifier = Modifier.weight(1f))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(onClick = { navController.popBackStack() },
                colors = ButtonDefaults
                    .buttonColors(containerColor = Color.LightGray),
                shape = RoundedCornerShape(24.dp),
                border = BorderStroke(1.dp, Color.DarkGray)
            ) {
                Text(text = "Quay lại", color = Color.Black)
            }
            Spacer(modifier = Modifier.width(16.dp))

            Button(onClick = {
                viewModel.addCart(item)
                navController.navigate(Screen.Cart.route)
            },
                modifier = Modifier.weight(1f),
                colors = ButtonDefaults
                    .buttonColors(containerColor = Color.Cyan),
                shape = RoundedCornerShape(24.dp),
                border = BorderStroke(1.dp, Color.Black)
            ) {
                Text(text = "Thêm giỏ hàng", color = Color.Black)
            }
        }
    }
}

@Composable
fun CartScreen(navController: NavController, viewModel: VModel) {
    val gioHang = viewModel.cart
    var tt by rememberSaveable { mutableDoubleStateOf(gioHang.getTongTien()) }
    var sl by rememberSaveable { mutableIntStateOf(1) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LazyColumn(
            state = rememberLazyListState(),
            contentPadding = PaddingValues(horizontal = 0.dp, vertical = 0.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(gioHang.list.size) {index ->
                sl = gioHang.list[index].soLuong
                ItemCart(item = gioHang.list[index], sl,
                    {
                        sl++
                        gioHang.list[index].soLuong = sl
                        tt = gioHang.getTongTien()
                    },
                    {
                        if (sl > 0) {
                            sl--
                            gioHang.list[index].soLuong = sl
                            tt = gioHang.getTongTien()
                        }
                    }
                )
            }
        }
        Spacer(modifier = Modifier.weight(1f))
        Spacer(modifier = Modifier.height(8.dp))

        Text(text = "Tổng tiền: $tt",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(8.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(onClick = { navController.popBackStack() },
                colors = ButtonDefaults
                    .buttonColors(containerColor = Color.LightGray),
                shape = RoundedCornerShape(24.dp),
                border = BorderStroke(1.dp, Color.DarkGray)
            ) {
                Text(text = "Quay lai", color = Color.Black)
            }
            Spacer(modifier = Modifier.width(16.dp))

            Button(onClick = {
                navController.navigate(Screen.Payment.route)
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
        Spacer(modifier = Modifier.height(8.dp))

        Nav(navController)
    }
}

@Composable
fun PaymentScreen(navController: NavController, viewModel: VModel) {
    val gioHang = viewModel.cart
    val context = LocalContext.current
    val un = viewModel.currentUser.un
    val now = "${LocalDateTime.now().hour}:" +
            "${LocalDateTime.now().minute} - " +
            "${LocalDateTime.now().dayOfMonth}/" +
            "${LocalDateTime.now().monthValue}/" +
            "${LocalDateTime.now().year}"
    val total = gioHang.getTongTien().toString()

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        Text(text = "Người mua: $un",
            fontSize = 22.sp
        )
        Spacer(modifier = Modifier.height(24.dp))

        Text(text = "Lúc: $now",
            fontSize = 22.sp
        )
        Spacer(modifier = Modifier.height(24.dp))

        Text(text = "Tổng tiền: ${total}$",
            fontSize = 22.sp
        )
        Spacer(modifier = Modifier.height(24.dp))

        Button(onClick = { navController.popBackStack() },
            colors = ButtonDefaults
                .buttonColors(containerColor = Color.LightGray),
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(24.dp),
            border = BorderStroke(1.dp, Color.DarkGray)
        ) {
            Text(text = "Quay lai",
                fontSize = 16.sp,
                color = Color.Black
            )
        }
        Spacer(modifier = Modifier.height(24.dp))

        Button(onClick = {
            viewModel.newCart()
            viewModel.andHistory(HoaDon(un, now, total))
            Toast.makeText(context, "Mua thành công",
                Toast.LENGTH_LONG).show()
            navController.navigate(Screen.Home.route) {
                popUpTo(Screen.Details.route) { inclusive = true }
                popUpTo(Screen.Cart.route) { inclusive = true }
                popUpTo(Screen.Payment.route) { inclusive = true }
            }
        },
            colors = ButtonDefaults
                .buttonColors(containerColor = Color.Yellow),
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(24.dp),
            border = BorderStroke(1.dp, Color.DarkGray)
        ) {
            Text(text = "Xác nhận",
                fontSize = 16.sp,
                color = Color.Black
            )
        }
    }
}

@Composable
fun HistoryScreen(navController: NavController, viewModel: VModel) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LazyColumn(
            state = rememberLazyListState(),
            contentPadding = PaddingValues(horizontal = 0.dp, vertical = 0.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(viewModel.historys.size) { index ->
                ItemHistory(item = viewModel.historys[index])
            }
        }
        Spacer(modifier = Modifier.weight(1f))

        Nav(navController)
    }
}

@Preview(showBackground = true)
@Composable
fun ScreenPreview() {
    KOT104_AssignmentTheme {
        NavController(Screen.Cart.route)
    }
}