package sample;

import a.d.e.a.T;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.*;

public class blocks {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        // TODO code application logic here
       // File file = new File(cowsignal.in);
       // Scanner in = new Scanner(file);
        Scanner in = new Scanner(System.in);

        PrintStream o = new PrintStream(new File("cowout.in"));


        PrintStream console = System.out;

        System.setOut(o);

        char[] letters = new char[26];

        int n = in.nextInt();
        while(in.hasNextLine()){
            String temp = in.nextLine();
            Set<Character> set = new Set<Character>() {
                @Override
                public int size() {
                    return 0;
                }

                @Override
                public boolean isEmpty() {
                    return false;
                }

                @Override
                public boolean contains(Object o) {
                    return false;
                }

                @Override
                public Iterator<Character> iterator() {
                    return null;
                }

                @Override
                public Object[] toArray() {
                    return new Object[0];
                }

                @Override
                public <T> T[] toArray(T[] a) {
                    return null;
                }

                @Override
                public boolean add(Character character) {
                    return false;
                }

                @Override
                public boolean remove(Object o) {
                    return false;
                }

                @Override
                public boolean containsAll(Collection<?> c) {
                    return false;
                }

                @Override
                public boolean addAll(Collection<? extends Character> c) {
                    return false;
                }

                @Override
                public boolean retainAll(Collection<?> c) {
                    return false;
                }

                @Override
                public boolean removeAll(Collection<?> c) {
                    return false;
                }

                @Override
                public void clear() {

                }
            }
            for(char i: temp.toCharArray())
                set.add(i);
            for(char x: set.toArray(new Character[set.size()]))
               letters[(int)(x - 'A' + 1)]++;
        }
        for(int i:letters){
            System.out.println(i);
        }

    }

}
