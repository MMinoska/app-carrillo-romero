package com.example.app_carrillo_romero

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.HttpResponse
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
//import io.ktor.client.*
////import io.ktor.client.features.observer.*
//import io.ktor.client.request.*
//import io.ktor.http.*
//import io.ktor.client.engine.cio.*
//import kotlinx.coroutines.experimental.async
import org.json.JSONArray
import org.json.JSONObject

import java.net.URI
import java.net.URL


class NivelUnoActivity : AppCompatActivity() {
    var sustantivo: List<String> = listOf("El libro ")
    var prep: List<String> = listOf("de Lenguajes ")
    var prep2: List<String> = listOf("de nivel ")
    var adjet: List<String> = listOf("avanzado ")
    var verbo: List<String> = listOf("fue aceptado ")
    var prep_art_sus: List<String> = listOf("por los profesores ")
    var prep_sus: List<String> = listOf("de Sistemas.")
    var random = 0
    var ordenada: String = ""
    var nuevo: String = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nivel_uno)

        val textView = findViewById<TextView>(R.id.prueba)
        val queue = Volley.newRequestQueue(this)
//        val url  = "http://192.168.100.55/conexion_carrillo_romero/nivelUno.php"
        val url ="https://www.google.com/"
        var prueba = URL(url).readText()
        println(prueba)
//        val client = HttpClient()
//
//        val response: HttpResponse = client.request(url) {
//            val method = HttpMethod.Get
//        }

//        prueba(url)


//
//
//        val htmlContent = HttpClient.request<String>{
//            url("https://en.wikipedia.org/wiki/Main_Page")
//            method = HttpMethod.Get
//        }




//        val stringRequest = StringRequest(Request.Method.GET,url, Response.Listener<String>{ stringResponse ->
//            val jsonArray = JSONArray(stringResponse)
//            println(jsonArray)
////            for(i in 0 until jsonArray.length()){
////                val jsonObject = JSONObject(jsonArray.getString(i))
//////                var text = jsonObject.get("sustantivo")
////                var text = "HOLAAA"
////                textView.text = text.toString()
////                Toast.makeText(applicationContext,text.toString(),Toast.LENGTH_LONG).show()
////            }
//        },
//            Response.ErrorListener{ volleyError ->
//            println("Fallo")
//        }
//        )
//        queue.add(stringRequest)


        logica(random)

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

    private fun logica(numero: Int){
        ordenada = sustantivo[random]+prep[random]+prep2[random]+adjet[random]+verbo[random]+prep_art_sus[random]+prep_sus[random]
        var ran1: TextView = findViewById(R.id.randomUnoText) as TextView
        ran1.text = sustantivo[random]
        var ran2: TextView = findViewById(R.id.randomDosText) as TextView
        ran2.text = prep[random]
        var ran3: TextView = findViewById(R.id.randomTresText) as TextView
        ran3.text = prep2[random]
        var ran4: TextView = findViewById(R.id.randomCuatroText) as TextView
        ran4.text = adjet[random]
        var ran5: TextView = findViewById(R.id.randomCincoText) as TextView
        ran5.text = verbo[random]
        var ran6: TextView = findViewById(R.id.randomSeisText) as TextView
        ran6.text = prep_art_sus[random]
        var ran7: TextView = findViewById(R.id.randomSieteText) as TextView
        ran7.text = prep_sus[random]

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

//    private fun prueba(url:String): Void{
//        val httpClient: HttpClient = HttpClient()
//        val response = async{ httpClient.get<HttpResponse>(url) {
//            headers {
//                append("Accept", "application/json")
//            }
//        }
//        }
//    }
}