package com.example.kotlin_proyecto_alex_egoitz

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Viajes::class), version =  1, exportSchema = false)
abstract class GfgDatabase : RoomDatabase(){
        abstract fun getviajeDao():ViajeDao


    companion object{

            @Volatile
            private var INSTANCE: GfgDatabase?=null
            fun getDatabase(context: Context): GfgDatabase{

                return INSTANCE?: synchronized(this ){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    GfgDatabase::class.java,
                    "viaje_Dat"

                ).build()
                INSTANCE = instance

                instance
                }
            }
        }
}