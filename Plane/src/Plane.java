
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
 
public class Plane {
    Fly[] flies;
 
    public void init() {
        flies = new Fly[3];
        flies[0] = new Fly("上海", "香港");
        flies[1] = new Fly("上海", "纽约");
        flies[2] = new Fly("上海", "北京");
    }
 
    public void writeFly(Fly[] flies, File output) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(output));
            for (int i = 0; i < flies.length; i++) {
                bw.write(flies[i].getDepart() + " " + flies[i].getDest() + "\r\n");
            }
            bw.flush();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
 
    public Fly[] readFly(File file) {
        ArrayList<Fly> f = new ArrayList<Fly>();
        try {
            @SuppressWarnings("resource")
            BufferedReader br = new BufferedReader(new FileReader(file));
            String temp = "";
            while ((temp = br.readLine()) != null) {
                String[] fac = temp.trim().split(" ");
                String dep = fac[0];
                String des = fac[1];
                Fly newF = new Fly(dep, des);
                f.add(newF);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Fly[] flyarray = new Fly[f.size()];
        for (int i = 0; i < f.size(); i++) {
            flyarray[i] = f.get(i);
        }
        return flyarray;
    }
 
    public static void main(String[] args) {
        Plane p = new Plane();
        p.init();
        File file = new File("output.txt");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        p.writeFly(p.flies, file);
        Fly[] array = p.readFly(file);
        for (int i = 0; i < array.length; i++) {
            System.out.println("出发地：" + array[i].getDepart() + " , 目的地："
                    + array[i].getDest());
        }
    }
}