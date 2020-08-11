package lotto;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        boolean flag = true;
        int licznik = 0;

        while (flag) {
            licznik += 1;
            Ending podsumowanie = new Ending(licznik);

            boolean czyponownie = true;
            String result = podsumowanie.onceAgain(czyponownie);
            czyponownie = podsumowanie.doAgain();

            podsumowanie.save(czyponownie, result, licznik);
            if (czyponownie == false) {
                flag = false;
                break;
            }
        }
    }
}
