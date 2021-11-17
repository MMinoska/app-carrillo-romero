package com.example.app_carrillo_romero.model

class NivelUno {

    companion object{
        // Tabla del Nivel 1
        const val CLOUD_FIRE_STORE_PATH = "NIVEL_UNO"
        // Atributos de la tabla
        const val ID_ORACION = "ID_ORACION"
        const val SUSTANTIVO = "SUSTANTIVO"
        const val PREP = "PREP"
        const val PREP_DOS = "PREP_DOS"
        const val ADJETIVO = "ADJETIVO"
        const val VERBO = "VERBO"
        const val PREP_ART_SUS = "PREP_ART_SUS"
        const val PREP_SUS = "PREP_SUS"
        const val ID_USER = "ID_USER"
    }
    var id_oracion = 0
    var sustantivo = ""
    var prep = ""
    var prep_dos = ""
    var adjetivo = ""
    var verbo = ""
    var prep_art_sus = ""
    var prep_sus = ""
    var id_user = 0

    fun toDictionary(): MutableMap<String, Any>{
        val map = mutableMapOf<String,Any>()
        map[ID_ORACION] = id_oracion
        map[SUSTANTIVO] = sustantivo
        map[PREP] = prep
        map[PREP_DOS] = prep_dos
        map[ADJETIVO] = adjetivo
        map[VERBO] = verbo
        map[PREP_ART_SUS] = prep_art_sus
        map[PREP_SUS] = prep_sus
        map[ID_USER] = id_user

        return map
    }

    fun parsing(map: MutableMap<String,Any>){
        id_oracion = map[ID_ORACION] as Int
        sustantivo = map[SUSTANTIVO]as String
        prep = map[PREP] as String
        prep_dos = map[PREP_DOS] as String
        adjetivo = map[ADJETIVO] as String
        verbo = map[VERBO] as String
        prep_art_sus = map[PREP_ART_SUS] as String
        prep_sus = map[PREP_SUS] as String
        id_user = map[ID_USER] as Int
    }
}