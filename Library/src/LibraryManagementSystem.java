public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library(); // Create a library instance

        while (true) {
            System.out.println("Library Management System...............");
            System.out.println("1. User \t 2. Admin \t 3. Exit");

            int option = Person.scanner.nextInt();z
            switch (option) {
                case 1:
                    Person.userMenu(library);
                    break;
                case 2:
                    // Admin login functionality can be added here
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid input!");
            }
        }
    }
}
