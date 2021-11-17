package com.example.app_carrillo_romero

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest

import com.android.volley.toolbox.Volley
import org.json.JSONArray
import org.json.JSONObject
import com.android.volley.VolleyError

import com.android.volley.toolbox.JsonArrayRequest





class NivelUnoActivity : AppCompatActivity() {
    var ordenada: String = ""
    var nuevo: String = ""
    val url = "http://192.168.100.55/conexion_carrillo_romero/nivelUno.php"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nivel_uno)

        logica(url)

        val verify: Button = findViewById(R.id.Verificarbutton) as Button
        verify.setOnClickListener {
            var usuario: EditText = findViewById(R.id.oracionText) as EditText
            nuevo = usuario.text.toString()
            when {
                nuevo.isEmpty() -> {
                    Toast.makeText(this, "Ingrese la oración !",
                        Toast.LENGTH_SHORT).show()
                }
                else -> {
                    verificar(nuevo)
                }
            }
        }
    }

    private fun logica(url: String){
        val queue = Volley.newRequestQueue(this)
        val stringRequest = StringRequest(Request.Method.GET,url,
            { response ->
                val jsonArray = JSONArray(response)
                val i = (0..jsonArray.length()).random()
                val jsonObject = JSONObject(jsonArray.getString(i))
                var sus = jsonObject.get("sustantivo")
                var prep = jsonObject.get("prep")
                var prep_dos = jsonObject.get("prep_dos")
                var adj = jsonObject.get("adjetivo")
                var verbo = jsonObject.get("verbo")
                var prep_art_sus = jsonObject.get("prep_art_sus")
                var prep_sus = jsonObject.get("prep_sus")
                findViewById<TextView>(R.id.randomUnoText).text =sus.toString()
                findViewById<TextView>(R.id.randomDosText).text = prep.toString()
                findViewById<TextView>(R.id.randomTresText).text = prep_dos.toString()
                findViewById<TextView>(R.id.randomCuatroText).text = adj.toString()
                findViewById<TextView>(R.id.randomCincoText).text = verbo.toString()
                findViewById<TextView>(R.id.randomSeisText).text = prep_art_sus.toString()
                findViewById<TextView>(R.id.randomSieteText).text = prep_sus.toString()

            },
            { error ->
                println("Falla")
            })
        queue.add(stringRequest)

    }

    private fun verificar(oracion_usuario: String){
        val response: TextView = findViewById(R.id.responseText) as TextView
        when {
            oracion_usuario == ordenada ->{
                response.text = "Usted ha ganado !"
            } else->{
                response.text = "Intentelo nuevamente !"
            }
        }
    }

}