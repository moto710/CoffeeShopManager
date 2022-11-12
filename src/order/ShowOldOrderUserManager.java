package order;

import utils.ReadWriteFile;
import user.SaveUser;
import user.SaveUserManager;
import utils.InstantUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import static enums.FilePath.OLD_ORDER_PATH;

public class ShowOldOrderUserManager {

//    private final static String PATCH_SHOWOLDORDER = "D:\\vscode\\module2\\CSModule2\\CSModule2\\data\\ShowOldOrder.csv";
    public static List<ShowOldOrderUser> findAll() {
        List<ShowOldOrderUser> showOldOrderUsers = new ArrayList<>();
        List<String> lines = ReadWriteFile.read(OLD_ORDER_PATH.getPath());
        for (String line : lines) {
            showOldOrderUsers.add(ShowOldOrderUser.ParseShowOldOrderUser(line));
        }
        return showOldOrderUsers;
    }
    public static void renderShowOldOrderUserManager() {
        System.out.println("㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋ALL-ORDER㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋");
        System.out.printf("\n\t%-20s %-20s %-20s %-20s %-20s %-20s  %-20s %-20s %-20s %-20s %s\n\n","ID Order", "Tên Khách Hàng","Số Điện Thoại","Địa Chỉ", "ID Sản Phẩm", "Tên Món Ăn", "Giá Tiền", "Số Lượng", "Thành Tiền", "Ngày Xuất Đơn", "㊋");
        BufferedReader br = null;
        try {
            String line;
            br = new BufferedReader(new FileReader(OLD_ORDER_PATH.getPath()));
            while ((line = br.readLine()) != null) {
                printMenu(parseCsvLine(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)
                    br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static List<String> parseCsvLine(String csvLine) {
        List<String> result = new ArrayList<>();
        if (csvLine != null) {
            String[] splitData = csvLine.split(",");
            for (int i = 0; i < splitData.length; i++) {
                result.add(splitData[i]);
            }
        }
        return result;
    }
    public static void printMenu(List<String> ShowOldOder) {
        System.out.printf("\n\t%-20s %-20s %-20s %-20s %-20s %-20s  %-20s %-20s %-20s %-20s %s\n",ShowOldOder.get(0),ShowOldOder.get(1),ShowOldOder.get(2),ShowOldOder.get(3), ShowOldOder.get(4), ShowOldOder.get(5), InstantUtils.doubleToVND(Double.parseDouble(ShowOldOder.get(6))), ShowOldOder.get(7), InstantUtils.doubleToVND(Double.parseDouble(ShowOldOder.get(8))), InstantUtils.instantToString(Instant.parse(ShowOldOder.get(9))), "㊋");
    }
    public static void ShowOldOrder(){
        List<AllOrder> allOrders = AllOrderManager.findAll();
        List<SaveUser> saveUsers = SaveUserManager.findAll();
        List<ShowOldOrderUser> showOldOrderUserList = new ArrayList<>();
        ReadWriteFile.write(OLD_ORDER_PATH.getPath(),showOldOrderUserList);
        Long idOldCustomer;
        String nameoldCustomer;
        String oldPhone;
        String oldAddress;
        Long oldIdItem;
        String oldNameFood;
        double oldPrice;
        int oldQuantity;
        Double oldtotal;
        Instant oldcreateAt;
        int count = 0;
        for (AllOrder allOrder:allOrders) {
            String fullname = allOrder.getNameCustomer();
            String phone = allOrder.getPhone();
            for (SaveUser saveUser: saveUsers) {
                String fullnameSaveUser = saveUser.getFullName();
                String phoneSaveUser = saveUser.getPhone();
                if(fullname.equals(fullnameSaveUser) && phone.equals(phoneSaveUser)){
                    showOldOrderUserList = findAll();
                    count++;
                    idOldCustomer = allOrder.getIdCustomer();
                    nameoldCustomer = allOrder.getNameCustomer();
                    oldPhone = allOrder.getPhone();
                    oldAddress = allOrder.getAddress();
                    oldIdItem = allOrder.getIditem();
                    oldNameFood = allOrder.getNameFood();
                    oldPrice = allOrder.getPrice();
                    oldQuantity = allOrder.getQuantity();
                    oldtotal = allOrder.getTotal();
                    oldcreateAt = allOrder.getCreateAt();
                    ShowOldOrderUser newShowOldOrderUser = new ShowOldOrderUser(idOldCustomer,nameoldCustomer,oldPhone,oldAddress,oldIdItem,oldNameFood,oldPrice,oldQuantity,oldtotal,oldcreateAt);
                    showOldOrderUserList.add(newShowOldOrderUser);
                    ReadWriteFile.write(OLD_ORDER_PATH.getPath(),showOldOrderUserList);
                }
            }
        }
        if(count == 0) {
            System.out.println("Khách hàng chưa mưa hàng trước đây !!");
            return;
        }
    }
    public static Double totalOldOrderPirce() {
        List<ShowOldOrderUser> showOldOrderUserList = findAll();
        Double totalOldOrderPirce = Double.valueOf(0);
        for (ShowOldOrderUser showOldOrderUser : showOldOrderUserList) {
            totalOldOrderPirce += showOldOrderUser.getTotal();
        }
        return totalOldOrderPirce;
    }
}
