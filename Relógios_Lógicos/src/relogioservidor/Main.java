package relogioservidor;

import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Main {
	public static void main(String[] args) {
		try {
			RelogioServerInterface sdrmi = new RelogioServerInterfaceImpl();
			Registry registry = LocateRegistry.getRegistry();
			registry.rebind("RelogioServerInterfaceImpl", (Remote) sdrmi);
			System.out.println("Servidor Relogio " + sdrmi + " registrado e pronto para aceitar solicitações.");
		} catch (Exception e) {
			System.out.println("Houve um erro: " + e.getMessage());
		}
	}
}
