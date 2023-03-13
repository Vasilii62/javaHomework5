package javaHomework5.gb;

import java.util.*;

/*Написать метод, определяющую правильность расстановки скобок в выражении.
        * Могут содержаться следующие скобки: ()[]{}<>
 * () -> true
        * []{}((<>)) -> true
        * ) -> false
        * [) -> false
        * []{}(<)> -> false*/
public class BracketValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите выражение: ");
        String expression = scanner.nextLine();

        if (isBracketsValid(expression)) {
            System.out.println("Скобки расставлены правильно");
        } else {
            System.out.println("Скобки расставлены неправильно");
        }
    }

    public static boolean isBracketsValid(String expression) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : expression.toCharArray()) {
            if (c == '(' || c == '[' || c == '{' || c == '<') {
                stack.push(c);
            } else if (c == ')' || c == ']' || c == '}' || c == '>') {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    char lastOpenBracket = stack.pop();
                    if ((c == ')' && lastOpenBracket != '(') ||
                            (c == ']' && lastOpenBracket != '[') ||
                            (c == '}' && lastOpenBracket != '{') ||
                            (c == '>' && lastOpenBracket != '<')) {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }
}
