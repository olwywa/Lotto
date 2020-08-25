package lotto;

import java.util.LinkedHashSet;

public class User {

    static int n;               // podaje ile losowan
    static int[] losowaniaUsera = new int[6];  // typy użytkownika

    public static int[] userValues(int min, int max) {

        GettingClass gettingClass = new GettingClass();
        LinkedHashSet<Integer> losowaniaUsera_ = new LinkedHashSet<>();

        System.out.println("Podaj 6 unikatowych liczb z przedzialu od 1 do 49:");

        while(true) {
            n = gettingClass.getInt();
            if (n < min || n > max) {
                System.out.println("Podaj liczbę z zakresu od 1 do 49.");
                continue;
            } else if(n >= min && n <= max) {
                losowaniaUsera_.add(n);
            }
            if (losowaniaUsera_.size() == 6) {
                break;
            }
        }

        int i = 0;
        for(Integer number: losowaniaUsera_) {
            losowaniaUsera[i] = number;
            i++;
        }

        return losowaniaUsera;
    }

    public static int userLottery() {
        GettingClass gettingClass = new GettingClass();

        System.out.println("Ile losowań chcesz wykonać?");
        int liczbaLosowan = gettingClass.getInt();

        while (liczbaLosowan <= 0) {
            System.out.println("Podaj liczbę większą od 0.");
            liczbaLosowan = gettingClass.getInt();

            if (liczbaLosowan > 0) {
                break;
            }
        }
        return liczbaLosowan;
    }
}