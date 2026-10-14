package uz.ttpu.weatherpatterns.mvc.controller
import kotlinx.coroutines.*
import uz.ttpu.weatherpatterns.mvc.model.WeatherModel
class WeatherController(private val m:WeatherModel,private val render:()->Unit){private val scope=CoroutineScope(SupervisorJob()+Dispatchers.Main);fun select(c:String){scope.launch{m.start();render();m.load(c);render()}};fun destroy()=scope.cancel()}
