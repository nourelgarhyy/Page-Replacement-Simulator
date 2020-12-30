
package pagereplacementzn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class FIFO {
   public ArrayList <Integer> pageSlots=new ArrayList();
   public Queue <Integer> ref = new LinkedList();
   public int pageFaults=0;
   public int d;

   
     FIFO(int noOfPageSlots, int pages[], int noOfPages ){
        for (int h=0; h<noOfPages; h++){
            if(pageSlots.size() < noOfPageSlots){ //empty spaces
                if(!pageSlots.contains(pages[h]) ){ //page doest exist 
            pageFaults++;
            pageSlots.add(pages[h]);
            ref.add(pages[h]);    //add in queue 
            } 
                
               System.out.println("after Page Fault:");
               for(int k=0;k<pageSlots.size();k++){
                  
                  System.out.println(+ pageSlots.get(k));
}   
            
        }
        else {
                if(!pageSlots.contains(pages[h]) ){
                  if(pageSlots.size() < noOfPages){
                      
                     d=ref.peek();
                     ref.poll();
                      
                    
                     
                     for(int r=0;r<noOfPageSlots;r++) {
                        if (d==(pageSlots.get(r))){
                            pageSlots.set(r,pages[h]);
                            ref.add(pages[h]); 
                            pageFaults++;
                            
                 System.out.println("after Page Fault:");
               for(int b=0;b<pageSlots.size();b++){
                  
                  System.out.println( pageSlots.get(b));
}   
            
                      
                     }
                     }
                     
                  }}}
                }
        System.out.println("the number of page faults is " + pageFaults);
}
   
   
   
}
