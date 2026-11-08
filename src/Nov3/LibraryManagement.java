//package Nov3;
//
//
//import java.io.*;
//import java.util.*;
//
//public class LibraryManagement {
//
//    static Scanner sc = new Scanner(System.in);
//
//    static final String FILE_NAME = "library.dat";
//
//    static LibraryData data;
//
//    // ================= MAIN METHOD =================
//
//    public static void main(String[] args) {
//
//        data = loadData();
//
//        int choice;
//
//        do {
//            System.out.println("\n================================");
//            System.out.println("   LIBRARY MANAGEMENT SYSTEM");
//            System.out.println("================================");
//            System.out.println("1. Add Book");
//            System.out.println("2. View All Books");
//            System.out.println("3. Register Member");
//            System.out.println("4. View All Members");
//            System.out.println("5. Issue Book");
//            System.out.println("6. Return Book");
//            System.out.println("7. Search Book");
//            System.out.println("8. View Issued Books");
//            System.out.println("9. Exit");
//            System.out.println("================================");
//
//            choice = readInt("Enter your choice: ");
//
//            switch (choice) {
//
//                case 1:
//                    addBook();
//                    break;
//
//                case 2:
//                    viewBooks();
//                    break;
//
//                case 3:
//                    registerMember();
//                    break;
//
//                case 4:
//                    viewMembers();
//                    break;
//
//                case 5:
//                    issueBook();
//                    break;
//
//                case 6:
//                    returnBook();
//                    break;
//
//                case 7:
//                    searchBook();
//                    break;
//
//                case 8:
//                    viewIssuedBooks();
//                    break;
//
//                case 9:
//                    saveData();
//                    System.out.println("Thank you for using Library System!");
//                    break;
//
//                default:
//                    System.out.println("Invalid choice!");
//            }
//
//        } while (choice != 9);
//    }
//
//    // ================= DATA CLASSES =================
//
//    static class LibraryData implements Serializable {
//
//        ArrayList<Book> books = new ArrayList<>();
//        ArrayList<Member> members = new ArrayList<>();
//        ArrayList<IssueRecord> records = new ArrayList<>();
//
//        int bookCounter = 1;
//        int memberCounter = 1;
//        int issueCounter = 1;
//    }
//
//    static class Book implements Serializable {
//
//        String id;
//        String title;
//        String author;
//        int quantity;
//
//        Book(String id, String title,
//             String author, int quantity) {
//
//            this.id = id;
//            this.title = title;
//            this.author = author;
//            this.quantity = quantity;
//        }
//    }
//
//    static class Member implements Serializable {
//
//        String id;
//        String name;
//        String mobile;
//
//        Member(String id, String name, String mobile) {
//
//            this.id = id;
//            this.name = name;
//            this.mobile = mobile;
//        }
//    }
//
//    static class IssueRecord implements Serializable {
//
//        String issueId;
//        String bookId;
//        String memberId;
//        boolean returned;
//
//        IssueRecord(String issueId,
//                    String bookId,
//                    String memberId) {
//
//            this.issueId = issueId;
//            this.bookId = bookId;
//            this.memberId = memberId;
//            this.returned = false;
//        }
//    }
//
//    // ================= INPUT METHODS =================
//
//    static int readInt(String message) {
//
//        while (true) {
//
//            try {
//                System.out.print(message);
//
//                return Integer.parseInt(sc.nextLine().trim());
//
//            } catch (NumberFormatException e) {
//
//                System.out.println("Enter a valid number!");
//            }
//        }
//    }
//
//    // ================= BOOK MANAGEMENT =================
//
//    static void addBook() {
//
//        System.out.println("\n--- ADD BOOK ---");
//
//        System.out.print("Enter book title: ");
//        String title = sc.nextLine().trim();
//
//        System.out.print("Enter author name: ");
//        String author = sc.nextLine().trim();
//
//        if (title.isEmpty() || author.isEmpty()) {
//
//            System.out.println("Fields cannot be empty!");
//            return;
//        }
//
//        int quantity = readInt("Enter quantity: ");
//
//        if (quantity <= 0) {
//
//            System.out.println("Quantity must be positive!");
//            return;
//        }
//
//        String id = String.format(
//                "B%03d", data.bookCounter++
//        );
//
//        Book book = new Book(
//                id, title, author, quantity
//        );
//
//        data.books.add(book);
//
//        saveData();
//
//        System.out.println("Book added successfully!");
//        System.out.println("Book ID: " + id);
//    }
//
//    static void viewBooks() {
//
//        System.out.println("\n--- ALL BOOKS ---");
//
//        if (data.books.isEmpty()) {
//
//            System.out.println("No books available.");
//            return;
//        }
//
//        System.out.printf(
//                "%-10s %-25s %-20s %-10s%n",
//                "ID", "TITLE", "AUTHOR", "QUANTITY"
//        );
//
//        for (Book b : data.books) {
//
//            System.out.printf(
//                    "%-10s %-25s %-20s %-10d%n",
//                    b.id, b.title, b.author, b.quantity
//            );
//        }
//    }
//
//    static Book findBook(String keyword) {
//
//        for (Book b : data.books) {
//
//            if (b.id.equalsIgnoreCase(keyword)
//                    || b.title.equalsIgnoreCase(keyword)) {
//
//                return b;
//            }
//        }
//
//        return null;
//    }
//
//    static void searchBook() {
//
//        System.out.println("\n--- SEARCH BOOK ---");
//
//        System.out.print("Enter Book ID or Title: ");
//
//        String keyword = sc.nextLine().trim();
//
//        Book b = findBook(keyword);
//
//        if (b == null) {
//
//            System.out.println("Book not found!");
//
//        } else {
//
//            System.out.println("Book ID: " + b.id);
//            System.out.println("Title: " + b.title);
//            System.out.println("Author: " + b.author);
//            System.out.println("Quantity: " + b.quantity);
//        }
//    }
//
//    // ================= MEMBER MANAGEMENT =================
//
//    static void registerMember() {
//
//        System.out.println("\n--- REGISTER MEMBER ---");
//
//        System.out.print("Enter member name: ");
//        String name = sc.nextLine().trim();
//
//        System.out.print("Enter mobile number: ");
//        String mobile = sc.nextLine().trim();
//
//        if (name.isEmpty()
//                || !mobile.matches("[0-9]{10}")) {
//
//            System.out.println("Invalid member details!");
//            return;
//        }
//
//        String id = String.format(
//                "M%03d", data.memberCounter++
//        );
//
//        Member member = new Member(
//                id, name, mobile
//        );
//
//        data.members.add(member);
//
//        saveData();
//
//        System.out.println("Member registered successfully!");
//        System.out.println("Member ID: " + id);
//    }
//
//    static void viewMembers() {
//
//        System.out.println("\n--- ALL MEMBERS ---");
//
//        if (data.members.isEmpty()) {
//
//            System.out.println("No members registered.");
//            return;
//        }
//
//        for (Member m : data.members) {
//
//            System.out.println(
//                    m.id + " | " + m.name
//                            + " | " + m.mobile
//            );
//        }
//    }
//
//    static Member findMember(String id) {
//
//        for (Member m : data.members) {
//
//            if (m.id.equalsIgnoreCase(id)) {
//
//                return m;
//            }
//        }
//
//        return null;
//    }
//
//    // ================= ISSUE BOOK =================
//
//    static void issueBook() {
//
//        System.out.println("\n--- ISSUE BOOK ---");
//
//        System.out.print("Enter Member ID: ");
//        String memberId = sc.nextLine().trim();
//
//        Member member = findMember(memberId);
//
//        if (member == null) {
//
//            System.out.println("Member not found!");
//            return;
//        }
//
//        System.out.print("Enter Book ID: ");
//        String bookId = sc.nextLine().trim();
//
//        Book book = findBook(bookId);
//
//        if (book == null) {
//
//            System.out.println("Book not found!");
//            return;
//        }
//
//        if (book.quantity <= 0) {
//
//            System.out.println("Book is out of stock!");
//            return;
//        }
//
//        book.quantity--;
//
//        String issueId = String.format(
//                "I%03d", data.issueCounter++
//        );
//
//        IssueRecord record = new IssueRecord(
//                issueId, book.id, member.id
//        );
//
//        data.records.add(record);
//
//        saveData();
//
//        System.out.println("Book issued successfully!");
//        System.out.println("Issue ID: " + issueId);
//        System.out.println("Book: " + book.title);
//        System.out.println("Member: " + member.name);
//    }
//
//    // ================= RETURN BOOK =================
//
//    static void returnBook() {
//
//        System.out.println("\n--- RETURN BOOK ---");
//
//        System.out.print("Enter Issue ID: ");
//
//        String issueId = sc.nextLine().trim();
//
//        IssueRecord record = null;
//
//        for (IssueRecord r : data.records) {
//
//            if (r.issueId.equalsIgnoreCase(issueId)) {
//
//                record = r;
//                break;
//            }
//        }
//
//        if (record == null) {
//
//            System.out.println("Issue record not found!");
//            return;
//        }
//
//        if (record.returned) {
//
//            System.out.println("Book already returned!");
//            return;
//        }
//
//        Book book = findBook(record.bookId);
//
//        if (book != null) {
//
//            book.quantity++;
//        }
//
//        record.returned = true;
//
//        saveData();
//
//        System.out.println("Book returned successfully!");
//    }
//
//    // ================= ISSUED BOOKS =================
//
//    static void viewIssuedBooks() {
//
//        System.out.println("\n--- ISSUED BOOKS ---");
//
//        boolean found = false;
//
//        for (IssueRecord r : data.records) {
//
//            if (!r.returned) {
//
//                Book book = findBook(r.bookId);
//                Member member = findMember(r.memberId);
//
//                if (book != null && member != null) {
//
//                    found = true;
//
//                    System.out.println(
//                            "Issue ID: " + r.issueId
//                    );
//
//                    System.out.println(
//                            "Book: " + book.title
//                    );
//
//                    System.out.println(
//                            "Member: " + member.name
//                    );
//
//                    System.out.println("----------------------");
//                }
//            }
//        }
//
//        if (!found) {
//
//            System.out.println("No books currently issued.");
//        }
//    }
//
//    // ================= FILE HANDLING =================
//
//    static LibraryData loadData() {
//
//        File file = new File(FILE_NAME);
//
//        if (!file.exists()) {
//
//            return new LibraryData();
//        }
//
//        try (ObjectInputStream in =
//                     new ObjectInputStream(
//                             new FileInputStream(file))) {
//
//            return (LibraryData) in.readObject();
//
//        } catch (Exception e) {
//
//            System.out.println("Error loading data!");
//
//            return new LibraryData();
//        }
//    }
//
//    static void saveData() {
//
//        try (ObjectOutputStream out =
//                     new ObjectOutputStream(
//                             new FileOutputStream(FILE_NAME))) {
//
//            out.writeObject(data);
//
//        } catch (IOException e) {
//
//            System.out.println("Error saving data!");
//        }
//    }
//}
//
