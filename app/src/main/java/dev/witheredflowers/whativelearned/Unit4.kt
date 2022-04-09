package dev.witheredflowers.whativelearned

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dev.witheredflowers.whativelearned.databinding.ActivityUnit4Binding

class Unit4 : AppCompatActivity() {
    private lateinit var binding: ActivityUnit4Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityUnit4Binding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.btnAmphibians.setOnClickListener {
            val intent = Intent(this@Unit4, NotYetImplementedActivity::class.java)
            startActivity(intent)
        }
    }
}