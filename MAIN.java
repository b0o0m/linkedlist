import java.util.Objects;
import java.util.Scanner;

public class MAIN {

    private static String command;

    public static void main(String[] args) {
        linkedList linkedList = new linkedList();
        label:
        while (true) {
            int number = 1;
            Scanner scanner = new Scanner(System.in);
            String toDoInput = scanner.nextLine();
            if (toDoInput.equals("print")){
                linkedList.print();
            }else if (toDoInput.equals("findMiddle")){
                linkedList.findMiddle();
                System.out.println(linkedList.getMiddleElement());
            }
            else {
                String[] s = toDoInput.split(" ");
                command = s[0];
                number = Integer.parseInt(s[1]);
            }

            switch (Objects.requireNonNull(command)) {
                case "add":
                    linkedList.add(number);
                    break;
                case "addFirst":
                    linkedList.addFirst(number);
                    break;
                case "removeMiddle":
                    linkedList.removeMiddle();
                    break;
                case "contains":
                    linkedList.contains(linkedList.head, number);
                    break;
                case "removeIndex":
                    linkedList.removeIndex(number);
                    break;
                case "finish":
                    break label;
            }

        }

    }
}
