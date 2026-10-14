package uz.ttpu.weatherpatterns.mvc.model
import uz.ttpu.weatherpatterns.data.model.Weather
import uz.ttpu.weatherpatterns.data.repository.WeatherRepository
class WeatherModel(private val repo:WeatherRepository){var loading=false;private set;var weather:Weather?=null;private set;var error:String?=null;private set;fun start(){loading=true;error=null};suspend fun load(c:String){repo.getWeather(c).onSuccess{weather=it}.onFailure{error=it.message};loading=false}}
