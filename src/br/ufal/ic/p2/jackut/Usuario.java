package br.ufal.ic.p2.jackut;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.*;

/**
 * Classe que representa um usuário no sistema.
 */
public class Usuario {
    private String login;
    private String senha;
    private String nome;
    private ArrayList<String> friends;
    private ArrayList<String> solicitacoesDeAmizade;
    private Map<String, String> atributos;
    private Queue<Recado> caixaMensagem;

    /**
     * Construtor padrão da classe Usuario.
     */
    public Usuario(){}

    /**
     * Construtor da classe Usuario com parâmetros.
     *
     * @param nome O nome do usuário.
     * @param login O login do usuário.
     * @param senha A senha do usuário.
     */
    @JsonCreator
    public Usuario(@JsonProperty("login") String nome, @JsonProperty("senha") String login, @JsonProperty("nome") String senha) {
        this.login = login;
        this.senha = senha;
        this.nome = nome;
        this.atributos = new HashMap<>();
        this.friends = new ArrayList<>();
        this.solicitacoesDeAmizade = new ArrayList<>();
        this.caixaMensagem = new LinkedList<>();
    }

    /**
     * Verifica se a senha fornecida corresponde à senha do usuário.
     *
     * @param senha A senha a ser verificada.
     * @return true se a senha corresponder, false caso contrário.
     */
    public boolean verificaSenha(String senha) {
        return Objects.equals(senha, this.senha);
    }

    /**
     * Obtém o login do usuário.
     *
     * @return O login do usuário.
     */
    public String getLogin() {
        return login;
    }

    /**
     * Define o login do usuário.
     *
     * @param login O novo login do usuário.
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * Obtém a senha do usuário.
     *
     * @return A senha do usuário.
     */
    public String getSenha() {
        return senha;
    }

    /**
     * Define a senha do usuário.
     *
     * @param senha A nova senha do usuário.
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     * Obtém o nome do usuário.
     *
     * @return O nome do usuário.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome do usuário.
     *
     * @param nome O novo nome do usuário.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Obtém a lista de amigos do usuário.
     *
     * @return A lista de amigos do usuário.
     */
    public ArrayList<String> getFriends() {
        return friends;
    }

    /**
     * Define a lista de amigos do usuário.
     *
     * @param friends A nova lista de amigos do usuário.
     */
    public void setFriends(ArrayList<String> friends) {
        this.friends = friends;
    }

    /**
     * Obtém a lista de solicitações de amizade do usuário.
     *
     * @return A lista de solicitações de amizade do usuário.
     */
    public ArrayList<String> getSolicitacoesDeAmizade() {
        return solicitacoesDeAmizade;
    }

    /**
     * Define a lista de solicitações de amizade do usuário.
     *
     * @param solicitacoesDeAmizade A nova lista de solicitações de amizade do usuário.
     */
    public void setSolicitacoesDeAmizade(ArrayList<String> solicitacoesDeAmizade) {
        this.solicitacoesDeAmizade = solicitacoesDeAmizade;
    }

    /**
     * Obtém os atributos do usuário.
     *
     * @return Um mapa contendo os atributos do usuário.
     */
    @JsonAnyGetter
    public Map<String, String> getAtributos() {
        return atributos;
    }

    /**
     * Define um atributo do usuário.
     *
     * @param atributos O nome do atributo.
     * @param valor O valor do atributo.
     */
    @JsonAnySetter
    public void setAtributos(String atributos, String valor) {
        this.atributos.put(atributos, valor);
    }

    /**
     * Obtém o valor de um atributo específico do usuário.
     *
     * @param atributo O nome do atributo.
     * @return O valor do atributo.
     */
    @JsonAnyGetter
    public String getAtributos(String atributo) {
        return atributos.get(atributo);
    }

    /**
     * Obtém a caixa de mensagens do usuário.
     *
     * @return A caixa de mensagens do usuário.
     */
    public Queue<Recado> getCaixaMensagem() {
        return caixaMensagem;
    }

    /**
     * Define a caixa de mensagens do usuário.
     *
     * @param caixaMensagem A nova caixa de mensagens do usuário.
     */
    public void setCaixaMensagem(Queue<Recado> caixaMensagem) {
        this.caixaMensagem = caixaMensagem;
    }

    /**
     * Define ou atualiza um atributo extra do usuário.
     *
     * @param atributo O nome do atributo.
     * @param conteudo O valor do atributo.
     */
    public void setExtraAtributos(String atributo, String conteudo) {
        if (atributos.containsKey(atributo)) {
            atributos.replace(atributo, conteudo);
        }
        else
            atributos.put(atributo, conteudo);
    }

    /**
     * Obtém o valor de um atributo extra específico do usuário.
     *
     * @param atributo O nome do atributo.
     * @return O valor do atributo.
     * @throws RuntimeException Se o atributo não estiver preenchido.
     */
    public String getExtraAtributos(String atributo) {
        if(atributos.containsKey(atributo)) return atributos.get(atributo);
        else throw new RuntimeException("Atributo não preenchido.");
    }

    /**
     * Define a caixa de mensagens do usuário.
     *
     * @param mensagem A nova caixa de mensagens do usuário.
     */
    public void setMensagem(Queue<Recado> mensagem) {
        this.caixaMensagem = mensagem;
    }

    /**
     * Adiciona um amigo à lista de amigos do usuário e remove a solicitação de amizade.
     *
     * @param solicitacaoAmizade O login do amigo a ser adicionado.
     */
    public void adicionarAmigos(String solicitacaoAmizade){
        this.friends.add(solicitacaoAmizade);
        this.solicitacoesDeAmizade.remove(solicitacaoAmizade);
    }

    /**
     * Adiciona um recado à caixa de mensagens do usuário.
     *
     * @param recado O recado a ser adicionado.
     */
    public void receberMensagem(Recado recado){ this.caixaMensagem.add(recado);}
}


