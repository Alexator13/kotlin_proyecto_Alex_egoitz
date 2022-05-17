package com.example.kotlin_proyecto_alex_egoitz

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface ViajeDAO {
    @Query("SELECT * from Viaje order by id asc")
    fun  MostrarTodas(): Flow<List<Viaje>>

    @Insert(onConflict =  OnConflictStrategy.IGNORE)
    suspend fun insertar(word: Viaje)

    @Query("delete from Viaje")
    suspend fun BorrarTodas()

@Update
suspend fun  Actualizar(word:Viaje)

@Delete
suspend fun Borrrar(word: Viaje)
}