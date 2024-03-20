package com.example.chap3_homework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView

class HomeActivity : AppCompatActivity() {
    private val images = intArrayOf(
        R.drawable.img1,
        R.drawable.img2,
        R.drawable.img3,
        R.drawable.img4,
        R.drawable.img5
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val imageView = findViewById<ImageView>(R.id.imageView2)
        val imageId = (Math.random() * images.size).toInt()
        imageView.setBackgroundResource(images[imageId])

        val idData = intent.getStringExtra("dataFromSigninActivity")
        val idShow = findViewById<TextView>(R.id.tv_idshow)
        idShow.setText(idData)

        val btn_exit = findViewById<Button>(R.id.btn_exit)
        btn_exit.setOnClickListener {
            finish()
        }

    }
}