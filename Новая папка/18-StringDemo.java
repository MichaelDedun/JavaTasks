// ������
package net.thumbtack.lessons;


public class StringDemo {

    // ������� ��� �� �������!

    public static void main(String[] args) {
        String[] stringArray = {"Hello,", " ", "World", ", " ,"I", " " ,"like", " ", "you", "."};
        String fullString = "";
        for(String elem : stringArray) {
            fullString += elem;
        }
        System.out.println(fullString);

    }

}
