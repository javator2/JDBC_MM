package pl.sdacademy.jdbc;

import sun.management.FileSystemImpl;

import java.math.BigDecimal;
import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static final String URL = "jdbc:mysql://localhost/ksiegarnia?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    public static final String username = "root";
    private static final String password =  "";

    public static void addNewBook() throws SQLException {

        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);

        System.out.println("Podaj tytuł:");
        String title = scanner.nextLine();
        System.out.println("Podaj autora:");
        String author = scanner.nextLine();
        System.out.println("Podaj datę (yyyy-MM-dd):");
        String date = scanner.nextLine();
        System.out.println("Podaj unikalny numer ISBN");
        String isbn = scanner.nextLine();
        System.out.println("Podaj kategorię:");
        String category = scanner.nextLine();
        System.out.println("Podaj ilość stron:");
        int pageCount = scanner.nextInt();
        System.out.println("Podaj wydawcę:");
        String publisher = scanner.next();
        System.out.println("Podaj cenę:");
        Float price = scanner.nextFloat();
        System.out.println("Ile sztuk wprowadzasz na stan?");
        int onStock = scanner.nextInt();


        Connection connection = DriverManager.getConnection(URL, username, password);

        PreparedStatement statement1 = connection.prepareStatement("insert into books values (?,?,?,?,?,?,?,?,?)");

        statement1.setString(1, title);
        statement1.setString(2, author);
        statement1.setDate (3, Date.valueOf(date), Calendar.getInstance());
        statement1.setString(4, isbn );
        statement1.setString(5, category);
        statement1.setInt(6, pageCount);
        statement1.setString(7, publisher);
        statement1.setDouble(8, price);
        statement1.setInt(9, onStock);
        statement1.execute();
        statement1.close();
    }

    public static void main(String[] args) throws ParseException {

        Connection connection = null; // połączenie z bazą danych
        Statement statement = null; // wykonanie zapytania

        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // rejestracja sterownika
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection(URL, username, password);
            String sql = "select * from books";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

//            while(resultSet.next()){
//                int pageCount = resultSet.getInt("page_count");
//                String title = resultSet.getString("title");
//                String author = resultSet.getString("author");
//                Date date = resultSet.getDate("published");
//
//
//                System.out.println(title);
//                System.out.println(author + " " + pageCount + " " + date);
//            }
            addNewBook();
            String sqlInsert = "INSERT INTO books (title, author, isbn, category, page_count, price) VALUES (\n" +
                    "'Spanie, granie, jedzenie, spanie z nozka - how to do it better',\n" +
                    "'Michał Marchwinski',\n" +
                    "'001-22-111-0001-7',\n" +
                    "'life style',\n" +
                    "24,\n" +
                    "1269.99\n" +
                    ")";
//            statement.executeUpdate("delete from books where isbn = '001-22-111-0001-7'");
//            statement.executeUpdate("delete from books where isbn = '001-22-111-0001-8'");
//            statement.executeUpdate(sqlInsert);

            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDateTime now = LocalDateTime.now();
            System.out.println(dtf.format(now));
            java.util.Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dtf.format(now));

            java.sql.Date sqlDate = new java.sql.Date(date.getTime());

//            PreparedStatement statement1 = connection.prepareStatement("insert into books values (?,?,?,?,?,?,?,?,?)");
//            statement1.setString(1, "LifeStyle dla Ciebie!");
//            statement1.setString(2, "Znowu Ja");
//            statement1.setDate(3, sqlDate);
//            statement1.setString(4,"001-22-111-0001-8" );
//            statement1.setString(5, "bazy danych");
//            statement1.setInt(6, 15);
//            statement1.setString(7, "PWN");
//            statement1.setDouble(8, 990);
//            statement1.setInt(9, 12);
//
//            statement1.execute();

            resultSet.close();
            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }




    }
}
