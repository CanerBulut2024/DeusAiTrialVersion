package com.deusai.deusai

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.deusai.deusai.databinding.ActivityUserBinding

class UserActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupListeners()
    }

    private fun setupListeners() {
        // Şifre Değiştirme
        binding.btnChangePassword.setOnClickListener {
            navigateToActivity(ChangePasswordActivity::class.java)
        }

        // Premium Plan Özellikleri
        binding.btnPremium.setOnClickListener {
            navigateToActivity(PremiumActivity::class.java)
        }

        // Hakkımızda Bilgisi
        binding.btnAboutUs.setOnClickListener {
            navigateToActivity(AboutUsActivity::class.java)
        }

        // Dil Değiştirme
        binding.btnChangeLanguage.setOnClickListener {
            navigateToActivity(LanguageActivity::class.java)
        }

        // Çıkış Yap
        binding.btnLogout.setOnClickListener {
            showLogoutConfirmationDialog()
        }

        // Hesap Değiştir
        binding.btnAccountChange.setOnClickListener {
            navigateToActivity(AccountChangeActivity::class.java)
        }

        // Kupon Gir
        binding.btnEnterCoupon.setOnClickListener {
            navigateToActivity(CouponActivity::class.java)
        }
    }

    private fun navigateToActivity(activityClass: Class<*>) {
        val intent = Intent(this, activityClass)
        startActivity(intent)
    }

    private fun showLogoutConfirmationDialog() {
        AlertDialog.Builder(this)
            .setMessage("Çıkış yapmak istiyor musunuz?")
            .setCancelable(false)
            .setPositiveButton("Evet") { _, _ -> finishAffinity() }
            .setNegativeButton("Hayır") { dialog, _ -> dialog.dismiss() }
            .create()
            .show()
    }
}
