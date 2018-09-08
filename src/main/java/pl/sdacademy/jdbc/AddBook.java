package pl.sdacademy.jdbc;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Locale;
import java.util.Scanner;

public class AddBook {
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


        PreparedStatement statement1 = Database.getConnection().prepareStatement("insert into books values (?,?,?,?,?,?,?,?,?)");

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

        Database.closeConnection();
    }
}
