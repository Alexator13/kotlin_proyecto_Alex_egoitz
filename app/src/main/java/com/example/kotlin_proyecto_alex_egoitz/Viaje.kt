package com.example.kotlin_proyecto_alex_egoitz

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity()
data class Viaje(

@PrimaryKey(autoGenerate = true) var id:Int = 0,
@NonNull val nombre:String = "",
@NonNull val destino:String = "",
@NonNull val fechaSalida:String = "",
@NonNull val fechaVuelta:String = "",
@NonNull val notas:String = "",
)
