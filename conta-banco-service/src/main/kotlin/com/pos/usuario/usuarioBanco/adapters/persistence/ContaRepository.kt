package com.pos.usuario.usuarioBanco.adapters.persistence

import com.pos.usuario.usuarioBanco.models.ContaEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface ContaRepository : JpaRepository<ContaEntity, Long> {

    fun findByCpf(cpf: String) : Optional<ContaEntity>

}