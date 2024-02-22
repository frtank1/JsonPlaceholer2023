package kz.tutorial.jsonplaceholdertypicode.presentation


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import kz.tutorial.jsonplaceholdertypicode.R
import kz.tutorial.jsonplaceholdertypicode.databinding.ActivityMainBinding
import kz.tutorial.jsonplaceholdertypicode.presentation.posts.PostsFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fl_container) as NavHostFragment
        navController = navHostFragment.findNavController()
        binding.bottomNavigation.setupWithNavController(navController)
    }

/*
    private fun navigateObserver(){
        binding.bottomNavigation.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.posts -> {
                    Navigation.findNavController(binding.flContainer).navigate(R.id.posts)
                }

                R.id.vector -> {
                    Navigation.findNavController(binding.flContainer).navigate(R.id.albums)
                }

                R.id.users -> {
                    Navigation.findNavController(binding.flContainer).navigate(R.id.users)
                }

                R.id.profile -> {
                    Navigation.findNavController(binding.flContainer).navigate(R.id.todos)
                }
            }
        }
    }

 */
}