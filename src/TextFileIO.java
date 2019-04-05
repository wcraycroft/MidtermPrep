import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.StringTokenizer;

// Text File IO

// Read with Scanner
// Read with BufferedReader
// Write with PrintWriter

public class TextFileIO {


    public static void readStocksWithScanner(Stock[] stockArray, String fileName) {
        // Declarations
        Scanner fileIn = null;
        FileInputStream inputStream = null;
        int companyCount = 0;   // Tracks number of companies copied to array to avoid exceeding array bound.

        // Stock instance variables;
        String name, stockSymbol;
        double stockPrice;

        // Try to open file
        try {
            inputStream = new FileInputStream(fileName);
        }
        catch (FileNotFoundException e) {
            System.err.println("Failed to open file " + fileName);
            e.printStackTrace();
            System.exit(0);
        }
        // Instantiate Scanner
        fileIn = new Scanner (inputStream);

        // Start of line read loop
        while (fileIn.hasNextLine()) {

            // Check if stockArray is full
            if (companyCount >= stockArray.length) {
                System.err.println("Could not store stock information past line "
                        + companyCount + ". Stock array is full.");
                break;
            }
            // Set delimiter to ","
            fileIn.useDelimiter(",");
            // Read company name, stock symbol (String)
            name = fileIn.next();
            stockSymbol = fileIn.next();
            // Set delimiter to white space before reading last item
            fileIn.useDelimiter("[,\\s]");
            // Read stock price (double)
            stockPrice = fileIn.nextDouble();
            // Clear newline char
            fileIn.nextLine();

            // Create Stock object and send to array, increment array counter
            stockArray[companyCount++] = new Stock(name, stockSymbol, stockPrice);

        }  // end of hastNextLine() while loop

        // Close Scanner
        fileIn.close();
    }

    /*
     * This method uses a BufferedReader to read a text file containing stock information and stores the
     * data into the passed array.
     */
    public static void readStocksWithBufferedReader(Stock[] stockArray, String fileName) {
        // Declarations
        BufferedReader fileIn = null;
        FileReader inputStream;
        String currentLine = "";
        int companyCount = 0;           // Tracks number of companies copied to array to avoid exceeding array bound.

        // Stock instance variables
        String name, stockSymbol;
        double stockPrice;

        // Instantiate and connect BufferedReader to FileReader
        try {
            inputStream = new FileReader(fileName);
            fileIn = new BufferedReader(inputStream);
        } catch (FileNotFoundException e) {
            System.err.println("Error opening file " + fileName);
            System.exit(0);
        }

        // Loop through each line until readLine returns null
        do {
            // Check if stockArray is full
            if (companyCount >= stockArray.length) {
                System.err.println("Could not store stock information past line "
                        + companyCount + ". Stock array is full.");
                break;
            }

            try {
                currentLine = fileIn.readLine();
            }
            catch (IOException e) {
                System.err.println("Error reading line " + companyCount);
            }
            // If there is a line to be read
            if (currentLine != null) {
                // Use StringTokenizer to parse information from line
                StringTokenizer tokenizer = new StringTokenizer(currentLine, ",");
                // Read name, symbol and price from tokenizer
                name = tokenizer.nextToken();
                stockSymbol = tokenizer.nextToken();
                stockPrice = Double.parseDouble(tokenizer.nextToken());

                // Create Stock object and send to array, increment array counter
                stockArray[companyCount++] = new Stock(name, stockSymbol, stockPrice);
            }

            // end of currentLine loop
        } while (currentLine != null);

        // When all files have been read, close reader
        try {
            fileIn.close();
        } catch (IOException e) {
            System.err.println("Error closing file " + fileName);
        }
    }

    /*
     * This method uses a PrintWriter to write data from an array of Stock objects to a file.
     * Takes in an array of Stock objects (Stock[]) and a file name (String).
     */
    public static void writeStocks(Stock[] stockArray, String fileName) {
        // Declarations
        PrintWriter writer = null;
        // Stock instance variables
        String name, stockSymbol;
        double stockPrice;
        // Formatter
        DecimalFormat twoDP = new DecimalFormat("0.00");

        // Instantiate writer
        try {
            // Not appending, so only String parameter
            writer = new PrintWriter(fileName);

            // Loop through stockArray
            for (Stock currentStock : stockArray) {

                if (currentStock != null) {
                    // Print each stock on new line
                    name = currentStock.getCompanyName();
                    stockSymbol = currentStock.getStockSymbol();
                    stockPrice = currentStock.getStockPrice();

                    writer.printf("%s,%s,%s\n", name, stockSymbol, twoDP.format(stockPrice));
                }
            }
            // Close writer
            writer.close();

        } catch (FileNotFoundException e) {
            System.err.println("Error creating file " + fileName);
            System.exit(0);
        }

    }
}
