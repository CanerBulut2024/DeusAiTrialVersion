package com.deusai.deusai

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.deusai.deusai.databinding.ActivityCouponBinding


class CouponActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCouponBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCouponBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnUseCoupon.setOnClickListener {
            val couponCode = binding.etCouponCode.text.toString()
            if (couponCode.isNotEmpty()) {
                // Kupon kodu doğrulama işlemi yapılacak
                Toast.makeText(this, "Kupon kullanıldı: $couponCode", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Lütfen geçerli bir kupon kodu girin", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
