package org.example.products;

import org.example.products.models.Pants;
import org.example.products.models.Product;
import org.example.products.models.Shirt;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class Main {
  
    static final String FILE_NAME = "products.txt";

    public static void main(String[] args) {
        try {
            Product[] products = getData();
            Arrays.sort(products);

            for (Product product : products) {
                System.out.println(product);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Function Name: getData
     * @return Product[]
     * @throws FileNotFoundException
     * 
     * Inside the function:
     *   1. Loads the data from products.txt
     */
    public static Product[] getData() throws FileNotFoundException {
        FileInputStream fis = new FileInputStream(FILE_NAME);
        Scanner scanFile = new Scanner(fis).useLocale(Locale.ENGLISH);

        Product[] products = new Product[18];

        for (int i = 0; scanFile.hasNextLine(); i++) {
            String productCat = scanFile.next();

            if (productCat.equals("PANTS")) {
                products[i] = new Pants(scanFile.nextInt(), scanFile.nextDouble(), scanFile.next(), scanFile.next());
            } else if (productCat.equals("SHIRT")) {
                products[i] = new Shirt(Shirt.Size.valueOf(scanFile.next()), scanFile.nextDouble(), scanFile.next(), scanFile.next());
            }

//            switch (scanFile.next()) {
//                case ("PANTS") : products[i] = new Pants(scanFile.nextInt(), scanFile.nextDouble(), scanFile.next(), scanFile.next());
//                case ("SHIRT") : products[i] = new Shirt(Shirt.Size.valueOf(scanFile.next()), scanFile.nextDouble(), scanFile.next(), scanFile.next());
//            }
        }
        scanFile.close();

        return products;
    }

}
