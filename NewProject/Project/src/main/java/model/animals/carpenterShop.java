package model.animals;



import java.awt.Point;
import java.util.ArrayList;

public class carpenterShop {
    private ArrayList<Building> buildings = new ArrayList<>();

    public boolean build(String type, Point location) {
        // در اینجا چک کردن موقعیت روی گیاه یا مزرعه فرضی قرار ندارد
        // فقط بررسی ساده برای نمونه
        for (Building b : buildings) {
            if (b.getLocation().equals(location)) {
                System.out.println("Cannot build here.");
                return false;
            }
        }
        // فرض بر ساخت موفق
        System.out.println("Building " + type + " at " + location);
        return true;
    }
}
