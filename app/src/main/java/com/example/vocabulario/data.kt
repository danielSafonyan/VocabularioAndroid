package com.example.vocabulario

import com.example.vocabulario.ui.models.PracticeWordModel

object VocabularioData {
    fun getData(): List<PracticeWordModel> {
        return mutableListOf(
            PracticeWordModel(
                "Agente físico que permite ver las cosas.",
                "Necesito encender la luz para leer el libro.",
                "luz"
            ),
            PracticeWordModel(
                "Un lugar donde las personas compran y venden bienes y productos.",
                "Voy al mercado para comprar frutas y verduras.",
                "mercado"
            ),
            PracticeWordModel(
                "Una bebida caliente que la gente suele tomar por la mañana.",
                "Me gusta beber café con leche en el desayuno.",
                "café"
            ),
            PracticeWordModel(
                "Una lengua romántica que se habla en muchos países de América Latina y España.",
                "Estoy estudiando español para comunicarme mejor.",
                "español"
            ),
            PracticeWordModel(
                "Una prenda de vestir que se usa para cubrir el cuerpo.",
                "En invierno, es importante abrigarse con un abrigo.",
                "abrigo"
            )
        )
    }
}
