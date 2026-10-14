package uz.ttpu.weatherpatterns.mvi.view
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import uz.ttpu.weatherpatterns.di.WeatherModule
import uz.ttpu.weatherpatterns.mvi.model.*
import uz.ttpu.weatherpatterns.mvi.viewmodel.WeatherMviViewModel
import uz.ttpu.weatherpatterns.ui.*
class MviActivity:ComponentActivity(){private val vm:WeatherMviViewModel by viewModels{WeatherModule.mviFactory};override fun onCreate(b:Bundle?){super.onCreate(b);setContent{AppTheme{val x by vm.state.collectAsStateWithLifecycle();val text=when{x.loading->"Loading…";x.error!=null->"Error: ${x.error}";x.weather!=null->x.weather!!.let{"${it.city}: ${it.temperatureC}°C, ${it.condition}"};else->"Pick a city"};WeatherScreen("MVI",text){vm.intent(WeatherIntent.SelectCity(it))}}}}}
