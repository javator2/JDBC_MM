package pl.sdacademy.jdbc;

import java.sql.*;

public class Main {

    public static void main(String[] args) throws SQLException {

     AddBook.addNewBook();
     }
}

//        Connection connection = null; // połączenie z bazą danych
//        Statement statement = null; // wykonanie zapytania
//
//
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver"); // rejestracja sterownika
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//
//        try {
//            connection = DriverManager.getConnection(URL, username, password);
//            String sql = "select * from books";
//            statement = connection.createStatement();
//            ResultSet resultSet = statement.executeQuery(sql);
//
//
//            } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
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
//
//            String sqlInsert = "INSERT INTO books (title, author, isbn, category, page_count, price) VALUES (\n" +
//                    "'Spanie, granie, jedzenie, spanie z nozka - how to do it better',\n" +
//                    "'Michał Marchwinski',\n" +
//                    "'001-22-111-0001-7',\n" +
//                    "'life style',\n" +
//                    "24,\n" +
//                    "1269.99\n" +
//                    ")";
//            statement.executeUpdate("delete from books where isbn = '001-22-111-0001-7'");
//            statement.executeUpdate("delete from books where isbn = '001-22-111-0001-8'");
//            statement.executeUpdate(sqlInsert);
//
//            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//            LocalDateTime now = LocalDateTime.now();
//            System.out.println(dtf.format(now));
//            java.util.Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dtf.format(now));
//
//            java.sql.Date sqlDate = new java.sql.Date(date.getTime());
//
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
//
//            resultSet.close();
//            statement.close();
//            connection.close();
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//



