package example;

public class example_1 {
    public static void main(String[] args){
        try{
            System.out.println("0");
            throw new RuntimeException("����������� �������");
        } catch (RuntimeException e){
            System.out.println("1" + e);
        }
        System.out.println("2");
    }
}
