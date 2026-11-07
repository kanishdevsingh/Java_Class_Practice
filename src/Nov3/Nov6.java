//package Nov3;
//
//
//import java.io.*;
//import java.util.*;
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
//import java.awt.Desktop;
//
//// Main Grocery Store Management System
//public class Nov6 {
//
//    static Scanner sc = new Scanner(System.in);
//
//    static final String DATA_FILE = "store.dat";
//    static final String RECORD_FOLDER = "CustomerRecords";
//    static final int LOW_STOCK_LIMIT = 5;
//
//    static StoreData store;
//
//    // ==================== MAIN METHOD ====================
//
//    public static void main(String[] args) {
//
//        store = loadData();
//
//        new File(RECORD_FOLDER).mkdirs();
//
//        int choice;
//
//        do {
//            System.out.println("\n================================");
//            System.out.println("     GROCERY STORE MANAGEMENT");
//            System.out.println("================================");
//            System.out.println("1. Register New Customer");
//            System.out.println("2. View All Customers");
//            System.out.println("3. Add Grocery Product");
//            System.out.println("4. View All Products");
//            System.out.println("5. Update Product Stock/Price");
//            System.out.println("6. Generate Customer Bill");
//            System.out.println("7. Search Customer");
//            System.out.println("8. View Customer Purchase History");
//            System.out.println("9. View Low Stock Products");
//            System.out.println("10. Export Customer History");
//            System.out.println("11. Print Customer History");
//            System.out.println("12. Exit");
//            System.out.println("================================");
//
//            choice = readInt("Enter your choice: ");
//
//            switch (choice) {
//
//                case 1:
//                    registerCustomer();
//                    break;
//
//                case 2:
//                    viewCustomers();
//                    break;
//
//                case 3:
//                    addProduct();
//                    break;
//
//                case 4:
//                    viewProducts();
//                    break;
//
//                case 5:
//                    updateProduct();
//                    break;
//
//                case 6:
//                    generateBill();
//                    break;
//
//                case 7:
//                    searchCustomer();
//                    break;
//
//                case 8:
//                    viewHistory();
//                    break;
//
//                case 9:
//                    lowStockProducts();
//                    break;
//
//                case 10:
//                    exportHistory();
//                    break;
//
//                case 11:
//                    printHistory();
//                    break;
//
//                case 12:
//                    saveData();
//                    System.out.println("Thank you for using Grocery Store!");
//                    break;
//
//                default:
//                    System.out.println("Invalid choice!");
//            }
//
//        } while (choice != 12);
//    }
//
//    // ==================== DATA CLASSES ====================
//
//    static class StoreData implements Serializable {
//
//        ArrayList<Customer> customers = new ArrayList<>();
//        ArrayList<Product> products = new ArrayList<>();
//        ArrayList<Bill> bills = new ArrayList<>();
//
//        int customerCounter = 1;
//        int productCounter = 1;
//        int billCounter = 1;
//    }
//
//    static class Customer implements Serializable {
//
//        String id;
//        String name;
//        String mobile;
//
//        Customer(String id, String name, String mobile) {
//            this.id = id;
//            this.name = name;
//            this.mobile = mobile;
//        }
//    }
//
//    static class Product implements Serializable {
//
//        String id;
//        String name;
//        double price;
//        int quantity;
//
//        Product(String id, String name,
//                double price, int quantity) {
//
//            this.id = id;
//            this.name = name;
//            this.price = price;
//            this.quantity = quantity;
//        }
//    }
//
//    static class Bill implements Serializable {
//
//        String billId;
//        String customerId;
//        LocalDateTime dateTime;
//
//        ArrayList<BillItem> items = new ArrayList<>();
//        double total;
//
//        Bill(String billId, String customerId) {
//            this.billId = billId;
//            this.customerId = customerId;
//            this.dateTime = LocalDateTime.now();
//        }
//    }
//
//    static class BillItem implements Serializable {
//
//        String productName;
//        double price;
//        int quantity;
//        double subtotal;
//
//        BillItem(String name, double price, int quantity) {
//
//            this.productName = name;
//            this.price = price;
//            this.quantity = quantity;
//            this.subtotal = price * quantity;
//        }
//    }
//
//    // ==================== FILE HANDLING ====================
//
//    static StoreData loadData() {
//
//        File file = new File(DATA_FILE);
//
//        if (!file.exists()) {
//            return new StoreData();
//        }
//
//        try {
//            ObjectInputStream in =
//                    new ObjectInputStream(new FileInputStream(file));
//
//            StoreData data = (StoreData) in.readObject();
//
//            in.close();
//
//            System.out.println("Previous data loaded successfully!");
//
//            return data;
//
//        } catch (Exception e) {
//
//            System.out.println("Error loading data:");
//            e.printStackTrace();
//
//            return new StoreData();
//        }
//    }
//
//    static void saveData() {
//
//        try {
//            ObjectOutputStream out =
//                    new ObjectOutputStream(new FileOutputStream(DATA_FILE));
//
//            out.writeObject(store);
//
//            out.close();
//
//        } catch (IOException e) {
//
//            System.out.println("Error saving data!");
//            e.printStackTrace();
//        }
//    }
//
//    // ==================== INPUT METHODS ====================
//
//    static int readInt(String message) {
//
//        while (true) {
//
//            try {
//                System.out.print(message);
//
//                int value = Integer.parseInt(sc.nextLine().trim());
//
//                return value;
//
//            } catch (NumberFormatException e) {
//
//                System.out.println("Please enter a valid number!");
//            }
//        }
//    }
//
//    static double readDouble(String message) {
//
//        while (true) {
//
//            try {
//                System.out.print(message);
//
//                double value = Double.parseDouble(sc.nextLine().trim());
//
//                if (Double.isFinite(value) && value >= 0) {
//                    return value;
//                }
//
//                System.out.println("Enter a valid non-negative amount!");
//
//            } catch (NumberFormatException e) {
//
//                System.out.println("Please enter a valid price!");
//            }
//        }
//    }
//
//    // ==================== CUSTOMER MANAGEMENT ====================
//
//    static void registerCustomer() {
//
//        System.out.println("\n--- CUSTOMER REGISTRATION ---");
//
//        System.out.print("Enter customer name: ");
//        String name = sc.nextLine().trim();
//
//        if (name.isEmpty()) {
//            System.out.println("Name cannot be empty!");
//            return;
//        }
//
//        System.out.print("Enter mobile number: ");
//        String mobile = sc.nextLine().trim();
//
//        if (!mobile.matches("[0-9]{10}")) {
//            System.out.println("Enter a valid 10-digit mobile number!");
//            return;
//        }
//
//        for (Customer c : store.customers) {
//
//            if (c.mobile.equals(mobile)) {
//                System.out.println("This mobile number is already registered!");
//                return;
//            }
//        }
//
//        String id = String.format("C%03d",
//                store.customerCounter++);
//
//        Customer customer = new Customer(id, name, mobile);
//
//        store.customers.add(customer);
//
//        saveData();
//
//        System.out.println("\nCustomer registered successfully!");
//        System.out.println("Customer ID: " + id);
//        System.out.println("Customer Name: " + name);
//    }
//
//    static void viewCustomers() {
//
//        System.out.println("\n--- ALL CUSTOMERS ---");
//
//        if (store.customers.isEmpty()) {
//            System.out.println("No customers registered.");
//            return;
//        }
//
//        System.out.printf("%-10s %-20s %-15s%n",
//                "ID", "NAME", "MOBILE");
//
//        for (Customer c : store.customers) {
//
//            System.out.printf("%-10s %-20s %-15s%n",
//                    c.id, c.name, c.mobile);
//        }
//    }
//
//    static Customer findCustomer(String keyword) {
//
//        for (Customer c : store.customers) {
//
//            if (c.id.equalsIgnoreCase(keyword) ||
//                    c.mobile.equals(keyword) ||
//                    c.name.equalsIgnoreCase(keyword)) {
//
//                return c;
//            }
//        }
//
//        return null;
//    }
//
//    static void searchCustomer() {
//
//        System.out.println("\n--- SEARCH CUSTOMER ---");
//
//        System.out.print("Enter ID, Name or Mobile: ");
//
//        String keyword = sc.nextLine().trim();
//
//        Customer c = findCustomer(keyword);
//
//        if (c == null) {
//            System.out.println("Customer not found!");
//        } else {
//            displayCustomer(c);
//        }
//    }
//
//    static void displayCustomer(Customer c) {
//
//        System.out.println("\nCustomer Details");
//        System.out.println("----------------------");
//        System.out.println("ID     : " + c.id);
//        System.out.println("Name   : " + c.name);
//        System.out.println("Mobile : " + c.mobile);
//    }
//
//    // ==================== PRODUCT MANAGEMENT ====================
//
//    static void addProduct() {
//
//        System.out.println("\n--- ADD GROCERY PRODUCT ---");
//
//        System.out.print("Enter product name: ");
//
//        String name = sc.nextLine().trim();
//
//        if (name.isEmpty()) {
//            System.out.println("Product name cannot be empty!");
//            return;
//        }
//
//        // Prevent duplicate product names
//        for (Product p : store.products) {
//
//            if (p.name.equalsIgnoreCase(name)) {
//
//                System.out.println("Product already exists!");
//                System.out.println("Use Update Product to change stock.");
//                return;
//            }
//        }
//
//        double price = readDouble("Enter price per unit: ");
//
//        int quantity = readInt("Enter available quantity: ");
//
//        if (quantity < 0) {
//            System.out.println("Quantity cannot be negative!");
//            return;
//        }
//
//        String id = String.format("P%03d",
//                store.productCounter++);
//
//        Product p = new Product(id, name, price, quantity);
//
//        store.products.add(p);
//
//        saveData();
//
//        System.out.println("\nProduct added successfully!");
//        System.out.println("Product ID: " + id);
//    }
//
//    static void viewProducts() {
//
//        System.out.println("\n--- GROCERY INVENTORY ---");
//
//        if (store.products.isEmpty()) {
//            System.out.println("No products available.");
//            return;
//        }
//
//        System.out.printf("%-8s %-20s %-12s %-10s%n",
//                "ID", "PRODUCT", "PRICE", "STOCK");
//
//        for (Product p : store.products) {
//
//            System.out.printf("%-8s %-20s Rs.%-9.2f %-10d%n",
//                    p.id, p.name, p.price, p.quantity);
//        }
//    }
//
//    static void updateProduct() {
//
//        System.out.println("\n--- UPDATE PRODUCT ---");
//
//        System.out.print("Enter Product ID or Name: ");
//
//        String keyword = sc.nextLine().trim();
//
//        Product p = findProduct(keyword);
//
//        if (p == null) {
//            System.out.println("Product not found!");
//            return;
//        }
//
//        System.out.println("Product: " + p.name);
//        System.out.println("Current Price: " + p.price);
//        System.out.println("Current Stock: " + p.quantity);
//
//        double price = readDouble("Enter new price: ");
//
//        int quantity = readInt("Enter new total stock: ");
//
//        if (quantity < 0) {
//            System.out.println("Quantity cannot be negative!");
//            return;
//        }
//
//        p.price = price;
//        p.quantity = quantity;
//
//        saveData();
//
//        System.out.println("Product updated successfully!");
//    }
//
//    static Product findProduct(String keyword) {
//
//        for (Product p : store.products) {
//
//            if (p.id.equalsIgnoreCase(keyword) ||
//                    p.name.equalsIgnoreCase(keyword)) {
//
//                return p;
//            }
//        }
//
//        return null;
//    }
//
//    // ==================== BILLING SYSTEM ====================
//
//    static void generateBill() {
//
//        System.out.println("\n========== CUSTOMER BILLING ==========");
//
//        System.out.print("Enter Customer ID, Name or Mobile: ");
//
//        String keyword = sc.nextLine().trim();
//
//        Customer customer = findCustomer(keyword);
//
//        if (customer == null) {
//            System.out.println("Customer not found! Register first.");
//            return;
//        }
//
//        displayCustomer(customer);
//
//        if (store.products.isEmpty()) {
//            System.out.println("No products available!");
//            return;
//        }
//
//        Bill bill = new Bill(
//                String.format("B%03d", store.billCounter++),
//                customer.id
//        );
//
//        // Temporary list for this bill
//        ArrayList<BillItem> cart = new ArrayList<>();
//
//        while (true) {
//
//            viewProducts();
//
//            System.out.print("\nEnter Product ID or Name (0 to finish): ");
//
//            String productName = sc.nextLine().trim();
//
//            if (productName.equals("0")) {
//                break;
//            }
//
//            Product p = findProduct(productName);
//
//            if (p == null) {
//                System.out.println("Product not found!");
//                continue;
//            }
//
//            System.out.println("Selected: " + p.name);
//            System.out.println("Available Stock: " + p.quantity);
//            System.out.println("Price: Rs. " + p.price);
//
//            int quantity = readInt("Enter purchase quantity: ");
//
//            if (quantity <= 0) {
//                System.out.println("Quantity must be greater than zero!");
//                continue;
//            }
//
//            // Check previously added quantity in this bill
//            int alreadyAdded = 0;
//
//            for (BillItem item : cart) {
//
//                if (item.productName.equalsIgnoreCase(p.name)) {
//                    alreadyAdded += item.quantity;
//                }
//            }
//
//            if (quantity + alreadyAdded > p.quantity) {
//
//                System.out.println("Insufficient stock!");
//                continue;
//            }
//
//            BillItem item = new BillItem(
//                    p.name, p.price, quantity
//            );
//
//            cart.add(item);
//
//            System.out.println("Product added to bill!");
//        }
//
//        if (cart.isEmpty()) {
//            System.out.println("No products selected. Bill cancelled.");
//            return;
//        }
//
//        // Calculate bill total
//        for (BillItem item : cart) {
//
//            bill.total += item.subtotal;
//            bill.items.add(item);
//        }
//
//        // Deduct stock only after successful bill creation
//        for (BillItem item : cart) {
//
//            Product p = findProduct(item.productName);
//
//            p.quantity -= item.quantity;
//        }
//
//        store.bills.add(bill);
//
//        saveData();
//
//        // Display final bill
//        printBill(bill, customer);
//
//        System.out.println("\nStock updated successfully!");
//
//        lowStockProducts();
//    }
//
//    // ==================== PRINT BILL ====================
//
//    static String formatBill(Bill bill, Customer customer) {
//
//        StringBuilder sb = new StringBuilder();
//
//        DateTimeFormatter dtf =
//                DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
//
//        sb.append("\n========================================\n");
//        sb.append("             GROCERY STORE\n");
//        sb.append("========================================\n");
//
//        sb.append("Bill ID : ").append(bill.billId).append("\n");
//        sb.append("Date    : ").append(bill.dateTime.format(dtf)).append("\n");
//
//        sb.append("----------------------------------------\n");
//
//        sb.append("Customer Name : ").append(customer.name).append("\n");
//        sb.append("Customer ID   : ").append(customer.id).append("\n");
//        sb.append("Mobile        : ").append(customer.mobile).append("\n");
//
//        sb.append("----------------------------------------\n");
//
//        sb.append(String.format("%-15s %5s %8s %10s%n",
//                "Product", "Qty", "Price", "Total"));
//
//        sb.append("----------------------------------------\n");
//
//        for (BillItem item : bill.items) {
//
//            sb.append(String.format("%-15s %5d %8.2f %10.2f%n",
//                    item.productName,
//                    item.quantity,
//                    item.price,
//                    item.subtotal));
//        }
//
//        sb.append("----------------------------------------\n");
//
//        sb.append(String.format("GRAND TOTAL: Rs. %.2f%n", bill.total));
//
//        sb.append("========================================\n");
//        sb.append("          THANK YOU! VISIT AGAIN\n");
//        sb.append("========================================\n");
//
//        return sb.toString();
//    }
//
//    static void printBill(Bill bill, Customer customer) {
//
//        System.out.println(formatBill(bill, customer));
//    }
//
//    // ==================== PURCHASE HISTORY ====================
//
//    static void viewHistory() {
//
//        System.out.println("\n--- CUSTOMER PURCHASE HISTORY ---");
//
//        System.out.print("Enter Customer ID, Name or Mobile: ");
//
//        String keyword = sc.nextLine().trim();
//
//        Customer customer = findCustomer(keyword);
//
//        if (customer == null) {
//            System.out.println("Customer not found!");
//            return;
//        }
//
//        displayCustomer(customer);
//
//        boolean found = false;
//
//        for (Bill bill : store.bills) {
//
//            if (bill.customerId.equals(customer.id)) {
//
//                found = true;
//
//                System.out.println("\n" + formatBill(bill, customer));
//            }
//        }
//
//        if (!found) {
//            System.out.println("No purchase history found!");
//        }
//    }
//
//    // ==================== LOW STOCK ALERT ====================
//
//    static void lowStockProducts() {
//
//        System.out.println("\n--- LOW STOCK ALERT ---");
//
//        boolean found = false;
//
//        for (Product p : store.products) {
//
//            if (p.quantity < LOW_STOCK_LIMIT) {
//
//                found = true;
//
//                System.out.println(
//                        "WARNING: " + p.name +
//                                " | Remaining Stock: " + p.quantity
//                );
//            }
//        }
//
//        if (!found) {
//            System.out.println("All products have sufficient stock.");
//        }
//    }
//
//    // ==================== EXPORT CUSTOMER HISTORY ====================
//
//    static String createCustomerHistory(Customer customer) {
//
//        StringBuilder sb = new StringBuilder();
//
//        DateTimeFormatter dtf =
//                DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
//
//        sb.append("========================================\n");
//        sb.append("       CUSTOMER PURCHASE HISTORY\n");
//        sb.append("========================================\n");
//
//        sb.append("Customer ID : ").append(customer.id).append("\n");
//        sb.append("Name        : ").append(customer.name).append("\n");
//        sb.append("Mobile      : ").append(customer.mobile).append("\n");
//
//        sb.append("========================================\n");
//
//        boolean found = false;
//
//        double totalSpent = 0;
//
//        for (Bill bill : store.bills) {
//
//            if (bill.customerId.equals(customer.id)) {
//
//                found = true;
//
//                sb.append("\nBill ID: ").append(bill.billId).append("\n");
//
//                sb.append("Date & Time: ")
//                        .append(bill.dateTime.format(dtf)).append("\n");
//
//                sb.append("----------------------------------------\n");
//
//                for (BillItem item : bill.items) {
//
//                    sb.append(item.productName)
//                            .append(" | Quantity: ").append(item.quantity)
//                            .append(" | Price: Rs. ").append(item.price)
//                            .append(" | Total: Rs. ").append(item.subtotal)
//                            .append("\n");
//                }
//
//                sb.append("Bill Total: Rs. ")
//                        .append(String.format("%.2f", bill.total))
//                        .append("\n");
//
//                totalSpent += bill.total;
//            }
//        }
//
//        if (!found) {
//            sb.append("\nNo purchase history available.\n");
//        }
//
//        sb.append("\n========================================\n");
//        sb.append("TOTAL AMOUNT SPENT: Rs. ")
//                .append(String.format("%.2f", totalSpent)).append("\n");
//
//        sb.append("========================================\n");
//
//        return sb.toString();
//    }
//
//    static Customer getCustomerForRecord() {
//
//        System.out.print("Enter Customer ID, Name or Mobile: ");
//
//        String keyword = sc.nextLine().trim();
//
//        Customer customer = findCustomer(keyword);
//
//        if (customer == null) {
//            System.out.println("Customer not found!");
//        }
//
//        return customer;
//    }
//
//    static File exportCustomerFile(Customer customer) {
//
//        File file = new File(
//                RECORD_FOLDER,
//                "Customer_" + customer.id + ".txt"
//        );
//
//        try (FileWriter fw = new FileWriter(file)) {
//
//            fw.write(createCustomerHistory(customer));
//
//            System.out.println("History exported successfully!");
//            System.out.println("File Location: " + file.getAbsolutePath());
//
//            return file;
//
//        } catch (IOException e) {
//
//            System.out.println("Error exporting history!");
//            e.printStackTrace();
//
//            return null;
//        }
//    }
//
//    static void exportHistory() {
//
//        System.out.println("\n--- EXPORT CUSTOMER HISTORY ---");
//
//        Customer customer = getCustomerForRecord();
//
//        if (customer != null) {
//            exportCustomerFile(customer);
//        }
//    }
//
//    // ==================== PRINT CUSTOMER HISTORY ====================
//
//    static void printHistory() {
//
//        System.out.println("\n--- PRINT CUSTOMER HISTORY ---");
//
//        Customer customer = getCustomerForRecord();
//
//        if (customer == null) {
//            return;
//        }
//
//        File file = exportCustomerFile(customer);
//
//        if (file == null) {
//            return;
//        }
//
//        try {
//
//            if (Desktop.isDesktopSupported() &&
//                    Desktop.getDesktop().isSupported(Desktop.Action.PRINT)) {
//
//                Desktop.getDesktop().print(file);
//
//                System.out.println("Print request sent to default printer!");
//
//            } else {
//
//                System.out.println(
//                        "Automatic printing is not supported on this system."
//                );
//
//                System.out.println("Open the exported TXT file and print it manually.");
//            }
//
//        } catch (Exception e) {
//
//            System.out.println("Unable to print the file.");
//            e.printStackTrace();
//        }
//    }
//}
//
