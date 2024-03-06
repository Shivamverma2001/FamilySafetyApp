package com.example.familysafety

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    lateinit var bottomNavigation:BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavigation=findViewById(R.id.bottom_bar)
        bottomNavigation.setOnItemSelectedListener {menuItem->
            if(menuItem.itemId==R.id.nav_guard){
                    inflateFragment(GuardFragment.newInstance())
            }else if(menuItem.itemId==R.id.nav_home){
                inflateFragment(HomeFragment.newInstance())
            }
            else if(menuItem.itemId==R.id.nav_dashboard){
                inflateFragment(DashboardFragment.newInstance())
            }
            else if(menuItem.itemId==R.id.nav_profile){
                inflateFragment(UserFragment.newInstance())
            }
            true
        }
    }

    private fun inflateFragment(newInstance:Fragment) {
        val transaction=supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container,newInstance)
        transaction.commit()
    }
}