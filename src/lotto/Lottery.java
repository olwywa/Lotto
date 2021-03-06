package lotto;
import java.util.*;

public class Lottery {

    static int[] randomoweLosowania;

    public static int[] lottery(int liczba) {     // generowanie liczb pseudolosowych przez komputer

        Set<Integer> randomoweLosowania_ = new HashSet<>();
        Random generator = new Random();
        while(randomoweLosowania_.size() < liczba) {
            randomoweLosowania_.add(generator.nextInt(48) + 1);
        }
        randomoweLosowania = new int[liczba];

        int i=0;
        for(Integer number: randomoweLosowania_) {
            randomoweLosowania[i] = number;
            i++;
        }

        return randomoweLosowania;
    }

    public static int[][] lotteryScore(int liczbaLosowan) {    // utworzenie zestawienia z losowań
        int [][] losowaniaMaszyny = new int[liczbaLosowan][6];
        for (int i = 0; i < liczbaLosowan; i++) {
            randomoweLosowania = lottery(6);
            for(int j=0;j<6;j++)
            {
                losowaniaMaszyny[i][j] = randomoweLosowania[j];
            }
        }

        int licznik = 1;
        for (int i = 0; i < liczbaLosowan; i++) {
            System.out.println("Losowanie nr. " + licznik);
            for(int j = 0; j < 6; j++) {
                System.out.print(losowaniaMaszyny[i][j] + " ");
            }
            System.out.println("");
            licznik++;
        }
        return losowaniaMaszyny;
    }

    public static String check(int[][] losowaniaMaszyny, int[] losowaniaUsera, int liczbaLosowan) {

        int liczba = 1;
        int counter = 0;
        String wyniki = "";

        wyniki += ("Liczba losowań: " + liczbaLosowan + "\n" + "\n");
        for (int i = 0; i < liczbaLosowan; i++) {
            counter = 0;
            for (int j = 0; j < 6; j++) {
                if (losowaniaMaszyny[i][j] == losowaniaUsera[j]) {
                    counter++;
                }
            }
            wyniki += ("Liczba trafionych " + liczba + ": ");
            wyniki += (counter + "\n");
            liczba++;
        }
        System.out.println(wyniki);
        return wyniki;
    }
}
