package lotto;

import java.io.*;

public class Ending {

    int licznik = 0;
    Ending (int licznik) {
        this.licznik = licznik;
    }

    public static boolean doWant() {

        boolean czychce = true;
        GettingClass gettingClass = new GettingClass();
        boolean isyes = gettingClass.isYes();
        try {
            if (isyes) {
                czychce = true;
            } else {
                czychce = false;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return czychce;
    }

    public static boolean wantToSave() {
        boolean czyZapisac;

        System.out.println("Czy zapisac uzyskane wyniki? TAK/NIE");
        boolean czychce = doWant();

        if (czychce == true) {
            czyZapisac = true;
        } else {
            czyZapisac = false;
        }
        return czyZapisac;
    }

    public static boolean doAgain() {

        boolean czyponownie;
        System.out.println("Czy chcesz przeprowadzic kolejne losowanie? TAK/NIE");
        boolean czychce = doWant();

        if (czychce == true) {
            czyponownie = true;
        } else {
            czyponownie = false;
            System.out.println("Dzięki za losowanie.");
        }
        return czyponownie;
    }

    public void save(boolean czyponownie, String result, int licznik) throws IOException {

        boolean czyZapisac = wantToSave();
        File plik = new File("losowanie_" + this.licznik + ".txt");
        System.out.println("Plik został zapisany w: " + plik.getAbsolutePath());
        if (!plik.exists()) {
            if (plik.createNewFile()) {
                if (czyZapisac) {
                    PrintWriter zapis = new PrintWriter(plik);
                    zapis.println(result);
                    zapis.close();
                }
            }
        }
    }

    public static String onceAgain (boolean czyponownie) {

        String result = "";

        User user = new User();
        int[] losowaniaUsera = user.userValues(1, 49);
        int liczbaLosowan = user.userLottery();

        Lottery lott = new Lottery();
        int[][] losowaniaMaszyny = lott.lotteryScore(liczbaLosowan);
        result = lott.check(losowaniaMaszyny, losowaniaUsera, liczbaLosowan);

        return result;
    }
}
