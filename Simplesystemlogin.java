

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
// 1. Registration: user can register by  provide user_name & password Enter 1.
// 2. Login- user can login by take the register_name & paswoard  Enter 2.
// 3. Access secured page-          Enter 3
// 4. Exist             Enter 4
import java.util.HashMap;
import java.util.InputMismatchException;      // use mismatch mistake code
import java.util.Scanner;

public class Simplesystemlogin
{
    private static HashMap<String, String> users = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);
    private static boolean isAuthenticated = false;

    public static void main(String[] args)
    {
        while (true)
        {
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Access Secured Page");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = -1;

            try
            {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline
            }
            catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Consume invalid input
                continue;
            }

            switch (choice) {
                case 1:
                    register();
                    break;
                case 2:
                    login();
                    break;
                case 3:
                    accessSecuredPage();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void register()
    {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        if (users.containsKey(username))
        {
            System.out.println("Username already taken. Please choose a different username.");
            return;
        }
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        users.put(username, password);
        System.out.println("Registration successful!");
    }

    private static void login()
    {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        if (!users.containsKey(username))
        {
            System.out.println("Username not found. Please register first.");
            return;
        }
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        if (users.get(username).equals(password))
        {
            isAuthenticated = true;
            System.out.println("Login successful!");
        } else {
            System.out.println("Incorrect password. Please try again.");
        }
    }

    private static void accessSecuredPage()
    {
        if (isAuthenticated) {
            System.out.println("Welcome to the secured page!");
        } else
        {
            System.out.println("Access denied. Please login first.");
        }
    }
}

