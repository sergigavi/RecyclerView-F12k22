package com.example.recyclerviewexamplo.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewexamplo.Piloto
import com.example.recyclerviewexamplo.R

class PilotoAdapter(private val pilotos:List<Piloto>) : RecyclerView.Adapter<PilotoViewHolder>(){ //  : -> extends

    //aqui le pasamos el item, el layout que va a poder modificar
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PilotoViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return PilotoViewHolder(layoutInflater.inflate(R.layout.item_piloto, parent, false))

    }

    //este metodo pasa por cada uno de los items y llama al Piloto render pasandole ese item
    override fun onBindViewHolder(holder: PilotoViewHolder, position: Int) {
        var item = pilotos[position]

        holder.render(item)
    }

    override fun getItemCount(): Int { //devuelve el tamaño del listado que tenemos
        return pilotos.size
    }

}