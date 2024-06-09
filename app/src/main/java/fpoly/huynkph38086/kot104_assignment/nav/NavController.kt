package fpoly.huynkph38086.kot104_assignment.nav

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun NavController(startDestination: String = Screen.Login.route){
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
    }
}

@Composable
fun Nav() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp)
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