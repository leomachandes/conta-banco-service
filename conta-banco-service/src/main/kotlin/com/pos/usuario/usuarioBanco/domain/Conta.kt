package com.pos.usuario.usuarioBanco.domain

data class Conta(
        val id: Long,
        val nome: String,
        val cpf: String,
        val saldo: Double? = 0.0,
        val ativo:Boolean) {
}