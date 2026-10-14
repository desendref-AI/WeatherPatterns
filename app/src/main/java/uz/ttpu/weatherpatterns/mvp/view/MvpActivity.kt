package uz.ttpu.weatherpatterns.mvp.view
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import uz.ttpu.weatherpatterns.data.model.Weather
import uz.ttpu.weatherpatterns.di.WeatherModule
import uz.ttpu.weatherpatterns.mvp.*
import uz.ttpu.weatherpatterns.mvp.presenter.WeatherPresenter
import uz.ttpu.weatherpatterns.ui.*
class MvpActivity:ComponentActivity(),WeatherContract.View{private var s by mutableStateOf("Pick a city");private val p=WeatherPresenter(this,WeatherModule.repository);override fun onCreate(b:Bundle?){super.onCreate(b);setContent{AppTheme{WeatherScreen("MVP",s,p::select)}}};override fun loading(){s="Loading…"};override fun weather(w:Weather){s="${w.city}: ${w.temperatureC}°C, ${w.condition}"};override fun error(m:String){s="Error: $m"};override fun onDestroy(){p.destroy();super.onDestroy()}}
