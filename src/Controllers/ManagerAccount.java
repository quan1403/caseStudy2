package Controllers;

import Acc.AccountUser;
import Validate.ValidateAccUser;
import io.WriteAndReaderAdmin;

import java.util.ArrayList;
import java.util.Scanner;

public class ManagerAccount {
    WriteAndReaderAdmin writeAndReaderAdmin = new WriteAndReaderAdmin();

     Scanner sc = new Scanner(System.in);

    public static AccountUser accountUser = null;
    ArrayList<AccountUser>accountUsers= WriteAndReaderAdmin.reader();

    {
       if (accountUsers.size()==0){
           accountUsers.add(new AccountUser("admin","admin","admin"));
           WriteAndReaderAdmin.write(accountUsers);
       }

    }

    public void menuLogin(){
        System.out.println("1.Login");
        System.out.println("2.Register");
        int choice = Integer.parseInt(sc.nextLine());
        switch (choice){
            case 1:
                login();
                break;
            case 2:
                register();
                break;

        }
    }
    public boolean login(){
        System.out.println("Nhập userName: ");
        String user = sc.nextLine();
        System.out.println("Nhập passWord:");
        String pass = sc.nextLine();

        for (int i=0; i<accountUsers.size();i++) {
            if (accountUsers.get(i).getUserName().equals(user)&& accountUsers.get(i).getPassWord().equals(pass)){
                ManagerAccount.accountUser =accountUsers.get(i);
                return true;
            }

        }
        return false;
    }
    public void register(){
        System.out.println("Tạo tài khoản:");

        System.out.println("Nhập họ và tên: - Viết hoa chữ cái đầu");
        String name = ValidateAccUser.name();
        System.out.println("Nhập tuổi:");
        String age = ValidateAccUser.age();
        System.out.println("Chọn giới tính");
        String gender = ValidateAccUser.gender();
        System.out.println("Nhập số điện thoại - nhập 10 số bắt đầu bằng số 0");
        String phone = ValidateAccUser.phone();
        System.out.println("Nhập địa chỉ:");
        String address = ValidateAccUser.address();
        System.out.println("Nhập email");
        String email = ValidateAccUser.email();


        String user = null;
        while (true){
            System.out.println("Nhập userName:");
            System.out.println("Viết hoa chữ cái đầu và có số");

            user = ValidateAccUser.username();
            if (checkUserName(user)){
                break;
            }else {
                System.err.println("trùng userName");
            }
        }
        System.out.println("Nhập passWord:");
        System.out.println("Mật khẩu không có ký tự đặc biệt");
        String pass = ValidateAccUser.password();




        accountUsers.add(new AccountUser(name,age,gender,phone,address,email,user,pass,"role"));
        writeAndReaderAdmin.write(accountUsers);
    }

    public boolean checkUserName(String userName){
        for (AccountUser acc :accountUsers) {
            if (acc.getUserName().equals(userName)){
                return false;
            }

        }
        return true;
    }



}
