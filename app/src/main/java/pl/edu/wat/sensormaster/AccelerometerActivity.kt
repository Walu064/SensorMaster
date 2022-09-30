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

class AccelerometerActivity : AppCompatActivity(), SensorEventListener {

    private lateinit var accelerometer : Sensor
    private lateinit var manager : SensorManager
    private lateinit var accelerometerTextView : TextView
    private lateinit var infoAccleremeterTextView : TextView

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_accelerometer)

        //Inicjacja właściwych komponentów do wyświetlania wskazań sensora:
        accelerometerTextView = findViewById(R.id.textView_AccelerometerData)
        infoAccleremeterTextView = findViewById(R.id.textView_infoAccelerometer)
        infoAccleremeterTextView.text = "Wskazanie czujnika przyspieszenia:"

        //Obiekt klasy sensor będący reprezentacją sensora natężenia światła:
        manager  = getSystemService(SENSOR_SERVICE) as SensorManager
        accelerometer = manager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)

        manager.registerListener(this, manager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), 0, null)

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
        accelerometerTextView.text = p0?.values?.get(0).toString()
    }
}