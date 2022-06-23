package pl.edu.wat.sensormaster

import android.annotation.SuppressLint
import android.hardware.Sensor
import android.hardware.SensorManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class LightSensorActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_light_sensor)

        //Inicjacja właściwych komponentów do wyświetlania wskazań sensora:
        val lightSensorTextView : TextView = findViewById(R.id.textView_lightSensorData)
        val infoTextView : TextView = findViewById(R.id.textView_info)
        infoTextView.text = "Wskazanie czujnika natężenia światła:"

        //Obiekt klasy sensor będący reprezentacją sensora natężenia światła:
        val manager : SensorManager = getSystemService(SENSOR_SERVICE) as SensorManager
        val lightSensor : Sensor = manager.getDefaultSensor(Sensor.TYPE_LIGHT)

        //Obsługa błędów sensora:
        if(lightSensor == null) lightSensorTextView.text = "Błąd sensora!"
        else lightSensorTextView.text = "Sensor bangla"

        //Funkcja do aktualizacji sensora:
    }
}