package com.propil.homework3.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.google.android.material.textfield.TextInputEditText
import com.propil.homework3.R

class RandomPicFragment : Fragment() {

    private lateinit var randomButton: Button
    private lateinit var specificButton: Button
    private lateinit var imageView: ImageView

    private lateinit var inputField: TextInputEditText


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_pic_random, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews(view)

        randomButton.setOnClickListener {
            //TODO: Add coroutines here
        }
    }

    //TODO: Add function to download images here


    private fun initViews(view: View) {
        randomButton = view.findViewById(R.id.random_button)
        specificButton = view.findViewById(R.id.specific_button)
        imageView = view.findViewById(R.id.image)
        inputField = view.findViewById(R.id.input_field)
    }

    companion object {
        private const val RANDOM_PIC_URL = "https://picsum.photos/200"

        fun newInstance(): RandomPicFragment {
            return RandomPicFragment()
        }
    }
}