package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast

class ForgotPassword : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)
        supportActionBar?.hide()

        var btn_send_otp= findViewById<Button>(R.id.btn_sendOtp)

        var btn_back = findViewById<ImageButton>(R.id.btn_bback_arrow)

        var forgotpasswordEmail = findViewById<EditText>(R.id.edittext_email_txt)

        btn_back.setOnClickListener()
        {
            onBackPressed()
        }

        btn_send_otp.setOnClickListener()
        {
            var send_otp = Intent(this@ForgotPassword, OtpPage::class.java)
            startActivity(send_otp)

            var validatex: Boolean = true

            if (Validatetxt(forgotpasswordEmail) == false) {
                if (validatex == true) {
                    validatex = false
                    Toast.makeText(
                        applicationContext, "Email Cannot Be Empty",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
            if (emailValidate(forgotpasswordEmail) == false) {
                if (validatex == true) {
                    validatex = false
                    Toast.makeText(
                        applicationContext, "Invalid email address",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }


    }
    fun Validatetxt(textx: EditText): Boolean {

        var res: Boolean = true
        if (textx.text.length == 0) {
            res = false
        }
        return res
    }
    fun emailValidate(emailtxt: EditText): Boolean {
        var res: Boolean = true

        var emailx = emailtxt.text

        if (android.util.Patterns.EMAIL_ADDRESS.matcher(emailx).matches() == false) {
            res = false
        }

        return res
    }
}