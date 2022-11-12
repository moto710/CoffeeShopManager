package surface;

import product.ProductManagement;
import login.view.LoginTemplate;
import order.AllOrderManager;
import order.DayOrderManager;
import order.OrderItemManager;
import order.OrderManager;
import utils.AddOrderItemInAllOrder;
import utils.BackMenuOrExit;
import utils.TotalPrice;

public class OptionAdmin extends LoginTemplate {

    static AddOrderItemInAllOrder addOrderItemInAllOrder = new AddOrderItemInAllOrder();
    static BackMenuOrExit backMenuOrExit = new BackMenuOrExit();
    static TotalPrice totalPrice = new TotalPrice();

    @Override
    protected void showBody() {
        boolean flag = false;
        do {
            menuAdmin();
            RenderList renderList = new RenderList();
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    renderList.renderMenuManager();
                    ProductManagement foodManager = new ProductManagement();
                    System.out.println("Vui lòng nhập lựa chọn của bạn: ");
                    System.out.printf("︻┳═一 :");
                    choice = Integer.parseInt(scanner.nextLine());
                    switch (choice) {
                        case 1:
                            foodManager.renderProduct();
                            backMenuOrExit.BackMeNuOrExitAdmin();
                            break;

                        case 2:
                            foodManager.addProduct();
                            backMenuOrExit.BackMeNuOrExitAdmin();
                            break;
                        case 3:
                            foodManager.removeProduct();
                            backMenuOrExit.BackMeNuOrExitAdmin();
                            break;
                        case 4:
                            foodManager.editProduct();
                            backMenuOrExit.BackMeNuOrExitAdmin();

                            break;
                        case 5:
                            foodManager.searchName();
                            backMenuOrExit.BackMeNuOrExitAdmin();
                            break;
                        case 6:
                            foodManager.sortAscending();
                            backMenuOrExit.BackMeNuOrExitAdmin();
                            break;
                        case 7:
                            foodManager.sortDescending();
                            backMenuOrExit.BackMeNuOrExitAdmin();
                            break;
                        case 0:
                            System.out.println("Hẹn Gặp Lại!!!");
                            System.exit(0);
                            break;
                        default:
                            System.out.println("Vui Lòng Nhập Lại!");
                            choice = 1;
                    }
                    break;
                case 2:
                    renderList.renderOrderManager();
                    OrderManager orderManager = new OrderManager();
                    OrderItemManager orderItemManager = new OrderItemManager();
                    AllOrderManager allOrderManager = new AllOrderManager();
                    DayOrderManager dayOrderManager = new DayOrderManager();
                    System.out.println("Vui lòng nhập lựa chọn của bạn: ");
                    System.out.printf("︻┳═一 :");
                    choice = Integer.parseInt(scanner.nextLine());
                    switch (choice) {
                        case 1: //hiển thị tổng oder
                            allOrderManager.renderAllOrder();
                            totalPrice.TotalAllOrderPrice();
                            backMenuOrExit.BackMeNuOrExitAdmin();
                            break;
                        case 2: // hiển thị order theo ngày
                            dayOrderManager.SortByDayOrder();
                            totalPrice.TotalDayPrice();
                            backMenuOrExit.BackMeNuOrExitAdmin();
                            break;
                        case 3: //thêm đơn đặt hàng
                            orderManager.addOrder();
                            orderItemManager.addOrderItem();
                            orderManager.renderOder();
                            orderItemManager.renderOrderItem();
                            totalPrice.TotalOrderItemPrice();
                            addOrderItemInAllOrder.AddOrderItemInAllOrder();
                            backMenuOrExit.BackMeNuOrExitAdmin();
                            break;
                        case 4:// sửa đơn đặt hàng
                            orderItemManager.editOrderItem();
                            addOrderItemInAllOrder.AddOrderItemInAllOrder();
                            System.out.println("Nhấn 1 để in hóa đơn hoặc 2 để về menu chính và 0 để thoát !! ");
                            System.out.printf("︻┳═一 :");
                            choice = Integer.parseInt(scanner.nextLine());
                            switch (choice) {
                                case 1:
                                    orderManager.renderOder();
                                    orderItemManager.renderOrderItem();
                                    totalPrice.TotalOrderItemPrice();
                                    backMenuOrExit.BackMeNuOrExitAdmin();
                                    break;
                                case 0:
                                    System.out.println("Hẹn Gặp Lại!!!");
                                    System.exit(0);
                                    break;
                                default:
                                    System.out.println("Vui Lòng Nhập Lại!");
                                    System.out.println("Nhấn 1 để in hóa đơn hoặc 0 để order tiếp ");
                                    System.out.printf("︻┳═一 :");
                                    choice = Integer.parseInt(scanner.nextLine());
                            }
                            break;
                        case 5: //xóa đơn đặt hàng
                            orderItemManager.deleteOrderItem();
                            addOrderItemInAllOrder.AddOrderItemInAllOrder();
                            System.out.println("Nhấn 1 để in hóa đơn hoặc 2 để về menu chính và 0 để thoát !! ");
                            System.out.printf("︻┳═一 :");
                            choice = Integer.parseInt(scanner.nextLine());
                            switch (choice) {
                                case 1:
                                    orderManager.renderOder();
                                    orderItemManager.renderOrderItem();
                                    totalPrice.TotalOrderItemPrice();
                                    backMenuOrExit.BackMeNuOrExitAdmin();
                                    break;
                                case 0:
                                    System.out.println("Hẹn Gặp Lại!!!");
                                    System.exit(0);
                                    break;
                                default:
                                    System.out.println("Vui Lòng Nhập Lại!");
                                    System.out.println("Nhấn 1 để in hóa đơn hoặc 0 để order tiếp ");
                                    System.out.printf("︻┳═一 :");
                                    choice = Integer.parseInt(scanner.nextLine());
                            }
                            break;
                        case 0:
                            System.out.println("Hẹn Gặp Lại!!!");
                            System.exit(0);
                            break;
                        default:
                            System.out.println("Vui Lòng Nhập Lại!");
                            choice = 3;
                    }
                    break;
                case 0:
                    System.out.println("Good bye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Enter your choice again!");
                    break;
            }

        }while (flag);
    }
    public static void menuAdmin() {
        System.out.println("-------------------------------------------------------");
        System.out.println("");
        System.out.println("\t1. Manage product");
        System.out.println("\t2. Manage Cart");
        System.out.println("\t0. Exit!");
        System.out.println("");
        System.out.println("-------------------------------------------------------");
        System.out.println("Enter your choice:");
        System.out.print("===>");
    }
}

