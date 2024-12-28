package com.deusai.deusai

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.deusai.deusai.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var doubleBackToExitPressedOnce = false // Çıkış için çift geri basma kontrolü

    // Fotoğraf seçimi için izin kontrolü
    private val photoPickerLauncher =
        registerForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
            uri?.let {
                Toast.makeText(this, "Fotoğraf seçildi: $uri", Toast.LENGTH_SHORT).show()
            } ?: Toast.makeText(this, "Fotoğraf seçimi iptal edildi.", Toast.LENGTH_SHORT).show()
        }

    private val cameraLauncher =
        registerForActivityResult(ActivityResultContracts.TakePicturePreview()) { bitmap ->
            bitmap?.let {
                Toast.makeText(this, "Kamera ile fotoğraf çekildi.", Toast.LENGTH_SHORT).show()
            } ?: Toast.makeText(this, "Fotoğraf çekimi iptal edildi.", Toast.LENGTH_SHORT).show()
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupClickListeners()

        // "Oluştur" butonuna tıklama işlemi
        binding.btnGenerate.setOnClickListener {
            val userInput = binding.etTextInput.text.toString()
            if (userInput.isEmpty()) {
                Toast.makeText(this, "Lütfen bir metin girin!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Girilen Metin: $userInput", Toast.LENGTH_SHORT).show()

                val intent = Intent(this,EditActivity::class.java)
                startActivity(intent)

                // Burada girilen metinle işlem yapabilirsiniz
            }
        }

    }



    private fun setupClickListeners() {
        // Fotoğraf seçimi butonu
        binding.btnPhotoPicker.setOnClickListener {
            if (hasCameraPermission()) {
                showPhotoOptions()
            } else {
                requestCameraPermission()
            }
        }

        // Premium butonu
        binding.btnPremium.setOnClickListener {
            navigateToActivity(PremiumActivity::class.java)
        }

        // Alt menü butonları
        binding.btnUser.setOnClickListener {
            navigateToActivity(UserActivity::class.java, "Kullanıcı sayfasına gidiliyor")
        }

        binding.btnHome.setOnClickListener {
            Toast.makeText(this, "Ana sayfadasınız", Toast.LENGTH_SHORT).show()
        }

        binding.btnTips.setOnClickListener {
            navigateToActivity(AboutUsActivity::class.java, "İpuçları sayfasına gidiliyor")
        }

        // Oluştur butonu
        binding.btnGenerate.setOnClickListener {
            navigateToActivity(EditActivity::class.java, "Düzenleme ekranına geçiliyor")
        }
    }

    private fun hasCameraPermission(): Boolean {
        return ContextCompat.checkSelfPermission(
            this,
            Manifest.permission.CAMERA
        ) == PackageManager.PERMISSION_GRANTED
    }

    private fun requestCameraPermission() {
        ActivityCompat.requestPermissions(
            this,
            arrayOf(Manifest.permission.CAMERA),
            REQUEST_CAMERA_PERMISSION
        )
    }

    private fun showPhotoOptions() {
        photoPickerLauncher.launch("image/*")
    }
    // Filtre butonları oluşturma
    private fun setupFilterButtons() {
        val filters = listOf(
            "Normal" to false,
            "Premium 1" to true,
            "Premium 2" to true,
            "Vintage" to false
        )

        filters.forEach { (filterName, isPremium) ->
            val button = Button(this).apply {
                text = if (isPremium) "$filterName 🔒" else filterName
                isEnabled = !isPremium // Premium olmayanlar aktif
                setOnClickListener {
                    Toast.makeText(this@MainActivity, "$filterName Filtre Seçildi", Toast.LENGTH_SHORT).show()
                }
            }
            binding.filterContainer.addView(button)
        }
    }
    // Geri tuşuna basıldığında yapılacaklar
    override fun onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed() // Uygulamadan çık
            return
        }

        this.doubleBackToExitPressedOnce = true
        Toast.makeText(this, "Çıkmak için tekrar geri tuşuna basın", Toast.LENGTH_SHORT).show()

        // Kullanıcı ikinci kez basmazsa durumu sıfırla
        Handler(Looper.getMainLooper()).postDelayed({ doubleBackToExitPressedOnce = false }, 2000)
    }

    private fun <T> navigateToActivity(activity: Class<T>, message: String? = null) {
        message?.let {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        }
        val intent = Intent(this, activity)
        startActivity(intent)
    }

    companion object {
        const val REQUEST_CAMERA_PERMISSION = 1001
    }
}


