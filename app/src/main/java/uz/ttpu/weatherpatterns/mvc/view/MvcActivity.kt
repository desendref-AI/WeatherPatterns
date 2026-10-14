package uz.ttpu.weatherpatterns.mvc.view
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import uz.ttpu.weatherpatterns.di.WeatherModule
import uz.ttpu.weatherpatterns.mvc.model.WeatherModel
import uz.ttpu.weatherpatterns.mvc.controller.WeatherController
import uz.ttpu.weatherpatterns.ui.*
class MvcActivity:ComponentActivity(){private val m=WeatherModel(WeatherModule.repository);private var s by mutableStateOf("Pick a city");private val c=WeatherController(m){s=when{m.loading->"Loading…";m.error!=null->"Error: ${m.error}";m.weather!=null->m.weather!!.let{"${it.city}: ${it.temperatureC}°C, ${it.condition}"};else->"Pick a city"}};override fun onCreate(b:Bundle?){super.onCreate(b);setContent{AppTheme{WeatherScreen("MVC",s,c::select)}}};override fun onDestroy(){c.destroy();super.onDestroy()}}
