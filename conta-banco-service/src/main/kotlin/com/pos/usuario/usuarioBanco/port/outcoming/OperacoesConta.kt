package com.pos.usuario.usuarioBanco.port.outcoming

import com.pos.usuario.usuarioBanco.adapters.rest.v1.dto.operacao.RetornoDto
import java.math.BigDecimal


interface OperacoesConta {

    fun depositar(cpf: String, valor: BigDecimal) : RetornoDto

    fun sacar(cpf: String, valor: BigDecimal) : RetornoDto

}