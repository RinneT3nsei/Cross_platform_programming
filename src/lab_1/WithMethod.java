package lab_1;

import java.util.Scanner;

public class WithMethod {
// МЕТОДИ ДЛЯ ВСІХ ПІДЗАДАЧ для роботи з об'єктами класу People

    public static People[] setPeopleArr(int k) {
// Введення масиву people
        Scanner sc = new Scanner(System.in, "cp1251");
        People people[] = new People[k];

        System.out.println("Введіть інформацію про people: ");
        for (int i = 0; i < people.length; i++) {
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
            sc.nextLine();   // очищення буфера
        }
        return people;
    }

    public static void showArray(People[] people) {
// Виведення масиву
        for (int i = 0; i < people.length; i++) {
            System.out.println("Name: " + people[i].name + "\tLastname: " + people[i].lastname + "\tSurname: " + people[i].surname
                    + "\tAge: " + people[i].age + "\tSize: " + people[i].size);
        }
    }

    public static void showPeople(People people) {
// Інформація про одну людину
        System.out.println("Name: " + people.name + "\tLastname: " + people.lastname + "\tSurname: " + people.surname
                + "\tAge: " + people.age + "\tSize: " + people.size);
    }

    public static int NomMax(People[] people) {
        // Людина з найбільшим розміром одягу
        int nommax = 0;    //номер елемента для Людина з найбільшим розміром одягу (початкове значення)
        double max = people[nommax].size; //максимальний розмір одягу
// (початкове значення)
        for (int i = 0; i < people.length; i++)
            if (people[i].size > nommax) {
                max = people[i].size;
                nommax = i;
            }
        return nommax;
    }

    public static void sortSize(People[] people) {

// Сортування people за розміром одягу
        for (int i = 0; i < people.length - 1; i++)
            for (int j = 0; j < people.length - 1 - i; j++)
                if (people[j].size > people[j + 1].size) {
                    People rab = people[j];    //rab – робоча змінна для перестановки
                    people[j] = people[j + 1];
                    people[j + 1] = rab;
                }
    }


    public static double AverageSize(People[] people) {
        // Середній розмір одягу для людей віком від 40 років
        int minage = 40;
        int allsize = 0;
        for (int i = 0; i < people.length; i++)
            if (people[i].age >= minage) {
                allsize += people[i].size;
            }
        float averagesize = allsize / people.length;
        return averagesize;
    }

    public static People findForLastname(People people[], String lastname) {
// Пошук за прізвище
        int n = -1;
        for (int i = 0; i < people.length; i++)
            if (lastname.equals(people[i].lastname))
                n = i;
        if (n != -1) {
            return people[n];
        } else return null;
    }

    public static void main(String[] args) {
// ГОЛОВНИЙ КЛАС З МЕТОДАМИ
        Scanner sc = new Scanner(System.in, "cp1251");
        System.out.print("Введіть кількість people=> ");
        int n = sc.nextInt();    // кількість країн
        People people[] = setPeopleArr(n);    // Введення інформації про країни

        System.out.println("\nІнформація про people: ");
        showArray(people);            // Виведення отриманої інформації

// Людина з найбільшим розміром одягу
        int nommax = NomMax(people);
        System.out.println("\nЛюдина з найбільшим розміром одягу: ");
        showPeople(people[nommax]);


        System.out.println("\nСередній розмір одягу для людей віком від 40 років: " + AverageSize(people));


        // Відсортований список за разміром одягу
        sortSize(people);
        System.out.println("\nВідсортований список за разміром одягу:");
        showArray(people);


        System.out.println("\nПошук людини \n Введіть прізвище людини => ");
        sc.nextLine();             // очищення буфера
        String slastname = sc.nextLine();
        People sfind = findForLastname(people, slastname);
        if (sfind != null) {
            showPeople(sfind);
        } else {
            System.out.println("Такої людини немає у списку!");
        }

    }
}

