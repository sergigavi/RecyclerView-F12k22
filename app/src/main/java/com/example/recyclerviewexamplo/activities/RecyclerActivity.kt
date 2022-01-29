package com.example.recyclerviewexamplo.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewexamplo.Piloto
import com.example.recyclerviewexamplo.PilotosProvider
import com.example.recyclerviewexamplo.R
import com.example.recyclerviewexamplo.adapter.PilotoAdapter
import com.example.recyclerviewexamplo.databinding.ActivityMainBinding
import com.example.recyclerviewexamplo.databinding.ActivityRecyclerBinding

class RecyclerActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRecyclerBinding //ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_recycler) //esta linea nos la cargamos ya que vamos a usar el viewbinding
        //con el binding ponemos esto:
        binding = ActivityRecyclerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //lo metemos en el onCreate para que nada mas se entre en este activity (se cargue en el movil) se llame a este metodo
        initRecyclerView()

    }

    private fun initRecyclerView() {
        val manager = LinearLayoutManager(this) //puedo cambiar el linear por un GridLayoutManager, y tengo que pasarle el numero de columnas por fila además del contexto (this)
        //vamos a usar los divider decorator para que quede mejor y diferenciar los diferentes items del recyclerview, en este caso solo le mete un divider entre item y item
        val decoration = DividerItemDecoration(this, manager.orientation /*LinearLayoutManager(this).orientation*/) //he puesto en una variable el linearLayoutManager(this) para usarlo aqui y debajo tambien

        //val recyclerView = findViewById<RecyclerView>(R.id.recyclerPiloto)//podemos quitar esto ya que vamos a usar el binding
        //en lugar de recyclerView.layoutManager, al usar el binding ponemos binding.recyclerPiloto (el nombre de la id) //+ hay que cambiar tambien el Pilotoviewholder
        binding.recyclerPiloto.layoutManager = manager //LinearLayoutManager(this) //si pusieramos varios layouts se podrian hacer varias columnas a la vez, un gridlayout
        binding.recyclerPiloto.adapter = PilotoAdapter(PilotosProvider.pilotos, {piloto ->  onItemSelected(piloto)}) //le pasamos la funcion lambda (entre llaves ya que es una lambda) //podriamos pasarle directamente it sin poner piloto ->, it es iterador, el contenido del piloto, pero lo pongo con la lambda de piloto para que no me lie

        binding.recyclerPiloto.addItemDecoration(decoration) //decoration facilito que solo mete una linea divisoria
        //podemos crear nuestros propios decorations personalizados


        //**esto es lo del onclick
        //al pilotoadapter arriba le pasamos una lista, pero tambien le podemos pasar una funcion lambda

    }

    //creamos la funcion que le tenemos que pasar al adapter junto a la lista
    fun onItemSelected(piloto:Piloto) //recibe un objeto piloto
    {
        Toast.makeText(this, piloto.nombre, Toast.LENGTH_SHORT).show() //aqui si le podemos pasar el contexto con el this ya que estamos en un activity
    }


}