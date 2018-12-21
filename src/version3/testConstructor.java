/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package version3;

/**
 *
 * @author Tarc
 */
public class testConstructor {
    
    public static void main(String[] args) {
        
        Character[] array = {'a', 'b', 'c', 'd', 'e'};
        SortedListInterface<Character> list = new SortedLinkedList(array);
        Character b = 'b';
        Character c = 'c';
        
        System.out.println("Original list : ");
        System.out.println(list);
        
        list.contains(b);
        
        list.remove(c);
        System.out.println("Current list : ");
        System.out.println(list);
    }
}
