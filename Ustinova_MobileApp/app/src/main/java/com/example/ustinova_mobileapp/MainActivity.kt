package com.example.ustinova_mobileapp

import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import android.widget.ImageButton


class MainActivity : AppCompatActivity() {

    var frg0 : StartingFragment = StartingFragment()
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button1: ImageButton = findViewById<ImageButton>(R.id.btn_fragment1)
        val button2: ImageButton = findViewById<ImageButton>(R.id.btn_fragment2)
        button1.setImageResource(R.drawable.shop11)
        button2.setImageResource(R.drawable.shop22)
        val ft = supportFragmentManager.beginTransaction() as FragmentTransaction
        ft.replace(R.id.frame_layout, frg0)
        ft.commit()
        button1.setOnClickListener {
            var frg1 : FirstFragment = FirstFragment()
            setNewFragment(frg1)
            button1.setImageResource(R.drawable.shop11_active)
            button2.setImageResource(R.drawable.shop22)
        }
        button2.setOnClickListener {
            var frg2: SecondFragment = SecondFragment()
            setNewFragment(frg2)
            button2.setImageResource(R.drawable.shop22_active)
            button1.setImageResource(R.drawable.shop11)
        }
    }

    private fun setNewFragment(fragment: Fragment) {
        val ft = supportFragmentManager.beginTransaction() as FragmentTransaction
        ft.replace(R.id.frame_layout, fragment)
       ft.addToBackStack(null)
        ft.commit()
    }
}