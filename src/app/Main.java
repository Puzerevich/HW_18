package app;

import app.Product;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Product[] array = new Product[]{
                new Product("Book", 74, true, LocalDate.of(2023, 2, 11)),
                new Product("Book", 74, false, LocalDate.of(2023, 1, 1)),
                new Product("Laptop", 47,true,LocalDate.of(2023, 4, 21)),
                new Product("Monitor", 430,false, LocalDate.of(2010, 1, 1)),
                new Product("Monitor", 30,false, LocalDate.of(2003, 1, 3)),
                new Product("Phone", 47,true, LocalDate.of(2023, 3, 1)),
                new Product("Book", 44,true, LocalDate.of(2023, 2, 2)),
                new Product("Phone", 40,false, LocalDate.of(2023, 12, 1)),
                new Product("Phone", 250,true, LocalDate.of(2012, 3, 12)),
                new Product("Book", 280,true, LocalDate.of(2011, 11, 1)),
                new Product("Book", 450,true, LocalDate.of(2010, 5, 21)),
                new Product("Phone", 600,true, LocalDate.of(2009, 1, 1)),
                new Product("Laptop", 550,false, LocalDate.of(2008, 1, 18)),
                new Product("Book", 490,false, LocalDate.of(2007, 1, 1)),
                new Product("Monitor", 930,false, LocalDate.of(2023, 2, 24)),
                new Product("Phone", 240,true, LocalDate.of(2006, 1, 21)),
                new Product("Book", 300,true, LocalDate.of(2005, 5, 18)),
                new Product("Book", 600,false, LocalDate.of(2004, 1, 11)),
                new Product("Laptop", 200,false, LocalDate.of(2003, 7, 19)),
                new Product("Book", 200,true, LocalDate.of(2002, 1, 21)),
                new Product("Book", 400,true, LocalDate.of(2001, 8, 30)),
                new Product("Phone", 430,false, LocalDate.of(2000, 1, 1)),
                new Product("Monitor", 130,false, LocalDate.of(2015, 2, 15))
        };


        Product product = new Product("", 0, false, LocalDate.now());

        //filtering
        product.filtering(array);

        //Books with discount
        List<Product> discountedBooks = product.getDiscountedBooks(List.of(array));
        System.out.println("Books with discount:");
        discountedBooks.forEach(System.out::println);

        //Cheap Book
        Product cheapestBook = product.getCheapBook(List.of(array));
        System.out.println("Cheapest Book: " + cheapestBook);

        //Last Three Added Products:
        List<Product> lastThreeAddedProducts = product.getLastThreeAddedProducts(List.of(array));
        System.out.println("Last Three Added Products:");
        lastThreeAddedProducts.forEach(System.out::println);

        //Total Cost
        double totalCostOfBooks = product.getTotalCostOfBooks(List.of(array));
        System.out.println("Total Cost: " + totalCostOfBooks);

        //Products by Type
        Map<String, List<Product>> productsByType = product.groupProductsByType(List.of(array));
        System.out.println("Products by Type:");
        productsByType.forEach((type, products) -> {
            System.out.println(type + ":");
            products.forEach(System.out::println);
        });
    }
}

