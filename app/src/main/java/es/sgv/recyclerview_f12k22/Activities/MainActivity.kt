package es.sgv.recyclerview_f12k22.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import es.sgv.recyclerview_f12k22.R
/*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import es.sgv.recyclerview_f12k22.Clases.PilotosProvider
import es.sgv.recyclerview_f12k22.Adapter.PilotoAdapter
import androidx.core.app.ActivityCompat.startActivityForResult
import android.view.View*/

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