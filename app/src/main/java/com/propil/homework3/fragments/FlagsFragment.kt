package com.propil.homework3.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.propil.homework3.R

class FlagsFragment: Fragment(){

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_flags, container, false)
    }

    companion object {
        fun newInstance(): FlagsFragment {
            return FlagsFragment()
        }
    }
}