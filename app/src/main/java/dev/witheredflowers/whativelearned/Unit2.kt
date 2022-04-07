package dev.witheredflowers.whativelearned

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import dev.witheredflowers.whativelearned.dogglers.MainActivity

class Unit2 : AppCompatActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_unit2)
		
		val btnDogglers: Button = findViewById(R.id.btnDogglers)
		btnDogglers.setOnClickListener {
			val intent = Intent(this@Unit2, MainActivity::class.java)
			startActivity(intent)
		}
	}
}