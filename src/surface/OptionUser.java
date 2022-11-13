package surface;

import order.order.OrderManager;
import order.orderitem.OrderItemManager;
import product.ProductManagement;
import order.*;
import user.view.SaveUserManager;
import utils.*;

import java.util.Scanner;

public class OptionUser {

//    private final static String PATCH_ALLORDER = "D:\\vscode\\module2\\CSModule2\\CSModule2\\data\\AllOrder.csv";
//    static AddOrderItemInAllOrder addOrderItemInAllOrder = new AddOrderItemInAllOrder();
//    static BackMenuOrExit backMeNuOrExit = new BackMenuOrExit();
//    static TotalPrice totalPrice = new TotalPrice();
//    public static void optionUser() {
//         int choice = -1;
//        while (choice != 0 && choice != 1 && choice != 2 && choice != 3 && choice != 4 && choice != 5 && choice != 6 && choice != 7 && choice != 8) {
//            Scanner scanner = new Scanner(System.in);
//            System.out.println("\uD83D\uDC8E  \uD83D\uDC8E  \uD83D\uDC8E  \uD83D\uDC8E  \uD83D\uDC8E  \uD83D\uDC8E \uD83D\uDC8E  \uD83D\uDC8E  \uD83D\uDC8E \uD83D\uDC8E  \uD83D\uDC8E  \uD83D\uDC8E  \uD83D\uDC8E  \uD83D\uDC8E  \uD83D\uDC8E  \uD83D\uDC8E ");
//            System.out.println("\uD83D\uDC8E " + "                                                 " + " \uD83D\uDC8E ");
//            System.out.println("\uD83D\uDC8E " + "        " + "1. Hiển thị menu" + "                         " + " \uD83D\uDC8E ");
//            System.out.println("\uD83D\uDC8E " + "        " + "2. Sắp xếp theo giá tăng dần món ăn" + "      " + " \uD83D\uDC8E ");
//            System.out.println("\uD83D\uDC8E " + "        " + "3. Sắp xếp theo giá giảm dần món ăn" + "      " + " \uD83D\uDC8E ");
//            System.out.println("\uD83D\uDC8E " + "        " + "4. Order Món Ăn" + "                          " + " \uD83D\uDC8E ");
//            System.out.println("\uD83D\uDC8E " + "        " + "5.Xem lại đơn hàng vừa mua" + "               " + " \uD83D\uDC8E ");
//            System.out.println("\uD83D\uDC8E " + "        " + "6.Chỉnh sửa đơn hàng" + "                     " + " \uD83D\uDC8E ");
//            System.out.println("\uD83D\uDC8E " + "        " + "7.Xóa đơn hàng" + "                           " + " \uD83D\uDC8E ");
//            System.out.println("\uD83D\uDC8E " + "        " + "8.Xem lại tổng đơn hàng đã mua" + "           " + " \uD83D\uDC8E ");
//            System.out.println("\uD83D\uDC8E " + "        " + "0. Thoát" + "                                 " + " \uD83D\uDC8E ");
//            System.out.println("\uD83D\uDC8E " + "                                                 " + " \uD83D\uDC8E ");
//            System.out.println("\uD83D\uDC8E  \uD83D\uDC8E  \uD83D\uDC8E  \uD83D\uDC8E  \uD83D\uDC8E  \uD83D\uDC8E \uD83D\uDC8E  \uD83D\uDC8E  \uD83D\uDC8E \uD83D\uDC8E  \uD83D\uDC8E  \uD83D\uDC8E  \uD83D\uDC8E  \uD83D\uDC8E  \uD83D\uDC8E  \uD83D\uDC8E ");
//            System.out.println("Vui lòng nhập lựa chọn của bạn :");
//            System.out.printf("︻┳═一 :");
//            choice = Integer.parseInt(scanner.nextLine());
//            OrderManager orderManager = new OrderManager();
//            ProductManagement foodManager = new ProductManagement();
//            OrderItemManager orderItemManager = new OrderItemManager();
//            switch (choice) {
//                case 1:
//                    foodManager.renderProduct();
//                    backMeNuOrExit.BackMeNuOrExitUser();
//
//                    break;
//                case 2:
//                    foodManager.sortAscending();
//                    backMeNuOrExit.BackMeNuOrExitUser();
//                    break;
//                case 3:
//                    foodManager.sortDescending();
//                    backMeNuOrExit.BackMeNuOrExitUser();
//                    break;
//                case 4:
//                    orderItemManager.addOrderItem();
//                    SaveUserManager.renderSaveUser();
//                    orderItemManager.renderOrderItem();
//                    totalPrice.TotalOrderItemPrice();
//                    SaveUserManager.AddOrderItemInAllOrderUser();
//                    backMeNuOrExit.BackMeNuOrExitUser();
//                    break;
//                case 5:
//                    orderManager.renderOder();
//                    orderItemManager.renderOrderItem();
//                    totalPrice.TotalOrderItemPrice();
//                    backMeNuOrExit.BackMeNuOrExitUser();
//                    break;
//                case 6:
//                    orderItemManager.editOrderItem();
//                    System.out.println("Nhấn 1 để in hóa đơn hoặc 2 để về menu chính và 0 để thoát !! ");
//                    System.out.printf("︻┳═一 :");
//                    choice = Integer.parseInt(scanner.nextLine());
//                    switch (choice) {
//                        case 1:
//                            orderManager.renderOder();
//                            orderItemManager.renderOrderItem();
//                            totalPrice.TotalOrderItemPrice();
//                            SaveUserManager.AddOrderItemInAllOrderUser();
//                            backMeNuOrExit.BackMeNuOrExitUser();
//                            break;
//                        case 2:
//                            OptionUser.optionUser();
//                            break;
//                        case 0:
//                            System.out.println("Hẹn Gặp Lại!!!");
//                            System.exit(0);
//                            break;
//                        default:
//                            System.out.println("Vui Lòng Nhập Lại!");
//                            System.out.println("Nhấn 1 để in hóa đơn hoặc 0 để order tiếp ");
//                            System.out.printf("︻┳═一 :");
//                            choice = Integer.parseInt(scanner.nextLine());
//                    }
//                    break;
//                case 7:
//                    orderItemManager.deleteOrderItem();
//                    totalPrice.TotalOrderItemPrice();
//                    System.out.println("Nhấn 1 để in hóa đơn hoặc 2 để về menu chính và 0 để thoát !! ");
//                    System.out.printf("︻┳═一 :");
//                    choice = Integer.parseInt(scanner.nextLine());
//                    switch (choice) {
//                        case 1:
//                            orderManager.renderOder();
//                            orderItemManager.renderOrderItem();
//                            SaveUserManager.AddOrderItemInAllOrderUser();
//                            backMeNuOrExit.BackMeNuOrExitUser();
//                            break;
//                        case 2:
//                            OptionSadmin.optionSadmin();
//                            break;
//                        case 0:
//                            System.out.println("Hẹn Gặp Lại!!!");
//                            System.exit(0);
//                            break;
//                        default:
//                            System.out.println("Vui Lòng Nhập Lại!");
//                            System.out.println("Nhấn 1 để in hóa đơn hoặc 0 để order tiếp ");
//                            System.out.printf("︻┳═一 :");
//                            choice = Integer.parseInt(scanner.nextLine());
//                    }
//                    break;
//                case 8:
//                    ShowOldOrderUserManager.ShowOldOrder();
//                    ShowOldOrderUserManager.renderShowOldOrderUserManager();
//                    totalPrice.TotalOldorderUser();
//                    backMeNuOrExit.BackMeNuOrExitUser();
//                    break;
//                case 0:
//                    System.out.println("Hẹn Gặp Lại!!!");
//                    System.exit(0);
//                    break;
//                default:
//                    System.out.println("Vui Lòng Nhập Lại!");
//                    OptionUser.optionUser();
//            }
//        }
//    }
}
