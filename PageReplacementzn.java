
package pagereplacementzn;

import java.util.Scanner;


public class PageReplacementzn {

    public static void main(String[] args) {
        
              int pages[] ;
              int capacity;
              int noOfPAges;
              Scanner sc=new Scanner(System.in);
              int input;
              int choice;
       
         System.out.println("enter number of slots");
         capacity = sc.nextInt();
          
         System.out.println("enter number of pages to be allocated");
         noOfPAges = sc.nextInt();
         pages = new int[noOfPAges]; 
         
         System.out.println("Enter the " + noOfPAges+ " pages");
         for (int h=0;h<noOfPAges;h++){
         input=sc.nextInt();
         pages[h]=input;
         
         }
         
        System.out.println("Select Algorithm for Page Replacement \n "
                 + "1 for FIFO \n "
                 + "2 for LRU \n"
                 + " 3 for Optimal");
         choice=sc.nextInt();
         
         
         switch(choice) {
         case(1):
         FIFO a = new FIFO (capacity, pages, noOfPAges);
         break;
         
         case(2):
         LRU b = new LRU (capacity, pages, noOfPAges);
         break;
         
         case(3):
         Optimal c = new Optimal (capacity, pages, noOfPAges);
         break;
         
         }
    
    }
    
}
