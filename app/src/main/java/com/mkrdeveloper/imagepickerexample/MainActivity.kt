package com.mkrdeveloper.imagepickerexample

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var btn: Button
    private lateinit var img: ImageView


    private val resultContract = registerForActivityResult(ActivityResultContracts.GetContent()){ result ->
        img.setImageURI(result)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn = findViewById(R.id.button)
        img = findViewById(R.id.imageView)

        btn.setOnClickListener {

            resultContract.launch("image/*")
        }
    }
}