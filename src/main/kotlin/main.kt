//VARIABLES DECLARADAS
const val RESPUESTA_AFIRMATIVA ="✅"
const val  RESPUESTA_NEGATIVA = "❌"
const val RESPUESTA_DUDOSA ="¿?"


//UNIMOS LAS RESPUESTAS CON LOS VALORES
val respuestas = mapOf(
    "Si" to RESPUESTA_AFIRMATIVA,
    "Es cierto" to RESPUESTA_AFIRMATIVA,
    "Totalmente" to RESPUESTA_AFIRMATIVA,
    "Sin duda" to RESPUESTA_AFIRMATIVA,
    "Pregunta en otro momento" to RESPUESTA_DUDOSA,
    "No puedo decirte en este momento" to RESPUESTA_DUDOSA,
    "Puede que si o puede que no" to RESPUESTA_DUDOSA,
    "Tal vez" to RESPUESTA_DUDOSA,
    "No va a suceder" to RESPUESTA_NEGATIVA,
    "No cuentes con ello" to RESPUESTA_NEGATIVA,
    "Definitivamente no" to RESPUESTA_NEGATIVA,
    "No creo" to RESPUESTA_NEGATIVA,

)

fun main(args: Array<String>) {
    println("Hola soy tu magica bola. Cual de estas opciones deseas realizar?")
    println("1) Una pregunta ")
    println("2) Revisar todas las respuestas ")
    println("3) Salir")

    val valorIngresado = readLine()
    when(valorIngresado){
        "1" -> realizarPregunta()
        "2" -> revisarRespuestas()
        "3" -> salir()
        else -> mostrarError()
    }
}

    fun realizarPregunta(){
        println("Que pregunta deseas realizar")
        readLine()
        println("Asi que esa era tu pregunta... La respuesta a eso es:")

        val respuestaGenerada = respuestas.keys. random()
        println(respuestaGenerada)

    }

    fun revisarRespuestas(){
        println("Selecciona una opcion")
        println("1) Revisar todas las respuestas")
        println("2) Revisar respuestas afirmativas")
        println("3) Revisar respuestas negativas")
        println("4) Revisar respuestas dudosas")

        val opcionIngresada = readLine()
        when (opcionIngresada){
            "1" -> revisarRespuestasPorTipo()
            "2" -> revisarRespuestasPorTipo(tipoDeRespuesta = RESPUESTA_AFIRMATIVA)
            "3" -> revisarRespuestasPorTipo(tipoDeRespuesta = RESPUESTA_NEGATIVA)
            "4" -> revisarRespuestasPorTipo(tipoDeRespuesta = RESPUESTA_DUDOSA)
            else  ->  println("Respuesta no valida, Adios")
        }
    }

    fun revisarRespuestasPorTipo( tipoDeRespuesta : String = "TODOS"  ){
        when (tipoDeRespuesta){
            "TODOS" -> respuestas.keys.forEach{ respuesta -> println(respuesta) }


            RESPUESTA_AFIRMATIVA -> respuestas.filterValues { values -> values == RESPUESTA_AFIRMATIVA }
                .also { respuestasPositivas ->  println(respuestasPositivas.keys) }


            RESPUESTA_NEGATIVA -> respuestas.filterValues { values -> values == RESPUESTA_NEGATIVA }
                .also { respuestasNegativa ->  println(respuestasNegativa.keys) }


            RESPUESTA_DUDOSA -> respuestas.filterValues { values -> values == RESPUESTA_DUDOSA }
                .also { respuestasDudosa ->  println(respuestasDudosa.keys) }
        }
    }

    fun salir(){

    }

    fun mostrarError(){

    }