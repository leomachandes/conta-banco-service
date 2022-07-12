package com.pos.usuario.usuarioBanco.port.outcoming

import com.pos.usuario.usuarioBanco.adapters.rest.v1.dto.AlteraContaDto
import com.pos.usuario.usuarioBanco.adapters.rest.v1.dto.ContaDto
import com.pos.usuario.usuarioBanco.adapters.rest.v1.dto.CriaContaDto

interface ModificaDadosConta {

    fun cadastraNovaConta(conta:CriaContaDto) : ContaDto

    fun alteraDadosConta(cpf:String, conta: AlteraContaDto) : ContaDto

    fun inativaConta(cpf: String)
}