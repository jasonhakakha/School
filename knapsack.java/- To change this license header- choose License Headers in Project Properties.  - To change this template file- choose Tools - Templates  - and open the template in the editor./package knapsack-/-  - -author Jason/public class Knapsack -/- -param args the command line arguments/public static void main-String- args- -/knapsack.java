/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package knapsack;

/**
 *
 * @author Jason
 */
public class Knapsack {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    static int ks(int weight[], int val[], int capacity, int items){
    if(items < 1) return 0;
    if(capacity < 1) return 0;
    
    if(weight[items - 1] > capacity)
        return ks(weight, val, capacity, items - 1);
    else
        return Math.max((val[items-1] + ks(weight, val, capacity - weight[items - 1], items - 1)),ks(weight, val, capacity, items - 1));
     
 
}
    
}
