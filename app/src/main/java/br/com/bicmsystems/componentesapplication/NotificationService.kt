package br.com.bicmsystems.componentesapplication

import android.app.IntentService
import android.content.Intent
import android.util.Log

class NotificationService : IntentService("") {

    override fun onHandleIntent(intent: Intent?) {

        Log.i("NotificationSevice Nome", intent?.getStringExtra("NOME"))
        Log.i("NotificationSevice Time", intent?.getStringExtra("TIME"))

    }

}