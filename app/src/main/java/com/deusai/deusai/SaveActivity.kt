package com.deusai.deusai

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.deusai.deusai.databinding.ActivitySaveBinding


class SaveActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySaveBinding
    private val savedItems = mutableListOf<String>() // Örnek veri listesi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySaveBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Kaydedilen içerikleri RecyclerView ile göster
        savedItems.addAll(listOf("İçerik 1", "İçerik 2", "İçerik 3")) // Örnek içerikler
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(this@SaveActivity)
            adapter = SavedItemsAdapter(savedItems) { item ->
                Toast.makeText(this@SaveActivity, "$item seçildi.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}