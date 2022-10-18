package variant_3;

import java.util.Scanner;

public class WithMethod {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        byte num1 = (byte) getByte();
        byte num2 = (byte) getByte();
        char operation = getOperation();
        byte result = (byte) calc(num1,num2,operation);
        System.out.println("��������� ��������: "+result);
    }

    public static byte getByte(){
        System.out.println("������� �����:");
        byte num;
        if(scanner.hasNextByte()){
            num = (byte) scanner.nextByte();
        } else {
            System.out.println("�� ��������� ������ ��� ����� �����. ���������� ��� ���.");
            scanner.next();//��������
            num = (byte) getByte();
        }
        return num;
    }

    public static char getOperation(){
        System.out.println("������� ��������:");
        char operation;
        if(scanner.hasNext()){
            operation = scanner.next().charAt(0);
        } else {
            System.out.println("�� ��������� ������ ��� ����� ��������. ���������� ��� ���.");
            scanner.next();//��������
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
                System.out.println("�������� �� ����������. ��������� ����.");
                result = (byte) calc(num1, num2, getOperation());//��������
        }
        return result;
    }
}