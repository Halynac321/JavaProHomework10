import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        System.out.println("Homework 10");
        ProductsList myProducts=new ProductsList();
        myProducts.add("Book",100, false, LocalDate.parse("2022-01-01"));
        myProducts.add("Book",70, false, LocalDate.parse("2021-01-01"));
        myProducts.add("Book",50, false, LocalDate.parse("2020-01-01"));
        myProducts.add("Book",350, false, LocalDate.parse("2020-01-01"));
        myProducts.add("Book",30, false, LocalDate.parse("2024-01-01"));
        myProducts.add("Book",40, false, LocalDate.parse("2024-01-01"));
        myProducts.add("Toy",100, false, LocalDate.parse("2022-10-10"));
        myProducts.add("Candy",5, false, LocalDate.parse("2022-10-10"));

        System.out.println("Testing  метод отримання всіх продуктів як списку, категорія яких еквівалентна “Book");
        List<Product> result= myProducts.findByTypeAndCost("Book",250);
        for (Product product: result){
            System.out.println("Product:" + product.getType() + ", Cost: " + product.getPrice());
        }

        System.out.println("Testing  метод отримання найдешевшого продукту з категорії Book");
        Product resulr2= myProducts.findCheapestByType("Book");
        System.out.println("Product:" + resulr2.getType() + ", Cost:" + resulr2.getPrice());

        System.out.println("Testing  метод отримання трьох останніх доданих продуктів");
        List<Product> result3= myProducts.findLastAddedThreeProducts();
        for (Product product: result3){
            System.out.println("Product:" + product.getType() + ", Cost: " + product.getPrice()
                    + ", Date:" + product.getDateAdded());
        }

        System.out.println("Testing метод калькуляції загальної вартості продуктів, які відповідають критеріям:");
        double result4= myProducts.totalCost(2024,"Book",75);
        System.out.println("Total cost: " + result4);

        System.out.println("Testing метод групування об'єктів за типом продукту.");
        Hashtable<String, ArrayList <Product>> result5= myProducts.groupProductsByType();
        for (String key: result5.keySet()){
            System.out.println("Type:" + key + ", Comut: " + result5.get(key).size());
        }

    }
}