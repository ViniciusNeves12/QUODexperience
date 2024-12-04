package br.com.fiap.quodvalidation

import androidx.compose.runtime.MutableState
import kotlin.math.pow

fun calcularIMC(altura: Double, peso: Double) : Double {
    return peso / (altura / 100).pow(2.0)
}

fun determinarClassificacaoIMC(imcUsuario: Double): String {
    return if(imcUsuario < 18.5) {
        "Abaixo do peso"
    } else if (imcUsuario >= 18.5 && imcUsuario < 25.0) {
        "Peso Ideal"
    } else if (imcUsuario >= 25.0 && imcUsuario < 30.0) {
        "Um pouco acima do peso"
    } else if (imcUsuario >= 30.0 && imcUsuario < 35.0) {
        "Obesidade Grau I"
    } else if (imcUsuario >= 35.0 && imcUsuario < 40.0) {
        "Obesidade Grau II"
    } else {"Obesidade Grau III"}
}