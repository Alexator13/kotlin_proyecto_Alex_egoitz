package com.example.kotlin_proyecto_alex_egoitz

import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.Flow


class Repositorio(val miDao: ViajeDao) {

    val listaViaje : Flow<List<Viaje>> = miDao.mostraTodas()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun Insertar(miViaje: Viaje){
        miDao.insertar(miViaje)
    }

    fun BuscarPorId(id:Int): Flow<Viaje>{
        return miDao.BuscarPorid(id)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun Borrar(miViaje: Viaje){
        miDao.Borrar(miViaje)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun Actualizar(miViaje: Viaje){
        miDao.Actualizar(miViaje)
    }
}