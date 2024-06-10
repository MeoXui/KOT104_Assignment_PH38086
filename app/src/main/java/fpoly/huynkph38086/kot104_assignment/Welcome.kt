@file:Suppress("DEPRECATION")

package fpoly.huynkph38086.kot104_assignment

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import fpoly.huynkph38086.kot104_assignment.ui.theme.KOT104_AssignmentTheme

class WelcomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KOT104_AssignmentTheme {
                WelcomeGreeting()
            }
        }

        Handler().postDelayed({
            startActivity(this, Intent(this, Main::class.java), null)
            finish()
        }, 3000)
    }
}

@Composable
fun WelcomeGreeting() {
    Box (
        modifier = Modifier
            .fillMaxWidth(1f)
            .fillMaxHeight(1f)
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Welcome!", fontSize = 30.sp)
    }
}

@Preview(showBackground = true)
@Composable
fun WelcomePreview() {
    KOT104_AssignmentTheme {
        WelcomeGreeting()
    }
}