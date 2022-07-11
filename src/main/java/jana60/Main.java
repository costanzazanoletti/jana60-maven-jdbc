package jana60;

import java.util.Scanner;
import org.apache.commons.lang3.StringUtils;

public class Main {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    System.out.println("Ciao come ti chiami?");
    String nome = scan.nextLine();
    nome = StringUtils.defaultIfEmpty(nome, "sconosciuto");
    System.out.println("Piacere di conoscerti, " + nome);

    scan.close();

  }

}
