package galgeleg;

import java.rmi.Naming;
import java.util.Scanner;

public class BenytGalgelogik {

  public static void main(String[] args) throws Exception {

      GalgeI k =(GalgeI) Naming.lookup("rmi://localhost:1099/Galge");
      Scanner scanner = new Scanner(System.in);
      
      System.out.println("//**\\\\**//**\\\\**//**\\\\**//**\\\\**//**\\\\**//**\\\\**//**\\\\");
      System.out.println("//                                                  \\\\");
      System.out.println("//    Velkommen til det fantastiske galgelej spil   \\\\");
      System.out.println("//                                                  \\\\");
      System.out.println("//              Tast 'y' for at starte              \\\\");
      System.out.println("//                                                  \\\\");
      System.out.println("//**\\\\**//**\\\\**//**\\\\**//**\\\\**//**\\\\**//**\\\\**//**\\\\");
      
      if (scanner.nextLine().toLowerCase().startsWith("n")) {
      k.nulstil();

      try {
        k.hentOrdFraDr();
      } catch (Exception e) {
      e.printStackTrace();
      }
    k.logStatus();
      }
      System.out.println("Get ordet!!!");
      
      while(!k.erSpilletSlut()){
          System.out.println("Du har gættet forkert " +k.getAntalForkerteBogstaver()+ " gange.");
          System.out.println("Hvis du gætter forkert 7 gange har du tabt :)");
          System.out.println("");
          System.out.println("Gæt på et bogstav!!!");
          System.out.println(k.getSynligtOrd());
          System.out.println("");
          System.out.println("Du har gættet på fælgende bogstaver " +k.getBrugteBogstaver());
         
          k.gætBogstav(scanner.nextLine().toLowerCase());
          k.logStatus();
             
      }
      
      if(k.erSpilletVundet()){
          System.out.println("Tillykke du har vundet!!!");
      }else if(k.erSpilletTabt()){
          System.out.println("BUUU du har tabt!!!");
      }
      k.nulstil();
      
  
  }
}
