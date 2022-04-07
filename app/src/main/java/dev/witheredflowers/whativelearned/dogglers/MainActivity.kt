package dev.witheredflowers.whativelearned.dogglers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dev.witheredflowers.whativelearned.R

class MainActivity : AppCompatActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main_dogglers)
		
		// Change ActionBar title according to locale
		supportActionBar?.setTitle(R.string.app_name_dogglers)
	}
}