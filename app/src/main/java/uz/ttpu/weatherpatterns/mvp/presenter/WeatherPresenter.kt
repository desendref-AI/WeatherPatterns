package uz.ttpu.weatherpatterns.mvp.presenter
import kotlinx.coroutines.*
import uz.ttpu.weatherpatterns.mvp.WeatherContract
import uz.ttpu.weatherpatterns.data.repository.WeatherRepository
class WeatherPresenter(private val v:WeatherContract.View,private val r:WeatherRepository,private val scope:CoroutineScope=CoroutineScope(SupervisorJob()+Dispatchers.Main)){fun select(c:String){v.loading();scope.launch{r.getWeather(c).onSuccess(v::weather).onFailure{v.error(it.message?:"Unknown error")}}};fun destroy()=scope.cancel()}
