package fpoly.huynkph38086.kot104_assignment

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import fpoly.huynkph38086.kot104_assignment.nav.NavController
import fpoly.huynkph38086.kot104_assignment.ui.theme.KOT104_AssignmentTheme

class Main : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KOT104_AssignmentTheme {
                Greeting8()
            }
        }
    }
}

@Composable
fun Greeting8() {
    NavController()
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview8() {
    KOT104_AssignmentTheme {
        Greeting8()
    }
}