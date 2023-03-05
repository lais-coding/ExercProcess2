package view;

import javax.swing.JOptionPane;


import controller.KillController;

public class Main {
	
	public Main() {
		super();
	}

	public static void main(String[] args) {
		
		int opc = 0;
		KillController k = new KillController();
		String way = "cmd /c start cmd.exe";
	
		
		
		while(opc != 4) {
			opc = Integer.parseInt(JOptionPane.showInputDialog("\n 1 - Lista de Processos \n 2 - Matar pelo PID \n 3 - Matar pelo nome \n 4 - Finalizar"));
			switch (opc){
			case 1:
				String processo = "";
				k.ListarProcessos(processo);
				break;
			case 2:
				int pid = Integer.parseInt(JOptionPane.showInputDialog("Digite o PID do processo: "));
				k.MatarPID(pid);
				break;
			case 3:
				String nome = JOptionPane.showInputDialog("Digite o nome do processo: ");
				k.MatarNome(nome);
				break;
		}
		
	}
}
	
}

