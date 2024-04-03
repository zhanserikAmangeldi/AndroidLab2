package com.example.myapplication.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.AnimalItemBinding
import com.example.myapplication.model.Animal
import com.example.myapplication.model.AnimalItemCallback

class AnimalAdapter(private val onAnimalClick: (Animal) -> Unit) : ListAdapter<Animal, AnimalAdapter.ViewHolder>(AnimalItemCallback()) {

    companion object{
        private const val ANIMAL_ADAPTER_TAG = "AnimalAdapter"
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(AnimalItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }



    inner class ViewHolder(private val binding: AnimalItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(animal: Animal){
            with(binding){
                name.text = animal.name
                scName.text = animal.taxonomy?.scientific_name
                slogan.text = animal.characteristics?.slogan

                checkToEmpty(scName)
                checkToEmpty(slogan)

                root.setOnClickListener{
                    onAnimalClick(animal)
                }
            }
        }

        fun checkToEmpty(tv:TextView){
            if(tv.text.isNullOrEmpty())
            {
                tv.visibility = View.GONE;
            } else {
                tv.visibility = View.VISIBLE;
            }

        }
    }



}