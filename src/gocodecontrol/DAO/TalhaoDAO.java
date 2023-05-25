package gocodecontrol.DAO;

import gocodecontrol.Models.Talhao;
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

public class TalhaoDAO {
    private Conexao conn;
    
    public TalhaoDAO() {
        try {
            this.conn = new Conexao();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Talhao detalheTalhao(int codigo) throws SQLException{
        String sql = "SELECT cd_talhao, nm_talhao, status FROM talhao where cd_talhao = ?;";
        PreparedStatement ps = this.conn.getConexao().prepareStatement(sql);
        ps.setInt(1, codigo);
        ResultSet rs = ps.executeQuery();
        Talhao t = new Talhao();
        while (rs.next()) {
            t.setCd_talhao(rs.getInt("cd_talhao"));
            t.setNm_talhao(rs.getString("nm_talhao"));
            t.setStatus(rs.getBoolean("status"));
        }
        
        return t;
    }
    
    public ArrayList<Talhao> buscarTodos() {
        try {
            String sql = "SELECT cd_talhao, nm_talhao, status FROM talhao";
            PreparedStatement ps = this.conn.getConexao().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ArrayList<Talhao> arrayTalhao = new ArrayList<>();
            while (rs.next()) {
                Talhao t = new Talhao();
                t.setCd_talhao(rs.getInt("cd_talhao"));
                t.setNm_talhao(rs.getString("nm_talhao"));
                t.setStatus(rs.getBoolean("status"));
                arrayTalhao.add(t);
            }
            return arrayTalhao;

        } catch (NumberFormatException | SQLException e) {
            return null;
        }
    }
    
    private DefaultCategoryDataset listaQuantidadeTalhao(){
        ArrayList<Talhao> listaTalhoes = this.buscarTodos();
        DefaultCategoryDataset data = new DefaultCategoryDataset();
        int quantidade = 0;
        for(Talhao talhao: listaTalhoes){
            quantidade += 1;
        }
        data.setValue(quantidade, "Quantidade", "");
        return data;
    }
    
    private PieDataset listaStatusTalhao() {  
        ArrayList<Talhao> listaTalhoes = this.buscarTodos();
        DefaultPieDataset data = new DefaultPieDataset();  
        int ativos = 0;
        int inativos = 0;
        for(Talhao talhao: listaTalhoes){
            if(talhao.isStatus()){
                ativos += 1; 
            }else{
                inativos += 1;
            }
        }
        data.setValue("Ativos", ativos);
        data.setValue("Inativos", inativos);
        return data;
    }  
    
    public JFreeChart graficoBarTalhao(){
        DefaultCategoryDataset data = this.listaQuantidadeTalhao();
        JFreeChart graficoBarra = ChartFactory.createBarChart("Talhões", "Quantidade de talhões", "Quantidade", data, PlotOrientation.VERTICAL, true, true, true);        
        CategoryPlot parametrizacaoGrafico = graficoBarra.getCategoryPlot();
	parametrizacaoGrafico.setNoDataMessage("Não há valores de resultado para exibição.");  
	parametrizacaoGrafico.setBackgroundPaint(Color.black);
        return graficoBarra;
    }
     
    public JFreeChart graficoPieTalhao(){
        PieDataset data = this.listaStatusTalhao();
        JFreeChart chart = ChartFactory.createPieChart3D("Seus Talhoes", data, true, true, false);         
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
    
}