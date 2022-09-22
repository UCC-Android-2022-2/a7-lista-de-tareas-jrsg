package com.example.listatareas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    private lateinit var adapter : ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val lvTareas : ListView = findViewById(R.id.lvTareas)

        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1)
        lvTareas.adapter = adapter


        val fabNuevaTarea : FloatingActionButton = findViewById(R.id.fabNuevaTarea)

        fabNuevaTarea.setOnClickListener{
            nuevaTarea()
        }
    }

    private fun nuevaTarea() {
        val intent = Intent(this, NuevaTareaActivity::class.java)

        startActivityForResult(intent, 1)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == 1){ //nueva tarea
            if(resultCode == RESULT_OK){ // ¿éxito?

                if(data != null) {
                    var tarea = data.getStringExtra("tarea")
                    adapter.add(tarea)
                }


            }
        }
    }
}