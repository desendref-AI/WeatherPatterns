package uz.ttpu.weatherpatterns.data.repository
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Test
import uz.ttpu.weatherpatterns.data.api.FakeWeatherApi
class WeatherRepositoryTest{private val r=WeatherRepository(FakeWeatherApi(0));@Test fun known()=runBlocking{assertEquals(24,r.getWeather("Tashkent").getOrNull()?.temperatureC)};@Test fun unknown()=runBlocking{assertTrue(r.getWeather("Atlantis").isFailure)}}
