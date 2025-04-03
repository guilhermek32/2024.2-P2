package br.ufal.ic.p2.jackut.Exceptions;

/**
 * Exceção lançada quando um usuário tenta adicionar outro usuário como amigo,
 * mas já existe um convite pendente.
 */
public class AmizadePendenteException extends RuntimeException {
    public AmizadePendenteException() {
        super("Usuário já está adicionado como amigo, esperando aceitação do convite.");
    }
}
