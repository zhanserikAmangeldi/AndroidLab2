package com.example.myapplication

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import com.example.myapplication.DetailActivity.Companion.obj
import com.example.myapplication.adapter.AnimalAdapter
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.model.Animal
import com.example.myapplication.service.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var adapter: AnimalAdapter ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)




        adapter = AnimalAdapter(onAnimalClick = {onClickAnimal(it)})
        binding.recyclerView.adapter = adapter


        binding.sv.apply{
            isSubmitButtonEnabled=true
        }


        binding.sv.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextChange(newText: String?): Boolean {
                if(newText.isNullOrEmpty()){
                    adapter?.submitList(listOf())
                }
                return false
            }

            override fun onQueryTextSubmit(query: String?): Boolean {
                Log.i(TAG,"textSubmit2 "+query);

                if(!query.isNullOrEmpty()) {
                    find(query)
                }
                return false
            }

        })


    }

    fun find(query: String){

        val client = ApiClient.instance
        val response = client.fetchAnimalsList(query)
        response.enqueue(object : Callback<List<Animal>> {
            override fun onResponse(call: Call<List<Animal>>, response: Response<List<Animal>>) {
                println("HttpResponse: ${response.body()}")

                val list = response.body()

                if (list != null) {
                    adapter?.submitList(list)
                }
            }

            override fun onFailure(call: Call<List<Animal>>, t: Throwable) {
                println("HttpResponse: ${t.message}")
            }
        })
    }


    private fun onClickAnimal(animal: Animal){
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra(obj, animal)
        startActivity(intent)
    }
}