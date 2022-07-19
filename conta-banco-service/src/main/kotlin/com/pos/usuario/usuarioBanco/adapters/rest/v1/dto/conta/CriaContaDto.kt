package com.pos.usuario.usuarioBanco.adapters.rest.v1.dto.conta


data class CriaContaDto(
        var id: Long ?= null,
        var nome: String ?= null ,
        var cpf: String ?= null ) {
}