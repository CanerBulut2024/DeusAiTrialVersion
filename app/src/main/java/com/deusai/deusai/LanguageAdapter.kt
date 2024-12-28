package com.deusai.deusai

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.deusai.deusai.databinding.ItemLanguageBinding


class LanguageAdapter(
    private val languages: List<String>,
    private val onLanguageSelected: (String) -> Unit
) : RecyclerView.Adapter<LanguageAdapter.LanguageViewHolder>() {

    private var selectedPosition: Int = -1 // Seçilen öğeyi takip etmek için değişken

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LanguageViewHolder {
        val binding = ItemLanguageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return LanguageViewHolder(binding)
    }

    override fun onBindViewHolder(holder: LanguageViewHolder, position: Int) {
        val language = languages[position]
        holder.bind(language, position == selectedPosition)

        holder.itemView.setOnClickListener {
            // Önce eski seçimi sıfırla
            val oldPosition = selectedPosition
            selectedPosition = position
            notifyItemChanged(oldPosition) // Eski öğeyi güncelle
            notifyItemChanged(position)   // Yeni seçimi güncelle
            onLanguageSelected(language)
        }
    }

    override fun getItemCount(): Int = languages.size

    class LanguageViewHolder(private val binding: ItemLanguageBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(language: String, isSelected: Boolean) {
            binding.languageName.text = language
            if (isSelected) {
                // Seçili öğe vurgulama
                binding.root.setBackgroundColor(Color.parseColor("#E0F7FA")) // Hafif bir renk
            } else {
                // Varsayılan arka plan
                binding.root.setBackgroundColor(Color.TRANSPARENT)
            }
        }
    }
}
