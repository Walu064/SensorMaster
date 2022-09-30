package pl.edu.wat.sensormaster

import android.annotation.SuppressLint
import android.content.Intent
import android.hardware.Sensor
import android.hardware.SensorManager
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Zmienna obsługująca textView z xml:
        val textViewTitleLabel : TextView = findViewById(R.id.textView_titleLabel)
        textViewTitleLabel.text = "Lista dostępnych sensorów: "

        //SensorManager do obsługi sensorów:
        val manager : SensorManager = getSystemService(SENSOR_SERVICE) as SensorManager

        //Inicjacja listy sensorów do wydrukowania ich nazw:
        val listOfSensors : List<Sensor> = manager.getSensorList(Sensor.TYPE_ALL)

        /*
        //pętla do wydrukowania sensorów w print View:
        val listOfSensorsLength : Int = listOfSensors.size
        for(i in 0 until listOfSensorsLength) {
            textViewListOfSensors.text =  textViewListOfSensors.text as String + "\n" + listOfSensors[i].name
        }
         */

        //Zmienne do obsługi buttonów do przejścia do kolejnych aktywności:
        val buttonLightSensorActivity : Button = findViewById(R.id.button_lightSensor)
        buttonLightSensorActivity.setOnClickListener{
            val intent = Intent(this, LightSensorActivity::class.java)
            startActivity(intent)
        }

        val buttonAccelerometerActivityActivity : Button = findViewById(R.id.button_proximitySensor)
        buttonAccelerometerActivityActivity.setOnClickListener{
            val intent = Intent(this, ProximitySensorActivity::class.java)
            startActivity(intent)
        }
    }
}

