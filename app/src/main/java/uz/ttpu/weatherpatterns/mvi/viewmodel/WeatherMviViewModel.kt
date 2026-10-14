package uz.ttpu.weatherpatterns.mvi.viewmodel
import androidx.lifecycle.*
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import uz.ttpu.weatherpatterns.data.repository.WeatherRepository
import uz.ttpu.weatherpatterns.mvi.model.*
class WeatherMviViewModel(private val r:WeatherRepository):ViewModel(){private val _s=MutableStateFlow(WeatherState());val state=_s.asStateFlow();fun intent(i:WeatherIntent){when(i){is WeatherIntent.SelectCity->load(i.city);WeatherIntent.DismissError->_s.update{it.copy(error=null)}}};private fun load(c:String){_s.update{it.copy(loading=true,error=null)};viewModelScope.launch{r.getWeather(c).onSuccess{w->_s.update{it.copy(loading=false,weather=w,error=null)}}.onFailure{e->_s.update{it.copy(loading=false,error=e.message)}}}}}
