import java.sql.*;
import java.util.Scanner;



public class Menu {


    public static void editing () {
        try {
            String url = "jdbc:mysql://localhost:3306/sys";
            String username = "root";
            String password = "Rootroot";
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();

            try
                    (Connection conn = DriverManager.getConnection(url, username, password)) {

                Statement statement1 = conn.createStatement();

                int rows = statement1.executeUpdate("UPDATE homebadget SET badget = badget - 1000");
                System.out.printf("Update %d  rows", rows);



                int v = statement1.executeUpdate("Update");

            }

        }
        catch (Exception e ){

            System.err.println(e);
        }
    }



    public static void delete() {
        try{
            String url = "jdbc:mysql://localhost:3306/sys";
            String username = "root";
            String password = "Rootroot";
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();

            try (Connection conn = DriverManager.getConnection(url, username, password)){

                Statement statement = conn.createStatement();

                int rows = statement.executeUpdate("DELETE FROM homebadget WHERE people_id = 41");
                System.out.printf("%d row(s) deleted", rows);

                int v = statement.executeUpdate("Update");
            }
        }

        catch(Exception ex){
            System.out.println("Connection failed...");

            System.out.println(ex);
        }
    }



    public static void add() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");



            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO homebadget (people_id,people_name,badget) value ('2','pavel','5000')");
            ResultSet resultset = statement.executeQuery("SELECT * FROM homebadget");

            while (resultset.next()) {
                System.out.println(resultset.getString(1) + " " +
                        resultset.getString(2) + " " +
                        resultset.getString(3));

            }
            int v = preparedStatement.executeUpdate();



        }catch (Exception e ){
            System.err.println(e);
        }
    }
    public static final String USER_NAME = "root";
    public static final String PASSWORD = "Rootroot";
    public  static final String URL = "jdbc:mysql://localhost:3306/sys";
    public static Statement statement;
    public static Connection connection;


    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL,USER_NAME,PASSWORD);



        }
        catch (Exception e) {
            System.err.println(e);
        }
    }

    static{
        try{
            connection = DriverManager.getConnection(URL,USER_NAME,PASSWORD);
            statement = connection.createStatement();
            System.out.println("connection");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new RuntimeException();
        }

    }



    public static void main(String[] ars) throws ClassNotFoundException, SQLException{



        Homebadget hm = new Homebadget();
        Homebadget ostap = new Homebadget();
        Homebadget oleh = new Homebadget();
        Homebadget pavlo = new Homebadget();


        boolean quit = false;
        /*   Cat cat1 =  foo(cat); */



        Scanner in = new Scanner(System.in);
        for (int i = 1; i <= 4; i++)
            System.out.println(i + ". Menu Item #" + i);
        System.out.println("0. Quit");
        int menuItem;
        do {

            System.out.print("Виберіть пункт меню:");

            menuItem = in.nextInt();
            switch (menuItem) {

                case 1:
                    System.out.println("У вас : \n" +
                            "" + Homebadget.getCount() + " \nплатників податків в списку");

                    break;

                case 2:
                    add();
                    System.out.println(":\n" +
                            "Ви добавили людину");
                    break;

                case 3:
                    delete();
                    System.out.println("Ви видалили людину з списку ");
                    break;

                case 4:
                    editing();
                    System.out.println(" Ви забрали кошти ");
                    break;


                case 0:
                    quit = true;
                    break;

                default:
                    System.out.println("Error");

            }

        } while (!quit);
        System.out.println("bye!");


    }


    private static int count = 0;

    public Menu() {
        new Counter().setCount();

    }

    public static int getCount() {
        return count;

    }

    private static class Counter {

        private void setCount() {
            count = count + 1;
        }

    }



    static class Homebadget implements Cloneable {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public Object clone() throws CloneNotSupportedException {
            return super.clone();
        }

        public void Setname(String cat) {

        }


        private static int count = 0;

        public Homebadget() {
            new Counter().setCount();
        }

        public static int getCount() {
            return count;

        }

        private static class Counter {

            private void setCount() {
                count = count + 1;
            }

        }

    }
}












