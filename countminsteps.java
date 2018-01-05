/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw;

/**
 *
 * @author karynsolky
 */
public class Hw {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println(countMinSteps(1));
        System.out.println(countMinSteps(4));
        System.out.println(countMinSteps(7));


    }
    protected static int countMinSteps(int x){
        if(x <= 1) return 0;
        int a,b,c;
        a = b =  c = x;
        
        a = countMinSteps(x - 1);
        if(x % 2 == 0) b = countMinSteps(x/2);
        if(x % 3 == 0) c = countMinSteps(x/3);
        return 1 + Math.min(Math.min(a,b), c);
        

        
    }
    
}
