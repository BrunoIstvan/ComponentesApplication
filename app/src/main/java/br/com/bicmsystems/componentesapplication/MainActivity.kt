package br.com.bicmsystems.componentesapplication

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnUm.setOnClickListener {

            disparaBasico()

        }

        btnDois.setOnClickListener {

            disparaNotificationChannel()

        }

    }

    fun disparaNotificationChannel() {

        NotificationUtils.showNotification(
                this@MainActivity,
                12345,
                channelId = "CHANNEL_BOTAO_DOIS",
                channelName = "CHANNEL_BOTAO_DOIS_NAME",
                title = "FIAP Android",
                message = "Notificação via Channel")

    }

    fun disparaBasico() {

        val alarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager

        val alarmIntent = Intent(this, AlarmeReceiver::class.java)
        alarmIntent.putExtra("TIME", "PALMEIRAS")

        val pendingIntent = PendingIntent.getBroadcast(this, 0,
                alarmIntent, PendingIntent.FLAG_CANCEL_CURRENT)

        alarmManager.set(AlarmManager.RTC_WAKEUP,
            Calendar.getInstance().timeInMillis + 5000,
                        pendingIntent)

    }



}
