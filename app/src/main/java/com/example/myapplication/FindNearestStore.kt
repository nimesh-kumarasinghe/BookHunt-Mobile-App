package com.example.myapplication

import android.Manifest
import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.core.app.ActivityCompat
import com.google.android.gms.location.LocationServices
import org.json.JSONObject

class FindNearestStore : AppCompatActivity() {


    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_find_nearest_store)
        supportActionBar?.hide()

        var near_btn = findViewById<Button>(R.id.btn_proceed)
        var back = findViewById<ImageButton>(R.id.btnn_back_button)
        var book_name = findViewById<EditText>(R.id.edittxt_enter_your_book_name)



        back.setOnClickListener() {
            onBackPressed()
        }
        near_btn.setOnClickListener()
        {
            /*GET USER LONG AND LAT HERE */

            /*GET USER LONG AND LAT HERE */

//            var intent_btn = Intent(this@FindNearestStore, Shop::class.java)
//            intent_btn.putExtra("sh_keyword", book_name.text.toString())
//            intent_btn.putExtra("user_lat", userlat)
//            intent_btn.putExtra("user_long", userLog)
//            startActivity(intent_btn)
            var validatex: Boolean = true
            if (Validatetxt(book_name) == false) {
                if (validatex == true) {
                    validatex = false
                    Toast.makeText(
                        applicationContext, "Book Name Cannot Be Empty",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
            if(validatex == true){
                getLocation() { res ->
                    val intent_btn = Intent(this@FindNearestStore, Shop::class.java)
                    intent_btn.putExtra("sh_keyword", book_name.text.toString())
                    intent_btn.putExtra("user_lat", res.getString("latitude"))
                    intent_btn.putExtra("user_long", res.getString("longitude"))
                    startActivity(intent_btn)
                }
            }


        }

    }

    private fun getLocation(onSuccess: (JSONObject) -> Unit) {

        val fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
        val REQUEST_LOCATION_PERMISSION = 1

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
            != PackageManager.PERMISSION_GRANTED
        ) {
            // Location permission has not been granted, request for it
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                REQUEST_LOCATION_PERMISSION
            )
        } else {
            // Location permission has been granted, get the user's current location
            fusedLocationClient.lastLocation
                .addOnSuccessListener { location: Location? ->
                    // Use the user's current location
                    val latitude = location?.latitude ?: 0.0
                    val longitude = location?.longitude ?: 0.0
//                    Log.d("Location", "Latitude: $latitude, Longitude: $longitude")
//                    Toast.makeText(
//                        applicationContext, "lat ${latitude} | long ${longitude}",
//                        Toast.LENGTH_SHORT
//                    ).show()

                    var js_object = JSONObject()
                    js_object.put("latitude", latitude)
                    js_object.put("longitude", longitude)

                    onSuccess(js_object)
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
}