/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
 
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
 
public class GeraRelatorio {

	// Método para realizar a conexão com o banco de dados
	public Connection getConexao() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost/inventarioweb", "root", "root");
		return conexao;
	}
 
	public byte[] gerarPDF(String diretorio) {
		byte[] retorno = null;
		String relatorio = diretorio + "REL_ALL.jrxml";
		//String imagem = diretorio + "cherry.jpg";
		try {
			// Faz a compilação do relatório
			JasperReport jasperReport = JasperCompileManager.compileReport(relatorio);
 
			// Cria o mapa de parâmetros que será enviado ao relatório
			HashMap<String, Object> paramatros = new HashMap<String, Object>();
 
			// Faz o apontamento para a imagem que aparece no top do relatório
			//paramatros.put("logo", imagem);
 
			// Preenche os dados do relatório
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, paramatros, getConexao());
                        
			// Objeto para a ser retornado
			retorno = JasperRunManager.runReportToPdf(jasperReport, paramatros, getConexao());
 
			// Gera o arquivo PDF no caminho especificado
			//JasperExportManager.exportReportToPdfFile(jasperPrint, "C:/temp/Relatorio.pdf");

 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return retorno;
	}
}