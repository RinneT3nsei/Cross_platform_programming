package variant_3;

import java.util.Scanner;

public class WithMethod {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        byte num1 = (byte) getByte();
        byte num2 = (byte) getByte();
        char operation = getOperation();
        byte result = (byte) calc(num1,num2,operation);
        System.out.println("Результат операции: "+result);
    }

    public static byte getByte(){
        System.out.println("Введите число:");
        byte num;
        if(scanner.hasNextByte()){
            num = (byte) scanner.nextByte();
        } else {
            System.out.println("Вы допустили ошибку при вводе числа. Попробуйте еще раз.");
            scanner.next();//рекурсия
            num = (byte) getByte();
        }
        return num;
    }

    public static char getOperation(){
        System.out.println("Введите операцию:");
        char operation;
        if(scanner.hasNext()){
            operation = scanner.next().charAt(0);
        } else {
            System.out.println("Вы допустили ошибку при вводе операции. Попробуйте еще раз.");
            scanner.next();//рекурсия
            operation = getOperation();
        }
        return operation;
    }

    public static byte calc(byte num1, byte num2, char operation){
        byte result;
        switch (operation){
            case '+':
                result = (byte) (num1+num2);
                break;
            default:
                System.out.println("Операция не распознана. Повторите ввод.");
                result = (byte) calc(num1, num2, getOperation());//рекурсия
        }
        return result;
    }
}