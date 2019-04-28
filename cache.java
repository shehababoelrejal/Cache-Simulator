package simulator;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;


public class cache 
{
    int input;
    setAssoc obj = new setAssoc ();
    int cacheArr [][];
    int cacheArrTime [];
    ArrayList<Integer> Words;
    int timeCounter;
    public cache() throws IOException
    {
        this.Words = new ArrayList<Integer>();
        this.cacheArr = new int [obj.noLines][obj.noWords];
        this.cacheArrTime = new int [obj.noLines];
        obj = new setAssoc ();
        input =0;
        timeCounter=0;
        for (int i =0 ; i<obj.noLines;i++)
        {
            for (int j =0 ; j<obj.noWords;j++)
            {
                cacheArr[i][j]=-1;
            }
        }
    }
  
    void reader() throws FileNotFoundException, IOException
    {
        BufferedReader br = new BufferedReader(new FileReader("E:\\CO Files\\03-ohaa2-directmapped.in"));
        Scanner sc = new Scanner(br);
        ArrayList <Integer> array = new  ArrayList<>();
        while(sc.hasNext())
        {
            array.add(sc.nextInt());
        }
        br.close();
        obj.setW(array.get(0));
        obj.setC(array.get(1));
        obj.setB(array.get(2));
        obj.setK(array.get(3));
        obj.noSets = obj.getC()/obj.getB();
        obj.noWords = obj.getB()/obj.getK();
        obj.noLines = obj.noSets*obj.getK();
//          obj.noSets=obj.getC()/obj.getB();
        
        for(int i = 4; i < array.size(); i++)
        {
            insert(array.get(i));
        }
    }
    
    void writer(char c) throws IOException
    {
        BufferedWriter bw = new BufferedWriter(new FileWriter("E:\\CO Files\\Output.in", true));
        bw.write(c + " ");
        bw.close();
    }
    
//    int GetTag(int num)
//    {
//        String NoBinStr = Integer.toBinaryString(num);
//        BigInteger d =new BigInteger (NoBinStr);
//        NoBinStr = String.format("%0" + obj.getW() + "d", d);
//        int Tag = Integer.parseInt(NoBinStr.substring(0, obj.tagS));
//        return Tag;
//    }

    int GetSet (int num)
    {
        return GetBlock(num) % obj.noSets;
    }
    int GetBlock (int num)
    {
        return num / obj.noWords;
    }
     
    int GetWord (int num)
    {
         return num % obj.noWords;
    }

    void insert (int num) throws IOException
    {
        char m = 'M';
        char c = 'C';
        int beginLine = GetSet(num)*obj.getK();
        int counter = num;
        int counter1 = num;
        int Least = beginLine;
        for(int i = beginLine ; i < obj.getK()+beginLine; i++)
        {
          for(int j = 0 ; j < obj.noWords; j++)
          {
            if(num == cacheArr[i][j])
            {
                System.out.print("C ");
                writer(c);
                cacheArrTime[i] = timeCounter;
                timeCounter++;
                return;
            }
          }
        }
        for(int i = beginLine; i < obj.getK() + beginLine; i++)
        {
             if(cacheArr[i][0] == -1)
             {
                cacheArr[i][GetWord(num)] = num;
                cacheArrTime[i] = timeCounter;
                timeCounter++;
                for(int j = GetWord(num)+1; j < obj.noWords; j++)
                {
                    cacheArr[i][j] = counter+1;
                    counter++;
                }
                for(int j = GetWord(num)-1; j >= 0; j--)
                {
                    cacheArr[i][j] = counter1-1;
                    counter1--;
                }
                System.out.print("M ");
                writer(m);
                return;
             }
        }
        for(int i =beginLine; i<obj.getK() + beginLine-1;i++)
        {
            if(cacheArrTime[Least] > cacheArrTime[i+1])
            {
                Least = i+1;
            }
        }
        cacheArr[Least][GetWord(num)] = num;
        cacheArrTime[Least] = timeCounter;
        timeCounter++;
        for(int j = GetWord(num)+1; j < obj.noWords; j++)
        {
            cacheArr[Least][j] = counter+1;
            counter++;
        }
         
        for(int j = GetWord(num)-1; j >= 0; j--)
        {
            cacheArr[Least][j] = counter1-1;
            counter1--;
        }
        System.out.print("M ");
        writer(m);
    }
}
