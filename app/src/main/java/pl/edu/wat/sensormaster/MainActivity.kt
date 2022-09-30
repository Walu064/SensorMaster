package pl.edu.wat.sensormaster

import android.annotation.SuppressLint
import android.content.Intent
import android.hardware.Sensor
import android.hardware.SensorManager
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Zmienna obsługująca textView z xml:
        val textViewTitleLabel : TextView = findViewById(R.id.textView_titleLabel)
        textViewTitleLabel.text = "Lista dostępnych sensorów: "

        //Zmienna obsługująca listView z xml:
        val listViewListOfSensors : ListView = findViewById(R.id.listView_listOfSensors)

        //SensorManager do obsługi sensorów:
        val manager : SensorManager = getSystemService(SENSOR_SERVICE) as SensorManager

        //Inicjacja listy sensorów do wydrukowania ich nazw:
        val listOfSensors : List<Sensor> = manager.getSensorList(Sensor.TYPE_ALL)

        //Konwersja listy sensorów na tablicę nazw sensorów:
        val sensorsNames = arrayOfNulls<String>(listOfSensors.size)
        val listOfSensorsLength : Int = listOfSensors.size
        for(i in 0 until listOfSensorsLength) {
            sensorsNames[i] = listOfSensors[i].name
        }

        //Adapter do zadaptowania elementu listy jako nazwe danego sensora:
        val arrayAdapter : ArrayAdapter<String> = ArrayAdapter(
            this, android.R.layout.simple_list_item_1, sensorsNames
        )

        listViewListOfSensors.adapter = arrayAdapter

        //Zmienne do obsługi buttonów do przejścia do kolejnych aktywności:
        val buttonLightSensorActivity : Button = findViewById(R.id.button_lightSensor)
        buttonLightSensorActivity.setOnClickListener{
            val intent = Intent(this, LightSensorActivity::class.java)
            startActivity(intent)
        }

        val buttonProximitySensorActivity : Button = findViewById(R.id.button_proximitySensor)
        buttonProximitySensorActivity.setOnClickListener{
            val intent = Intent(this, ProximitySensorActivity::class.java)
            startActivity(intent)
        }

        val buttonAccelerometerActivity : Button = findViewById(R.id.button_accelerometer)
        buttonAccelerometerActivity.setOnClickListener{
            val intent = Intent(this, AccelerometerActivity::class.java)
            startActivity(intent)
        }
    }
}

