package com.example.kotlin_proyecto_alex_egoitz

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "viaje_tabla")
data class Viajes(
    @PrimaryKey val  idViaje:Int,
    @ColumnInfo(name = "Nombe") val name:String?,
    @ColumnInfo(name = "Fecha1") val fecha1:String?,
    @ColumnInfo(name = "Fecha2") val fecha2:String?,
    @ColumnInfo(name = "Destino") val Destino:String?,
    @ColumnInfo(name = "Notas") val Notas:String?,




)
