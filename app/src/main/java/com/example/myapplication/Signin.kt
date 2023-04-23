package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONObject


class Signin : AppCompatActivity() {


    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)
        supportActionBar?.hide()

        val sharedPref = getSharedPreferences("customer_data_sv", Context.MODE_PRIVATE)
        val isLoggedIn = sharedPref.getBoolean("isLogin", false)

        if (isLoggedIn == true) {
            var bynw = Intent(this@Signin, HomeScreen::class.java)
            startActivity(bynw)
        }

        var txt_forgot_pwd = findViewById<TextView>(R.id.txt_forgot_pw)
        var txt_sign_up = findViewById<TextView>(R.id.txt_dont_have_anaccount)
        var btn_b = findViewById<Button>(R.id.btn_sign_in_btn)

        var txt_email = findViewById<EditText>(R.id.edittext_email_email)
        var txt_password = findViewById<EditText>(R.id.edittxt_password_pw)

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


            var validatex: Boolean = true

            if (Validatetxt(txt_email) == false) {
                if (validatex == true) {
                    validatex = false
                    Toast.makeText(
                        applicationContext, "Email Cannot Be Empty",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
            if (Validatetxt(txt_password) == false) {
                if (validatex == true) {
                    validatex = false
                    Toast.makeText(
                        applicationContext, "Password Cannot Be Empty",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
            if (emailValidate(txt_email) == false) {
                if (validatex == true) {
                    validatex = false
                    Toast.makeText(
                        applicationContext, "Invalid email address",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
//            if (passwordValidate(txt_password) == false) {
//                if (validatex == true) {
//                    validatex = false
//                    Toast.makeText(
//                        applicationContext, "Your password should be more than 8 characters",
//                        Toast.LENGTH_SHORT
//                    ).show()
//                }
//            }
            if (validatex == true) {

                Log.e("X","X")
                //Signin details here

                val jsonObject = JSONObject()
                jsonObject.put("Email", txt_email.text)
                jsonObject.put("CPassword", txt_password.text)


                val queue = Volley.newRequestQueue(this.applicationContext)

                val jsonObjectRequest = JsonObjectRequest(Request.Method.POST,
                    "https://api.icodingx.com/bookhunt/customers/login",
                    jsonObject,
                    { response ->
                        if (response.getString("status") == "True") {
                            val sharedPref = getSharedPreferences("customer_data_sv", MODE_PRIVATE)
                            var editor = sharedPref.edit()
                            editor.putBoolean("isLogin", true)
                            editor.putString(
                                "logged",
                                response.getJSONObject("data").getString("CustomerID")
                            )
                            editor.apply()

                            Toast.makeText(
                                applicationContext, "Success",
                                Toast.LENGTH_LONG
                            ).show()

                            var bynw = Intent(this@Signin, HomeScreen::class.java)
                            startActivity(bynw)
                        } else {
                            //Login Failed
                        }


                    },
                    { error ->
                        Log.e("X","Req failed")
                    })

                queue.add(jsonObjectRequest)
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

    fun passwordValidate(pwdtxt: EditText): Boolean {
        var res: Boolean = true
        var pwdx = pwdtxt.text

        if (pwdx.length < 8) {
            res = false
        }

        return res
    }

}