package br.ufal.ic.p2.jackut;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Classe que representa um recado no sistema.
 */
public class Recado {
    private String remetente;
    private String mensagem;

    /**
     * Construtor da classe Recado com parâmetros.
     *
     * @param remetente O remetente do recado.
     * @param mensagem A mensagem do recado.
     */
    public Recado(){}
    @JsonCreator
    public Recado(@JsonProperty("remetente") String remetente, @JsonProperty("mensagem") String mensagem) {
        this.remetente = remetente;
        this.mensagem = mensagem;
    }

    /**
     * Obtém o remetente do recado.
     *
     * @return O remetente do recado.
     */
    public String getRemetente() {return remetente;}

    /**
     * Obtém a mensagem do recado.
     *
     * @return A mensagem do recado.
     */
    public String getMensagem() {return mensagem;}

}
