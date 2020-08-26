
import java.util.Scanner;

public class Input {
    final private Scanner scanner;

    public Input() {
        this.scanner = new Scanner(System.in);
    }

    public void clear() {
        this.scanner.nextLine();
    }

    public String getString(){
        return this.scanner.nextLine();
    }
    public boolean yesNo(){
        String response = getString();
        response = response.toLowerCase();
        if (response.equals("yes") || response.equals("y")){
            return true;
        } else if (response.equals("no") || response.equals("n")) {
            return false;
        } else {
            return yesNo();
        }
    }
    public int getInt(int min, int max){
        boolean flag = false;
        int num;
        do {
            num = this.scanner.nextInt();
            try {
                if (num >= min && num <= max) {
                    num = Integer.valueOf(getString());
                    flag = true;
                } else {
                    System.out.println("Invalid response.");
                }
            } catch(NumberFormatException e){
                e.printStackTrace();
            }
        } while(!flag);
        return num;
    }
    public int getInt(){
        int num = 0;
        try {
            num = Integer.valueOf(getString());
        } catch (NumberFormatException e) {
            System.out.println("Invalid response.");
            e.printStackTrace();
        }
        return num;
    }

    double getDouble(double min, double max){
        boolean flag = false;
        double dubNum;
        do {
            dubNum = this.scanner.nextDouble();
            try {
                if (dubNum >= min && dubNum <= max) {
                    dubNum = Integer.valueOf(getString());
                    flag = true;
                } else {
                    System.out.println("Invalid response.");
                }
            } catch(NumberFormatException e) {
                System.out.println("Invalid Response");
                e.printStackTrace();
            }
        } while (!flag);
        return dubNum;
    }
    public double getDouble(){
        double num;
        try {
            num = Integer.valueOf(getString());
        } catch (NumberFormatException e) {
            System.out.println("Invalid response.");
            e.printStackTrace();
        }
        return num;
    }
}
