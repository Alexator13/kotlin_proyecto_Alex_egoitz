package com.example.kotlin_proyecto_alex_egoitz

import androidx.lifecycle.*
import kotlinx.coroutines.launch
import java.lang.IllegalArgumentException

class ViajeViewModel(private val miRepositorio: Repositorio) : ViewModel() {
  val  allViaje:LiveData<List<Viajes>> = miRepositorio.listaViaje.asLiveData()
    lateinit var miViaje:LiveData<Viajes>

    fun Insertar(miViaje: Viajes)  = viewModelScope.launch {

        miRepositorio.Insertar(miViaje)
    }
    fun BuscarPorId(id:Int)= viewModelScope.launch {
        miViaje = miRepositorio.BuscarPorId(id).asLiveData()
    }
    fun Borrar(miViaje: Viajes) = viewModelScope.launch {
        miRepositorio.Borrar(miViaje)
    }

    fun Actualizar(miViaje: Viajes) = viewModelScope.launch {
        miRepositorio.Actualizar(miViaje)
    }

    }


class ViajeViewModelFactory(private val repository:Repositorio) : ViewModelProvider.Factory{
    override fun <T :ViewModel> create(modelClass: Class<T>): T{
        if (modelClass.isAssignableFrom(ViajeViewModel::class.java)){
            @Suppress("UNCHECKED_CAST")
            return ViajeViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
