/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package galgeleg;

import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Matt_Lab
 */
public interface GalgeI extends java.rmi.Remote{

boolean erSidsteBogstavKorrekt()            throws java.rmi.RemoteException;
boolean erSpilletSlut()                     throws java.rmi.RemoteException;
boolean erSpilletTabt()                     throws java.rmi.RemoteException;
boolean erSpilletVundet()                   throws java.rmi.RemoteException;
int getAntalForkerteBogstaver()             throws java.rmi.RemoteException;
ArrayList<String> getBrugteBogstaver()      throws java.rmi.RemoteException;
String getOrdet()                           throws java.rmi.RemoteException;
String getSynligtOrd()                      throws java.rmi.RemoteException;
void gætBogstav(String bogstav)             throws java.rmi.RemoteException;
void hentOrdFraDr()                         throws java.rmi.RemoteException, Exception;
String hentUrl(String url)                  throws java.rmi.RemoteException, IOException;
void logStatus()                            throws java.rmi.RemoteException;
void nulstil()                              throws java.rmi.RemoteException;
void opdaterSynligtOrd()                    throws java.rmi.RemoteException;
}
