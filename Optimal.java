
package pagereplacementzn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author zeina
 */
public class Optimal { 
    public int pageSlots[];
    public int ref [];
    public Queue <Integer> trial = new LinkedList();
    public int pageFaults=0;
    public int var=-1;
    public int d;
    public boolean isFull=false;
    int count=0;

    
    int frames, pointer = 0, hit = 0, fault = 0,ref_len;
      
        
    Optimal(int noOfPageSlots, int pages[], int noOfPages ){
       ref = new int[noOfPages]; 
       pageSlots =new int[noOfPageSlots];
    
        
        for(int j = 0; j < noOfPageSlots; j++)
                pageSlots[j] = -1;
        
        for(int i = 0; i < noOfPages; i++)
        {
         int search=-1;
         
         for(int j = 0; j < noOfPageSlots; j++)
         {
          if(pageSlots[j] == pages[i])
          {
           search = j;
           hit++;
           break;
          } 
         }
         if(search == -1)
         {
          if(isFull)
          {
           int index[] = new int[noOfPageSlots];
           boolean index_flag[] = new boolean[noOfPageSlots];
           for(int j = i + 1; j < noOfPages; j++)
           {
            for(int k = 0; k < noOfPageSlots; k++)
            {
             if((pages[j] == pageSlots[k]) && (index_flag[k] == false))
             {
              index[k] = j;
              index_flag[k] = true;
              break;
             }
            }
           }
           int max = index[0];
           pointer = 0;
           if(max == 0)
            max = 200;
           for(int j = 0; j < noOfPageSlots; j++)
           {
            if(index[j] == 0)
             index[j] = 200;
            if(index[j] > max)
            {
             max = index[j];
             pointer = j;
            }
           }
          }
          pageSlots[pointer] = pages[i];
            
                 System.out.println("after Page Fault:");
               for(int b=0;b<noOfPageSlots;b++){
                  System.out.println( pageSlots[b]);
               }
          pageFaults++;
         
          if(!isFull)
          {
           pointer++;
              if(pointer == noOfPageSlots)
              {
               pointer = 0;
               isFull = true;
              }
          }
          
         }

         
             count++;
        }
      
                               
        
        System.out.println("the number of page faults is " + pageFaults);
    }
    
}
