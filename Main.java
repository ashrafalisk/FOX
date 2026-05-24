 import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ExpenseManager manager = new ExpenseManager();

        while (true) {
            System.out.println("\n1.Add Expense");
            System.out.println("2.View Expenses");
            System.out.println("3.Total Expense");
            System.out.println("4.Search Category");
            System.out.println("5.Exit");

            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                System.out.print("Date: ");
                String date = sc.nextLine();

                System.out.print("Category: ");
                String cat = sc.nextLine();

                System.out.print("Amount: ");
                double amt = sc.nextDouble();

                manager.addExpense(date, cat, amt);
            }

            else if (choice == 2) {
                manager.viewExpenses();
            }

            else if (choice == 3) {
                manager.totalExpense();
            }

            else if (choice == 4) {
                System.out.print("Enter category: ");
                String cat = sc.nextLine();
                manager.searchCategory(cat);
            }

            else {
                break;
            }
        }
    sc.close();
    
    }
}