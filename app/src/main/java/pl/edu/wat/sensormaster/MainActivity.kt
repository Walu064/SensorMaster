package pl.edu.wat.sensormaster

import android.annotation.SuppressLint
import android.hardware.Sensor
import android.hardware.SensorManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textViewListOfSensors : TextView = findViewById(R.id.textView_listOfSensors)
        textViewListOfSensors.text = " "

        val manager : SensorManager = getSystemService(SENSOR_SERVICE) as SensorManager
        val listOfSensors : List<Sensor> = manager.getSensorList(Sensor.TYPE_ALL)

        val listOfSensorsLength : Int = listOfSensors.size


        for(i in 0 until listOfSensorsLength) {
            textViewListOfSensors.text = textViewListOfSensors.text as String + "\n" + listOfSensors[i].name
        }


    }
}

