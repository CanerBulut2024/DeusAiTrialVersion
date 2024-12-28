package com.deusai.deusai

import android.os.Bundle
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.deusai.deusai.databinding.ActivityEditBinding


class EditActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEditBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupButtonListeners()
        disableScreenCapture()
    }

    private fun setupButtonListeners() {
        binding.btnCrop.setOnClickListener { showToast("Kırpma işlemi başlatıldı") }
        binding.btnRotate.setOnClickListener { showToast("Döndürme işlemi başlatıldı") }
        binding.btnFilter.setOnClickListener { showToast("Filtre uygulandı") }
        binding.btnSave.setOnClickListener { savePhoto() }
        binding.btnDownload.setOnClickListener { downloadPhoto() }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun savePhoto() {
        // Fotoğrafı kaydetme işlemi
        Toast.makeText(this, "Fotoğraf başarıyla kaydedildi", Toast.LENGTH_SHORT).show()
    }

    private fun downloadPhoto() {
        // Fotoğrafı indirme işlemi
        Toast.makeText(this, "Fotoğraf başarıyla indirildi", Toast.LENGTH_SHORT).show()
    }

    private fun disableScreenCapture() {
        window.setFlags(
            WindowManager.LayoutParams.FLAG_SECURE,
            WindowManager.LayoutParams.FLAG_SECURE
        )
        Toast.makeText(this, "Ekran görüntüsü alma özelliği devre dışı bırakıldı", Toast.LENGTH_SHORT).show()
    }
}
