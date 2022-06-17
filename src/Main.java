
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Administrator
 */
public class Main {

    public static void showMenu() {
        System.out.println("Choose one of this options:");
        System.out.println("Person Tree:");
        System.out.println("1. Insert a new Person.");
        System.out.println("2. Inorder traversal");
        System.out.println("3. Breadth-First Traversal");
        System.out.println("4. Search by Person ID");
        System.out.println("5. Delete by Person ID");
        System.out.println("6. Balancing Binary Search Tree ");
        System.out.println("7. DFS_Graph");
        System.out.println("8. Dijkstra");
        System.out.println("Exit:");
        System.out.println("0. Exit");
    }

    public static void main(String[] args) throws IOException {
        //Person_Management.list.clear();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("====================================");
            showMenu();
            System.out.print("Moi nhap lua chon: ");
            int selection = sc.nextInt();
            sc.nextLine();
            switch (selection) {
                case 1:
                    Person_Management.insert();
                    break;
                case 2:
                    Person_Management.inorder();
                    break;
                case 3:
                    Person_Management.bst();
                    break;
                case 4:
                    Person_Management.search();
                    break;
                case 5:
                    Person_Management.delete();
                    break;
                case 6:
                    Person_Management.balance();
                    break;
                case 7:
                    Person_Management.depthFirstSearch();
                    break;
                case 8:
                    Person_Management.dijstrak();
                    break;
                case 0:
                    System.exit(0);
                    break;
            }
        }
    }

}
