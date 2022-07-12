package com.pos.usuario.usuarioBanco.mappers

import com.pos.usuario.usuarioBanco.adapters.rest.v1.dto.ContaDto
import com.pos.usuario.usuarioBanco.adapters.rest.v1.dto.CriaContaDto
import com.pos.usuario.usuarioBanco.models.ContaEntity
import org.springframework.stereotype.Component

@Component
class Mapper {

    fun entityToDto(entity:ContaEntity) :ContaDto {

        val contract = ContaDto(entity.id, entity.nome,entity.cpf,entity.saldo,entity.ativo)
        return contract;
    }

    fun dtoToEntity(dto: CriaContaDto) :ContaEntity {

        val entity = ContaEntity(dto.id, dto.nome,dto.cpf)
        return entity;
    }


}