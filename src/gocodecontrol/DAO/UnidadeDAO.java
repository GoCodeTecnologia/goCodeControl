/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gocodecontrol.DAO;

import gocodecontrol.Models.Talhao;
import gocodecontrol.Models.Unidade;
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

/**
 *
 * @author Andre Nascimento
 */
public class UnidadeDAO {
    
    private Conexao conn;

    public UnidadeDAO(){
        try {
            this.conn = new Conexao();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList<Unidade> buscarTodos() {
        try {
            String sql = "SELECT * FROM unidade u inner join usuario usu on u.cd_usuario = usu.cd_usuario;";
            PreparedStatement ps = this.conn.getConexao().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ArrayList<Unidade> arrayUnidade = new ArrayList<>();
            while (rs.next()) {
                Unidade u = new Unidade();
                u.setCd_unidade(rs.getInt("cd_unidade"));
                u.setNm_unidade(rs.getString("nm_unidade"));
                u.setAtivo(rs.getString("ativo"));
                arrayUnidade.add(u);
            }
            return arrayUnidade;

        } catch (NumberFormatException | SQLException e) {
            return null;
        }
    }
    
    private PieDataset listaStatusUnidade() {  
        ArrayList<Unidade> listaUnidades = this.buscarTodos();
        DefaultPieDataset data = new DefaultPieDataset();  
        int ativos = 0;
        int inativos = 0;
        for(Unidade unidade: listaUnidades){
            if(unidade.getAtivo() == "1"){
                ativos += 1; 
            }else{
                inativos += 1;
            }
        }
        data.setValue("Ativos", ativos);
        data.setValue("Inativos", inativos);
        return data;
    } 
    
    private DefaultCategoryDataset listaQuantidadeUnidade(){
        ArrayList<Unidade> listaUnidades = this.buscarTodos();
        DefaultCategoryDataset data = new DefaultCategoryDataset();
        int quantidade = 0;
        for(Unidade unidade: listaUnidades){
            quantidade += 1;
        }
        data.setValue(quantidade, "Quantidade", "");
        return data;
    }
    
    public JFreeChart graficoPieUnidade(){
        PieDataset data = this.listaStatusUnidade();
        JFreeChart chart = ChartFactory.createPieChart3D("Unidades", data, true, true, false);         
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
    
    public JFreeChart graficoBarUnidades(){
        DefaultCategoryDataset data = this.listaQuantidadeUnidade();
        JFreeChart graficoBarra = ChartFactory.createBarChart("Unidades", "Quantidade de Unidades", "Quantidade", data, PlotOrientation.VERTICAL, true, true, true);        
        CategoryPlot parametrizacaoGrafico = graficoBarra.getCategoryPlot();
	parametrizacaoGrafico.setNoDataMessage("Não há valores de resultado para exibição.");  
	parametrizacaoGrafico.setBackgroundPaint(Color.black);
        return graficoBarra;
    }
}
