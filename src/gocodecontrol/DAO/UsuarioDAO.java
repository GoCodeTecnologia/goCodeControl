/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gocodecontrol.DAO;

import gocodecontrol.GUI.Login;
import gocodecontrol.Models.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Andre Nascimento
 */
public class UsuarioDAO {
    
    private Conexao conexao;
    private Usuario usuario;
    
    public UsuarioDAO(){
    
        try {
            this.conexao = new Conexao();
        } catch (ClassNotFoundException | SQLException ex) { 
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    
    public boolean autentica(String acesso, String senha) throws SQLException{
        String sql = "select * from usuario where nm_acesso = ? and senha = ? limit 1;";
        PreparedStatement ps = this.conexao.getConexao().prepareStatement(sql);
        ps.setString(1, acesso);    
        ps.setString(2, senha);        
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
                Usuario usuarioClass = new Usuario();
                usuarioClass.setCd_codigo(rs.getInt("cd_usuario"));
                usuarioClass.setNome_usuario(rs.getString("nome_usuario"));
                usuarioClass.setNm_acesso(rs.getString("nm_acesso"));
                usuarioClass.setSenha(rs.getString("senha"));
                usuarioClass.setCd_permissao(rs.getInt("cd_permissao"));
                this.usuario = usuarioClass; 
                return true;
        }
       
        return false;
    }
    
    public String nomeUsuario(int codigo) throws SQLException{
        String sql = "select nome_usuario from usuario where cd_usuario = ?;";
        PreparedStatement ps = this.conexao.getConexao().prepareStatement(sql);
        ps.setInt(1, codigo);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            return rs.getString("nome_usuario");
        }
        return null;
    }

    public ArrayList<Usuario> buscarTodos() {
        try {
            String sql = "SELECT * from usuario;";
            PreparedStatement ps = this.conexao.getConexao().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ArrayList<Usuario> arrayUsuarios = new ArrayList<>();
            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setCd_codigo(rs.getInt("cd_usuario"));
                usuario.setCd_permissao(rs.getInt("cd_permissao"));
                usuario.setNm_acesso(rs.getString("nm_acesso"));
                usuario.setNome_usuario(rs.getString("nome_usuario"));
                usuario.setSenha(rs.getString("senha"));
                arrayUsuarios.add(usuario);
            }
            return arrayUsuarios;

        } catch (NumberFormatException | SQLException e) {
            return null;
        }
    }
    
    public Usuario getUsuario() {
        return usuario;
    }
    
    
    
}
