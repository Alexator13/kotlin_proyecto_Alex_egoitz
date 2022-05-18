package com.example.kotlin_proyecto_alex_egoitz

import androidx.room.*
import kotlinx.coroutines.flow.Flow
import java.nio.channels.FileLock

@Dao
interface ViajeDao {

    @Query("SELECT * FROM viaje_tabla")
    fun  mostraTodas(): Flow<List<Viaje>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertar(Viajes: Viaje)

    @Query("DELETE FROM  viaje_tabla")
    suspend fun borrarTodo()
    @Query("SELECT * FROM VIAJE_TABLA where idViaje like :id")
    fun BuscarPorid(id:Int): Flow<Viaje>
    @Update
    suspend fun  Actualizar(Viajes: Viaje)
    @Delete
    suspend fun Borrar(Viajes: Viaje)
}