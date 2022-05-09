package com.samderra.archive.data.remote

import android.util.Log
import com.google.gson.GsonBuilder
import com.google.gson.JsonParser
import okhttp3.logging.HttpLoggingInterceptor

class LoggerInterceptor : HttpLoggingInterceptor.Logger {
    companion object {
        const val LOG_DIVIDER = "================================================================"
    }

    private val gson = GsonBuilder().setPrettyPrinting().create()

    override fun log(message: String) {
        val trimMessage = message.trim { it <= ' ' }
        if (trimMessage.startsWith("{") && trimMessage.endsWith("}")
            || trimMessage.startsWith("[") && trimMessage.endsWith("]")
        ) {
            try {
                val prettyPrintJson = gson.toJson(JsonParser.parseString(message))
                Log.w("Network Response", LOG_DIVIDER + "\n" + prettyPrintJson + "\n" + LOG_DIVIDER)
            } catch (e: Exception) {
                Log.w("Network Response", message, null)
            }
        } else {
            Log.w("Network Response", message, null)
        }
    }
}
