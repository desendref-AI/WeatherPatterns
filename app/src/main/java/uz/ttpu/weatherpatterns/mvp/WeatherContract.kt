package uz.ttpu.weatherpatterns.mvp
import uz.ttpu.weatherpatterns.data.model.Weather
interface WeatherContract{interface View{fun loading();fun weather(w:Weather);fun error(m:String)}}
