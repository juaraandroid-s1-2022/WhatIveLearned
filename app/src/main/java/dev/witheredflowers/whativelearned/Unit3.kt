package dev.witheredflowers.whativelearned

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dev.witheredflowers.whativelearned.databinding.ActivityUnit3Binding
import dev.witheredflowers.whativelearned.lunchtray.MainActivity

class Unit3 : AppCompatActivity() {
	private lateinit var binding: ActivityUnit3Binding
	
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		
		binding = ActivityUnit3Binding.inflate(layoutInflater)
		
		setContentView(binding.root)
		
		binding.btnLunchTray.setOnClickListener {
			val intent = Intent(this@Unit3, MainActivity::class.java)
			startActivity(intent)
		}
	}
}