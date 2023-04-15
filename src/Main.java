import exercises.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Ex1 testData = new Ex1();
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите цифру, соответствующую необходимому критерию поиска\n" +
                "1 - Разрешение дисплея\n" +
                "2 - Модель ЦПУ\n" +
                "3 - Тип операционной системы\n" +
                "4 - Цена\n" +
                "5 - Объем ОЗУ");
        int ex = scan.nextInt();
        switch (ex) {
            case 1:
                System.out.print("Введите требуемое разрешение или формат (например, \"Full HD\"): ");
                scan = new Scanner(System.in);
                var resolution = scan.nextLine();
                testData.searchByResolution(resolution);
                break;
            case 2:
                System.out.print("Введите модель ЦПУ (например, \"Celeron\"): ");
                scan = new Scanner(System.in);
                var cpu = scan.nextLine();
                testData.searchByCPU(cpu);
                break;
            case 3:
                System.out.print("Введите марку операционной системы (например, \"Windows 10\"): ");
                scan = new Scanner(System.in);
                var os = scan.nextLine();
                testData.searchByOS(os);
                break;
            case 4:
                System.out.print("Введите нижнюю границу цены: ");
                scan = new Scanner(System.in);
                Double minPrice = scan.nextDouble();
                Double maxPrice;
                do {
                    System.out.print("Введите верхнюю границу цены: ");
                    maxPrice = scan.nextDouble();
                } while (maxPrice <= minPrice);
                testData.searchByPrice(minPrice, maxPrice);
                break;
            case 5:
                System.out.print("Введите нижнюю границу объема ОЗУ: ");
                scan = new Scanner(System.in);
                Integer minRAM = scan.nextInt();
                Integer maxRAM;
                do {
                    System.out.print("Введите верхнюю границу объема ОЗУ: ");
                    maxRAM = scan.nextInt();
                } while (maxRAM <= minRAM);
                testData.searchByRAM(minRAM, maxRAM);
                break;
        }

    }
}