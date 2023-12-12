package com.dra.frontend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

import com.dra.frontend.dto.MensagemDTO;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Mensagem {
    private Long id;
    private String assunto;
    private Contato emissor;
    private Contato receptor;
    private String conteudo;
    private String data;

        public String formatDateHour(String dataHora) {
        OffsetDateTime odt = OffsetDateTime.parse(dataHora);
        LocalDateTime localDateTime = odt.toLocalDateTime();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        String formattedDateTime = localDateTime.format(formatter);
        return formattedDateTime;
    }

    public Mensagem(MensagemDTO mensagemDTO) {
        this.emissor = mensagemDTO.getEmissor();
        this.receptor = mensagemDTO.getReceptor();
        this.conteudo = mensagemDTO.getConteudo();
        this.assunto = mensagemDTO.getAssunto();
        this.data = formatDateHour(mensagemDTO.getData());
        this.id = mensagemDTO.getId();
    }

    public Mensagem(String assunto, String conteudo, String receptor){
        this.assunto = assunto;
        this.conteudo = conteudo;
        this.receptor = new Contato();
        this.receptor.setEmail(receptor);
    }
}
