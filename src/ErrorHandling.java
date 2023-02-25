import java.util.Scanner;
        import java.util.ArrayList;

public class ErrorHandling {
    //Indeholder metoder til at scanne input med error handling, kan også potentielt klare menu'er fra Main

    private Scanner s = new Scanner(System.in);

    public void printArray(ArrayList arrayList) {
        for (Object o : arrayList) {
            System.out.println(o.toString());
        }
    }

    public String readString(String inputType) {
        String str = s.next();
        while (inputType.isEmpty()){
            System.out.println("Must contain symbols");
            s.next();
        }
        return str;
    }

    public int readInteger(String inputType, int limit) {
        int i;
        try {
            i = s.nextInt();
            while(i < 0 || i > limit){
                System.out.println("Indtast kun " + inputType);
                i = readInteger(inputType, limit);
            }
        } catch (Exception e) {
            System.out.print("Indtast kun " + inputType + "\n");
            s.nextLine();
            i = readInteger(inputType, limit);
        } return i;
    }

    public double readDouble(String inputType, double limit) {
        double d;
        try {
            d = s.nextInt();
            while(d < 0 || d > limit){
                System.out.println("Indtast kun " + inputType);
                d = readDouble(inputType, limit);
            }
        } catch (Exception e) {
            System.out.print("Indtast kun " + inputType + "\n");
            s.nextLine();
            d = readDouble(inputType, limit);
        } return d;
    }
}