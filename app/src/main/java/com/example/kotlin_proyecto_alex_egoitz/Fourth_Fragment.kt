package com.example.kotlin_proyecto_alex_egoitz


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
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

        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val spinner: Spinner = binding.spinnerDestinos
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter.createFromResource(
            activity as MainActivity,
            R.array.destinos,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            spinner.adapter = adapter
        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

     fun onItemSelected(parent: AdapterView<*>, view: View?, pos: Int, id: Long) {
        // An item was selected. You can retrieve the selected item using
        // parent.getItemAtPosition(pos)
    }

     fun onNothingSelected(parent: AdapterView<*>) {
        // Another interface callback
    }



}