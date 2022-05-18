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
import com.example.kotlin_proyecto_alex_egoitz.databinding.FourthFragmentBinding
import com.example.kotlin_proyecto_alex_egoitz.databinding.FragmentSecondBinding
import com.example.kotlin_proyecto_alex_egoitz.databinding.ThirdFragmentBinding
import kotlinx.coroutines.newSingleThreadContext


class Fourth_Fragment : Fragment() {

    private var _binding: FourthFragmentBinding? = null

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

        _binding = FourthFragmentBinding.inflate(inflater, container, false)
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
        val id:Int=arguments?.getInt("id") ?: -1
        binding.editTextViajeNombre2.setText((activity as MainActivity).listaViajes[id].nombre)
        binding.editTextSalidaFecha2.setText((activity as MainActivity).listaViajes[id].fecha1)
        binding.editTextFechaVuelta2.setText((activity as MainActivity).listaViajes[id].fecha2)
        binding.editTextNotas2.setText((activity as MainActivity).listaViajes[id].notas )
        //botnes de editar y borrar
        binding.buttonEditar.setOnClickListener {
            (activity as MainActivity).listaViajes[id].nombre = binding.editTextViajeNombre2.text.toString()
             var nombre = binding.editTextViajeNombre2.text.toString()
            (activity as MainActivity).listaViajes[id].destino = binding.spinnerDestinos.selectedItem.toString()
            var destino = binding.spinnerDestinos.selectedItem.toString()
            (activity as MainActivity).listaViajes[id].fecha1 = binding.editTextSalidaFecha2.text.toString()
            var fecha1 = binding.editTextSalidaFecha2.text.toString()
            (activity as MainActivity).listaViajes[id].fecha2 = binding.editTextFechaVuelta2.text.toString()
            var fecha2 = binding.editTextFechaVuelta2.text.toString()
            (activity as MainActivity).listaViajes[id].notas = binding.editTextNotas2.text.toString()
                var notas = binding.editTextNotas2.text.toString()
          editViaje(ve = Viajes(id,nombre,destino,fecha1,fecha2,notas))
            Toast.makeText(activity, "Viaje editado", Toast.LENGTH_SHORT).show()
         }
        binding.buttonBorrar.setOnClickListener {
            (activity as MainActivity).listaViajes.remove((activity as MainActivity).listaViajes[id])
             var nombre = binding.editTextViajeNombre2.text.toString()

            var destino = binding.spinnerDestinos.selectedItem.toString()

            var fecha1 = binding.editTextSalidaFecha2.text.toString()

            var fecha2 = binding.editTextFechaVuelta2.text.toString()
            (activity as MainActivity).listaViajes[id].notas = binding.editTextNotas2.text.toString()
            var notas = binding.editTextNotas2.text.toString()

            Toast.makeText(activity, "Viaje cancelado", Toast.LENGTH_SHORT).show()
            deleteViaje(ve = Viajes(id,nombre,destino,fecha1,fecha2,notas))

        }
    }
  fun editViaje(ve: Viajes )  = db.getviajeDao().Actualizar(ve)
  fun deleteViaje(ve: Viajes )  = db.getviajeDao().Borrar(ve)

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