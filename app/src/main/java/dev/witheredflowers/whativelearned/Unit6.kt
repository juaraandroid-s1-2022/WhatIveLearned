package dev.witheredflowers.whativelearned

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dev.witheredflowers.whativelearned.databinding.ActivityUnit6Binding

class Unit6 : AppCompatActivity() {
	private lateinit var binding: ActivityUnit6Binding

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)

		binding = ActivityUnit6Binding.inflate(layoutInflater)

		setContentView(binding.root)

		binding.btnWaterMe.setOnClickListener {
			val intent = Intent(this@Unit6, NotYetImplementedActivity::class.java)
			startActivity(intent)
		}
	}
}