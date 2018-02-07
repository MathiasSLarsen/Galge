/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package galgeleg;

import java.rmi.Naming;
import java.rmi.Remote;

/**
 *
 * @author Matt_Lab
 */
public class ServerGalge {
    public static void main(String[] arg) throws Exception
	{
		// Enten: Kør programmet 'rmiregistry' fra mappen med .class-filerne, eller:
		java.rmi.registry.LocateRegistry.createRegistry(1099); // start i server-JVM

		GalgeI k = (GalgeI) new Galgelogik();
		Naming.rebind("rmi://localhost/Galge", k);
		System.out.println("Kontotjeneste registreret.");
	}
}
