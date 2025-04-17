package relogiocliente;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.Iterator;

import relogioservidor.RelogioServerInterface;

public class Main {

	public static void main(String[] args) {
		int total = 0;
		int media = 0;
		
		ArrayList<RelogioServerInterface> servers = new ArrayList();
		try {
			Registry registry = LocateRegistry.getRegistry("localhost");
			RelogioServerInterface c = (RelogioServerInterface) registry.lookup("RelogioServerInterfaceImpl")
			System.out.println("O objeto servirdor " + c + " foi encontrado com sucesso.\n");
			System.out.println(c.getTime());
			servers.add(c);
			
			registry = LocateRegistry.getRegistry(""); //colocar o ip aqui
			c = (RelogioServerInterface) registry.lookup("RelogioInterfaceImpl");
			servers.add(c);
			System.out.println(c.getTime());
		} catch (Exception e) {
			System.out.println(e);
		}
		
		for (RelogioServerInterface a : servers) {
			a.setDiferenca(a.getTime() - servers.get(0).getTime());
			total += a.getDiferenca();
		}
		media = total/servers.size();
		System.out.println("MEDIA = " + media);
		for (RelogioServerInterface a : servers) {
			a.setDiferenca(media +(-1 * a.getDiferenca()));
		}
		
		for (RelogioServerInterface a : servers) {
			int inteira = a.getTime() / 60;
			int resto = a.getTime() % 60;
			
			System.out.println(inteira + ": " + resto);
		}
	}

}
