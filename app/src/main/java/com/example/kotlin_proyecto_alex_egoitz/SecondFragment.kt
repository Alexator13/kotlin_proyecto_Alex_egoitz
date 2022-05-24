package com.example.kotlin_proyecto_alex_egoitz

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin_proyecto_alex_egoitz.databinding.FragmentSecondBinding
import kotlin.math.log

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
 class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!
    lateinit var miRecyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity).supportActionBar?.title = "Ver viajes"
        miRecyclerView = binding.ViewViajes
        miRecyclerView.layoutManager = LinearLayoutManager(activity)
        (activity as MainActivity).miViewModel.allViaje.observe(activity as MainActivity){ it -> miRecyclerView.adapter = Adaptador(it, this)
 }
        //miRecyclerView.adapter = Adaptador( (activity as MainActivity).listaViajes, this)

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}