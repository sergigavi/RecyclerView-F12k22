package com.example.recyclerviewexamplo.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewexamplo.PilotosProvider
import com.example.recyclerviewexamplo.R
import com.example.recyclerviewexamplo.adapter.PilotoAdapter
import androidx.core.app.ActivityCompat.startActivityForResult
import android.content.Intent
import android.view.View
import android.widget.Button


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //aqui hago que funcione el boton para que me lleve al recycler
        cargarActivityRecycler()
    }

    private fun cargarActivityRecycler() {

        val btn: Button = findViewById<Button>(R.id.btnIrRecyclerView)

        btn.setOnClickListener{
            val intent = Intent(this,RecyclerActivity::class.java)
            startActivity(intent)
        }

    }

}