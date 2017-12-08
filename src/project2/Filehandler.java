package project2;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Filehandler
{

    ArrayList<Animal> list = new ArrayList<Animal>();

    public ArrayList<Animal> getList()
    {
        return list;
    }
    private static final String RURL = "cats_dogs.txt";
    private static final String WURL = "animals.json";

    public ArrayList<Animal> read()
    {
        BufferedReader br = null;
        FileReader fr = null;

        try
        {

            fr = new FileReader(RURL);
            br = new BufferedReader(fr);

            String sCurrentLine;
            int line = 0;
            while ((sCurrentLine = br.readLine()) != null)
            {

                String[] array = sCurrentLine.split(",");
                if (line >= 1)
                {
                    list.add(new Animal(array[0], array[1], array[2], array[3]));
                }
                line++;
            }

            return list;

        } catch (IOException e)
        {

            e.printStackTrace();
            return null;

        } finally
        {

            try
            {
                if (br != null)
                {
                    br.close();
                }

                if (fr != null)
                {
                    fr.close();
                }

            } catch (IOException ex)
            {

                ex.printStackTrace();

            }

        }
    }

    public boolean jsonmethod(ArrayList<Animal> animal)
    {
        String json = new Gson().toJson(animal);
        BufferedWriter bw = null;
        FileWriter fw = null;

        try
        {

            fw = new FileWriter(WURL);
            bw = new BufferedWriter(fw);
            bw.write(json);

            System.out.println("Done");

        } catch (IOException e)
        {

            e.printStackTrace();

        } finally
        {

            try
            {

                if (bw != null)
                {
                    bw.close();
                }

                if (fw != null)
                {
                    fw.close();
                }

            } catch (IOException ex)
            {

                ex.printStackTrace();

            }

        }

        return true;
    }

}
