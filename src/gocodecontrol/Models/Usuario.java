/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gocodecontrol.Models;

/**
 *
 * @author Andre Nascimento
 */
public class Usuario {
    
    private int cd_codigo;
    private String nome_usuario;
    private String nm_acesso;
    private String senha;
    private int cd_permissao;
     
    public int getCd_permissao(){
        return cd_permissao;
    }

    public int getCd_codigo() {
        return cd_codigo;
    }

    public void setCd_codigo(int cd_codigo) {
        this.cd_codigo = cd_codigo;
    }

    public String getNome_usuario() {
        return nome_usuario;
    }

    public void setNome_usuario(String nome_usuario) {
        this.nome_usuario = nome_usuario;
    }

    public String getNm_acesso() {
        return nm_acesso;
    }

    public void setNm_acesso(String nm_acesso) {
        this.nm_acesso = nm_acesso;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setCd_permissao(int cd_permissao) {
        this.cd_permissao = cd_permissao;
    }
     
}
