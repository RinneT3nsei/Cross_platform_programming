package example;

public class example_14 {
    public static void m(int x) throws ArithmeticException{
        int h=10/x;
    }
    public static void main(String[] args){
        try{
            int l = args.length;
            System.out.println("����� ������=" + l);
            m(l);
        }
        catch (ArithmeticException e) {
            System.out.println("�������: ĳ����� �� ����");
        }
    }
}
