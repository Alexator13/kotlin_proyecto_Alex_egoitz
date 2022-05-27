package com.example.kotlin_proyecto_alex_egoitz


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.kotlin_proyecto_alex_egoitz.databinding.FourthFragmentBinding
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext
import com.example.kotlin_proyecto_alex_egoitz.Viajes as Viajes1


open class fFourth_Fragment : Fragment() {

    private var _binding: FourthFragmentBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    var size = 9999
    var listaViajes: MutableList<Viajes1> = mutableListOf()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FourthFragmentBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        (activity as AppCompatActivity).supportActionBar?.title = "Viaje"
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

       // dataColect()
        val id: Int = arguments?.getInt("id") ?: -1
        Log.d("id", id.toString())

        Log.d("lista", listaViajes.size.toString())

        if (id != -1) {
            (activity as MainActivity).miViewModel.allViaje.observe(viewLifecycleOwner){ type ->
            type?.forEach{
                if (it.idViaje == id){

                    binding.editTextViajeNombre2.setText(it.name.toString())
                     binding.editTextSalidaFecha2.setText(it.fecha1.toString())
                     binding.editTextFechaVuelta2.setText(it.fecha2.toString())

                    binding.editTextNotas2.setText(it.Notas.toString())
                }
            }}


            // (activity as MainActivity).miViewModel.BuscarPorId(id)
           // var nombre = listaViajes[id].name.toString()

         //   binding.editTextViajeNombre2.setText(nombre)
            // binding.editTextSalidaFecha2.setText((activity as MainActivity).listaViajes[id].fecha1)
            //binding.editTextFechaVuelta2.setText((activity as MainActivity).listaViajes[id].fecha2)
            //binding.editTextNotas2.setText((activity as MainActivity).listaViajes[id].notas)
        }

        //botnes de editar y borrar
        binding.buttonEditar.setOnClickListener {
            //   (activity as MainActivity).listaViajes[id].nombre = binding.editTextViajeNombre2.text.toString()
            var nombre = binding.editTextViajeNombre2.text.toString()
            //     (activity as MainActivity).listaViajes[id].destino = binding.spinnerDestinos.selectedItem.toString()
            var destino = binding.spinnerDestinos.selectedItem.toString()
            //    (activity as MainActivity).listaViajes[id].fecha1 = binding.editTextSalidaFecha2.text.toString()
            var fecha1 = binding.editTextSalidaFecha2.text.toString()
            //   (activity as MainActivity).listaViajes[id].fecha2 = binding.editTextFechaVuelta2.text.toString()
            var fecha2 = binding.editTextFechaVuelta2.text.toString()
            //   (activity as MainActivity).listaViajes[id].notas = binding.editTextNotas2.text.toString()
            var notas = binding.editTextNotas2.text.toString()
            Toast.makeText(activity, "Viaje editado", Toast.LENGTH_SHORT).show()
            var viaje2: Viajes1 = Viajes1(id, nombre, destino, fecha1, fecha2, notas)

            (activity as MainActivity).miViewModel.Actualizar(viaje2)

        }
        binding.buttonBorrar.setOnClickListener {
//
            Toast.makeText(activity, "Viaje cancelado", Toast.LENGTH_SHORT).show()

            var nombre = binding.editTextViajeNombre2.text.toString()

            var destino = binding.spinnerDestinos.selectedItem.toString()
            var fecha1 = binding.editTextSalidaFecha2.text.toString()

            var fecha2 = binding.editTextFechaVuelta2.text.toString()

            var notas = binding.editTextNotas2.text.toString()
            Toast.makeText(activity, "Viaje editado", Toast.LENGTH_SHORT).show()
            var viaje2: Viajes1 = Viajes1(id, nombre, destino, fecha1, fecha2, notas)


            (activity as MainActivity).miViewModel.Borrar(viaje2)
        }

        setHasOptionsMenu(true)

    }

    fun dataColect() {

        (activity as MainActivity).miViewModel.allViaje.observe(viewLifecycleOwner) { type ->
            type?.forEach {

                listaViajes.add(id,
                    Viajes1(
                        id,
                        it.name.toString(),
                        it.Destino.toString(),
                        it.fecha1.toString(),
                        it.fecha2.toString(),
                        it.Notas.toString()
                    )
                )
            }
        }
    }

    override fun onPrepareOptionsMenu(menu: Menu) {
        super.onPrepareOptionsMenu(menu)
        menu.findItem(R.id.ayuda_fr1)?.isVisible = false
        menu.findItem(R.id.ayuda_fr2)?.isVisible = false
        menu.findItem(R.id.ayuda_fr3)?.isVisible = false
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