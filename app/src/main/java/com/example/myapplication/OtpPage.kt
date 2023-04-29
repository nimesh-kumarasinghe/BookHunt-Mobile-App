package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast

class OtpPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_otp_page)
        supportActionBar?.hide()

        var intentx = intent
        var customer_id = intentx.getStringExtra("customer_id")
        var code = intentx.getStringExtra("code")

        var btn_verfy = findViewById<Button>(R.id.btn_verify)
        var btn_img = findViewById<ImageButton>(R.id.btn_back_arr)
        var OTP = findViewById<EditText>(R.id.edittxt_enterOTP)


        btn_verfy.setOnClickListener()
        {


            var validatex: Boolean = true

            if (Validatetxt(OTP) == false) {
                if (validatex == true) {
                    validatex = false
                    Toast.makeText(
                        applicationContext, "OTP Empty",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
            if(validatex == true){
                if (code.toString() == OTP.text.toString()) {
                    var otp_verify = Intent(this@OtpPage, ResetPassword::class.java)
                    otp_verify.putExtra("customer_id", customer_id)
                    startActivity(otp_verify)
                } else {
                    Toast.makeText(
                        applicationContext, "Invalid OTP",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

        }

        btn_img.setOnClickListener()
        {
            onBackPressed()
        }
    }

    fun Validatetxt(textx: EditText): Boolean {

        var res: Boolean = true
        if (textx.text.length == 0) {
            res = false
        }
        return res
    }
}