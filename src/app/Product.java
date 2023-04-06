package app;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Product {
    private String type;
    private double price;
    private boolean discount;
    LocalDate date;

    //1
    public Product(String type, int price, boolean isDiscnt, LocalDate addDate) {
        this.type = type;
        this.price = price;
        this.discount = isDiscnt;
        this.date = addDate;
    }


    public void filtering (Product[] array) {
        List<Product> expensiveBooks = Stream.of(array)
                .filter(p -> p.getType().equals("Book") && p.getPrice() > 250)
                .toList();
    }

    public String getType() {
        return type;
    }

    public void setType(String category) {
        this.type = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "type='" + type + '\'' +
                ", price=" + price +
                ", Discount=" + discount +
                ", AddDate=" + date +
                '}';
    }

    // 2
    public List<Product> getDiscountedBooks(List<Product> productList) {
        return productList.stream()
                .filter(product -> product.getType().equals("Book") && product.isDiscount())
                .peek(product -> product.setPrice((int) (product.getPrice() * 0.9)))
                .collect(Collectors.toList());
    }

    private boolean isDiscount() {
        return discount;
    }

    // 3
    public Product getCheapBook(List<Product> productList) {
        Optional<Product> cheapestBook = productList.stream()
                .filter(product -> product.getType().equals("Book"))
                .min(Comparator.comparing(Product::getPrice));

        return cheapestBook.orElseThrow(() -> new RuntimeException("Category Book not found"));
    }

    // 4
    public List<Product> getLastThreeAddedProducts(List<Product> productList) {
        return productList.stream()
                .sorted(Comparator.comparing(Product::getAddedDate).reversed())
                .limit(3)
                .collect(Collectors.toList());
    }

    public LocalDate getAddedDate() {
        return date;
    }

    // 5
    public double getTotalCostOfBooks(List<Product> productList) {
        LocalDate currentDate = LocalDate.now();
        return productList.stream()
                .filter(product -> product.getType().equals("Book")
                        && product.getPrice() <= 75
                        && product.getAddedDate().getYear() == currentDate.getYear())
                .mapToDouble(Product::getPrice)
                .sum();
    }

    // 6
    public Map<String, List<Product>> groupProductsByType(List<Product> productList) {
        return productList.stream().collect(Collectors.groupingBy(Product::getType));
    }


}
