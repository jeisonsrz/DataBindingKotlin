package com.example.creatic_04b1.databinding

import android.databinding.DataBindingUtil
import android.databinding.ObservableBoolean
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.creatic_04b1.databinding.databinding.ActivityMainBinding
import com.example.creatic_04b1.databinding.models.Book
import java.util.*
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {

    lateinit var  binding:ActivityMainBinding
    val loading:ObservableBoolean = ObservableBoolean(true)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.loading = loading
        loadBook()
    }

    fun loadBook()
    {
        thread {
            Thread.sleep(3000)
            runOnUiThread {
                binding.book = buildBook()
                loading.set(false)
            }
        }
    }

    fun buildBook():Book = Book().apply {

        name = "Android para Dummies"
        img = "https://images-na.ssl-images-amazon.com/images/I/51ATYjwrA-L._SX394_BO1,204,203,200_.jpg"
        date = Date()
        catergory = 2
    }
}
