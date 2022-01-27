package com.example.recyclerviewexamplo.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.recyclerviewexamplo.Piloto
import com.example.recyclerviewexamplo.R

//encargado de coger los atributos de cada objeto y pintarlos

class PilotoViewHolder(view:View): RecyclerView.ViewHolder(view) {

    val Pimagen = view.findViewById<ImageView>(R.id.IV_pilotoImg)

    val Pnombre = view.findViewById<TextView>(R.id.TV_nombrePiloto)
    val Pdorsal = view.findViewById<TextView>(R.id.TV_dorsal)
    val Pescuderia = view.findViewById<TextView>(R.id.TV_escuderia)

    fun render(piloto: Piloto){
        Pnombre.text = piloto.nombre
        Pdorsal.text = piloto.dorsal.toString()
        Pescuderia.text = piloto.escuderia
        Glide.with(Pimagen.context).load(piloto.imagen).into(Pimagen)
    }

    //al no estar en una activity no tenemos contexto  ni podemos poner el this, pero podemos sacarlo de cualquier otro sitio (en mi caso lo saco de la imagen con el Pimagen.context)
}