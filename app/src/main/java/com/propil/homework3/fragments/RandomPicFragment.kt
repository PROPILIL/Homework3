package com.propil.homework3.fragments

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.material.textfield.TextInputEditText
import com.propil.homework3.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.net.URL

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
            CoroutineScope(Dispatchers.IO).launch {
                val bitmap = downloadRandomBitmap(RANDOM_PIC_URL)
                imageView.post {
                    imageView.setImageBitmap(bitmap)
                }
            }
        }
        specificButton.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                val inputNum = inputField.text.toString()
                val url = "$SPECIFIC_PIC_URL$inputNum/200"

                when (val bitmap = downloadRandomBitmap(url)) {
                    null -> withContext(Dispatchers.Main) {
                        Toast.makeText(activity, "$inputNum index not found", Toast.LENGTH_SHORT).show()
                    }
                    else -> {
                        Log.d("TAG", inputNum)
                        Log.d("TAG", url)
                        Log.d("TAG", "$bitmap")
                        imageView.post {
                            imageView.setImageBitmap(bitmap)
                        }
                    }
                }


            }
        }
    }

    private fun initViews(view: View) {
        randomButton = view.findViewById(R.id.random_button)
        specificButton = view.findViewById(R.id.specific_button)
        imageView = view.findViewById(R.id.image)
        inputField = view.findViewById(R.id.input_field)
    }

    private fun downloadRandomBitmap(imageUrl: String?): Bitmap? {
        return try {
            val connection = URL(imageUrl).openConnection()
            connection.connect()
            val inputStream = connection.getInputStream()
            val bitmap = BitmapFactory.decodeStream(inputStream)
            inputStream.close()
            bitmap
        } catch (e: Exception) {
            null
        }
    }

    companion object {
        private const val RANDOM_PIC_URL = "https://picsum.photos/200"
        private const val SPECIFIC_PIC_URL = "https://picsum.photos/id/"

        fun newInstance(): RandomPicFragment {
            return RandomPicFragment()
        }
    }
}