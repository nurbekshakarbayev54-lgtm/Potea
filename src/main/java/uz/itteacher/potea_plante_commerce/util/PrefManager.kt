package uz.itteacher.potea_plante_commerce.util


import android.R
import android.content.Context

object PrefManager {

    private const val PREF_NAME = "app_prefs"
    private const val KEY_INTRO_SEEN = "intro_seen"
    private const val KEY_PIN_CODE = "pin_code"

    private fun prefs(context: Context) =
        context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)

    // Saqlash
    fun setIntroSeen(context: Context, seen: Boolean) {
        prefs(context).edit()
            .putBoolean(KEY_INTRO_SEEN, seen)
            .apply()
    }

    // O‘qish
    fun isIntroSeen(context: Context): Boolean {
        return prefs(context).getBoolean(KEY_INTRO_SEEN, false)
    }

    // Saqlash
    fun setPinCode(context: Context, pincode: String) {
        prefs(context).edit()
            .putString(KEY_PIN_CODE, pincode)
            .apply()
    }

    // O‘qish
    fun isPinCode(context: Context): String {
        return prefs(context).getString(KEY_PIN_CODE, "").toString()
    }

}
