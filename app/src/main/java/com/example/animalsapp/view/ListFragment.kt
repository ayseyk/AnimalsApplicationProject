package com.example.animalsapp.view

import android.os.Bundle
import android.text.Layout
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.animalsapp.R
import com.example.animalsapp.databinding.FragmentListBinding


class ListFragment : Fragment() {

    lateinit var binding : FragmentListBinding

    override fun onCreateView( //bundan önce viewla alakalı iş yapılamaz
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListBinding.inflate(layoutInflater)
        return binding.root
        //return inflater.inflate(R.layout.fragment_list, container, false)
    }


}