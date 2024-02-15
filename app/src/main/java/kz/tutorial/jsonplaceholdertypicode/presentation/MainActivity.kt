package kz.tutorial.jsonplaceholdertypicode.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import kz.tutorial.jsonplaceholdertypicode.R
import kz.tutorial.jsonplaceholdertypicode.databinding.ActivityMainBinding
import kz.tutorial.jsonplaceholdertypicode.presentation.posts.PostsFragment

private lateinit var binding: ActivityMainBinding
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.bottomNavigation.setOnItemSelectedListener {
            when(it.itemId){
               R.id.posts ->{Navigation.findNavController(binding.flContainer).navigate(R.id.posts)}
                R.id.vector -> {}
                R.id.users -> {Navigation.findNavController(binding.flContainer).navigate(R.id.users)}
                R.id.profile -> {}
            }
            true
        }
    }


}