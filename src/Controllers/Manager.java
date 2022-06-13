package Controllers;

import Acc.AccountUser;
import Models.ClassShop;
import Models.Product;
import Models.SortGiamDan;
import Models.SortTangDan;
//import Validate.Validate;

import io.WriteAndReader2;
import io.WriteAndReaderAdmin;
import io.WriteAndReaderShop;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Manager {
    static WriteAndReaderAdmin writeAndReaderAdmin = new WriteAndReaderAdmin();
    static WriteAndReader2 writeAndReader2 = new WriteAndReader2();
    static WriteAndReaderShop writeAndReaderShop = new WriteAndReaderShop();
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Product> productList = writeAndReader2.reader();
    static ArrayList<ClassShop> classShops = writeAndReaderShop.reader();
    static ArrayList<AccountUser> accountUsers = writeAndReaderAdmin.reader();


//   static ArrayList<ClassShop>classShopsList = writeAndReaderShop.reader();


    public void menuAdmin() {
        System.out.println("Hello" + ManagerAccount.accountUser.getUserName());
        System.out.println("Phần mềm quản lý sản phẩm");
        System.out.println("1.Nhập thông tin sản phẩm");
        System.out.println("2.Quản lý danh mục sản phẩm");
        System.out.println("3.Quản lý sản phẩm");
        System.out.println("4.Show danh sách tài khoản user");
        System.out.println("5.Xóa tài khoản user");
        System.out.println("6.Logout");


        int choice = Integer.parseInt(sc.nextLine());
        switch (choice) {

            case 1:
                nhapthongtinsanpham();
                break;

            case 2:
                menuDanhMuc();
                break;
            case 3:
                menuSanPham();
                break;
            case 4:
                showListAccUser();
                break;
            case 5:
                showListAccUser();
               deletedAccUser();
                break;
            case 6:
                ManagerAccount.accountUser = null;
                break;


        }
    }

    public void menuUser() {
        System.out.println("Hello" + ManagerAccount.accountUser.getUserName());
        System.out.println("Menu");
        System.out.println("1.Hiển thị danh mục sản phẩm");
        System.out.println("2.Hiển thị sản phẩm");
        System.out.println("3.Hiển thị sản phẩm theo danh mục");
        System.out.println("4.Sắp xếp theo giá tăng dần");
        System.out.println("5.Nhập tên sản phẩm muốn mua");
        System.out.println("6.Giỏ hàng của bạn ");
        System.out.println("7.Logout");
        int choice = Integer.parseInt(sc.nextLine());
        switch (choice) {
            case 1:
                showDanhMuc();
                break;
            case 2:
                showSanPham();
                break;
            case 3:
                FindSpQuaDM();
                break;
            case 4:
                Sort();
                break;
            case 5:
                showSanPham();
                Shop();
                break;
            case 6:
                ShowShop();
                break;
            case 7:
                ManagerAccount.accountUser = null;

        }
    }

    public  Product nhapDuLieuSanPham() {
       int idCategory;
        String nameCategory;
       int idProduct;
        String nameProduct;
        double price;
        int amount;
        String describe;
        try {
            System.out.println("Nhập id danh mục:");
            idCategory = Integer.parseInt(sc.nextLine());
            System.out.println("Nhập tên danh mục:");
            nameCategory = sc.nextLine();
            System.out.println("Nhập id sản phẩm:");
            idProduct = Integer.parseInt(sc.nextLine());
            System.out.println("Nhập tên của sản phẩm:");
            nameProduct = sc.nextLine();
            System.out.println("Nhập giá của sản phẩm:");
            price = Double.parseDouble(sc.nextLine());
            System.out.println("Nhập số lượng tồn:");
            amount = Integer.parseInt(sc.nextLine());
            System.out.println("Nhập mổ tả sản phẩm:");
            describe = sc.nextLine();
            return new Product(idCategory, nameCategory, idProduct, nameProduct, price, amount,describe);
        } catch (NumberFormatException e) {
            System.out.println("Lỗi rồi nhập lại đê");
            return nhapDuLieuSanPham();
        }
    }

    public void nhapthongtinsanpham() {
        productList.add(nhapDuLieuSanPham());
        writeAndReader2.write(productList);
    }

    public void menuDanhMuc() {
        System.out.println("Chọn chức năng:");
        System.out.println("1.Hiển thị danh mục sản phẩm:");
        System.out.println("2.Xóa tên danh mục sản phẩm");
        System.out.println("3.Tìm sản phẩm theo danh mục:");
        System.out.println("4.Back");
        int choice1 = Integer.parseInt(sc.nextLine());
        switch (choice1) {
            case 1:
                showDanhMuc();
                break;
            case 2:
                deletedDanhMuc();
                menuDanhMuc();
                break;
            case 3:
                FindSpQuaDM();
                break;

            case 4:
                menuAdmin();
                break;
        }
    }

    public void showDanhMuc() {
        productList=writeAndReader2.reader();
        for (Product c : productList) {
            System.out.println("id danh mục:" + c.getIdCaterory() + ";" + "tên danh mục:" + c.getNameCaterory());

        }
    }
    public int checkid(String name){

        for (int i=0; i< productList.size(); i++){
            if (productList.get(i).getNameProduct().equals(name)){
                return i;
            }
        }
        return -1;
    }

    public   void Edit(){
        System.out.println("Nhập tên sản phẩm ");
        String name = sc.nextLine();
        if (checkid(name)!=-1) {
           productList.set(checkid(name),nhapDuLieuSanPham());
            writeAndReader2.write(productList);
        }else {
            System.out.println("  Không tìm thấy tên sản phẩm");
        }
        menuAdmin();
    }

    public void deletedDanhMuc() {
        ArrayList<Product> productList = writeAndReader2.reader();
        System.out.println(productList.size());
        System.out.println("Nhập tên danh mục muốn xóa:");
        String name = sc.nextLine();
        int index =-1;
        boolean check =true;
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getNameCaterory().equals(name)) {
                index=i;
                check=false;
            }
        }
        if (check==true) {
            System.out.println("Không có tên sản phẩm");
        }
        System.out.println("Nhập y để xóa");
        System.out.println("Nhập n để thoát");
        String a = sc.nextLine();
        if (a.equals("y")) {
            System.out.println(index);
            productList.remove(index);
            writeAndReader2.write(productList);
            System.out.println("xóa thành công");
        }
        else {
            if (a.equals("n")) {
                menuSanPham();
            }
        }
    }



    public void FindSpQuaDM() {
        System.out.println("Nhập tên danh mục:");
        String name = sc.nextLine();
        Product product = null;
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getNameCaterory().equals(name)) {
                System.out.println(product = productList.get(i));
            }

        }
    }

    public void menuSanPham() {
        System.out.println("Chọn chức năng:");
        System.out.println("1.Hiển thị thông tin sản phẩm:");
        System.out.println("2.Tìm tên sản phẩm:");
        System.out.println("3.Sắp xếp sản phẩm theo giá");
        System.out.println("4.Sửa sản phẩm:");
        System.out.println("5.Xóa sản phẩm:");
        System.out.println("6.Back");
        int choice2 = Integer.parseInt(sc.nextLine());
        switch (choice2) {
            case 1:
                showSanPham();
                break;
            case 2:
                FindProduct();
                break;
            case 3:
                Sort();
                break;
            case 4:
                Edit();
                break;
            case 5:
                deleteSanPham();
                break;
            case 6:
                menuAdmin();
                break;


        }
    }

    public void showSanPham() {
        productList=writeAndReader2.reader();
        for (Product p : productList) {
            System.out.println(p.showSp());
        }
    }


    public void deleteSanPham() {
        ArrayList<Product> productList = writeAndReader2.reader();
        System.out.println(productList.size());
        System.out.println("Nhập tên sản phẩm muốn xóa:");
        String name = sc.nextLine();
        int index =-1;
        boolean check =true;
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getNameProduct().equals(name)) {
                index=i;
                check=false;
            }
        }
        if (check==true) {
            System.out.println("Không có tên sản phẩm");
        }
        System.out.println("Nhập y để xóa");
        System.out.println("Nhập n để thoát");
        String a = sc.nextLine();
        if (a.equals("y")) {
            System.out.println(index);
            productList.remove(index);
            writeAndReader2.write(productList);
            System.out.println("xóa thành công");
        }
        else {
            if (a.equals("n")) {
                menuSanPham();
            }
        }
    }


    public void FindProduct() {
        System.out.println("Nhập tên cần tìm kiếm");
        String name = sc.nextLine();

        boolean check = false;
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getNameProduct().equals(name)) {
                check = true;
                System.out.println( productList.get(i));
            }

        }
        if (check ==false){
            System.out.println("sản phẩm k tồn tại");
        }

    }

    public void Sort() {
        System.out.println("1.Sắp xếp theo giá tăng dần");
        System.out.println("2.sắp xếp theo giá giảm dần");
        int choice1 = Integer.parseInt(sc.nextLine());
        switch (choice1) {
            case 1:
                productList.sort(new SortTangDan());
                showSanPham();
                break;
            case 2:
                productList.sort(new SortGiamDan());
                showSanPham();
                break;
        }
    }

    public void Shop() {
        boolean checkShop = false;
        ClassShop classShop = new ClassShop();

        for (ClassShop shop : classShops) {
            if (shop.getUser().equals(ManagerAccount.accountUser.getUserName())) {
                checkShop = true;
                classShop = shop;
        }
        }

        System.out.println("Nhap ten san pham ");
        String name = sc.nextLine();
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getNameProduct().equals(name)) {
//                double price = productList.get(i).getPrice();
                int amount = productList.get(i).getAmount();
                if (amount < 1) {
                    System.out.println("không dủ sản phẩm");
                    menuUser();
                    break;
                }
                int amount3 = (amount - 1);
                productList.get(i).setAmount(amount3);
                writeAndReader2.write(productList);


                classShop.getProducts().add(productList.get(i));
                classShop.setPrices(classShop.getPrices() + productList.get(i).getPrice());

                if (!checkShop) {
                    classShop.setUser(ManagerAccount.accountUser.getUserName());
                    classShops.add(classShop);
                }
                writeAndReaderShop.write(classShops);
            }
        }
    }

    public void ShowShop() {
        classShops = writeAndReaderShop.reader();
        double sum = 0;
        for (int i = 0; i < classShops.size(); i++) {
            if (classShops.get(i).getUser().equals(ManagerAccount.accountUser.getUserName())) {
                System.out.println(classShops.get(i));
                sum += classShops.get(i).getPrices();
            }
        }

        System.out.println("Tong tien :" + sum);
        System.out.println("1:Thanh toan");
        System.out.println("2:Xoa san pham");
        System.out.println("3:Quay lai");
        switch (Integer.parseInt(sc.nextLine())) {
            case 1:
                ArrayList<ClassShop> classShops1 = new ArrayList<>();
                for (int i = 0; i < classShops.size(); i++) {
                    if (!classShops.get(i).getUser().equals(ManagerAccount.accountUser.getUserName())) {
                        classShops1.add(classShops.get(i));

                    }
                }
                classShops = classShops1;
                System.out.println("Cam on quy khach ");
                writeAndReaderShop.write(classShops);
                break;
            case 2:
                boolean check = true;
                System.out.println("Nhập tên sản phẩm muốn xóa :");
                String name = sc.nextLine();
                for (int i = 0; i < classShops.size(); i++) {
                    if (classShops.get(i).getUser().equals(ManagerAccount.accountUser.getUserName())){
                        for (int j = 0; j <classShops.get(i).getProducts().size(); j++) {
                            if (classShops.get(i).getProducts().get(j).getNameProduct().equals(name)){
                                double prices =  classShops.get(i).getProducts().get(j).getPrice();
                                double pricess = (sum - prices);
                                classShops.get(i).setPrices(pricess);
                                classShops.get(i).getProducts().remove(j);

                                System.out.println("Đã xóa thành công ");
                                writeAndReaderShop.write(classShops);
                                check = false;
                            }
                        }
                        System.out.println(classShops.get(i).getProducts().size());
                    }
                }
                if (check==true){
                    System.out.println("Không tìm thấy sản phẩm cần xóa");
                }
                break;
            case 3:
                break;




        }

    }
    public void showListAccUser(){
        accountUsers=writeAndReaderAdmin.reader();
        for (AccountUser acc : accountUsers) {
            System.out.println(acc);

        }
    }
    public void deletedAccUser(){
        System.out.println("Nhập tên tk muốn xóa:");
        String name = sc.nextLine();
        int index =-1;
        boolean check =true;
        for (int i = 0; i < accountUsers.size(); i++) {
            if (accountUsers.get(i).getUserName().equals(name)) {
                index=i;
                check=false;
            }
        }
        if (check==true) {
            System.out.println("Không có tên sản phẩm");
        }
        System.out.println("Nhập y để xóa");
        System.out.println("Nhập n để thoát");
        String a = sc.nextLine();
        if (a.equals("y")) {
            System.out.println(index);
            accountUsers.remove(index);
            writeAndReaderAdmin.write(accountUsers);
            System.out.println("xóa thành công");
        }
        else {
            if (a.equals("n")) {
                menuSanPham();
            }
        }
    }

}












