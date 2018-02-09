/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package galgeleg;

import javax.xml.ws.Endpoint;

/**
 *
 * @author Matt_Lab
 */
public class ServerGalge {
    public static void main(String[] arg) throws Exception
	{
		GalgeI k = (GalgeI) new Galgelogik();

		/* RMI */
		//Enten: Kør programmet 'rmiregistry' fra mappen med .class-filerne, eller:
		//java.rmi.registry.LocateRegistry.createRegistry(1099); // start i server-JVM
		//Naming.rebind("rmi://localhost/Galge", k);

		/* SOAP */
		Endpoint.publish("http://[::]:9932/galgeleg",k);
		System.out.println("Galgelogik publiceret over SOAP.");
	}
}
