package com.example.kotlin_proyecto_alex_egoitz

import androidx.room.*
import kotlinx.coroutines.flow.Flow
import java.nio.channels.FileLock

@Dao
interface ViajeDao {

    @Query("SELECT * FROM viaje_tabla")
    fun  mostraTodas(): Flow<List<Viajes>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
     fun insertar(Viajes: com.example.kotlin_proyecto_alex_egoitz.Viajes)

    @Query("DELETE FROM  viaje_tabla")
 fun borrarTodo()
    @Query("SELECT * FROM VIAJE_TABLA where idViaje like :id")
    fun BuscarPorid(id:Int): Flow<Viajes>
    @Update
   fun  Actualizar(Viajes: Viajes)
    @Delete
 fun Borrar(Viajes: Viajes)
}