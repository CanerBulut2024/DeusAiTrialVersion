package com.deusai.deusai

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.deusai.deusai.databinding.ActivityChangePasswordBinding

class ChangePasswordActivity : AppCompatActivity() {

    private lateinit var binding: ActivityChangePasswordBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChangePasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnChangePassword.setOnClickListener {
            val oldPassword = binding.etOldPassword.text.toString()
            val newPassword = binding.etNewPassword.text.toString()
            val confirmPassword = binding.etConfirmPassword.text.toString()

            if (newPassword == confirmPassword) {
                // Şifreyi değiştirme işlemi burada yapılacak
                Toast.makeText(this, "Şifreniz başarıyla değiştirildi", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Yeni şifreler uyuşmuyor", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
