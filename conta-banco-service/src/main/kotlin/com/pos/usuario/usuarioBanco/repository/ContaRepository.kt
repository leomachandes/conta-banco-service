package com.pos.usuario.usuarioBanco.repository

import com.pos.usuario.usuarioBanco.domain.Conta
import org.springframework.data.mongodb.repository.MongoRepository
import java.util.*

interface ContaRepository : MongoRepository<Conta, Long> {

    fun findByCpf(cpf: String) : Optional<Conta>

}