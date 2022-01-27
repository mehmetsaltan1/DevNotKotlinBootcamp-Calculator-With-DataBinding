package com.example.hesapmakinesi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.hesapmakinesi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var tasarim: ActivityMainBinding
    private lateinit var sayi1: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        tasarim = DataBindingUtil.setContentView(this, R.layout.activity_main)
        tasarim.mainActivityNesnesi = this
        tasarim.hesaplamaSonucu = "0"
        sayi1 = tasarim.hesaplamaSonucu.toString();

    }
    fun artiTiklandi() {
        sayi1 = tasarim.textViewSonuc.text.toString();
        tasarim.hesaplamaSonucu = "0"
    }

    fun topla(alinanSayi: String) {
        var gelenSayi = sayi1.toInt()
        var sayi2 = alinanSayi.toInt()
        var toplam = gelenSayi + sayi2
        tasarim.textViewSonuc.text = toplam.toString()
        sayi1="0"
    }

    fun degerAta(gelenDeger: Int) {
        if (tasarim.hesaplamaSonucu == "0") {
            tasarim.hesaplamaSonucu = "$gelenDeger"
        } else {
            tasarim.hesaplamaSonucu = "${tasarim.hesaplamaSonucu}$gelenDeger"
        }

    }

    fun sifirla() {
        tasarim.hesaplamaSonucu = "0"
        sayi1 = "0"
    }
}