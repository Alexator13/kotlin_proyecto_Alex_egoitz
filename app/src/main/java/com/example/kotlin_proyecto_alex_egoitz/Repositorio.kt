package com.example.kotlin_proyecto_alex_egoitz

import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.Flow


class Repositorio(val miDao: ViajeDao) {

    val listaViaje : Flow<List<Viajes>> = miDao.mostraTodas()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun Insertar(miViaje: Viajes){
        miDao.insertar(miViaje)
    }

    fun BuscarPorId(id:Int): Flow<Viajes>{
        return miDao.BuscarPorid(id)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun Borrar(miViaje: Viajes){
        miDao.Borrar(miViaje)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun Actualizar(miViaje: Viajes){
        miDao.Actualizar(miViaje)
    }
}