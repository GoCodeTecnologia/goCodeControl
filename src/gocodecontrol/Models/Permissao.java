/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gocodecontrol.Models;

/**
 *
 * @author Andre Nascimento
 */
public class Permissao {
 
    private int cd_permissao;
    private String nm_permissao;
    
    public Permissao(){
        
    }
    public int getCd_permissao() {
        return cd_permissao;
    }

    public void setCd_permissao(int cd_permissao) {
        this.cd_permissao = cd_permissao;
    }

    public String getNm_permissao() {
        return nm_permissao;
    }

    public void setNm_permissao(String nm_permissao) {
        this.nm_permissao = nm_permissao;
    }
    
}
