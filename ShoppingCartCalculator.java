import java.util.ArrayList;

public class ShoppingCartCalculator {

    /**
     - คำนวณราคาสินค้าและการใช้คูปองส่วนลดโดยคำนวณจาก ราคาสินค้า*ชิ้น
     - ถ้าคูปองส่วนลด "BOGO" ให้ใช้โปรโมชั่นซื้อ 1 แถม 1  (เช่น ซื้อ 2 จ่าย 1, ซื้อ 3 จ่าย 2, ซื้อ 4 จ่าย 2) 
     - ถ้าคูปองส่วนลด "BULK" หากซื้อตั้งแต่ 6 ชิ้นขึ้นไป จะได้รับส่วนลด 10% จากราคารวมของสินค้านั้น
     @param คำนวณราคาสินค้า price*quantity
     @return คืนค่าราคาสินค้าและหากมีการ error จะส่งข้อมูลกลับมา
     */
    public static double calculateTotalPrice(ArrayList<CartItem> items) {
        // ไม่มีสินค้าหรือตะกร้าว่างเปล่า
        if (items == null || items.isEmpty()) 
            return 0.0;
        // มีสินค้าตั้งแต่ 1 ขึ้นไป
            double total = 0.0;
        for(int i = 0; i < items.size(); i++) {
            CartItem item = items.get(i);
            double itemTotal = 0.0;
            String sku = item.sku();
        if (item.quantity()>0 && item.price()>0) {

        switch (sku) {
            case "BOGO" : {
                int p = (item.quantity() / 2) + (item.quantity() % 2);
                itemTotal = p * item.price();
                break;
            }
            case "BULK" : {
                if (item.quantity() >= 6) {
                    itemTotal = ( item.quantity() * item.price() ) * 0.9;
                } else {
                    itemTotal = item.quantity() * item.price();
                }
                    break;
                }
                default : {
                    itemTotal = item.quantity() * item.price();
                }
            }
            }else{
                continue;
            }
            
            total += itemTotal; // total = total+itemTotal
        } 
        return total; 

    }
}