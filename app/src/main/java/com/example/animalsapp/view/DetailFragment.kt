package com.example.animalsapp.view

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.palette.graphics.Palette
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.example.animalsapp.R
import com.example.animalsapp.databinding.FragmentDetailBinding
import com.example.animalsapp.model.Animal
import com.example.animalsapp.model.AnimalPalette
import com.example.animalsapp.util.getProgressDrawable
import com.example.animalsapp.util.loadImage
import kotlinx.android.synthetic.main.item_animal.*

class DetailFragment : Fragment() {

    private lateinit var binding : FragmentDetailBinding
    private lateinit var dataBinding : FragmentDetailBinding

    var animal : Animal? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dataBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_detail, container, false)
        binding = FragmentDetailBinding.inflate(layoutInflater)
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments.let {
            animal = DetailFragmentArgs.fromBundle(it!!).animal
        }

        animal?.imageUrl?.let{
            setupBackgrounColor(it)
        }

        dataBinding.animal = animal
    }

    private fun setupBackgrounColor(url : String){
        Glide.with(this)
            .asBitmap()
            .load(url)
            .into(object: CustomTarget<Bitmap>(){
                override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
                    Palette.from(resource)
                        .generate(){palette ->
                            val intColor = palette?.lightMutedSwatch?.rgb ?: 0
                            dataBinding.palette = AnimalPalette(intColor)
                        }
                }

                override fun onLoadCleared(placeholder: Drawable?) {
                }

            })
    }
}