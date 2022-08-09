import java.util.*;

public class Main {
    private static boolean isNumber(String s) throws NumberFormatException {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static void print(List s) {
        System.out.println("Список покупок: ");
        int numberInCart = 1;
        for (Object products : s) {
            System.out.println(numberInCart + ". " + products);
            numberInCart++;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> shoppingCart = new ArrayList<>();

        while (true) {

            System.out.println("Выбирите номер операции: \n1. Добавить \n2. Показать \n3. Удалить \n4. Поиск");
            String input = scanner.nextLine();

            switch (input) {
                case "1": //Add
                    System.out.println("Какую покупку вы хотите добавить?");
                    String product = scanner.nextLine();
                    shoppingCart.add(product);
                    System.out.println("В корзине покупок: " + shoppingCart.size());
                    break;

                case "2": //Print
                    print(shoppingCart);
                    break;

                case "3": //Remove
                    System.out.println("Список покупок: ");
                    int delNumber = 1;
                    for (String products : shoppingCart) {
                        System.out.println(delNumber + ". " + products);
                        delNumber++;
                    }
                    System.out.println("Какую хотите удалить? Выберите номер или название");
                    String delete = scanner.nextLine();
                    if (isNumber(delete)) {
                        try {
                            int i = Integer.parseInt(delete) - 1;
                            System.out.println("Вы удалили " + shoppingCart.get(i) + " из корзины");
                            shoppingCart.remove(i);
                        } catch (IndexOutOfBoundsException e) {
                            System.out.println("Этого нет в корзине! ");
                        }
                    } else if (shoppingCart.contains(delete)) {
                        System.out.println("Вы удалили " + delete + " из корзины");
                        shoppingCart.remove(delete);
                    } else {
                        System.out.println("Этого нет в корзине!");
                    }
                    break;

                case "4": //Search
                    System.out.println("Введите текст для поиска");
                    String search = scanner.nextLine();
                    System.out.println("Найдено:");
                    for (int i = 0; i < shoppingCart.size(); i++) {
                        if (shoppingCart.get(i).toLowerCase().contains(search.toLowerCase())) {
                            System.out.println(i + 1 + ". " + shoppingCart.get(i).toLowerCase());
                        }
                    }
                    break;

                default:
                    System.out.println("Неправельный ввод.");
                    break;
            }
        }
    }
}




