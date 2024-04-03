package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityDetailBinding
import com.example.myapplication.model.Animal

class DetailActivity : AppCompatActivity() {


    private lateinit var binding: ActivityDetailBinding

    companion object {
        const val obj = "animal"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val animal : Animal = intent.getParcelableExtra(obj)!!

        binding.tree.text = animal.taxonomy!!.kingdom + "/" +
                animal.taxonomy.phylum + "/" +
                animal.taxonomy.classs + "/" +
                animal.taxonomy.order + "/" +
                animal.taxonomy.family + "/" +
                animal.taxonomy.genus + "/" +
                animal.taxonomy.scientific_name

        binding.name.text = animal.name

        binding.locations.text = animal.locations.joinToString(separator = " | ")

        binding.lifespan.text = animal.characteristics?.lifespan + " live"

        binding.diet.text = "They eat " + animal.characteristics?.diet







//        val backButton = findViewById<Button>(R.id.backButton)
//
        binding.btn.setOnClickListener {
            onBackPressed()
        }
    }
}