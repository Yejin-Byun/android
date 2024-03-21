package com.example.chap3_homework

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts

class SigninActivity : AppCompatActivity() {
    private val resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if(result.resultCode == RESULT_OK) {
            val data = result.data

            data?.let {
                val idText = findViewById<EditText>(R.id.edit_text_id)
                val pwText = findViewById<EditText>(R.id.edit_text_pw)

                val idData = data.getStringExtra("idData")
                val pwData = data.getStringExtra("pwData")

                idData?.let { idText.setText(it) }
                pwData?.let { pwText.setText(it) }

                Toast.makeText(this, "회원가입이 완료되었습니다. 로그인하세요.", Toast.LENGTH_SHORT).show()
            }
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)

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
            resultLauncher.launch(Intent(this, SignupActivity::class.java))
        }

    }

}