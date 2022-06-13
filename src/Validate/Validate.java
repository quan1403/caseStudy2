//package Validate;
//
//import io.WriteAndReader2;
//
//import java.util.Scanner;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//
//public class Validate {
//    static WriteAndReader2 writeAndReader2 = new WriteAndReader2();
//    public static final String regexid = "[1-9]+";
//    public static final String regexNameProduct = "[A-Z][a-z]{1,15}+";
//    static Scanner sc = new Scanner(System.in);
//
//    public static String id() {
//        while (true) {
//            String id = sc.nextLine();
//            Pattern pattern = Pattern.compile(regexid);
//            Matcher matcher = pattern.matcher(id);
//            if (matcher.matches()) {
//                for (int i = 1; i < writeAndReader2.reader().size(); i++) {
//                    if (writeAndReader2.reader().get(i).getIdProduct().equals(id)) {
//                        System.out.println("id đã tồn tại");
//                        id();
//                    }
//                }
//                return id;
//            }
//            System.out.println("Nhập sai rồi");
//        }
//    }
//
//    public static String idProduct() {
//        while (true) {
//            String id = sc.nextLine();
//            Pattern pattern = Pattern.compile(regexid);
//            Matcher matcher = pattern.matcher(id);
//            if (matcher.matches()) {
//                for (int i = 1; i < writeAndReader2.reader().size(); i++) {
//                    if (writeAndReader2.reader().get(i).getIdProduct().equals(id)) {
//                        System.out.println("id đã tồn tại");
//                        idProduct();
//                    }
//                }
//                return idProduct();
//            }
//            System.out.println("Nhập sai rồi");
//        }
//    }
//
//}
