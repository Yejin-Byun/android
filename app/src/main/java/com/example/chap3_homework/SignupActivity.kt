package com.example.chap3_homework

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts

class SignupActivity : AppCompatActivity() {
    private lateinit var launcher : ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
                result ->
            if(result.resultCode == Activity.RESULT_OK) {
                val data = result.data
                val userData = data?.getSerializableExtra("userData") as? UserData

                userData?.let {
                    val idText = findViewById<EditText>(R.id.edit_text_id)
                    idText.setText(userData.id)

                    val pwText = findViewById<EditText>(R.id.edit_text_pw)
                    pwText.setText(userData.pw)

                    val intent = Intent(this, SigninActivity::class.java)
                    intent.putExtra("userData", userData)
                    startActivity(intent)
                }

            }
        }

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
                val userData = UserData(idData, pwData)

                val intent = Intent(this, SigninActivity::class.java)
                intent.putExtra("userData", userData)
                launcher.launch(intent)

                Toast.makeText(this, "회원가입 성공", Toast.LENGTH_SHORT).show()
            }
        }
    }

}