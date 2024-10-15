import java.util.Scanner;

public class UI {
    private Scanner _in;

    /**
     * Конструктор по умолчанию для класса UI
     */
    UI(){
        _in = new Scanner(System.in);
    }

    /**
     * Запускает интерфейс для взаимодействия пользователя с программой
     */
    public void Run(){

        boolean flag = true;
        while (flag){
            try {
                System.out.println("Введите строки на проверку:");
                String str = _in.nextLine();

                HTMLcode code = new HTMLcode(str.split(" "));
                code.Check();

                String[] Res = code.get_all_results();
                for (var i : Res){
                    System.out.println(i);
                }

                flag = false;

            } catch (RuntimeException e){
                System.out.println("Некорректный ввод данных");
            }
        }
    }
}
