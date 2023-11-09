package com.damarazka.lastdicoding

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import org.w3c.dom.Text
import java.util.jar.Attributes.Name

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val dataPerson = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra<Person>("key_hero", Person::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Person>("key_hero")
        }

        val tvDetailName = findViewById<TextView>(R.id.tv_detail_name)
        val tvDetailDescription = findViewById<TextView>(R.id.tv_detail_description)
        val ivDetailPhoto = findViewById<ImageView>(R.id.iv_detail_photo)

        tvDetailName.text = dataPerson?.name
        tvDetailDescription.text = dataPerson?.description
        ivDetailPhoto.setImageResource(dataPerson!!.photo)
    }
}