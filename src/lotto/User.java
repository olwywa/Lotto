package lotto;

public class User {

    static int n;               // podaje ile losowan
    static int[] losowaniaUsera = new int[6];  // typy użytkownika

    public static int[] userValues(int min, int max) {

        GettingClass gettingClass = new GettingClass();

        System.out.println("Podaj 6 unikatowych liczb z przedzialu od 1 do 49.");
        int licznik = 1;

        for (int i = 0; i < losowaniaUsera.length; i++)  {
            System.out.println("Podaj " + licznik + ". liczbę: ");
            n = gettingClass.getInt();
            if (n < min || n > max) {
                System.out.println("Podaj liczbę z zakresu od 1 do 49.");
                i--;
                continue;
            } else if(n >= min && n <= max) {
                losowaniaUsera[i] = n;
                licznik++;
            }
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