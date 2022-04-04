package dev.witheredflowers.whativelearned

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fabChangeLanguage: FloatingActionButton = findViewById(R.id.fabChangeLocale)

        fabChangeLanguage.setOnClickListener {
            // TODO: Change this to add locale logic
            // source: https://lokalise.com/blog/kotlin-internationalization/
            Toast.makeText(applicationContext, "Halo", Toast.LENGTH_SHORT).show()
        }
    }
}