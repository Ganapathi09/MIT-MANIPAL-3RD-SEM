package opplabs;

import java.util.ArrayList;
import java.util.List;

interface Item {
    String getCategory();
    String getManufacturer();
    String getType();
    String getOperatingSystem();
    int getSales();
}

class Hardware implements Item {
    private String category;
    private String manufacturer;
    private int sales;

    public Hardware(String category, String manufacturer, int sales) {
        this.category = category;
        this.manufacturer = manufacturer;
        this.sales = sales;
    }

    @Override
    public String getCategory() {
        return category;
    }

    @Override
    public String getManufacturer() {
        return manufacturer;
    }

    @Override
    public String getType() {
        return null;
    }

    @Override
    public String getOperatingSystem() {
        return null;
    }

    @Override
    public int getSales() {
        return sales;
    }
}

class Software implements Item {
    private String type;
    private String operatingSystem;
    private int sales;

    public Software(String type, String operatingSystem, int sales) {
        this.type = type;
        this.operatingSystem = operatingSystem;
        this.sales = sales;
    }

    @Override
    public String getCategory() {
        return null;
    }

    @Override
    public String getManufacturer() {
        return null;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public String getOperatingSystem() {
        return operatingSystem;
    }

    @Override
    public int getSales() {
        return sales;
    }
}

public class Main1 {
    public static void main(String[] args) {
        // Create a list of items
        List<Item> items = new ArrayList<>();
        items.add(new Hardware("Laptop", "Apple", 100));
        items.add(new Software("Operating System", "Windows", 200));
        items.add(new Hardware("Desktop", "Dell", 300));
        items.add(new Software("Productivity Suite", "Office", 400));

        // Calculate total sales for hardware and software
        int totalHardwareSales = 0;
        int totalSoftwareSales = 0;
        for (Item item : items) {
            if (item instanceof Hardware) {
                totalHardwareSales += item.getSales();
            } else if (item instanceof Software) {
                totalSoftwareSales += item.getSales();
            }
        }

        // Print the results
        System.out.println("Total hardware sales: " + totalHardwareSales);
        System.out.println("Total software sales: " + totalSoftwareSales);
    }
}

