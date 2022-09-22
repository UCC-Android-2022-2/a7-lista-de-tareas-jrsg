package com.example.listatareas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import android.widget.Toast

class NuevaTareaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nueva_tarea)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_nueva_tarea, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if(item.itemId == R.id.opc_nueva_guardar){
            guardar()
        }

        return super.onOptionsItemSelected(item)
    }

    private fun guardar() {
        val etNuevaTarea : EditText = findViewById(R.id.etNuevaTarea)
        val tarea : String = etNuevaTarea.text.toString()

        if(tarea.isNotEmpty()) {
            val intent = Intent()
            intent.putExtra("tarea", tarea)

            setResult(RESULT_OK, intent)
            finish()
        }else{
            Toast.makeText(this, getString(R.string.escriba_tarea), Toast.LENGTH_SHORT).show()
        }
    }
}