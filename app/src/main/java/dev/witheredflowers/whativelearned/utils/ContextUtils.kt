package dev.witheredflowers.whativelearned.utils

import android.content.Context
import android.content.ContextWrapper
import android.content.res.Resources
import android.os.Build
import android.os.LocaleList
import java.util.*

class ContextUtils(base: Context?) : ContextWrapper(base) {
	companion object {
		fun updateLocale(context: Context?, localeToSwitchTo: Locale): ContextWrapper {
			val resources: Resources = context!!.getResources()
			val configuration = resources.getConfiguration()
			
			if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
				val localeList = LocaleList(localeToSwitchTo)
				
				LocaleList.setDefault(localeList)
				configuration.setLocales(localeList)
				
			} else {
				configuration.locale = localeToSwitchTo
				resources.updateConfiguration(configuration, resources.displayMetrics)
			}
			
			return ContextUtils(context)
		}
	}
}