package com.deusai.deusai

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.deusai.deusai.databinding.ActivityAboutUsBinding

class AboutUsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAboutUsBinding
    private lateinit var tipsAdapter: TipsAdapter
    private val tipsList: MutableList<String> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAboutUsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initializeRecyclerView()
        loadDynamicTips()
    }

    private fun initializeRecyclerView() {
        // RecyclerView setup
        tipsAdapter = TipsAdapter(tipsList)
        binding.rvTips.layoutManager = LinearLayoutManager(this)
        binding.rvTips.adapter = tipsAdapter
    }

    private fun loadDynamicTips() {
        // Dinamik ipuçları örnekleri
        val sampleTips = listOf(
            "Fotoğraf eklemek için kamerayı veya galeriyi seçin.",
            "Metin eklemek için metin kutusuna yazı yazın.",
            "Filtre eklemek için filtreler kısmına tıklayın.",
            "Uygulama içi satın alımlar için premium üyelik satın alabilirsiniz.",
            "Sık sorulan sorulara ulaşmak için İpuçları sayfasını ziyaret edin."
        )
        tipsList.addAll(sampleTips)
        tipsAdapter.notifyDataSetChanged() // Liste güncelleniyor
    }
}
