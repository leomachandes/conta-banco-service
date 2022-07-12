package com.pos.usuario.usuarioBanco.adapters.rest.v1.dto



data class CriaContaDto(
        var id: Long ?= null,
        var nome: String ?= null ,
        var cpf: String ?= null ) {
}