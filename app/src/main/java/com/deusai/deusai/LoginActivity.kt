package com.deusai.deusai

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.deusai.deusai.databinding.ActivityLoginBinding


class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Giriş butonuna tıklama
        binding.btnLogin.setOnClickListener {
            val username = binding.etUsername.text.toString().trim()
            val password = binding.etPassword.text.toString().trim()

            // Alanları kontrol etme
            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Lütfen tüm alanları doldurun.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Kullanıcı adı ve şifre kontrolü
            if (username == "test@gmail.com" && password == "1234") {
                // Giriş başarılı olduğunda mesaj göster ve MainActivity'ye yönlendir
                Toast.makeText(this, "Giriş başarılı.", Toast.LENGTH_SHORT).show()

                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()  // Bu Activity'yi kapat
            } else {
                // Kullanıcı adı veya şifre yanlışsa hata mesajı göster
                Toast.makeText(this, "Kullanıcı adı veya şifre yanlış.", Toast.LENGTH_SHORT).show()
            }
        }

        // Kayıt olma butonuna tıklama
        binding.btnRegister.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }

        // Şifremi unuttum butonuna tıklama
        binding.tvForgotPassword.setOnClickListener {
            startActivity(Intent(this, ChangePasswordActivity::class.java))
        }
    }



}
