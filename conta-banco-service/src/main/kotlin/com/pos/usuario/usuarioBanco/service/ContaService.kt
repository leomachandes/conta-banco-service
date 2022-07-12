package com.pos.usuario.usuarioBanco.service

import com.pos.usuario.usuarioBanco.adapters.persistence.ContaRepository
import com.pos.usuario.usuarioBanco.adapters.rest.v1.dto.AlteraContaDto
import com.pos.usuario.usuarioBanco.adapters.rest.v1.dto.ContaDto
import com.pos.usuario.usuarioBanco.adapters.rest.v1.dto.CriaContaDto
import com.pos.usuario.usuarioBanco.mappers.Mapper
import com.pos.usuario.usuarioBanco.port.incoming.ConsultaDadosConta
import com.pos.usuario.usuarioBanco.port.outcoming.ModificaDadosConta
import org.springframework.stereotype.Service

@Service
class ContaService(val repository: ContaRepository, val mapper: Mapper) : ConsultaDadosConta, ModificaDadosConta{


    override fun consultaDadosContaPorCpf(cpf: String): ContaDto {

        val contaOptional = repository.findByCpf(cpf)
        return mapper.entityToDto(contaOptional.get())
    }

    override fun cadastraNovaConta(conta: CriaContaDto): ContaDto {

        val entity = mapper.dtoToEntity(conta)
        val contaCriada = repository.save(entity)
        return mapper.entityToDto(contaCriada)
    }

    override fun alteraDadosConta(cpf: String, conta: AlteraContaDto): ContaDto {

        val contaDB = repository.findByCpf(cpf).get();
        val contaAlterada = repository.save(contaDB.copy(nome = conta.nome))
        return  mapper.entityToDto(contaAlterada)

    }

    override fun inativaConta(cpf: String) {
        val contaDB = repository.findByCpf(cpf).get();
        repository.save(contaDB.copy(ativo = false))
    }
}