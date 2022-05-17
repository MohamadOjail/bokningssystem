package se.ya.bokningssystem;

import java.util.Random;

public class Lex {

    private static final Random rnd = new Random();

    public static String randomFirstName(){
        String[] firstNames = {"Cilla", "Vide", "Konrad", "Torborg", "Maria",
                                "Kim", "Karina", "Vera", "Alve", "Ulla", "Andreas",
                                "Björne", "Algot", "Vilmar", "Adrian", "Marika",
                                "Ylva", "Camilla", "Urban", "Tuva", "Erling", "Erland", "Christel", "Bodil", "Lucas"};
        return firstNames[rnd.nextInt(firstNames.length)];
    }

    public static String randomLastName(){
        String[] lastNames = {"Andréasson", "Winter", "Lindberg", "Björklund", "Gerhardsson",
                                "Mikaelsson", "Holmberg", "Berg", "Fransson", "Lund", "Adolvsson",
                                "Olofsson", "Arvidsson", "Lundquist", "Mårdh", "Gustafsson", "Alexandersson", "Ljunggren", "Alfson", "Andreasson"};
        return lastNames[rnd.nextInt(lastNames.length)];
    }

    public static String randomItem(){
        String[] items = {"cykel", "tangentbord", "datormus", "projektor", "vittavla", "konferensstol",
                            "dator", "surfplatta", "laserpekare", "högtalare"};
        return items[rnd.nextInt(items.length)];
    }

    public static String randomArtNum() {
        String output = "";
        final String lexicon = "abcdefghijklmnopqrstuvwxyz";
        output += lexicon.charAt(rnd.nextInt(lexicon.length()));
        output += lexicon.charAt(rnd.nextInt(lexicon.length()));
        output += rnd.nextInt(10);
        output += rnd.nextInt(10);
        output += rnd.nextInt(10);
        return output;
    }
}
