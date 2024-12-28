package com.deusai.deusai

import android.content.Context
import android.content.SharedPreferences

class AccountManager(context: Context) {

    private val prefs: SharedPreferences =
        context.applicationContext.getSharedPreferences("account_prefs", Context.MODE_PRIVATE)

    fun saveAccount(account: String) {
        val accounts = getSavedAccounts().toMutableSet()
        if (accounts.add(account)) { // Yeni hesap eklenmişse kaydet
            prefs.edit().putStringSet("accounts", accounts).apply()
        }
        setCurrentAccount(account)
    }

    fun getSavedAccounts(): List<String> {
        return prefs.getStringSet("accounts", emptySet())?.toList() ?: emptyList()
    }

    fun removeCurrentAccount() {
        prefs.edit().remove("current_account").apply()
    }

    fun setCurrentAccount(account: String) {
        prefs.edit().putString("current_account", account).apply()
    }

    fun getCurrentAccount(): String? {
        return prefs.getString("current_account", null)
    }
}
