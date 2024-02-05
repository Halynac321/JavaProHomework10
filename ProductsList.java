import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class ProductsList {
    ArrayList <Product> productsList=new ArrayList<Product>();

    public void add(Product product){
        productsList.add(product);
    }
    public void add(String type, double price){
        productsList.add(new Product(type,price));
    }
    public void add(String type, double price, boolean discount){
        productsList.add(new Product(type,price, discount));
    }

    public void add(String type, double price, boolean discount, LocalDate dateAdded){
        productsList.add(new Product(type,price, discount,dateAdded));
    }

    public List<Product> findByTypeAndCost(String type, double costmore){
        List result = productsList.stream().filter(
                s->s.getType().equals(type) && s.getPrice()>costmore).collect(Collectors.toList());
        return result;
    }

    public List<Product> findByTypeAndDiscount(String type, int discount){
        List result = productsList.stream().filter(
                s->s.getType().equals(type) && s.getDiscount()).collect(Collectors.toList()
        );
        return result;
    }

    public Product findCheapestByType (String type){
        List <Product> result = productsList.stream().filter(
                s->s.getType().equals(type)).toList();
        List <Product> newList = new ArrayList<Product>(result);
        newList.sort(Comparator.comparing(o -> o.getPrice()));
        return newList.get(0);
    }

    public List<Product> findLastAddedThreeProducts(){
        productsList.sort(Comparator.comparing(o -> o.getDateAdded()));
        int count=productsList.size();
        List<Product> result= Arrays.asList(productsList.get(count-1),productsList.get(count-2),productsList.get(count-3));
        return result;
    }

    public double totalCost (int year, String type, double cost){
        double result = productsList.stream().filter(
                s->s.getType().equals(type) && s.getPrice() < cost &&
                        s.getDateAdded().getYear() == year).mapToDouble(item -> item.getPrice()).
                sum();
        return result;
    }

    public Hashtable groupProductsByType () {
        Hashtable<String, ArrayList <Product>> result = new Hashtable<>();
        for (Product product: productsList){
            ArrayList <Product>myArray;
            if (result.containsKey(product.getType())) {
                myArray= result.get(product.getType());
            }
            else {
                myArray = new ArrayList<Product>();
                result.put(product.getType(),myArray);
            }
            myArray.add(product);
        }
        return result;
    }



}
