package com.example.kotlin_proyecto_alex_egoitz

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView

class Adaptador(var listaViajes: List<Viajes>, var secondFragment: SecondFragment) : RecyclerView.Adapter<Adaptador.ViewHolder>() {

    inner class ViewHolder (v: View):RecyclerView.ViewHolder(v){
        var nombre: TextView
        var destino: TextView
        var fecha1: TextView
        var fecha2: TextView
        var id:Int=-1
        init {


            nombre = v.findViewById(R.id.textViewNombre)
            destino = v.findViewById(R.id.textViewDestino)
            fecha1 = v.findViewById(R.id.textViewFecha1)
            fecha2 = v.findViewById(R.id.textViewFecha2)

        }
        init {
            v.setOnClickListener {
                val bundle = bundleOf("id" to this.id )
                secondFragment.findNavController().navigate(R.id.action_SecondFragment_to_fourth_Fragment2, bundle)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup,viewType: Int): ViewHolder {
        val v= LayoutInflater.from(parent.context).inflate(R.layout.contenedor, parent, false)
        return ViewHolder(v)


    }

    override fun getItemCount(): Int {

        return listaViajes.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.nombre.text = "${listaViajes[position].name}"
        holder.destino.text="${listaViajes[position].Destino}"
        holder.fecha1.text="${listaViajes[position].fecha1}"
        holder.fecha2.text= "${listaViajes[position].fecha2}"
        holder.id = listaViajes[position].idViaje


    }
}