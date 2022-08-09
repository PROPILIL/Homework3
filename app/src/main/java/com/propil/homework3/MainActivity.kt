package com.propil.homework3

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.propil.homework3.fragments.FlagsFragment
import com.propil.homework3.fragments.MainFragment
import com.propil.homework3.fragments.RandomPicFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        runDefaultFragment()

    }

    private fun runDefaultFragment() {
        val fragment = MainFragment.newInstance()
        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container_view, fragment)
            .addToBackStack(null)
            .commit()
    }
}