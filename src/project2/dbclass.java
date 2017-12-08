package project2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class dbclass
{
    private Connection conn = null;
    private ResultSet rs = null;
    private static final String DB_URL = "jdbc:mysql://localhost:3306/animals";
    private static final String USER = "root";
    private static final String PASS = "";
    public static ArrayList<Animal> animalsReturn = new ArrayList<Animal>();
    public static ArrayList<Animal> animals = new ArrayList<Animal>();
    public PreparedStatement pstmt;

    public void DbConnect()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (ClassNotFoundException | SQLException ex)
        {
            System.out.println("Error connecting to database");
        }
    }

    public void showList()
    {
        DbConnect();
        Animal draft;
        try
        {

            pstmt = conn.prepareStatement("SELECT * FROM animals.animals;");
            rs = pstmt.executeQuery();
            while (rs.next())
            {

                double age = rs.getDouble("age");
                String name = rs.getString("name");
                String url = rs.getString("url");
                String type = rs.getString("type");
                draft = new Animal(url, type, name, age + "");

                animalsReturn.add(draft);
            }
        } catch (SQLException ex)
        {
            Logger.getLogger(dbclass.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void populateDatabase(ArrayList<Animal> ani)
    {
        DbConnect();
        System.out.println("");
        int u = 0;
        try
        {

            for (Animal x : ani)
            {

                if (x.getType().equals("cat") || x.getType().equals("dog"))
                {
                    pstmt = conn.prepareStatement("INSERT INTO animals(url, name, type, age) VALUES (?,?,?,?);");
                    pstmt.setString(1, x.getUrl());
                    pstmt.setString(2, x.getName());
                    pstmt.setString(3, x.getType());
                    pstmt.setDouble(4, Double.valueOf(x.getAge()));
                    pstmt.executeUpdate();
                } else
                {

                    System.out.println("wrong data");

                    u = 10;

                }
            }
            if (u != 10)
            {
                pstmt.close();
                //u=0;
            }

            conn.close();
        } 
        catch (SQLException ex)
        {
            
        }
    }
    
    public ArrayList<Animal> Getlist()
    {
        return animals;
    }

    public ArrayList<Animal> GetReadyList()
    {
        return animalsReturn;
    }

    public void copyToListM(ArrayList<Animal> i)
    {
        for (Animal x : i)
        {
            animals.add(x);
        }
    }
}
