package ru.appngo.smsreceiver

import android.content.IntentFilter
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.auth.api.phone.SmsRetriever

class MainActivity : AppCompatActivity() {

    private val smsBroadcastReceiver by lazy {
        SmsBroadcastReceiver()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        println("mySignature ${AppSignatureHelper(this).appSignatures}")
        if (SmsRetrieverRegister().isGooglePlayServicesAvailable(this)) {
            SmsRetrieverRegister().startListenForSms(this)
        }
        registerReceiver(smsBroadcastReceiver, IntentFilter(SmsRetriever.SMS_RETRIEVED_ACTION))
    }

    override fun onDestroy() {
        unregisterReceiver(smsBroadcastReceiver)
        super.onDestroy()
    }
}
