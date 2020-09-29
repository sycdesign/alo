package com.jd.structures.L10Trie.TernarySearchTree;

import java.util.Scanner;

/**
 * @author: gaohongbin5
 * @date: 2020/9/24 21:24:49
 * @description: TernarySearchTreeTest
 */
public class TernarySearchTreeTest {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    TernarySearchTree tst = new TernarySearchTree();
    System.out.println("Ternary Search Tree Test\n");

    char ch;

    do {
      System.out.println("\nTernary Search Tree Operations\n");
      System.out.println("1. insert word");
      System.out.println("2. search word");
      System.out.println("3. delete word");
      System.out.println("4. check empty");
      System.out.println("5. make empty");

      int choice = scan.nextInt();
      switch (choice) {
        case 1:
          System.out.println("Enter word to insert");
          tst.insert(scan.next());
          break;
        case 2:
          System.out.println("Enter word to search");
          System.out.println("Search result : " + tst.search(scan.next()));
          break;
        case 3:
          System.out.println("Enter word to delete");
          tst.delete(scan.next());
          break;
        case 4:
          System.out.println("Empty Status : " + tst.isEmpty());
          break;
        case 5:
          System.out.println("Ternary Search Tree cleared");
          tst.makeEmpty();
          break;
        default:
          System.out.println("Wrong Entry \n ");
          break;
      }
      System.out.println(tst);

      System.out.println("\nDo you want to continue (Type y or n) \n");
      ch = scan.next().charAt(0);
    } while (ch == 'Y' || ch == 'y');
  }
}
