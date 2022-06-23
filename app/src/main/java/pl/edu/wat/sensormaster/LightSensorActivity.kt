package pl.edu.wat.sensormaster

import android.annotation.SuppressLint
import android.content.Intent
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView

class LightSensorActivity : AppCompatActivity(), SensorEventListener {

    private lateinit var lightSensor : Sensor
    private lateinit var manager : SensorManager
    private lateinit var lightSensorTextView : TextView
    private lateinit var infoTextView : TextView

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_light_sensor)

        //Inicjacja właściwych komponentów do wyświetlania wskazań sensora:
        lightSensorTextView = findViewById(R.id.textView_lightSensorData)
        infoTextView = findViewById(R.id.textView_infoLight)
        infoTextView.text = "Wskazanie czujnika natężenia światła:"

        //Obiekt klasy sensor będący reprezentacją sensora natężenia światła:
        manager  = getSystemService(SENSOR_SERVICE) as SensorManager
        lightSensor = manager.getDefaultSensor(Sensor.TYPE_LIGHT)

        manager.registerListener(this, manager.getDefaultSensor(Sensor.TYPE_LIGHT), 0, null)

        val buttonReturnToMainActivity : Button = findViewById(R.id.button_returnToMainMenu)
        buttonReturnToMainActivity.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {
        //Metoda wygenerowana automatycznie.
    }

    /**
     Metoda nadpisująca wskazanie sensora:
     */
    override fun onSensorChanged(p0: SensorEvent?) {
        lightSensorTextView.text = p0?.values?.get(0).toString()
    }
}