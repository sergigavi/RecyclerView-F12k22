package com.example.recyclerviewexamplo.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewexamplo.Piloto
import com.example.recyclerviewexamplo.R
//el segundo parametro (el del onclicklistener) es una funcion lambda
class PilotoAdapter(private val pilotos:List<Piloto>, private val onClickListener:(Piloto) -> Unit) : RecyclerView.Adapter<PilotoViewHolder>(){ //  : -> extends

    //aqui le pasamos el item, el layout que va a poder modificar
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PilotoViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return PilotoViewHolder(layoutInflater.inflate(R.layout.item_piloto, parent, false))

    }

    //este metodo pasa por cada uno de los items y llama al Piloto render pasandole ese item
    override fun onBindViewHolder(holder: PilotoViewHolder, position: Int) {
        var item = pilotos[position]

        holder.render(item, onClickListener) //aqui tambien le devolvemos la lambda del onclick
    }

    override fun getItemCount(): Int { //devuelve el tamaño del listado que tenemos
        return pilotos.size
    }

}