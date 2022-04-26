package com.example.kotlin_proyecto_alex_egoitz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kotlin_proyecto_alex_egoitz.databinding.FourthFragmentBinding
import com.example.kotlin_proyecto_alex_egoitz.databinding.ThirdFragmentBinding

class Fourth_Fragment : Fragment() {
    private var _binding: FourthFragmentBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FourthFragmentBinding.bind().inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}