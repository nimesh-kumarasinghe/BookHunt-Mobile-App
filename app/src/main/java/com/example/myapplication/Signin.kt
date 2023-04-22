package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley



class Signin : AppCompatActivity() {


    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)
        supportActionBar?.hide()

        var txt_forgot_pwd = findViewById<TextView>(R.id.txt_forgot_pw)
        var txt_sign_up = findViewById<TextView>(R.id.txt_dont_have_anaccount)
        var btn_b= findViewById<Button>(R.id.btn_sign_in_btn)

//        var txt_email = findViewById<EditText>(R.id.edittext_email_email)
//        var txt_password = findViewById<EditText>(R.id.edittxt_password_pw)

        txt_forgot_pwd.setOnClickListener()
        {
            var forgot_password = Intent(this@Signin, ForgotPassword::class.java)
            startActivity(forgot_password)
        }

//        val queue = Volley.newRequestQueue(this.applicationContext)
//        val url = "https://webhook.site/6c2eaf1c-7491-4d54-a743-8a2039c1c12e"
        txt_sign_up.setOnClickListener()
        {

            var sign_up_intent = Intent(this@Signin, Signup::class.java)
            startActivity(sign_up_intent)
        }




        btn_b.setOnClickListener()
        {
//            val stringRequest = StringRequest(Request.Method.DELETE, url,
//                { response ->
//                    // Handle the response data here
//                },
//                { error ->
//                    // Handle errors here
//                })
//
//            queue.add(stringRequest)
            var bynw = Intent(this@Signin, HomeScreen::class.java)
            startActivity(bynw)
        }








    }
}