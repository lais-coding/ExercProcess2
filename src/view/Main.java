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
		
		while(opc != 5) {
			opc = Integer.parseInt(JOptionPane.showInputDialog("\n 1 - Identificar SO \n 2 - Lista de Processos \n 3 - Matar pelo PID \n 4 - Matar pelo nome \n 5 - Finalizar"));
			switch (opc){
			case 1:
				String os = " ";
				k.IdentificarSO(os);
				break;
			case 2:
				String processo = "";
				k.ListarProcessos(processo);
				break;
		//	case 3:
		//		String pid = "";
		//		k.MatarPID(pid);
		//		break;
		}
		
	}
}
	
}
