package com.yusril.codelabbroadcast

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.yusril.codelabbroadcast.databinding.ActivitySmsReceiverBinding

class SmsReceiverActivity : AppCompatActivity() {
    private var binding: ActivitySmsReceiverBinding? = null

    companion object {
        const val EXTRA_SMS_NO = "extra_sms_no"
        const val EXTRA_SMS_MESSAGE = "extra_sms_message"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sms_receiver)
        binding = ActivitySmsReceiverBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        binding?.btnClose?.setOnClickListener { finish() }

        val senderNo=intent.getStringExtra(EXTRA_SMS_NO)
        val senderMessage=intent.getStringExtra(EXTRA_SMS_MESSAGE)

        binding?.tvFrom?.text=getString(R.string.from,senderNo)
        binding?.tvMessage?.text=senderMessage
    }

    override fun onDestroy() {
        super.onDestroy()
        binding=null
    }
}