package ru.appngo.smsreceiver

import android.content.Context
import android.util.Log
import com.google.android.gms.auth.api.phone.SmsRetriever
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.GoogleApiAvailability




class SmsRetrieverRegister {
    fun startListenForSms(context: Context) {
        val client = SmsRetriever.getClient(context)
        val task = client.startSmsRetriever()
        task.addOnSuccessListener { Log.d("smsReceiveTag", "success subscribtion") }
        task.addOnFailureListener { Log.e("smsReceiveTag", "fail subscribe on sms", IllegalStateException()) }
    }

    fun isGooglePlayServicesAvailable(context: Context): Boolean {
        val googleApiAvailability = GoogleApiAvailability.getInstance()
        val resultCode = googleApiAvailability.isGooglePlayServicesAvailable(context)
        return resultCode == ConnectionResult.SUCCESS
    }

}
