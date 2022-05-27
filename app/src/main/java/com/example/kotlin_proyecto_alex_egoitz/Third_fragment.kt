package com.example.kotlin_proyecto_alex_egoitz

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import com.example.kotlin_proyecto_alex_egoitz.databinding.FragmentFirstBinding
import com.example.kotlin_proyecto_alex_egoitz.databinding.ThirdFragmentBinding

 class third_fragment : Fragment() {
    private var _binding: ThirdFragmentBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    val db: GfgDatabase
        get() {
            TODO()
        }


     override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = ThirdFragmentBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)
        (activity as AppCompatActivity).supportActionBar?.title = "Nuevo viaje"
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
            var viaje2: Viajes = Viajes (id,nombre,destino,fecha1,fecha2,notas)

            (activity as MainActivity).miViewModel.Insertar(viaje2)

            Toast.makeText(activity , "Viaje guardado con exito en base de datos", Toast.LENGTH_SHORT).show()

        }

    }

     override fun onPrepareOptionsMenu(menu: Menu) {
         super.onPrepareOptionsMenu(menu)
         menu.findItem(R.id.ayuda_fr1)?.isVisible=false
         menu.findItem(R.id.ayuda_fr2)?.isVisible=false
         menu.findItem(R.id.ayuda_fr4)?.isVisible=false
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