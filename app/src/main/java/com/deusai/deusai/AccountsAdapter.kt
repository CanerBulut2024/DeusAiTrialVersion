package com.deusai.deusai

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.deusai.deusai.databinding.ItemAccountBinding


class AccountsAdapter(
    private val accounts: List<String>,
    private val onAccountClick: (String) -> Unit
) : RecyclerView.Adapter<AccountsAdapter.AccountViewHolder>() {

    inner class AccountViewHolder(private val binding: ItemAccountBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(account: String) {
            binding.tvAccountName.text = account
            binding.root.setOnClickListener {
                onAccountClick(account) // Hesap seçildiğinde geri çağırma
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AccountViewHolder {
        val binding =
            ItemAccountBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AccountViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AccountViewHolder, position: Int) {
        holder.bind(accounts[position])
    }

    override fun getItemCount(): Int = accounts.size
}
