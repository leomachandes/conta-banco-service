package com.pos.usuario.usuarioBanco.adapters.rest.v1.dto.operacao

import java.math.BigDecimal


data class SaqueDto (

    var cpf:String ?= null,
    var valor:BigDecimal ?= null

)

