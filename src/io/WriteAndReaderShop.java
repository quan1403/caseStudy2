package io;

import Models.ClassShop;
import Models.Product;

import java.io.*;
import java.util.ArrayList;

public class WriteAndReaderShop {
    public void write(ArrayList<ClassShop> classShopsList){
    File file = new File("C:\\Users\\ADMIN\\Desktop\\caseStudy\\Quanlysanpham\\src\\Models\\ClassShop.txt");
    try {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(classShopsList);
        objectOutputStream.close();
        fileOutputStream.close();

    } catch (FileNotFoundException e) {
        throw new RuntimeException(e);
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
}
    public ArrayList<ClassShop> reader(){

        File file = new File("C:\\Users\\ADMIN\\Desktop\\caseStudy\\Quanlysanpham\\src\\Models\\ClassShop.txt");
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            return  (ArrayList<ClassShop>) objectInputStream.readObject();

        } catch (FileNotFoundException e) {
            System.err.println("file k tồn tại");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("file chưa tồn tại");;
        }
        return new ArrayList<>();
    }
}
