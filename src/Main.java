import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean ready = true;
        while (ready) {
            List<String> wordList = new ArrayList<>(Arrays.asList(
                    "бегемотиха", "крокодильчик", "гипопатам", "антилопа", "шимпанзе", "шакалиха"
            ));
            String word = wordList.get((int) (Math.random() * wordList.size()));
            char[] wordChars = word.toCharArray();
            char[] newChars = new char[wordChars.length];
            List<Integer> indexes = new ArrayList<>();
            newChars[0] = wordChars[0];
            newChars[newChars.length - 1] = wordChars[wordChars.length - 1];
            for (int i = 1; i < wordChars.length - 1; i++) {
                int position = (int) (Math.random() * (wordChars.length - 2) + 1);
                if (!indexes.contains(position)) {
                    newChars[i] = wordChars[position];
                    indexes.add(position);
                } else {
                    i--;
                }
            }
            System.out.println("Попробуйте отгадать, какое животное тут зашифровано?");
            for (char c : newChars
            ) {
                System.out.print(c);
            }
            System.out.println("\nВведите ваш вариант ответа:");
            Scanner scanner2 = new Scanner(System.in);
            String answer = scanner2.next();
            if (answer.equals(word)) {
                System.out.println("Поздравляем! Вы угадали!");
            } else {
                System.out.println("К сожалению, неверно(((");
            }
            System.out.println("Сыграем еще раз? (да/нет)");
            Scanner scanner3 = new Scanner(System.in);
            switch (scanner3.next()){
                case "да":
                    break;
                case "нет":
                    System.out.println("Спасибо за игру. До встречи!");
                    ready=false;
                    break;
                default:
                    System.out.println("Неверная команда. Закрываем игру");
                    ready=false;
            }
        }
    }
}
