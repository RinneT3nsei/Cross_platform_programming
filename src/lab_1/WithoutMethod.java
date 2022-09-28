package lab_1;

import java.util.Scanner;

public class WithoutMethod {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in, "cp1251");

// Введення інформації про людей
        System.out.println("Введіть кількість people=> ");
        int n = sc.nextInt();    //	кількість people
        People people[] = new People[n];
        System.out.println("Введіть інформацію про people: ");
        for (int i = 0; i < people.length; i++) {
            sc.nextLine();    //	очищення буфера
            people[i] = new People();
            System.out.print("Ім'я " + (i + 1) + "-ї людини => ");
            people[i].name = sc.nextLine();
            System.out.print("Прізвище " + (i + 1) + "-ї людини => ");
            people[i].lastname = sc.nextLine();
            System.out.print("По-батькові " + (i + 1) + "-ї людини => ");
            people[i].surname = sc.nextLine();
            System.out.print("Вік " + (i + 1) + "-ї людини => ");
            people[i].age = sc.nextDouble();
            System.out.print("Розмір одягу " + (i + 1) + "-ї людини => ");
            people[i].size = sc.nextDouble();
        }

// Виведення отриманої інформації
        System.out.println("\nІнформація про people:");
        for (int i = 0; i < people.length; i++) {
            System.out.println("Name: " + people[i].name + "\tLastname: " + people[i].lastname + "\tSurname: " + people[i].surname
                    + "\tAge: " + people[i].age + "\tSize: " + people[i].size);

        }


// Людина з найбільшим розміром одягу
        int nommax = 0;    //номер елемента для Людина з найбільшим розміром одягу (початкове значення)
        double max = people[nommax].size; //максимальний розмір одягу
// (початкове значення)
        for (int i = 0; i < people.length; i++)
            if (people[i].size > nommax) {
                max = people[i].size;
                nommax = i;
            }
        System.out.println("\nЛюдина з найбільшим розміром одягу :");
        System.out.println("Name: " + people[nommax].name + "\tSize: " + people[nommax].size);


// Середній розмір одягу для людей віком від 40 років
        int allsize = 0;
        int minage = 40;

        for (int i = 0; i < people.length; i++)
            if (people[i].age >= minage) {
                allsize += people[i].size;
            }
        float averagesize = allsize / people.length;
        System.out.println("\nСередній розмір одягу для людей віком від 40 років: " + averagesize);

// Сортування people за розміром одягу
        for (int i = 0; i < people.length - 1; i++)
            for (int j = 0; j < people.length - 1 - i; j++)
                if (people[j].size > people[j + 1].size) {
                    People rab = people[j];    //rab – робоча змінна для перестановки
                    people[j] = people[j + 1];
                    people[j + 1] = rab;
                }
        System.out.println("\nВідсортований список за разміром одягу:");
        for (int i = 0; i < people.length; i++) {
            System.out.println("Name: " + people[i].name + "\tSize: " + people[i].size);
        }

// Пошук за назвою
        sc.nextLine();             // очищення буфера
        System.out.println("Введіть прізвище шуканої людини=>");
        String lastname = sc.nextLine();
        int nom = -1;            //−1 – країна з шуканою назвою відсутня

        for (int i = 0; i < people.length; i++)
            if (lastname.equalsIgnoreCase(people[i].lastname)) nom = i;

        if (nom != -1) {
            System.out.println("Така людина є у списку. Це" +
                    "\tName: " + people[nom].name + "\tLastname: " + people[nom].lastname + "\tSurname: " + people[nom].surname + "\tAge: "
                    + people[nom].age + "\tSize: " + people[nom].size);
        } else System.out.println("Такої людини немає у списку");

        //Редактирование
        sc.nextLine();             // очищення буфера
        System.out.println("Изменение фамилии на новую: ");
        String newlastname = sc.nextLine();
        people[nom].lastname = newlastname;
        System.out.println("Измененная информация: ");
            for (int i = 0; i < people.length; i++) {
                if (nom != -1) {
                System.out.println("\tName: " + people[nom].name + "\tLastname: " + people[nom].lastname + "\tSurname: " + people[nom].surname + "\tAge: "
                        + people[nom].age + "\tSize: " + people[nom].size);
            }
        else System.out.println("Ошибка");
        }
    }
}

