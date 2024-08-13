
import java.util.Objects;
import java.util.Scanner;

class Product {
     private int PId;
     private String pname;
     private String brand;
     private double price;

     public Product(int pId, String pname, String brand, double price) {
          super();
          PId = pId;
          this.pname = pname;
          this.brand = brand;
          this.price = price;
     }

     public int getPId() {
          return PId;
     }

     public void setPId(int pId) {
          PId = pId;
     }

     public String getPname() {
          return pname;
     }

     public void setPname(String pname) {
          this.pname = pname;
     }

     public String getBrand() {
          return brand;
     }

     public void setBrand(String brand) {
          this.brand = brand;
     }

     public double getPrice() {
          return price;
     }

     public void setPrice(double price) {
          this.price = price;
     }

     @Override
     public String toString() {
          return "Product [PId=" + PId + ", pname=" + pname + ", brand=" + brand + ", price=" + price + "]";
     }

     @Override
     public int hashCode() {
          return Objects.hash(PId, brand, pname, price);
     }

     @Override
     public boolean equals(Object obj) {
          if (this == obj) {
               return true;
          }
          if (obj == null || getClass() != obj.getClass()) {
               return false;
          }
          Product other = (Product) obj;
          return PId == other.PId && brand.equals(other.brand) && Double.compare(other.price, price) == 0;
     }
}

public class Driver {

     public static void main(String[] args) {
          Scanner sc = new Scanner(System.in);

          Product[] products = new Product[5];

          for (int i = 0; i < 5; i++) {
               System.out.println("Enter Product " + (i + 1) + " Details");
               System.out.print("Enter Product Id: ");
               int PId = sc.nextInt();
               sc.nextLine(); // Consume the leftover newline character
               System.out.print("Enter Product Name: ");
               String pName = sc.nextLine();
               System.out.print("Enter Product Brand: ");
               String brand = sc.nextLine();
               System.out.print("Enter Product Price: ");
               double price = sc.nextDouble();

               products[i] = new Product(PId, pName, brand, price);
          }

          System.out.println("Product List:");
          for (Product product : products) {
               System.out.println(product.toString());
          }

          System.out.println("\nChecking for duplicates:");
          for (int i = 0; i < products.length; i++) {
               for (int j = i + 1; j < products.length; j++) { // Start j from i+1 to avoid self-comparison
                    if (products[i].equals(products[j])) {
                         System.out.println(
                                   "Duplicate Product: " + products[i].toString() + " and " + products[j].toString());
                    } else {
                         System.out.println(
                                   "Different Product: " + products[i].toString() + " and " + products[j].toString());
                    }
               }
          }

          sc.close();
     }
}
