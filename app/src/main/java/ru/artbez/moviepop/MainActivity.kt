package ru.artbez.moviepop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import ru.artbez.moviepop.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var mActBinding: ActivityMainBinding ?= null
    private val binding get() = mActBinding!!
    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mActBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        MAIN = this
        navController = Navigation.findNavController(this, R.id.nav_host)

    }

    override fun onDestroy() {
        super.onDestroy()
        mActBinding = null
    }
}