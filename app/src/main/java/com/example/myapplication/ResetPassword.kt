package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast

class ResetPassword : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reset_password)
        supportActionBar?.hide()

        var btn_reset_pwd= findViewById<Button>(R.id.btn_reset)
        var btn_img= findViewById<ImageButton>(R.id.back_button_button)

        var confirmPassword = findViewById<EditText>(R.id.edittxt_confirm_pw)
        var newPassword = findViewById<EditText>(R.id.edittxt_new_pw)


        btn_reset_pwd.setOnClickListener()
        {
            var reset_pwd = Intent(this@ResetPassword, Success::class.java)
            startActivity(reset_pwd)

            var validatex: Boolean = true
            if (Validatetxt(newPassword) == false) {
                if (validatex == true) {
                    validatex = false
                    Toast.makeText(
                        applicationContext, "Password Cannot Be Empty",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
            if (Validatetxt(confirmPassword) == false) {
                if (validatex == true) {
                    validatex = false
                    Toast.makeText(
                        applicationContext, "Password Cannot Be Empty",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
            if (passwordValidate(newPassword) == false) {
                if (validatex == true) {
                    validatex = false
                    Toast.makeText(
                        applicationContext, "Your password should be more than 8 characters",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
            if (passwordValidate(confirmPassword) == false) {
                if (validatex == true) {
                    validatex = false
                    Toast.makeText(
                        applicationContext, "Your password should be more than 8 characters",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
            if(validatex == true){
                //reset function
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

    fun passwordValidate(pwdtxt: EditText): Boolean {
        var res: Boolean = true
        var pwdx = pwdtxt.text

        if (pwdx.length < 8) {
            res = false
        }

        return res
    }
}