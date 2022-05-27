package com.example.kotlin_proyecto_alex_egoitz

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.viewModels
import com.example.kotlin_proyecto_alex_egoitz.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding
    var listaViajes:MutableList<Viaje> = mutableListOf()
    val database by lazy { GfgDatabase.getDatabase(this ) }
    val miRepositorio by lazy { Repositorio(database.getviajeDao()) }
    val miViewModel:ViajeViewModel by viewModels{ViajeViewModelFactory(miRepositorio)  }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val navController = findNavController(R.id.nav_host_fragment_content_main)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)


        }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.creditos -> Toast.makeText(this, "Programa creado por Alexander Regaolado y Egoitz Perez de Arrilucea", Toast.LENGTH_LONG).show()
            R.id.ayuda_fr1 -> Toast.makeText(this, "Este es el menu principal", Toast.LENGTH_LONG).show()
            R.id.ayuda_fr2 -> Toast.makeText(this, "Aqui se ven los viajes, si seleccionas uno se podra editar o borrar", Toast.LENGTH_LONG).show()
            R.id.ayuda_fr3 -> Toast.makeText(this, "Aqui se puede crear un viaje nuevo", Toast.LENGTH_LONG).show()
            R.id.ayuda_fr4 -> Toast.makeText(this, "Aqui se muestran los datos de el viaje, estos se pueden cambiar para editar el viaje o eliminar el viaje por completo", Toast.LENGTH_LONG).show()
            else -> super.onOptionsItemSelected(item)
        }
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }
}