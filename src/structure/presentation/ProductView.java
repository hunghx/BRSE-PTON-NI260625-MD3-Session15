package structure.presentation;

import structure.bussiness.ProductService;
import structure.bussiness.ProductServiceImpl;

import java.util.Scanner;

public class ProductView {
    // chứa giao diện hiển thị
    private static final ProductService productService = new ProductServiceImpl();

    public static void mainMenu(Scanner sc) {
        while (true) {
            System.out.println("""
                    -------------------------------------------------
                    1. Xem danh sách sản phẩm.
                    2. Thêm mới sản phẩm.
                    3. Cập nhật sản phẩm.
                    4. Xóa sản phẩm
                    5. Tìm kiếm sản phẩm
                    0. Thoát
                    -------------------------------------------------
                    Mời bạn nhập chức năng : 
                    """);
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    productService.showListProducts();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 0:
                    System.out.println("Cảm ơn bạn đã sử dụng dịch vụ !!");
                    return;
                default:
                    System.out.println("Chức năng không hợp lệ, vui lòng nhập lại !!");
            }
        }
    }
}
