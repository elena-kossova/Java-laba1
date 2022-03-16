import java.util.Scanner;
/** @author Elena Chernuhina
 * */
public class main_List {
    public static void main(String[] args) {
        Conteiner meineList = new Conteiner();
        System.out.println("Введите размерность списка:");
        Scanner sc = new Scanner(System.in);
        int i = 0;
        int size = 0;
        size = sc.nextInt();
        System.out.println("Введите список:");
        while (i <= size) {
            meineList.add(sc.nextLine());
            i++;
        }

        System.out.println("Мой список:");
        System.out.println(meineList.toString());


        int c = -1;
        while (c != 5) {
            System.out.println("Что хотите сделать?\n");
            System.out.println("1 - добавить элемент\n");
            System.out.println("2 - удалить элемент\n");
            System.out.println("3 - распечатать весь список\n");
            System.out.println("4 - узнать размерность списка\n");
            System.out.println("5 - закончить\n\n");
            System.out.println("Выберите необходимое число\n");
            //c = sc.nextLine();
            while (!sc.hasNextInt()) {
                System.out.println("Пожалуйста, введите число!\n");
                sc.next();
            }
            c = sc.nextInt();
            switch (c) {
                case 1: {
                    System.out.println("Введите желаемый элемент\n");
                    while (!sc.hasNextInt()) {
                        System.out.println("Пожалуйста, введите число!\n");
                        sc.next();
                    }
                    int listik = sc.nextInt();
                    meineList.add(listik);
                    System.out.println("Получившийся список:");
                    System.out.println(meineList.toString());
                    System.out.println("----------------------------------------------------");
                    break;
                }
                case 2: {
                    System.out.println("Укажите индекс, после которого стоит удаляемый элемент\n"); //с нуля
                    while (!sc.hasNextInt()) {
                        System.out.println("Пожалуйста, введите число!\n");
                        sc.next();
                    }
                    int position = sc.nextInt();
                    if (!meineList.delete(position)){
                        System.out.println("Удаление невозможно!");
                    }
                    else {
                        System.out.println("Список после удаления");
                        System.out.println(meineList.toString());
                    }
                    System.out.println("----------------------------------------------------");
                    break;
                }
                case 3: {
                    System.out.println("Мой список: ");
                    System.out.println(meineList.toString());
                    System.out.println("----------------------------------------------------");
                    break;
                }
                case 4: {
                    System.out.println("Количество элементов в списке: " + meineList.sizeOfList());
                    System.out.println("----------------------------------------------------");
                    break;
                }
                case 5: {
                    break;
                }
            }
        }
    }
}
