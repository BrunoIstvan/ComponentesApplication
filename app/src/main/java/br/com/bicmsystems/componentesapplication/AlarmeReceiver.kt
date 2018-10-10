package br.com.bicmsystems.componentesapplication

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent


class AlarmeReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {

        val service = Intent(context, NotificationService::class.java)
        service.putExtra("NOME", "BRUNO ISTVAN CAMPOS MONTEIRO")
        service.putExtra("TIME", intent?.getStringExtra("TIME"))
        context?.startService(service)

    }

}