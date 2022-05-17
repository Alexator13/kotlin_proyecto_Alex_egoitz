package com.example.kotlin_proyecto_alex_egoitz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.kotlin_proyecto_alex_egoitz.databinding.FragmentFirstBinding
import com.example.kotlin_proyecto_alex_egoitz.databinding.ThirdFragmentBinding

class third_fragment : Fragment() {
    private var _binding: ThirdFragmentBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = ThirdFragmentBinding.inflate(inflater, container, false)
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
        binding.buttonGuardar.setOnClickListener {
            var nombre:String = binding.editTextViajeNombre.text.toString()
            var destino:String = binding.spinnerDestinos.selectedItem.toString()
            var fecha1:String = binding.editTextSalidaFecha.text.toString()
            var fecha2:String = binding.editTextFechaVuelta.text.toString()
            var notas:String = binding.editTextNotas.text.toString()
            var id:Int =  (activity as MainActivity).listaViajes.lastIndex + 1
            (activity as MainActivity).listaViajes.add(id,Viaje(nombre,destino,fecha1,fecha2,notas))
            Toast.makeText(activity , "Viaje guardado con exito", Toast.LENGTH_SHORT).show()

        }



    }

    fun onItemSelected(parent: AdapterView<*>, view: View?, pos: Int, id: Long) {
        // An item was selected. You can retrieve the selected item using
        // parent.getItemAtPosition(pos)
    }

    fun onNothingSelected(parent: AdapterView<*>) {
        // Another interface callback
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}