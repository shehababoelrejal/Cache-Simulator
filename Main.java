package simulator;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lenovo
 */
public class Main
{
    public static void main(String[] Args) throws IOException
    {
        BufferedWriter bw = new BufferedWriter(new FileWriter("E:\\CO Files\\Output.in", false));
        cache obj = new cache();
        obj.reader();
//        for(int j = 0; j< obj.obj.noLines;j++)
//        {
//            for(int i = 0; i< obj.obj.noWords;i++)
//            {
//                System.out.print( obj.cacheArr[j][i]+"  ");
//            } 
//        System.out.println("");
//        }
    }
}



  