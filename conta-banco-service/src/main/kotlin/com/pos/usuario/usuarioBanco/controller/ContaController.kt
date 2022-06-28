package com.pos.usuario.usuarioBanco.controller

import com.pos.usuario.usuarioBanco.domain.Conta
import com.pos.usuario.usuarioBanco.repository.ContaRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("conta")
class ContaController(val repository: ContaRepository) {

    @PostMapping
    fun create(@RequestBody conta: Conta) = ResponseEntity.ok(repository.save(conta))

    @GetMapping("{cpf}")
    fun findByCpf(@PathVariable cpf: String) = ResponseEntity.ok(repository.findByCpf(cpf))

    @PutMapping("{cpf}")
    fun update(@PathVariable cpf: String,@RequestBody conta: Conta): ResponseEntity<Conta>  {
        val contaDB = repository.findByCpf(cpf).get()
        val contaSalva = repository.save(contaDB.copy(nome = conta.nome, saldo = conta.saldo))
        return ResponseEntity.ok(contaSalva);
    }

    @DeleteMapping("{cpf}")
    fun inativaConta(@PathVariable cpf: String) = repository.
        findByCpf(cpf)
            .ifPresent {repository.delete(it)}

}


