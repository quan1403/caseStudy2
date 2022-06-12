package io;

import Acc.AccountUser;

import java.io.*;
import java.util.ArrayList;

public class WriteAndReaderAdmin {
    static File file = new File("C:\\Users\\ADMIN\\Desktop\\caseStudy\\Quanlysanpham\\src\\Acc\\accountAdmin.txt");
    public static void write(ArrayList<AccountUser> accountAdminList){

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(accountAdminList);
            objectOutputStream.close();
            fileOutputStream.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static ArrayList<AccountUser> reader(){

        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            return  (ArrayList<AccountUser>) objectInputStream.readObject();
        } catch (FileNotFoundException e) {
            System.err.println("file k tồn tại");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("file chưa tồn tại");;
        }
        return new ArrayList<>();
    }
//    public ArrayList<AccountAdmin> reader1(String path){
//
//        File file = new File(path);
//        try {
//            FileInputStream fileInputStream = new FileInputStream(file);
//            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
//            return  (ArrayList<AccountAdmin>) objectInputStream.readObject();
//        } catch (FileNotFoundException e) {
//            System.err.println("file k tồn tại");
//        } catch (IOException | ClassNotFoundException e) {
//            System.out.println("file chưa tồn tại");;
//        }
//        return new ArrayList<>();
//    }


}
