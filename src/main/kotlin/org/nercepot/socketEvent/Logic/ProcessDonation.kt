package org.nercepot.socketEvent.Logic

import org.json.JSONException
import org.json.JSONObject

object ProcessDonation {
    @JvmStatic
    @Throws(JSONException::class)
    fun processDonation(vararg arg0: Any?) {
        val json = JSONObject(arg0[0] as String?)

        val donationAmount = json.getInt("amount")
        val donationUsername = json.getString("username")
        val donationBullding = json.getString("billing_system")

//         Здесь может быть логика обработки доната
        println("--------------------------------------------")
        println(json)
        println("--------------------------------------------")

        //Привер вывода
        println("--------------------------------------------")
        println("Donation received from: $donationUsername")
        println("Amount: $donationAmount")
        println("Bullding: $donationBullding")
        println("--------------------------------------------")

        if (donationBullding == "TWITCH")
            println("TWITCH")
        else if(donationBullding == "moneymailru")
            println("moneymailru")
    }


//    fun print(vararg arg0: Any?) {
//
//
//
//    }
}
