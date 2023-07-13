package com.example.nucollection

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
class DashboardActivity : AppCompatActivity() {
    lateinit var bottomNavigation: BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loadFragment(HomeFragment())
        setContentView(R.layout.activity_dashboard)
        bottomNavigation = findViewById(R.id.bottomNavigation)
        bottomNavigation.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.home -> {
                    loadFragment(HomeFragment())

                }
                R.id.contact -> {
                    loadFragment(CartFragment())

                }
                R.id.profile -> {
                    loadFragment(ProfileFragment())

                }

                else -> {

                }
            }
            true
        }
    }
    private fun loadFragment(fragment: Fragment) {
        val transaction=supportFragmentManager.beginTransaction()
        transaction.replace(com.google.android.material.R.id.container,fragment)
        transaction.commit()
    }
}