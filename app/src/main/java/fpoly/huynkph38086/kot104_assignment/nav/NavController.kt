package fpoly.huynkph38086.kot104_assignment.nav

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import fpoly.huynkph38086.kot104_assignment.R

@Composable
fun NavController(startDestination: String = Screen.Login.route){
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
            colors = CardDefaults.cardColors(containerColor = Color.White),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ) {
            val navController = rememberNavController()
            val viewModel: VModel = viewModel()

            NavHost(
                navController = navController,
                startDestination = startDestination,
            ) {
                composable(Screen.Login.route) { LoginScreen(navController, viewModel) }
                composable(Screen.Register.route) { RegisterScreen(navController, viewModel) }
                composable(Screen.Home.route) { HomeScreen(navController, viewModel) }
                composable("${Screen.Details.route}/{id}",
                    arguments = listOf(navArgument("id") { type = NavType.StringType })
                ) {backStackEntry ->
                    backStackEntry.arguments?.getString("id")?.let {id ->
                        DetailsScreen(navController, viewModel, id)
                    }
                }
                composable(Screen.Cart.route) { CartScreen(navController, viewModel) }
                composable(Screen.Payment.route) { PaymentScreen(navController, viewModel) }
                composable(Screen.History.route) { HistoryScreen(navController, viewModel) }
            }
        }
    }
}

@Composable
fun Nav(navController: NavController) {
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Button(onClick = { navController.navigate(Screen.Home.route) {
                popUpTo(Screen.Details.route) { inclusive = true }
                popUpTo(Screen.Cart.route) { inclusive = true }
                popUpTo(Screen.Payment.route) { inclusive = true }
                popUpTo(Screen.History.route) { inclusive = true }
            } },
                colors = ButtonDefaults
                    .buttonColors(containerColor = Color.White)
            ) {
                Icon(painter = painterResource(id = R.drawable.baseline_home_24),
                    contentDescription = "Home",
                    tint = Color.Black)
            }

            Button(onClick = { navController.navigate(Screen.Cart.route) {
                popUpTo(Screen.History.route) { inclusive = true }
            } },
                colors = ButtonDefaults
                    .buttonColors(containerColor = Color.White)
            ) {
                Icon(painter = painterResource(id = R.drawable.baseline_shopping_cart_24),
                    contentDescription = "Cart",
                    tint = Color.Black)
            }

            Button(onClick = { navController.navigate(Screen.History.route) {
                popUpTo(Screen.Cart.route) { inclusive = true }
            } },
                colors = ButtonDefaults
                    .buttonColors(containerColor = Color.White)
            ) {
                Icon(painter = painterResource(id = R.drawable.baseline_access_time_24),
                    contentDescription = "History",
                    tint = Color.Black)
            }
        }
    }
}