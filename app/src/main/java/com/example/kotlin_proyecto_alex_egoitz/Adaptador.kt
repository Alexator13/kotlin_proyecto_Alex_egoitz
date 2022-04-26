package com.example.kotlin_proyecto_alex_egoitz

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Adaptador : RecyclerView.Adapter<Adaptador.ViewHolder>() {

    inner class ViewHolder (v: View):RecyclerView.ViewHolder(v){
        var nombre: TextView
        var destino: TextView
        var fecha1: TextView
        var fecha2: TextView

        init {

            nombre = v.findViewById(R.id.textViewNombre)
            destino = v.findViewById(R.id.textViewDestino)
            fecha1 = v.findViewById(R.id.textViewFecha1)
            fecha2 = v.findViewById(R.id.textViewFecha2)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup,viewType: Int): ViewHolder {
        val v= LayoutInflater.from(parent.context).inflate(R.layout.contenedor, parent, false)
        return ViewHolder(v)


    }

    override fun getItemCount(): Int {
        //return listaPeliculas.size
        return 5
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.nombre.text=""
        holder.destino.text=""
        holder.fecha1.text=""
        holder.fecha1.text=""

    }
}