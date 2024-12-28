package com.deusai.deusai

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.deusai.deusai.databinding.ActivityLanguageBinding

import java.util.Locale


class LanguageActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLanguageBinding
    private lateinit var adapter: LanguageAdapter
    private var selectedLanguage: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLanguageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Dil listesini ayarla
        val languages = listOf("English", "Türkçe", "Español", "Français", "Deutsch")
        adapter = LanguageAdapter(languages) { language ->
            selectedLanguage = language
            binding.btnNext.isEnabled = true
        }

        binding.languageList.layoutManager = LinearLayoutManager(this)
        binding.languageList.adapter = adapter

        // İleri butonuna tıklandığında
        binding.btnNext.setOnClickListener {
            selectedLanguage?.let { lang ->
                saveLanguagePreference(lang)
                setAppLanguage(lang)
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }
        }
    }

    private fun saveLanguagePreference(language: String) {
        val sharedPreferences = getSharedPreferences("app_preferences", MODE_PRIVATE)
        sharedPreferences.edit().putString("selected_language", language).apply()
    }

    private fun setAppLanguage(language: String) {
        val locale = when (language) {
            "Türkçe" -> "tr"
            "Español" -> "es"
            "Français" -> "fr"
            "Deutsch" -> "de"
            else -> "en"
        }
        val config = resources.configuration
        val localeObj = Locale(locale)
        Locale.setDefault(localeObj)
        config.setLocale(localeObj)
        resources.updateConfiguration(config, resources.displayMetrics)
    }
}