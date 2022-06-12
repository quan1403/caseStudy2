package io;

import Models.Product;

import java.io.*;
import java.util.ArrayList;

public class WriteAndReader2 {
    public void write(ArrayList<Product>productList){
        File file = new File("C:\\Users\\ADMIN\\Desktop\\caseStudy\\Quanlysanpham\\src\\Models\\Product.txt");
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(productList);
            objectOutputStream.close();
            fileOutputStream.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public ArrayList<Product> reader(){

        File file = new File("C:\\Users\\ADMIN\\Desktop\\caseStudy\\Quanlysanpham\\src\\Models\\Product.txt");
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            return  (ArrayList<Product>) objectInputStream.readObject();
        } catch (FileNotFoundException e) {
            System.err.println("file k tồn tại");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("file chưa tồn tại");;
        }
        return new ArrayList<>();
    }
}
