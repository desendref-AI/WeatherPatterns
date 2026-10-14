package uz.ttpu.weatherpatterns.mvvm.viewmodel
import androidx.lifecycle.*
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import uz.ttpu.weatherpatterns.data.model.Weather
import uz.ttpu.weatherpatterns.data.repository.WeatherRepository
sealed interface WeatherUiState{data object Idle:WeatherUiState;data object Loading:WeatherUiState;data class Success(val w:Weather):WeatherUiState;data class Error(val m:String):WeatherUiState}
class WeatherViewModel(private val r:WeatherRepository):ViewModel(){private val _s=MutableStateFlow<WeatherUiState>(WeatherUiState.Idle);val state=_s.asStateFlow();fun select(c:String){_s.value=WeatherUiState.Loading;viewModelScope.launch{r.getWeather(c).onSuccess{_s.value=WeatherUiState.Success(it)}.onFailure{_s.value=WeatherUiState.Error(it.message?:"Unknown error")}}}}
