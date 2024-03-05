package com.example.implicitintent

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
//call
    var phoneNum : EditText? = null
    var sendbtn : Button? = null
//email
    var email : EditText? = null
    var subject : EditText? = null
    var message : EditText? = null
    var btnSend_email : Button? = null
//Phone
    var phoneNumSMS : EditText? = null
    var messageSMS :EditText? = null
    var sendSMS :Button? = null
//view URL
    var viewURL :Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //call
        phoneNum = findViewById(R.id.etPhoneNum)
        sendbtn = findViewById(R.id.btnCall)
        sendbtn?.setOnClickListener() {
            var getphoneNum = phoneNum?.text.toString()
            val dialIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$getphoneNum"))
            startActivity(dialIntent)
        }
            //email
            email = findViewById(R.id.etEmail)
            var getemail = email?.text.toString()
            subject = findViewById(R.id.etEmail)
            var getSubject = subject?.text.toString()
            message = findViewById(R.id.etMessagemail)
            var getMessage = message?.text.toString()
            btnSend_email = findViewById(R.id.btnSendEMAIL)
            btnSend_email?.setOnClickListener() {
                val sendEmailIntent = Intent(Intent.ACTION_SEND)
                sendEmailIntent.type = "plain/text"
                sendEmailIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf(getemail))
                sendEmailIntent.putExtra(Intent.EXTRA_SUBJECT, getSubject)
                sendEmailIntent.putExtra(Intent.EXTRA_TEXT, getMessage)
                startActivity(Intent.createChooser(sendEmailIntent, "Send Email"))

            }
        //send sms
        phoneNumSMS = findViewById(R.id.etPhoneNumSMS)
        var getNum = phoneNumSMS?.text.toString()
        messageSMS = findViewById(R.id.etMsgSMS)
        var getMsg = messageSMS?.text.toString()
        sendSMS = findViewById(R.id.btnSendSMS)

        sendSMS?.setOnClickListener(){
            val sendSmsIntent = Intent(Intent.ACTION_SENDTO)
            sendSmsIntent.data = Uri.parse("smsto:$getNum")
            sendSmsIntent.putExtra("sms_body", getMsg)
            startActivity(sendSmsIntent)
        }
        //view URL
        viewURL = findViewById(R.id.btnviewURL)
        viewURL?.setOnClickListener(){
            val viewUrlIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.co.in/"))
            startActivity(viewUrlIntent)
        }
    }
}