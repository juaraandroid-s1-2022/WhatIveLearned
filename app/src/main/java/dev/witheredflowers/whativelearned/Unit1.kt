package dev.witheredflowers.whativelearned

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import dev.witheredflowers.whativelearned.lemonade.MainActivity

class Unit1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_unit1)
        
        val btnLemonade:Button = findViewById(R.id.btnLemonade)
        btnLemonade.setOnClickListener() {
            val intent = Intent(this@Unit1, MainActivity::class.java)
            startActivity(intent)
        }
    }
}