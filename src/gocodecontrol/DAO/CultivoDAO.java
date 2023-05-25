/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gocodecontrol.DAO;

import gocodecontrol.Models.Cultivo;
import gocodecontrol.Models.Produto;
import java.awt.Color;
import static java.lang.Integer.parseInt;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Andre Nascimento
 */
public class CultivoDAO {
    private Conexao conn;

    public CultivoDAO(){
        try {
            this.conn = new Conexao();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList<Cultivo> buscarTodos() {
        try {
            String sql = "select * from cultivo;";
            PreparedStatement ps = this.conn.getConexao().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ArrayList<Cultivo> arrayCultivo = new ArrayList<>();
            while (rs.next()) {
                Cultivo c = new Cultivo();
                c.setCd_cultivo(rs.getInt("cd_cultivo"));
                c.setDt_inicio(rs.getString("dt_inicio"));
                c.setDt_colheita(rs.getString("dt_colheita"));
                c.setAndamento(rs.getString("andamento"));
                c.setCd_produto(rs.getInt("cd_produto"));
                c.setCd_talhao(rs.getInt("cd_talhao"));
                c.setCd_usuario(rs.getInt("cd_usuario"));
                arrayCultivo.add(c);
            }
            return arrayCultivo;

        } catch (NumberFormatException | SQLException e) {
            return null;
        }
    }
        
    public boolean inserirCultivo(
            String dt_inicio, String dt_colheita,
            String andamento, String usuario, String produto, String talhao
    ){
    
        String sql = "insert into cultivo(dt_inicio,dt_colheita,andamento,cd_produto,cd_talhao,cd_usuario)"
                + "values(?,?,?,?,?,?);";
        try {
           PreparedStatement ps = this.conn.getConexao().prepareStatement(sql);
           ps.setString(1, dt_inicio);
           ps.setString(2, dt_colheita);
           ps.setString(3, andamento);
           ps.setInt(4, parseInt(produto));
           ps.setInt(5, parseInt(talhao));
           ps.setInt(6, parseInt(usuario));
           int retorno = ps.executeUpdate();
           this.conn.confirmar();
           return retorno > 0;
            
        } catch (SQLException ex) {
            Logger.getLogger(CultivoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
    }
    
    public boolean apagarCultivo(int codigo){
    
        String sql = "delete from cultivo where cd_cultivo = ?;";
        try {
            PreparedStatement ps = this.conn.getConexao().prepareStatement(sql);
            ps.setInt(1, codigo);
            int retorno = ps.executeUpdate();
            this.conn.confirmar();
            return retorno > 0;
        } catch (SQLException ex) {
            Logger.getLogger(CultivoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }        
    }
    
    private DefaultCategoryDataset listaQuantidadeCultivoPorProduto() throws SQLException{
        ArrayList<Cultivo> listaCultivo = this.buscarTodos();
        DefaultCategoryDataset data = new DefaultCategoryDataset();
        HashMap<Integer, Integer> cultivoPorProduto = new HashMap<Integer, Integer>();
        ProdutoDAO produto = new ProdutoDAO();
        UsuarioDAO usuario = new UsuarioDAO();
        for(Cultivo cultivo: listaCultivo){   
            if(cultivoPorProduto.containsKey(cultivo.getCd_produto())){
               cultivoPorProduto. put(cultivo.getCd_produto(), cultivoPorProduto.get(cultivo.getCd_produto()) + 1);        
            }else{
               cultivoPorProduto.put(cultivo.getCd_produto(), 1);
            }
        }     
        
        for(Cultivo cultivo: listaCultivo){ 
            data.setValue(cultivoPorProduto.get(cultivo.getCd_produto()), "Cultivo", produto.nomeProduto(cultivo.getCd_produto()));
        }
                      
        return data;
    }
    
    private DefaultCategoryDataset listaQuantidadeCultivoPorProdutor() throws SQLException{
        ArrayList<Cultivo> listaCultivo = this.buscarTodos();
        DefaultCategoryDataset data = new DefaultCategoryDataset();
        HashMap<Integer, Integer> CultivoPorProdutor = new HashMap<Integer, Integer>();
        ProdutoDAO produto = new ProdutoDAO();
        UsuarioDAO usuario = new UsuarioDAO();
        for(Cultivo cultivo: listaCultivo){   
            if(CultivoPorProdutor.containsKey(cultivo.getCd_usuario())){
               CultivoPorProdutor. put(cultivo.getCd_usuario(), CultivoPorProdutor.get(cultivo.getCd_usuario()) + 1);        
            }else{
               CultivoPorProdutor.put(cultivo.getCd_usuario(), 1);
            }
        }     
        
        for(Cultivo cultivo: listaCultivo){ 
                data.setValue(CultivoPorProdutor.get(cultivo.getCd_usuario()), "Cultivo", usuario.nomeUsuario(cultivo.getCd_usuario()));
        }
                      
        return data;
    }
    
    private DefaultCategoryDataset listaQuantidadeCultivoPorProdutorEProduto() throws SQLException{
        ArrayList<Cultivo> listaCultivo = this.buscarTodos();
        DefaultCategoryDataset data = new DefaultCategoryDataset();
        HashMap<Integer, HashMap<String, Integer>> CultivoPorProdutor = new HashMap<>();
        ProdutoDAO produto = new ProdutoDAO();
        UsuarioDAO usuario = new UsuarioDAO();
        for(Cultivo cultivo: listaCultivo){   
            if(CultivoPorProdutor.containsKey(cultivo.getCd_usuario())){
                HashMap<String, Integer> produtos = CultivoPorProdutor.get(cultivo.getCd_usuario());
                if(produtos.containsKey(produto.nomeProduto(cultivo.getCd_produto()))){
                    produtos.put(produto.nomeProduto(cultivo.getCd_produto()), 
                        produtos.get(produto.nomeProduto(cultivo.getCd_produto())) + 1);
                    CultivoPorProdutor.put(cultivo.getCd_usuario(), produtos);   
                }else{
                    produtos.put(produto.nomeProduto(cultivo.getCd_produto()), 1);
                    CultivoPorProdutor.put(cultivo.getCd_usuario(), produtos);
                }
            }else{
                HashMap<String, Integer> produtos = new HashMap<>();
                produtos.put(produto.nomeProduto(cultivo.getCd_produto()), 1);
                CultivoPorProdutor.put(cultivo.getCd_usuario(), produtos);
            }
        }     
        
        Iterator i = CultivoPorProdutor.entrySet().iterator();
        while(i.hasNext()) {
           
            Map.Entry<Integer, HashMap<String, Integer>> entrada = (Map.Entry<Integer, HashMap<String, Integer>>)i.next();
            if(entrada.getValue().size() > 1){
                Iterator j = entrada.getValue().entrySet().iterator();
                while(j.hasNext()) {
                    Map.Entry<String, Integer> valores = (Map.Entry<String, Integer>)j.next();
                    data.setValue(valores.getValue(),
                            usuario.nomeUsuario(entrada.getKey()), valores.getKey());
                }
            }else{
                Iterator v = entrada.getValue().entrySet().iterator();
                while(v.hasNext()) {
                    Map.Entry<String, Integer> valores = (Map.Entry<String, Integer>)v.next();
                    data.setValue(valores.getValue(),
                            usuario.nomeUsuario(entrada.getKey()), valores.getKey());
                }
                
            }
              
        }
       
        return data;
    }
    
    public JFreeChart graficoBarPorProduto() throws SQLException{
        DefaultCategoryDataset data = this.listaQuantidadeCultivoPorProduto();
        JFreeChart graficoBarra = ChartFactory.createBarChart("Quantidade de cultivos", "Quantidade", "Quantidade", data, PlotOrientation.VERTICAL, true, true, true);        
        CategoryPlot parametrizacaoGrafico = graficoBarra.getCategoryPlot();
	parametrizacaoGrafico.setNoDataMessage("Não há valores de resultado para exibição.");  
	parametrizacaoGrafico.setBackgroundPaint(Color.black);
        return graficoBarra;
    }
    
    public JFreeChart graficoBarPorProdutor() throws SQLException{
        DefaultCategoryDataset data = this.listaQuantidadeCultivoPorProdutor();
        JFreeChart graficoBarra = ChartFactory.createBarChart("Quantidade de cultivos", "Quantidade", "Quantidade", data, PlotOrientation.VERTICAL, true, true, true);        
        CategoryPlot parametrizacaoGrafico = graficoBarra.getCategoryPlot();
	parametrizacaoGrafico.setNoDataMessage("Não há valores de resultado para exibição.");  
	parametrizacaoGrafico.setBackgroundPaint(Color.black);
        return graficoBarra;
    }
    
    public JFreeChart graficoBarPorProdutorEProduto() throws SQLException{
        DefaultCategoryDataset data = this.listaQuantidadeCultivoPorProdutorEProduto();
        JFreeChart graficoBarra = ChartFactory.createBarChart("Quantidade de cultivos", "Quantidade", "Quantidade", data, PlotOrientation.VERTICAL, true, true, true);        
        CategoryPlot parametrizacaoGrafico = graficoBarra.getCategoryPlot();
	parametrizacaoGrafico.setNoDataMessage("Não há valores de resultado para exibição.");  
	parametrizacaoGrafico.setBackgroundPaint(Color.black);
        return graficoBarra;
    }
}
