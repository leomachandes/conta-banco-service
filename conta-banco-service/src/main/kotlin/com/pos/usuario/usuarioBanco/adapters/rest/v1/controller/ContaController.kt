package com.pos.usuario.usuarioBanco.adapters.rest.v1.controller

import com.pos.usuario.usuarioBanco.adapters.rest.v1.dto.conta.AlteraContaDto
import com.pos.usuario.usuarioBanco.adapters.rest.v1.dto.conta.ContaDto
import com.pos.usuario.usuarioBanco.adapters.rest.v1.dto.conta.CriaContaDto
import com.pos.usuario.usuarioBanco.port.incoming.ConsultaDadosConta
import com.pos.usuario.usuarioBanco.port.outcoming.ModificaDadosConta
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("conta")


class ContaController(val consultaService: ConsultaDadosConta, val modificaService: ModificaDadosConta) {


    @PostMapping
    fun create(@RequestBody conta: CriaContaDto) = ResponseEntity.ok(modificaService.cadastraNovaConta(conta))

    @GetMapping("/{cpf}")
    fun findByCpf(@PathVariable cpf: String) = ResponseEntity.ok(consultaService.consultaDadosContaPorCpf(cpf))

    @PutMapping("/{cpf}")
    fun update(@PathVariable cpf: String,@RequestBody conta: AlteraContaDto): ResponseEntity<ContaDto>  {
        val contaAlterada = modificaService.alteraDadosConta(cpf,conta)
        return ResponseEntity.ok(contaAlterada);
    }

    @PutMapping("/{cpf}/inativarConta")
    fun inativaConta(@PathVariable cpf: String) {

        modificaService.inativaConta(cpf)
    }


}


