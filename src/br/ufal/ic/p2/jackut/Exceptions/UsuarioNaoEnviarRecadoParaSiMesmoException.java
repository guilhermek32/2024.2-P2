package br.ufal.ic.p2.jackut.Exceptions;

/**
 * Exceção lançada quando um usuário tenta enviar um recado para si mesmo.
 */
public class UsuarioNaoEnviarRecadoParaSiMesmoException extends RuntimeException {
    public UsuarioNaoEnviarRecadoParaSiMesmoException() {
        super("Usuário não pode enviar recado para si mesmo.");
    }
}
