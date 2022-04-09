package dev.witheredflowers.whativelearned

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dev.witheredflowers.whativelearned.databinding.ActivityUnit5Binding

class Unit5 : AppCompatActivity() {
	private lateinit var binding: ActivityUnit5Binding

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)

		binding = ActivityUnit5Binding.inflate(layoutInflater)

		setContentView(binding.root)

		binding.btnForage.setOnClickListener {
			val intent = Intent(this@Unit5, NotYetImplementedActivity::class.java)
			startActivity(intent)
		}
	}
}