package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.swing.JOptionPane;

public class KillController {
	
	public KillController() {
		super();
	}

	
	// 1 - Identificar Sistema Operacional
	public String IdentificarSO(String os) {
		String oos = System.getProperty("os.name");
		JOptionPane.showMessageDialog(null, "O Sistema Operacional nessa máquina é " +oos);
		return oos;
	}
	
	//2 - Lista de Processos
	
	public void ListarProcessos(String processo) {
		
		String sistema = System.getProperty("os.name");
		
		if(sistema.contains("Windows")) {
			processo = "TASKLIST /FO TABLE";
			try {
				Process lista = Runtime.getRuntime().exec(processo);
				InputStream dados = lista.getInputStream();
				InputStreamReader ler = new InputStreamReader(dados);
				BufferedReader buffer = new BufferedReader(ler);
				String linha = buffer.readLine();
				
				while(linha != null) {
					System.out.println(linha);
					linha = buffer.readLine();
				}
				
				buffer.close();
				ler.close();
				dados.close();
				
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "Não foi possível apresentar a lista de processos");
			}
			
		}
		

		if(sistema.contains("Linux")) {
			processo = "ps -ef";
			try {
				Process lista = Runtime.getRuntime().exec(processo);
				InputStream dados = lista.getInputStream();
				InputStreamReader ler = new InputStreamReader(dados);
				BufferedReader buffer = new BufferedReader(ler);
				String linha = buffer.readLine();
				
				while(linha != null) {
					System.out.println(linha);
					linha = buffer.readLine();
				}
				
				buffer.close();
				ler.close();
				dados.close();
				
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "Não foi possível apresentar a lista de processos");
			}
			
		}
		
	}
	
	//3 - Matar processo por PID
	
	//public void MatarPID(String pid) {
		
		//String sistema = System.getProperty("os.name");
		
		//if(sistema.contains("WINDOWS")) {
			//String comandopid = "TASKKILL /PID"
		//}
		
//	}
	
	
}
