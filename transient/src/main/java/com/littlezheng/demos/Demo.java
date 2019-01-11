package com.littlezheng.demos;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class Demo {

    public static void main(String[] args) {
        try (OutputStream fo = new FileOutputStream("e:/1.obj"); 
                ObjectOutputStream out = new ObjectOutputStream(fo);
                InputStream fi = new FileInputStream("e:/1.obj");
                ObjectInputStream in = new ObjectInputStream(fi)) {
            out.writeObject(new Person("Jack", 23));
            out.flush();
            
            Person p = (Person) in.readObject();
            System.out.println(p);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
