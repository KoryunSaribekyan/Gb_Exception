package less2;

public class Less2 {
    public static void main(String[] args) {
        int number = 1;
        try {
            number = 10/0;
            String test = null;
            System.out.println(test.length());
        } catch (ArithmeticException e){
            System.out.println("upporation divide by zero not supperted");
        } catch (NullPointerException e){
            System.out.println("nullpointer exc" );
        }

    }
}
