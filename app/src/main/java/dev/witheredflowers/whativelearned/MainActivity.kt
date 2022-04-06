package dev.witheredflowers.whativelearned

import android.annotation.SuppressLint
import android.content.Context
import android.content.ContextWrapper
import android.content.Intent
import android.os.Bundle
import android.os.LocaleList
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import dev.witheredflowers.whativelearned.utils.ContextUtils
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun attachBaseContext(newBase: Context?) {
        val localeToSwitchTo = Locale("in")
        val localeUpdatedContext: ContextWrapper =
            ContextUtils.updateLocale(newBase, localeToSwitchTo)

        super.attachBaseContext(localeUpdatedContext)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loadLocale()
        setContentView(R.layout.activity_main)

        // Change ActionBar title according to locale
        supportActionBar?.setTitle(R.string.app_name)

        // Floating Action Button Event
        val fabChangeLanguage: FloatingActionButton = findViewById(R.id.fabChangeLocale)
        fabChangeLanguage.setOnClickListener {
            // source: https://lokalise.com/blog/kotlin-internationalization/
            changeLocale()
            recreate()
        }

        // Unit 1 Button Event
        val btnUnit1: Button = findViewById(R.id.btnUnitOne)
        btnUnit1.setOnClickListener {
            val intent = Intent(this@MainActivity, Unit1::class.java)
            startActivity(intent)
        }
    }

    @SuppressLint("NewApi")
    private fun setLocale(localeToSet: String) {
        val localeListToSet = LocaleList(Locale(localeToSet))
        val sharedPref = getSharedPreferences("Settings", Context.MODE_PRIVATE).edit()

        LocaleList.setDefault(localeListToSet)
        resources.configuration.setLocales(localeListToSet)
        resources.updateConfiguration(resources.configuration, resources.displayMetrics)

        sharedPref.putString("locale_to_set", localeToSet)
        sharedPref.apply()
    }

    private fun loadLocale() {
        val sharedPref = getSharedPreferences("Settings", Context.MODE_PRIVATE)
        val localeToSet: String = sharedPref.getString("locale_to_set", "")!!

        setLocale(localeToSet)
    }

    private fun changeLocale() {
        val sharedPref = getSharedPreferences("Settings", Context.MODE_PRIVATE)
        val localeToSet: String = sharedPref.getString("locale_to_set", "")!!

        if (localeToSet == "en") {
            setLocale("id")
            sharedPref.edit().putString("locale_to_set", "id").apply()
        } else {
            setLocale("en")
            sharedPref.edit().putString("locale_to_set", "en").apply()
        }
    }
}