package Validate;

import Acc.AccountUser;
import io.WriteAndReaderAdmin;


import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateAccUser {

    public static final String regexname = "[A-Z][a-z]+";
    public static final String regexage = "[0-9]{1,2}";
    public static final String regexaddress = "[A-Za-z0-9]+";
    public static final String regexphone = "0[0-9]{9}";
    public static final String regexemail = "[A-Za-z0-9]+@+[a-z]+.[a-z]+";
    public static final String regexuserName = "[A-Z][a-z]{1,9}[0-9]{1,9}+";
    public static final String regexpassWord = "[A-Za-z0-9]{6,12}+";
    public static final String regexchoice = "[0-9]+";

    static Scanner sc = new Scanner(System.in);
    static WriteAndReaderAdmin writeAndReaderAdmin = new WriteAndReaderAdmin();






    public static String name() {
        while (true) {
            String Name = sc.nextLine();
            Pattern pattern = Pattern.compile(regexname);
            Matcher matcher = pattern.matcher(Name);
            if (matcher.matches()) {
                return Name;
            }
            System.out.println("Nhập sai rồi, nhập lại đi");


        }
    }

    public static String age() {
        while (true) {
            String Age = sc.nextLine();
            Pattern pattern = Pattern.compile(regexage);
            Matcher matcher = pattern.matcher(Age);
            if (matcher.matches()) {
                return Age;
            }
            System.out.println("Nhập sai rồi, nhập lại đi");
        }
    }
    public static String address(){
        while (true){
            String Address = sc.nextLine();
            Pattern pattern = Pattern.compile(regexaddress);
            Matcher matcher = pattern.matcher(Address);
            if (matcher.matches()){
                return Address;
            }
            System.out.println("Nhập sai rồi , nhập lại đi");
        }
    }
    public static String phone (){
        ArrayList<AccountUser>accountUsers=new ArrayList<>();
        while (true){
            String Phone = sc.nextLine();
            Pattern pattern = Pattern.compile(regexphone);
            Matcher matcher = pattern.matcher(Phone);
            if (matcher.matches()){
                for (int i = 1; i < writeAndReaderAdmin.reader().size(); i++) {
                    if (writeAndReaderAdmin.reader().get(i).getPhone().equals(Phone)){
                        System.out.println("số điện thoại đã được sử dụng");
                        phone();
                    }

                }
                return Phone;
            }
            System.out.println("Nhập sai rồi, nhập lại đi");
        }
    }
    public static String email(){
        while (true){
            String Email = sc.nextLine();
            Pattern pattern = Pattern.compile(regexemail);
            Matcher matcher = pattern.matcher(Email);
            if (matcher.matches()){
                for (int i = 1; i < writeAndReaderAdmin.reader().size(); i++) {
                    if (writeAndReaderAdmin.reader().get(i).getEmail().equals(Email)){
                        System.out.println("email đã tồn tại");
                        email();
                    }
                }
                return Email;
            }
            System.out.println("Nhập sai rồi, nhập lại đi");
        }
    }
    public static String username(){
        while (true){
            String userName = sc.nextLine();
            Pattern pattern = Pattern.compile(regexuserName);
            Matcher matcher = pattern.matcher(userName);
            if (matcher.matches()){
                for (int i = 1; i < writeAndReaderAdmin.reader().size(); i++) {
                    if (writeAndReaderAdmin.reader().get(i).getUserName().equals(userName)){
                        System.out.println("tài khoàn đã tồn tại");
                        username();
                    }

                }
                return userName;
            }
            System.out.println("Nhập sai rồi , nhập lại đi");
        }
    }
    public static String password(){
        while (true){
            String passWord = sc.nextLine();
            Pattern pattern = Pattern.compile(regexpassWord);
            Matcher matcher = pattern.matcher(passWord);
            if (matcher.matches()){
                return passWord;

            }
            System.out.println("Nhập sai rồi, nhập lại đi");
        }
    }
    public static String choice(){
        while (true){
            String choice = sc.nextLine();
            Pattern pattern = Pattern.compile(regexchoice);
            Matcher matcher = pattern.matcher(choice);
            if (matcher.matches()){
                return choice;
            }
            System.out.println("Chỉ nhập số");
        }
    }
    public static String gender(){
        System.out.println("1.Male");
        System.out.println("2.Female");
        System.out.println("Nhập lựa chọn của bạn");
        int choice = Integer.parseInt(sc.nextLine());
        switch (choice){
            case 1:
                return "Male";
            case 2:
                return "Female";
            default:
                return "kp con ng";

        }
    }
}
