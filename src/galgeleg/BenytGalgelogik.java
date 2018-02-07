package galgeleg;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.URL;
import java.rmi.Naming;
import java.util.Scanner;

public class BenytGalgelogik {

    public static void main(String[] args) throws Exception {

        GalgeI k = (GalgeI) Naming.lookup("rmi://localhost:1099/Galge");

        URL url = new URL("http://javabog.dk:9901/brugeradmin?wsdl");
        QName serviceQName = new QName("http://soap.transport.brugerautorisation/", "BrugeradminImplService");
        QName portQName = new QName("http://soap.transport.brugerautorisation/", "BrugeradminImplPort");
        Service service = Service.create(url, serviceQName);
        Brugeradmin auth = service.getPort(portQName, Brugeradmin.class);

        Scanner scanner = new Scanner(System.in);
        String brugerNavn;
        String password;

        System.out.println("//**\\\\**//**\\\\**//**\\\\**//**\\\\**//**\\\\**//**\\\\**//**\\\\");
        System.out.println("//                                                  \\\\");
        System.out.println("//    Velkommen til det fantastiske galgelej spil   \\\\");
        System.out.println("//                                                  \\\\");
        System.out.println("//              Intast bruger navn                  \\\\");
        System.out.println("//                                                  \\\\");
        System.out.println("//**\\\\**//**\\\\**//**\\\\**//**\\\\**//**\\\\**//**\\\\**//**\\\\");

        brugerNavn = scanner.nextLine();

        System.out.println("//**\\\\**//**\\\\**//**\\\\**//**\\\\**//**\\\\**//**\\\\**//**\\\\");
        System.out.println("//                                                  \\\\");
        System.out.println("//    Velkommen til det fantastiske galgelej spil   \\\\");
        System.out.println("//                                                  \\\\");
        System.out.println("//              Intast password                     \\\\");
        System.out.println("//                                                  \\\\");
        System.out.println("//**\\\\**//**\\\\**//**\\\\**//**\\\\**//**\\\\**//**\\\\**//**\\\\");

        password = scanner.nextLine();

        if (auth.hentBruger(brugerNavn, password) != null) {
            k.nulstil();

            try {
                k.hentOrdFraDr();
            } catch (Exception e) {
                e.printStackTrace();
            }
            k.logStatus();

            System.out.println("Get ordet!!!");

            while (!k.erSpilletSlut()) {
                System.out.println("Du har gættet forkert " + k.getAntalForkerteBogstaver() + " gange.");
                System.out.println("Hvis du gætter forkert 7 gange har du tabt :)");
                System.out.println("");
                System.out.println("Gæt på et bogstav!!!");
                System.out.println(k.getSynligtOrd());
                System.out.println("");
                System.out.println("Du har gættet på fælgende bogstaver " + k.getBrugteBogstaver());

                k.gætBogstav(scanner.nextLine().toLowerCase());
                k.logStatus();

            }

            if (k.erSpilletVundet()) {
                System.out.println("Tillykke du har vundet!!!");
            } else if (k.erSpilletTabt()) {
                System.out.println("BUUU du har tabt!!!");
            }
            k.nulstil();
        }else{
            System.out.println("Brugeren findes ikke!!!!");
        }

    }

}
