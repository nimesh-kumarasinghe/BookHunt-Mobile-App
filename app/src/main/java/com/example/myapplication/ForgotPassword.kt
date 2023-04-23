package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley

class ForgotPassword : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)
        supportActionBar?.hide()

        var btn_send_otp = findViewById<Button>(R.id.btn_sendOtp)

        var btn_back = findViewById<ImageButton>(R.id.btn_bback_arrow)

        var forgotpasswordEmail = findViewById<EditText>(R.id.edittext_email_txt)

        btn_back.setOnClickListener()
        {
            onBackPressed()
        }

        btn_send_otp.setOnClickListener()
        {


//            var validatex: Boolean = true
//
//            if (Validatetxt(forgotpasswordEmail) == false) {
//                if (validatex == true) {
//                    validatex = false
//                    Toast.makeText(
//                        applicationContext, "Email Cannot Be Empty",
//                        Toast.LENGTH_SHORT
//                    ).show()
//                }
//            }
//            if (emailValidate(forgotpasswordEmail) == false) {
//                if (validatex == true) {
//                    validatex = false
//                    Toast.makeText(
//                        applicationContext, "Invalid email address",
//                        Toast.LENGTH_SHORT
//                    ).show()
//                }
//            }
            val queue = Volley.newRequestQueue(this.applicationContext)


            val jsonObjectRequest = JsonObjectRequest(
                Request.Method.GET,
                "https://api.icodingx.com/bookhunt/customers/forgot-password?Email=${forgotpasswordEmail.text}",
                null,
                { response ->
                    //success
                    if (response.getString("Status") == "True") {

                        var send_otp = Intent(this@ForgotPassword, OtpPage::class.java)
                        send_otp.putExtra("customer_id", response.getString("SellerID"))
                        send_otp.putExtra("code", response.getString("code"))
                        startActivity(send_otp)

                    } else {
                        //email not found
                    }
                },
                { error ->
                    // Handle errors here
                })

            queue.add(jsonObjectRequest)


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