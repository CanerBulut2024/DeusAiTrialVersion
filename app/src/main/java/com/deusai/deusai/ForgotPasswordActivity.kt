package com.deusai.deusai

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.deusai.deusai.databinding.ActivityForgotPasswordBinding

class ForgotPasswordActivity : AppCompatActivity() {

    private lateinit var binding: ActivityForgotPasswordBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityForgotPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSubmit.setOnClickListener {
            val emailOrUsername = binding.etEmailOrUsername.text.toString()

            if (emailOrUsername.isEmpty()) {
                Toast.makeText(this, "E-posta veya kullanıcı adı boş bırakılamaz", Toast.LENGTH_SHORT).show()
            } else {
                // Burada e-posta doğrulama ve şifre sıfırlama kodu gönderme işlemini yapabilirsiniz
                Toast.makeText(this, "E-posta adresine şifre sıfırlama kodu gönderildi", Toast.LENGTH_SHORT).show()
                finish()
            }
        }
    }
}
