package com.example.chap3_homework

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class SigninActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)

        val userData = intent.getSerializableExtra("userData") as? UserData
        userData?.let {
            val idText = findViewById<EditText>(R.id.edit_text_id)
            idText.setText(userData.id)

            val pwText = findViewById<EditText>(R.id.edit_text_pw)
            pwText.setText(userData.pw)
        }

        val btnLogin = findViewById<Button>(R.id.btn_login)
        btnLogin.setOnClickListener {
            val idText = findViewById<EditText>(R.id.edit_text_id)
            val idData = idText.text.toString()
            val pwText = findViewById<EditText>(R.id.edit_text_pw)

            if(idText.text.isEmpty() || pwText.text.isEmpty()) {
                Toast.makeText(this, "아이디/비밀번호를 확인해 주세요", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this, HomeActivity::class.java)
                intent.putExtra("dataFromSigninActivity", idData)
                startActivity(intent)

                Toast.makeText(this,"로그인 성공",Toast.LENGTH_SHORT).show()
            }
        }

        val btnSignup = findViewById<Button>(R.id.btn_signup)
        btnSignup.setOnClickListener {
            val intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)
        }

    }

}