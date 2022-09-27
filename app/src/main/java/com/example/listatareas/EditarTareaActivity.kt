package com.example.listatareas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import android.widget.Toast

class EditarTareaActivity : AppCompatActivity() {
    private lateinit var etEditarTarea : EditText //<----------------

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_editar_tarea)

        configUi()
    }

    private fun configUi() {

        if(intent != null){
            val tarea = intent.getStringExtra("tarea")
            etEditarTarea = findViewById(R.id.etEditarTarea) //<----------------

            etEditarTarea.setText(tarea)
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_modificar_tarea, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        //switch / case
        when(item.itemId){
            R.id.opc_mod_guardar -> {
                guardar()
            }
            R.id.opc_eliminar -> {
                eliminar()
            }
        }


        return super.onOptionsItemSelected(item)
    }

    private fun eliminar() {
        TODO("Not yet implemented")
    }

    private fun guardar() {
        val tarea = etEditarTarea.text.toString()

        if(tarea.isNotEmpty()) {
            val intent = Intent()

            intent.putExtra("tarea", tarea)
            setResult(RESULT_OK, intent)
            finish()
        }else{
            //mensaje "Escriba una tarea"
            Toast.makeText(this, R.string.escriba_tarea, Toast.LENGTH_SHORT).show()
        }
    }
}