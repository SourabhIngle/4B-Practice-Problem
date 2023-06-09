import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Stock {

    String stockName;
    int numberOfShare;
    double sharePrice;
    double sharesValue;

    public int getNumberOfShare() {
        return numberOfShare;
    }

    public double getSharePrice() {
        return sharePrice;
    }

    public void setSharesValue(double sharesValue) {
        this.sharesValue = sharesValue;
    }


    public Stock(String stockName, int numberOfShare, double sharePrice) {
        this.stockName = stockName;
        this.numberOfShare = numberOfShare;
        this.sharePrice = sharePrice;
    }
}

public class StockAccountManagement {
    Scanner sc = new Scanner(System.in);
    double totalSharesValue = 0;
    Stock stock;
    List<Stock> stocksData = new ArrayList<>();

    void withdrawsMoney() {
        double balance = totalSharesValue;
        boolean exit = true;

        while (exit) {
            System.out.println("1 For check balance.\n2 For withdrawal money\n3 FAAAor exit");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("\n******************************\nAccount balance is " + totalSharesValue+"\n" +
                                         "******************************");
                    break;

                case 2:
                    System.out.print("\n******************************\nEnter withdrawal money amount : ");
                    int money = sc.nextInt();
                    if (money <= balance) {
                        totalSharesValue = balance - money;
                        System.out.println("Money Debited.\n" +
                                "Current balance is " +totalSharesValue);
                    } else {
                        System.out.println("Debit amount exceeded account balance." +
                                "\n******************************");
                    }
                    break;

                case 3:
                    exit = false;
                    break;

                default:
                    System.out.println("Type wrong number");
            }
        }

    }

    public void StockPortfolio() {
        for (Stock a : stocksData) {
            System.out.println("Stock Name        => " + a.stockName + "\nNumber of shares  => " + a.numberOfShare + "" +
                    "\nShare price       => " + a.sharePrice + "\n---------------------------" +
                    "\nTotal share price => " + (a.numberOfShare * a.sharePrice));
            System.out.println("--------------------------------------------------------------------");
        }
        System.out.println("********************************************************************" +
                "\nTotal Stocks value is $" + totalSharesValue + "\n" +
                "********************************************************************");
    }

    public void StockReport() {
        System.out.println("Enter how many stock do want to store :");
        int size = sc.nextInt();

        for (int i = 0; i < size; i++) {
            sc.nextLine();

            System.out.println("Enter stock name");
            String name = sc.nextLine();

            System.out.println("Enter number of shares");
            int numberOfShare = sc.nextInt();

            System.out.println("Enter stock price");
            double stockPrice = sc.nextDouble();

            stock = new Stock(name, numberOfShare, stockPrice);

            double sharesValue = stock.getNumberOfShare() * stock.getSharePrice();

            stock.setSharesValue(sharesValue);

            totalSharesValue += sharesValue;

            stocksData.add(stock);
            System.out.println("---------------------------------------------------------------\n");
        }
    }

    public static void main(String[] args) {
        StockAccountManagement stockAccountManagement = new StockAccountManagement();
        stockAccountManagement.StockReport();
        stockAccountManagement.StockPortfolio();
        stockAccountManagement.withdrawsMoney();
    }
}
