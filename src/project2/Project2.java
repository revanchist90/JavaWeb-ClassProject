package project2;

import java.util.ArrayList;
import java.util.Iterator;

public class Project2
{

    public static void main(String[] args)
    {

        Filehandler fhd = new Filehandler();
        fhd.read();

        dbclass db = new dbclass();
//        Iterator it = fhd.getList().listIterator();
//
//        ArrayList<Animal> arr = fhd.getList();
//
//        for (Animal x : arr)
//        {
//            System.out.println(x.getName());
//        }

        db.copyToListM(fhd.getList());
        db.populateDatabase(db.Getlist());//edw baloume ta stoieia stin basi
        db.showList();//edw ta baome stin alli lista apo tin basi
        fhd.jsonmethod(db.GetReadyList());//edw pairnoume tin lista apo tin basi
    }
}
