package com.pos.usuario.usuarioBanco.adapters.rest.v1.controller

import com.pos.usuario.usuarioBanco.adapters.rest.v1.dto.operacao.DepositoDto
import com.pos.usuario.usuarioBanco.adapters.rest.v1.dto.operacao.RetornoDto
import com.pos.usuario.usuarioBanco.adapters.rest.v1.dto.operacao.SaqueDto
import com.pos.usuario.usuarioBanco.port.outcoming.OperacoesConta
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("operacoes")
class OperacoesContaController(val service: OperacoesConta) {


    @PostMapping("/depositar")
    fun depositar(@RequestBody dto: DepositoDto) : ResponseEntity<RetornoDto> {
        val retorno = dto.cpf?.let { dto.valor?.let { it1 -> service.depositar(it, it1) } }
        return ResponseEntity.ok(retorno);


    }

    @PostMapping("/sacar")
    fun sacar(@RequestBody dto: SaqueDto) :ResponseEntity<RetornoDto> {

        val retorno = dto.cpf?.let { dto.valor?.let { it1 -> service.sacar(it, it1) } }
        return ResponseEntity.ok(retorno);

    }


}