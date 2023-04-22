package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class Signup : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        supportActionBar?.hide()

        var txt_already_acc = findViewById<TextView>(R.id.txt_already_have_an_account)

        var txt_first_name = findViewById<EditText>(R.id.edttxt_fname)
        var txt_last_name = findViewById<EditText>(R.id.edttxt_lname)
        var address_no = findViewById<EditText>(R.id.edttxt_address)
        var city = findViewById<EditText>(R.id.edttxt_city)
        var street = findViewById<EditText>(R.id.signup_editTxt5)
        var postal_code = findViewById<EditText>(R.id.edttxt_postal_code)
        var number = findViewById<EditText>(R.id.edttxt_phoneno)
        var email = findViewById<EditText>(R.id.edttxt_email)
        var password = findViewById<EditText>(R.id.edttxt_pw)

        txt_already_acc.setOnClickListener()
        {
            var already_acc = Intent(this@Signup, Signin::class.java)
            startActivity(already_acc)
        }

        var btnc= findViewById<Button>(R.id.btn_signup)

        btnc.setOnClickListener()
        {
            var bb = Intent(this@Signup, Signin::class.java)
            startActivity(bb)


            var validatex: Boolean = true

            if (Validatetxt(txt_first_name) == false) {
                if (validatex == true) {
                    validatex = false
                    Toast.makeText(
                        applicationContext, "First Name Cannot Be Empty",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
            if (Validatetxt(txt_last_name) == false) {
                if (validatex == true) {
                    validatex = false
                    Toast.makeText(
                        applicationContext, "Last Name Cannot Be Empty",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
            if (Validatetxt(address_no) == false) {
                if (validatex == true) {
                    validatex = false
                    Toast.makeText(
                        applicationContext, "Address Number Cannot Be Empty",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
            if (Validatetxt(city) == false) {
                if (validatex == true) {
                    validatex = false
                    Toast.makeText(
                        applicationContext, "City Cannot Be Empty",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
            if (Validatetxt(street) == false) {
                if (validatex == true) {
                    validatex = false
                    Toast.makeText(
                        applicationContext, "Street Cannot Be Empty",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
            if (Validatetxt(postal_code) == false) {
                if (validatex == true) {
                    validatex = false
                    Toast.makeText(
                        applicationContext, "Postal Code Cannot Be Empty",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
            if (Validatetxt(number) == false) {
                if (validatex == true) {
                    validatex = false
                    Toast.makeText(
                        applicationContext, "Mobile Number Cannot Be Empty",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
            if (mobileValidate(number) == false) {
                if (validatex == true) {
                    validatex = false
                    Toast.makeText(
                        applicationContext, "Please recheck your mobile number",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

            if (Validatetxt(email) == false) {
                if (validatex == true) {
                    validatex = false
                    Toast.makeText(
                        applicationContext, "Email Cannot Be Empty",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
            if (emailValidate(email) == false) {
                if (validatex == true) {
                    validatex = false
                    Toast.makeText(
                        applicationContext, "Invalid email address",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
            if (Validatetxt(password) == false) {
                if (validatex == true) {
                    validatex = false
                    Toast.makeText(
                        applicationContext, "Password Cannot Be Empty",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
            if (passwordValidate(password) == false) {
                if (validatex == true) {
                    validatex = false
                    Toast.makeText(
                        applicationContext, "Your password should be more than 8 characters",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
            if (validatex == true){
                Toast.makeText(
                    applicationContext, "Success",
                    Toast.LENGTH_LONG
                ).show()

                //Signup details here
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

    fun mobileValidate(numtxt: EditText): Boolean {
        var res: Boolean = true

        var xx = numtxt.text

        val regex = "-?[0-9]+(\\.[0-9]+)?".toRegex()
        if (xx.matches(regex) != true) {
            res = false
        }
        if (xx.length != 10) {
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