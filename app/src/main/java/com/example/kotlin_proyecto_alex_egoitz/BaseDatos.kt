package com.example.kotlin_proyecto_alex_egoitz

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Viaje::class), version=1, exportSchema = false)
abstract class BaseDatos: RoomDatabase() {

    abstract fun miDao(): ViajeDAO
    companion object{


    }@Volatile
    private var INSTACE: BaseDatos? = null

    fun getDatabase(context:Context) : BaseDatos{

        return INSTACE?: synchronized(this){
            val  instance = Room.databaseBuilder(context.applicationContext,
                BaseDatos::class.java,
            "ViajeBase").build()

                INSTACE = instance
            instance
                 }
    }



}