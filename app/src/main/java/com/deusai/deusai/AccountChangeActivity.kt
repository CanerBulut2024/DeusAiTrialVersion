package com.deusai.deusai

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.deusai.deusai.databinding.ActivityAccountChangeBinding

class AccountChangeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAccountChangeBinding
    private val accountManager = AccountManager(this) // Hesap yönetimi için bir yardımcı sınıf

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAccountChangeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupListeners()
    }

    private fun setupListeners() {
        // Hesap değişikliği
        binding.btnSwitchAccount.setOnClickListener {
            navigateToLoginScreen(false) // Başka hesap eklemek için yönlendirme
        }

        // Mevcut hesaptan çıkış
        binding.btnLogoutAccount.setOnClickListener {
            accountManager.removeCurrentAccount()
            navigateToLoginScreen(true) // Çıkış yapıldı, giriş ekranına yönlendir
        }
    }

    private fun navigateToLoginScreen(isLogout: Boolean) {
        val intent = Intent(this, LoginActivity::class.java)
        intent.putExtra("isLogout", isLogout) // Çıkış yapıldığını belirtmek için bayrak
        startActivity(intent)
        finish() // Bu aktiviteyi kapat
    }
}
