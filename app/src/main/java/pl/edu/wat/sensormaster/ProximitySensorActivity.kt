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

class ProximitySensorActivity : AppCompatActivity(), SensorEventListener {

    private lateinit var proximitySensor : Sensor
    private lateinit var manager : SensorManager
    private lateinit var proximitySensorTextView : TextView
    private lateinit var infoTextView : TextView

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_accelerometer)

        proximitySensorTextView = findViewById(R.id.textView_ProximitySensorData)
        infoTextView = findViewById(R.id.textView_infoProximity)
        infoTextView.text = "Wskazanie czujnika zbliżeniowego:"

        manager  = getSystemService(SENSOR_SERVICE) as SensorManager
        proximitySensor = manager.getDefaultSensor(Sensor.TYPE_LIGHT)
        manager.registerListener(this, manager.getDefaultSensor(Sensor.TYPE_LIGHT), 0, null)

        if(proximitySensor == null) proximitySensorTextView.text = "Błąd sensora!"
        else proximitySensorTextView.text = "Sensor bangla"

        val buttonReturnToMainActivity : Button = findViewById(R.id.button_returnToMainMenu)
        buttonReturnToMainActivity.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onSensorChanged(p0: SensorEvent?) {
        proximitySensorTextView.text = p0?.values?.get(0).toString()
    }

    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {
    }
}