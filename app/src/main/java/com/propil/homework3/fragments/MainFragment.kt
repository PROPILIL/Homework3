package com.propil.homework3.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import com.propil.homework3.R

class MainFragment : Fragment() {

    private lateinit var toFlags: FrameLayout
    private lateinit var toPicture: FrameLayout

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return layoutInflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews(view)

        toFlags.setOnClickListener {
            runFlagsFragment()
        }

        toPicture.setOnClickListener {
            runPictureFragment()
        }
    }

    private fun initViews(view: View) {
        toFlags = view.findViewById(R.id.to_flags_frame)
        toPicture = view.findViewById(R.id.to_picture_frame)
    }

    private fun runFlagsFragment() {
        val fragment = FlagsFragment.newInstance()
        parentFragmentManager.beginTransaction()
            .replace(R.id.fragment_container_view, fragment)
            .addToBackStack(null)
            .commit()
    }

    private fun runPictureFragment() {
        val fragment = RandomPicFragment.newInstance()
        parentFragmentManager.beginTransaction()
            .replace(R.id.fragment_container_view, fragment)
            .addToBackStack(null)
            .commit()
    }

    companion object {
        fun newInstance(): MainFragment {
            return MainFragment()
        }
    }
}