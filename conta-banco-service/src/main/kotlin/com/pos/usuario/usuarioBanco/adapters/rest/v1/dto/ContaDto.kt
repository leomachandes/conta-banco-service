package com.pos.usuario.usuarioBanco.adapters.rest.v1.dto



data class ContaDto(
        var id: Long ?= null,
        var nome: String ?= null ,
        var cpf: String ?= null ,
        var saldo: Double? = 0.0,
        var ativo: Boolean ? = true) {
}