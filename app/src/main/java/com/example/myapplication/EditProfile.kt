package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast

class EditProfile : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)

        supportActionBar?.hide()

        var back = findViewById<ImageButton>(R.id.btn_back_back)
        var editPhoto = findViewById<Button>(R.id.btn_edit_photo)
        var save = findViewById<Button>(R.id.button_save)

        var txt_first_name = findViewById<EditText>(R.id.editText_fname)
        var txt_last_name = findViewById<EditText>(R.id.editTxt_lname)
        var address_no = findViewById<EditText>(R.id.edittxt_address)
        var city = findViewById<EditText>(R.id.edittxt_city)
        var street = findViewById<EditText>(R.id.edittext_street)
        var postal_code = findViewById<EditText>(R.id.edittxt_postalcode)
        var number = findViewById<EditText>(R.id.editText_phone)


        back.setOnClickListener(){
            onBackPressed()
        }

        editPhoto.setOnClickListener(){

        }

        save.setOnClickListener(){
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

}
