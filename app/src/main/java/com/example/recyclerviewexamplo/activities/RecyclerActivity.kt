package com.example.recyclerviewexamplo.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewexamplo.PilotosProvider
import com.example.recyclerviewexamplo.R
import com.example.recyclerviewexamplo.adapter.PilotoAdapter

class RecyclerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler)

        //lo metemos en el onCreate para que nada mas se entre en este activity (se cargue en el movil) se llame a este metodo
        initRecyclerView()

    }

    private fun initRecyclerView() {
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerPiloto)
        recyclerView.layoutManager = LinearLayoutManager(this) //si pusieramos varios layouts se podrian hacer varias columnas a la vez, un gridlayout
        recyclerView.adapter = PilotoAdapter(PilotosProvider.pilotos)
    }
}