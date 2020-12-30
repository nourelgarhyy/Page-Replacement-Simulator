
package pagereplacementzn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
*
* @author nourelgarhy
*/
public class LRU {
 public int pageSlots[];
 public ArrayList <Integer> ref = new ArrayList();
 public Queue <Integer> trial = new LinkedList();
 public int pageFaults=0;
 //public int LRU=100000;
 public int var=-1;
 public int d;
 public boolean flag=false;



 LRU(int noOfPageSlots, int pages[], int noOfPages ){
 pageSlots = new int[noOfPageSlots]; 
  for(int j = 0; j < noOfPageSlots; j++)
            pageSlots[j] = -1;
  
  
 for(int i = 0; i < noOfPages; i++){
            if(ref.contains(pages[i])){
                ref.remove(ref.indexOf(pages[i]));
            }
            
            ref.add(pages[i]);
            int search = -1;
            for(int j = 0; j < noOfPageSlots; j++){
              
               
                
                if(pageSlots[j] == pages[i]){

                    search = j;
                    break;
                }
            }
            if(search == -1){
                if(flag){
                    int LRU = noOfPages;
                    for(int j = 0; j < noOfPageSlots; j++){     
                        if(ref.contains(pageSlots[j])){ 
                            int temp = ref.indexOf(pageSlots[j]);
                            if(temp < LRU){

                                LRU = temp;
                                d = j;
                            }
                        }
                    }
                }
                pageSlots[d] = pages[i];
                pageFaults++;
                 
                System.out.println("after Page Fault:");
                for(int b=0;b<noOfPageSlots;b++){
                  
                  System.out.println( pageSlots[b]);
}   
                
                
                d++;
                if(d == noOfPageSlots){
                    d = 0;
                    flag = true;
                }
            }
        }
         System.out.println("the number of page faults is " + pageFaults);
    }
}