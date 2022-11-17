package service;

import models.Cart;
import utils.ReadWriteFile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static enums.FilePath.CART_LIST_PATH;
import static enums.FilePath.ORDER_ITEM_PATH;

public class CartService {
    private List<Cart> cartList;

    public CartService() {
        List<Cart> cartList = new ArrayList<>();
        this.cartList = cartList;
    }

    public List<Cart> getCartList() {
        return cartList;
    }

    public void setCartList(List<Cart> cartList) {
        this.cartList = cartList;
    }
    public static List<Cart> findAll() {
        List<Cart> carts = new ArrayList<>();
        List<String> lines = ReadWriteFile.read(CART_LIST_PATH.getPath());
        for (String line : lines) {
            carts.add(Cart.ParseCart(line));
        }
        return carts;
    }
    public static void renderCart() {
        BufferedReader br = null;
        try {
            String line;
            br = new BufferedReader(new FileReader(CART_LIST_PATH.getPath()));
            while ((line = br.readLine()) != null) {
                printCart(parseCsvLine(line));
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

    public static void printCart(List<String> carts) {
        System.out.printf("%s, %s, %s, %s, %s, %s\n", carts.get(0), carts.get(1), carts.get(2), carts.get(3),
                carts.get(4), carts.get(5));
    }

    public void addCart(Cart cart) {
        List<Cart> carts = findAll();
        carts.add(cart);
        ReadWriteFile.write(CART_LIST_PATH.getPath(), carts);
    }
    public Cart findIdCart(long id) {
        List<Cart> list = findAll();
        Cart temp = new Cart();
        for (Cart item : list) {
            if (item.getIdCart() == id) {
                temp = item;
                break;
            }
        }
        return temp;
    }
    public void removeCart(long id) {
        List<Cart> list = findAll();
        list.remove(findIdCart(id));
        ReadWriteFile.write(ORDER_ITEM_PATH.getPath(), list);
    }
}
