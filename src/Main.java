import Acc.AccountUser;
import Controllers.Manager;
import Controllers.ManagerAccount;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Manager manager = new Manager();
        ManagerAccount managerAccount = new ManagerAccount();
        while (true){
           if (ManagerAccount.accountUser == null){
               managerAccount.menuLogin();
           }else {
               if (ManagerAccount.accountUser.getRole().equals("admin")){
                   manager.menuAdmin();
               }else {
                   manager.menuUser();
               }
           }
        }
    }
}
