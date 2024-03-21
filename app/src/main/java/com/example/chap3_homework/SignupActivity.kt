package com.example.chap3_homework

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
class SignupActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        val btnSignUp = findViewById<Button>(R.id.btn_goSignup)
        btnSignUp.setOnClickListener {
            val nameText = findViewById<EditText>(R.id.edit_text_name)
            val idEditText = findViewById<EditText>(R.id.edit_text_sID)
            val pwEditText = findViewById<EditText>(R.id.edit_text_sPW)

            val idData = idEditText.text.toString()
            val pwData = pwEditText.text.toString()

            if (nameText.text.isEmpty() || idEditText.text.isEmpty() || pwEditText.text.isEmpty()) {
                Toast.makeText(this, "입력되지 않은 정보가 있습니다.", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent().apply {
                    putExtra("idData", idData)
                    putExtra("pwData", pwData)
                }
                setResult(RESULT_OK, intent)
                finish()
            }
        }
    }

}