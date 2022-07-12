package com.pos.usuario.usuarioBanco.port.incoming

import com.pos.usuario.usuarioBanco.adapters.rest.v1.dto.ContaDto

interface ConsultaDadosConta {

    fun consultaDadosContaPorCpf(cpf:String) : ContaDto
}