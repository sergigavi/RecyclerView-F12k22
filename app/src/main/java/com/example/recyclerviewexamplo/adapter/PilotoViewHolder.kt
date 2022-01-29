package com.example.recyclerviewexamplo.adapter

import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.recyclerviewexamplo.Piloto
import com.example.recyclerviewexamplo.databinding.ItemPilotoBinding

//encargado de coger los atributos de cada objeto y pintarlos

class PilotoViewHolder(view:View): RecyclerView.ViewHolder(view) {

    //le pasamos view, que es la vista que recibía
    val binding = ItemPilotoBinding.bind(view) //el binding se nos crea automaticamente y lo renombrar con el nombre del xml+binding, en este caso item_piloto.xml -> ItemPilotoBinding

    //gracias al binding podemos cargarnos todo esto
    /*
    val Pimagen = view.findViewById<ImageView>(R.id.IV_pilotoImg)
    val Pnombre = view.findViewById<TextView>(R.id.TV_nombrePiloto)
    val Pdorsal = view.findViewById<TextView>(R.id.TV_dorsal)
    val Pescuderia = view.findViewById<TextView>(R.id.TV_escuderia)
    */

    fun render(piloto: Piloto, onClickListener:(Piloto) -> Unit){

        //basicamente con el binding accedemos directamente a la id de cada componente (la id que le hemos puesto en el xml de item_piloto
        //ahora en lugar de Pnombre/Pdorsal/Pescuderia/Pimagen .text, con el binding ponemos binding.TVNombrePiloto.text
        binding.TVNombrePiloto.text = piloto.nombre
        binding.TVDorsal.text = piloto.dorsal.toString()
        binding.TVEscuderia.text = piloto.escuderia
        Glide.with(binding.IVPilotoImg.context).load(piloto.imagen).into(binding.IVPilotoImg)
        //ya está implementado el viewBinding en nuestro recyclerview
        //al no estar en una activity no tenemos contexto  ni podemos poner el this, pero podemos sacarlo de cualquier otro sitio (en mi caso lo saco de la imagen con el Pimagen.context)

            //forma mas facil de gestionar los clicks, manteniendola dentro del viewholder
        //así sería el onclick de cuando pulse en la foto de un item del recyclerview, lo he metido en una funcion para organizar el codigo
        //onClickDeLaFoto(piloto)

        //si queremos que el click pase cuando pulsas en todo el item y no en la foto:
        //llamamos dentro de la funcion render al itemView, el itemView es toda la celda
        //onClickDelItem(piloto)

        //otra algo más compleja sería pasandole una funcion a nuestro adapter, el adapter se lo pasará al viewholder y cada vez que se clickee en un item se llama a esa funcion
        //y como esa funcion es del activity, automaticamente llega toda al informacion a ese activity
        //**VER recycleractivity
        itemView.setOnClickListener(){ //de esta forma cada vez que se haga click vamos a llamar a la funcion lambda
            onClickListener(piloto) //a la lambda le pasamos el objeto piloto con el que estemos //el que le hayamos hecho click
        }


    }

    private fun onClickDelItem(piloto: Piloto) {
        itemView.setOnClickListener()
        {
            Toast.makeText(binding.IVPilotoImg.context,
                piloto.toString(),
                Toast.LENGTH_SHORT)
                .show()
        }
    }

    private fun onClickDeLaFoto(piloto: Piloto) {
        //voy a meterle un onclick listener a la foto para que se le pueda hacer click
        //poner el componente al que queremos acceder y darle el atributo de clickable
        binding.IVPilotoImg.setOnClickListener() //cada listener va en relacion a cada item sobre el que se hace el click
        {
            Toast.makeText(binding.IVPilotoImg.context,
                "El nombre es " + piloto.nombre,
                Toast.LENGTH_SHORT)
                .show() //context, mensaje, duracion
        }
    }


}