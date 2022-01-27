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
        sayi1 = (tasarim.textViewSonuc.text.toString().toInt() + sayi1.toInt()).toString();
        /* Üstte yapılan işlemde kullanıcı 2 den fazla sayı girdiğinde uygulamada hata oluşuyordu
        yapılan işlemle bu sorun çözüldü kullanıcı artı butonuna her tıkladığında bellekte kalan değer ile
        son girilen değer birbirleriyle toplanıp istenilen sonuç bulunuyor
         */
        tasarim.hesaplamaSonucu = "0"
    }

    fun topla(alinanSayi: String) {
        var gelenSayi = sayi1.toInt() // Defaul oluşturduğum sayıdan elde ettiğim veriyi aktardım
        var sayi2 = alinanSayi.toInt() // Databinding'den aldığım değeri aktardım
        var toplam = gelenSayi + sayi2
        tasarim.textViewSonuc.text = toplam.toString()
        sayi1="0" /* Kullanıcı hesapla tuşunda tıkladıktan sonra değer ekrana basılıyordu fakat 2.kez
        bastığında kullanıcı ek bir değer girmemesine rağmen bellekte kalan sayıyla sonuç toplanıp ekrana
        yanlış bilgi bastırılıyordu sayi1 değerini burada sıfırlayınca bu sorun ortadan kalktı
        */
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