package uz.ttpu.weatherpatterns.mvvm.view
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import uz.ttpu.weatherpatterns.di.WeatherModule
import uz.ttpu.weatherpatterns.mvvm.viewmodel.*
import uz.ttpu.weatherpatterns.ui.*
class MvvmActivity:ComponentActivity(){private val vm:WeatherViewModel by viewModels{WeatherModule.mvvmFactory};override fun onCreate(b:Bundle?){super.onCreate(b);setContent{AppTheme{val x by vm.state.collectAsStateWithLifecycle();WeatherScreen("MVVM",when(x){WeatherUiState.Idle->"Pick a city";WeatherUiState.Loading->"Loading…";is WeatherUiState.Success->(x as WeatherUiState.Success).w.let{"${it.city}: ${it.temperatureC}°C, ${it.condition}"};is WeatherUiState.Error->"Error: ${(x as WeatherUiState.Error).m}"},vm::select)}}}}
