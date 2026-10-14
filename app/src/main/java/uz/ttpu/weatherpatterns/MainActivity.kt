package uz.ttpu.weatherpatterns
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import uz.ttpu.weatherpatterns.mvc.view.MvcActivity
import uz.ttpu.weatherpatterns.mvp.view.MvpActivity
import uz.ttpu.weatherpatterns.mvvm.view.MvvmActivity
import uz.ttpu.weatherpatterns.mvi.view.MviActivity
import uz.ttpu.weatherpatterns.ui.AppTheme
class MainActivity:ComponentActivity(){override fun onCreate(b:Bundle?){super.onCreate(b);setContent{AppTheme{Launcher{startActivity(Intent(this,it))}}}}}
@Composable fun Launcher(open:(Class<*>)->Unit){Column(Modifier.fillMaxSize().padding(24.dp),verticalArrangement=Arrangement.spacedBy(16.dp)){Text("Weather Patterns",style=MaterialTheme.typography.displaySmall); listOf("MVC" to MvcActivity::class.java,"MVP" to MvpActivity::class.java,"MVVM" to MvvmActivity::class.java,"MVI" to MviActivity::class.java).forEach{(n,c)->ElevatedButton({open(c)},Modifier.fillMaxWidth()){Text(n)} }}}
