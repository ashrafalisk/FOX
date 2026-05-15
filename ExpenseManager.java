import java.util.*;
import java.io.*;

class ExpenseManager {
    ArrayList<Expense> expenses = new ArrayList<>();
    String fileName = "expenses.txt";

    void addExpense(String date, String category, double amount) {
        Expense e = new Expense(date, category, amount);
        expenses.add(e);
        saveToFile();
    }

    void viewExpenses() {
        loadFromFile();
        for (Expense e : expenses) {
            System.out.println(e.date + " | " + e.category + " | " + e.amount);
        }
    }

    void totalExpense() {
        loadFromFile();
        double sum = 0;
        for (Expense e : expenses) {
            sum += e.amount;
        }
        System.out.println("Total Expense: " + sum);
    }

    void searchCategory(String category) {
        loadFromFile();
        for (Expense e : expenses) {
            if (e.category.equalsIgnoreCase(category)) {
                System.out.println(e.date + " | " + e.category + " | " + e.amount);
            }
        }
    }

    void saveToFile() {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
            for (Expense e : expenses) {
                bw.write(e.toString());
                bw.newLine();
            }
            bw.close();
        } catch (Exception e) {
            System.out.println("Error saving file");
        }
    }

    void loadFromFile() {
        expenses.clear();
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                expenses.add(new Expense(data[0], data[1], Double.parseDouble(data[2])));
            }
            br.close();
        } catch (Exception e) {
            System.out.println("File not found");
        }
    }
}