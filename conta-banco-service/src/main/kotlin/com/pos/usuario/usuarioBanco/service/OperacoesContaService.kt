package com.pos.usuario.usuarioBanco.service

import com.pos.usuario.usuarioBanco.adapters.rest.v1.dto.operacao.RetornoDto
import com.pos.usuario.usuarioBanco.adapters.rest.v1.dto.operacao.SolicitaOperacaoDto
import com.pos.usuario.usuarioBanco.port.incoming.ConsultaDadosConta
import com.pos.usuario.usuarioBanco.port.outcoming.OperacoesConta
import org.codehaus.jackson.map.ObjectMapper
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import java.math.BigDecimal

@Service
class OperacoesContaService( val rabbitTemplate: RabbitTemplate, val consultaDadosContaService: ConsultaDadosConta):OperacoesConta {

    @Value("#{fila.deposita}")
    lateinit var  filaDeposito :String

    @Value("#{fila.saque}")
    lateinit var  filaSaque :String

    override fun depositar(cpf: String, valor: BigDecimal): RetornoDto {
        val conta = consultaDadosContaService.consultaDadosContaPorCpf(cpf);

        enviar(conta.id, valor, filaDeposito)
        return  RetornoDto("Deposito efetuado com sucesso!", conta.id)


    }

    override fun sacar(cpf: String, valor: BigDecimal): RetornoDto {
        val conta = consultaDadosContaService.consultaDadosContaPorCpf(cpf);
        return  RetornoDto("Deposito efetuado com sucesso!", conta.id)
    }

    private fun enviar(idConta:Long?, valor: BigDecimal, fila:String) {

        val deposito = SolicitaOperacaoDto(idConta, valor);
        val json = ObjectMapper().writeValueAsString(deposito);
        rabbitTemplate.convertAndSend(json, fila);

    }
}