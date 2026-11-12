package Bai8;
import java.util.Scanner;
public class ListCD {
	    private CD[] cdr;   
	    private int count;  
	    public ListCD(int n) {
	        this.cdr = new CD[n];
	        this.count = 0;
	    }
	    private void expandCapacity(){
	        if (count >= cdr.length){
	            CD[] tam = new CD[cdr.length * 2];
	            System.arraycopy(cdr, 0, tam, 0, count);
	            cdr = tam;
	        }
	    }
	    public boolean addCD(CD crom){
	        for (int i = 0; i < count; i++) {
	            if (cdr[i].getId().equalsIgnoreCase(crom.getId())){
	                return false;
	            }
	        }
	        expandCapacity();
	        cdr[count] = crom;
	        count++;
	        return true;
	    }
	    public boolean remove(String removeID){
	        for (int i = 0; i < count; i++) {
	            if (cdr[i].getId().equalsIgnoreCase(removeID)){
	                //dồn các phần tử phía sau lên phía trước
	                for (int j = i; j < count - 1; j++){
	                    cdr[j] = cdr[j + 1];
	                }
	                cdr[count - 1] = null;
	                count--;
	                return true;
	            }
	        }
	        return false;
	    }
	    public boolean updatePrice(String id, float price) throws Exception{
	        for (int i = 0; i < count; i++) {
	            if (cdr[i].getId().equalsIgnoreCase(id)){
	                cdr[i].setPrice(price);
	                return true;
	            }
	        }
	        return false;
	    }
	    public void printList(){
	        CD.printHeader(); 
	        for (int i = 0; i < count; i++) {
	            System.out.println(cdr[i]); 
	        }
	    }
	    public float calculateTotalCost(){
	        float sum = 0;
	        for (int i = 0; i < count; i++) {
	            sum += cdr[i].getPrice() * cdr[i].getTrackCount();
	        }
	        return sum;
	    }
	    public void inputCD (Scanner sc){
	        try {
	            System.out.println("Enter CD ID: ");
	            String id = sc.nextLine();

	            System.out.println("Enter CD title: ");
	            String title = sc.nextLine();

	            System.out.println("Enter artist name: ");
	            String artist = sc.nextLine();

	            System.out.println("Enter track count: ");
	            int trackCount = Integer.parseInt(sc.nextLine());

	            System.out.println("Enter price: ");
	            float price = Float.parseFloat(sc.nextLine());

	            CD cd = new CD(id, title, artist, trackCount, price);
	            if (addCD(cd)){
	                System.out.println("=> CD added successfully!");
	            } else {
	                System.out.println("=> CD ID already exists, addition failed!");
	            }
	        } catch (Exception e) {
	            System.out.println("=> Error" + e.getMessage());
	        }
	    }
	    public void removeCD(Scanner scanner){
	        try {
	            System.out.println("Enter CD ID to remove: ");
	            String id = scanner.nextLine();
	            boolean isRemoved = remove(id);

	            if (isRemoved) {
	                System.out.println("=> Successfully removed CD with ID: " + id);
	            } else {
	                System.out.println("=> Failed to remove: CD ID not found!");
	            }
	        } catch (Exception e) {
	            System.out.println("=> Error: " + e.getMessage());
	        }
	    }
	    public void updatePriceCD (Scanner sc) throws Exception {
	        try {
	            System.out.println("Enter CD ID to update: ");
	            String id = sc.nextLine();

	            System.out.println("Enter new price: ");
	            float newPrice = Float.parseFloat(sc.nextLine());

	            boolean isUpdated = updatePrice(id, newPrice);

	            if (isUpdated) {
	                System.out.println("=> Successfully updated price for CD ID: " + id);
	            } else {
	                System.out.println("=> Failed to update: CD ID not found!");
	            }
	        } catch (Exception e) {
	            System.out.println("=> Error: " + e.getMessage());
	        }
	    }
}

