package com.example.animalsapp.view

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.palette.graphics.Palette
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.example.animalsapp.databinding.FragmentDetailBinding
import com.example.animalsapp.model.Animal
import com.example.animalsapp.util.getProgressDrawable
import com.example.animalsapp.util.loadImage
import kotlinx.android.synthetic.main.fragment_detail.*
import kotlinx.android.synthetic.main.item_animal.*
import kotlinx.android.synthetic.main.item_animal.animalImage
import kotlinx.android.synthetic.main.item_animal.animalName

class DetailFragment : Fragment() {

    lateinit var binding : FragmentDetailBinding

    var animal : Animal? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(layoutInflater)
        return binding.root
        //return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments.let {
            animal = DetailFragmentArgs.fromBundle(it!!).animal
        }

        context?.let {
            animalImage.loadImage(animal?.imageUrl, getProgressDrawable(it))

        }

        animalName.text = animal?.name
        animalLocation.text = animal?.location
        animalLifespan.text = animal?.lifeSpan
        animalDiet.text = animal?.diet

        animal?.imageUrl?.let{
            setupBackgrounColor(it)
        }
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
                            binding.animalLayout.setBackgroundColor(intColor)
                        }
                }

                override fun onLoadCleared(placeholder: Drawable?) {
                }

            })
    }
}