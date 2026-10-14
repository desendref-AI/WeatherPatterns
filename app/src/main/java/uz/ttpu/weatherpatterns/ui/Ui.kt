package uz.ttpu.weatherpatterns.ui
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
@Composable
fun AppTheme(content: @Composable () -> Unit) = MaterialTheme(content = content)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WeatherScreen(title: String, status: String, onCity: (String) -> Unit) {
    Scaffold(topBar = { CenterAlignedTopAppBar(title = { Text(title) }) }) { p ->
        Column(
            Modifier.fillMaxSize().padding(p).padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            ElevatedCard(Modifier.fillMaxWidth()) {
                Text(status, Modifier.padding(24.dp), style = MaterialTheme.typography.headlineSmall)
            }
            listOf("Tashkent", "Samarkand", "Bukhara", "Atlantis").forEach { c ->
                Button({ onCity(c) }, Modifier.fillMaxWidth()) { Text(c) }
            }
        }
    }
}
