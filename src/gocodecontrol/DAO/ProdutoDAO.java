package gocodecontrol.DAO;

import gocodecontrol.Models.Produto;
import java.awt.Color;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.util.Rotation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

public class ProdutoDAO {
    private Conexao conn;
    
    public ProdutoDAO() {
        try {
            this.conn = new Conexao();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String nomeProduto(int codigo) throws SQLException{
        String sql = "select nm_produto from produto where cd_produto = ?;";
        PreparedStatement ps = this.conn.getConexao().prepareStatement(sql);
        ps.setInt(1, codigo);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            return rs.getString("nm_produto");
        }
        return null;
    }
    
    public ArrayList<Produto> buscarTodos() {
        try {
            String sql = "SELECT cd_produto, nm_produto, valor, ativo, qtde FROM produto";
            PreparedStatement ps = this.conn.getConexao().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ArrayList<Produto> arrayProduto = new ArrayList<>();
            while (rs.next()) {
                Produto p = new Produto();
                p.setCd_produto(rs.getInt("cd_produto"));
                p.setNm_produto(rs.getString("nm_produto"));
                p.setValor(Double.parseDouble(rs.getString("valor")));
                p.setAtivo(rs.getBoolean("ativo"));
                p.setQtde(rs.getInt("qtde"));
                arrayProduto.add(p);
            }
            return arrayProduto;

        } catch (NumberFormatException | SQLException e) {
            return null;
        }
    }
    
    private PieDataset listaStatusProduto() {  
        ArrayList<Produto> listaProdutos = this.buscarTodos();
        DefaultPieDataset data = new DefaultPieDataset();  
        int ativos = 0;
        int inativos = 0;
        for(Produto produto: listaProdutos){
            if(produto.isAtivo()){
                ativos += 1; 
            }else{
                inativos += 1;
            }
        }
        data.setValue("Ativos", ativos);
        data.setValue("Inativos", inativos);
        return data;
    } 
    
    private DefaultCategoryDataset listaQuantidadeProdutos(){
        ArrayList<Produto> listaProdutos = this.buscarTodos();
        DefaultCategoryDataset data = new DefaultCategoryDataset();
        for(Produto produto: listaProdutos){    
            data.setValue(produto.getQtde(), "Quantidade", produto.getNm_produto());
        }
        
        return data;
    }
        
    public JFreeChart graficoPieProduto(){
        PieDataset data = this.listaStatusProduto();
        JFreeChart chart = ChartFactory.createPieChart3D("Produtos", data, true, true, false);         
        chart.getPlot().setForegroundAlpha(0.5f);
	PiePlot parametrizacaoGrafico = (PiePlot) chart.getPlot(); 
	parametrizacaoGrafico.setLabelGenerator(new StandardPieSectionLabelGenerator("Quantidade - {1} \n Porcentagem - {2}"));
	parametrizacaoGrafico.setNoDataMessage("Não há valores de resultado para exibição.");  
	parametrizacaoGrafico.setLabelBackgroundPaint(Color.white);
	parametrizacaoGrafico.setBackgroundPaint(Color.black);		
	parametrizacaoGrafico.setDirection(Rotation.CLOCKWISE);
	parametrizacaoGrafico.setLabelShadowPaint(Color.red);
        parametrizacaoGrafico.setSectionPaint(0, Color.BLACK);
        parametrizacaoGrafico.setSectionPaint(1, Color.CYAN);
               
        return chart;
    }
    
    public JFreeChart graficoBarProduto(){
        DefaultCategoryDataset data = this.listaQuantidadeProdutos();
        JFreeChart graficoBarra = ChartFactory.createBarChart("Produtos", "Quantidade de Produtos", "Quantidade", data, PlotOrientation.VERTICAL, true, true, true);        
        CategoryPlot parametrizacaoGrafico = graficoBarra.getCategoryPlot();
	parametrizacaoGrafico.setNoDataMessage("Não há valores de resultado para exibição.");  
	parametrizacaoGrafico.setBackgroundPaint(Color.black);
        return graficoBarra;
    }
    
    public boolean inserir(Produto prod) {
        try {

            String sql = "INSERT INTO produto (nm_produto, valor, ativo, qtde)VALUES (?, ?, ?, ?)";
            PreparedStatement ps = this.conn.getConexao().prepareStatement(sql);

            ps.setString(1, prod.getNm_produto());
            ps.setDouble(2, prod.getValor());
            ps.setBoolean(3, prod.isAtivo());
            ps.setInt(4, prod.getQtde());
            ps.execute();

            this.conn.confirmar();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
}