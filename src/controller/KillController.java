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
	
	public void MatarPID(int pid) {

		String pidw = "TASKKILL /PID"; //Comando no Windows
		String pidl = "kill -9"; //Comando no Linux
		String way = "cmd /c"; //CMD Windows
		
	
			StringBuffer buffer = new StringBuffer();
			
			String sistema = System.getProperty("os.name");
			
			//Caso seja Windows
			
			if(sistema.contains("Windows")) {
				try {					
				//Tente executar o kill no Windows
					buffer.append(way);
					buffer.append("");
					buffer.append(pidw);
					buffer.append(" ");
					buffer.append(pid);
					Runtime.getRuntime().exec(buffer.toString());
				} catch (Exception e) {
					e.printStackTrace(); //Caso não dê certo, apresente o erro
				} 
				
			
				} 
			
			
			//Caso seja Linux
			
			 if (sistema.contains("Linux")) {
				 try {	
					 	//Tente executar o kill no Linux
						buffer.append(pidl);
						buffer.append(" ");
						buffer.append(pid);
					} catch (Exception e) {
						e.printStackTrace(); //Caso não dê certo, apresente o erro
					}
				 
			
					}  
			 
	}
	
	
			//4 - Matar processo por nome
	
	public void MatarNome(String nome) {
		
		String nomew = "TASKKILL /IM"; //Comando para matar por nome no Windows
		String nomel = "pkill -f"; //Comando para matar por nome no Linux
		String way = "cmd /c"; //CMD no Windows
		
		StringBuffer buffer = new StringBuffer();
		
		String sistema = System.getProperty("os.name");
		
	//Caso seja Windows
		
		if(sistema.contains("Windows")) {
		try {					
			//Tente executar o kill no Windows
				buffer.append(way);
				buffer.append("");
				buffer.append(nomew);
				buffer.append(" ");
				buffer.append(nome);
				Runtime.getRuntime().exec(buffer.toString());
			} catch (Exception e) {
				e.printStackTrace(); //Caso não dê certo, apresente o erro
			} 
			
		
			} 
		
		
		//Caso seja Linux
		
		 if (sistema.contains("Linux")) {
			 try {	
				 	//Tente executar o kill no Linux
					buffer.append(nomel);
					buffer.append(" ");
					buffer.append(nome);
				} catch (Exception e) {
					e.printStackTrace(); //Caso não dê certo, apresente o erro
				}
			 
		
				}  
		 
		
		
		
	}
	
	
}
			
	

