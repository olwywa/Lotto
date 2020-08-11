package lotto;

import java.util.Scanner;

public class GettingClass {

    public int getInt() {
        try {
            Scanner scan = new Scanner(System.in);

            while(true) {
                if (scan.hasNextInt()) {
                    return scan.nextInt();
                }
                scan.next();
            }

        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
        return 0;
    }

    public String getAnswer() {
        String answer = "";
        try {
            Scanner scan = new Scanner(System.in);

            while(true) {
                if (scan.hasNext()) {
                    answer = scan.next();
                    break;
                }
                scan.next();
            }

        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
        return answer;
    }

    public boolean isYes() {
        boolean isyes = false;
        String answer = getAnswer();
        String tak = "TAK";
        String nie = "NIE";
        boolean czyzle = true;

        while(czyzle) {
            if (answer.equals(tak)) {
                isyes = true;
                czyzle = false;
                break;
            } else if (answer.equals(nie)) {
                isyes = false;
                czyzle = false;
                break;
            } else {
                System.out.println("Wpisz tylko TAK lub NIE.");
                answer = getAnswer();
            }
        }
        return isyes;
    }
}
