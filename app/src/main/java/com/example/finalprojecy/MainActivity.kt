package com.example.finalprojecy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.appbar.MaterialToolbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val drawerLayout = findViewById<DrawerLayout>(R.id.drawer_layout)
        val materialToolbar = findViewById<MaterialToolbar>(R.id.topAppBar)
        materialToolbar.setNavigationOnClickListener{
            drawerLayout.openDrawer(GravityCompat.START)
        }
    }
}