package com.pos.usuario.usuarioBanco.models

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class ContaEntity(
        @Id @GeneratedValue
        var id: Long ?= null,
        var nome: String ?= null ,
        var cpf: String ?= null ,
        var saldo: Double? = 0.0,
        var ativo: Boolean ? = true) {



}