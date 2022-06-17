
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Administrator
 */
public class Person_Management {

    static ArrayList<Person> checkList = new ArrayList<Person>();
    static ArrayList<Person> list = new ArrayList<Person>();
    public static MyBSTree myTree = new MyBSTree();
    public static MyQueue queue = new MyQueue();

    public static void insert() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap thong tin: ");
        System.out.print("Input new ID: ");
        String ID = sc.nextLine();

        //kiem tra xem Id co bi trung khong
        Person people1 = new Person(ID);
        if (checkList.size() > 1) {
            for (int i = 0; i < checkList.size(); i++) {
                if (ID.equals(checkList.get(i).ID)) {
                    System.out.println("ID bị trùng");
                    return;
                }
            }
        }
        checkList.add(people1);

        System.out.print("Input Name: ");
        String name = sc.nextLine();
        System.out.print("Input birthplace: ");
        String birthPlace = sc.nextLine();
        System.out.print("Input Birth of Date: ");
        String dob = sc.nextLine();

        Person people = new Person(ID, name, birthPlace, dob);

        Node newNode = new Node(people);
        myTree.insert(newNode);

    }

    public static void inorder() {
        myTree.inOrder(myTree.root);
    }

    //duyet theo chieu rong
    public static void bst() {
        if (myTree.root == null) {
            System.out.println("tree is Empty!");
        } else {
            queue.enqueue(myTree.root);
            while (!queue.isEmpty()) {
                Node temp = (Node) queue.dequeue();
                System.out.println(temp.info.toString());
                if (temp.left != null) {
                    queue.enqueue(temp.left);
                }
                if (temp.right != null) {
                    queue.enqueue(temp.right);
                }
            }
        }
    }

    //Tim kiem ID
    public static void search() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap Id can tim kiem: ");
        String key = sc.nextLine();
        myTree.searchBSTree(myTree.root, key);
    }

    public static void delete() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap Id can xoa: ");
        String key = sc.nextLine();
        myTree.delete(myTree.root, key);
    }

    public static void createInOrder(Node current) {
        if (current == null) {
            return;
        }
        createInOrder(current.left);
        list.add(current.info);
        createInOrder(current.right);
    }

    public static void balance() {
        list.clear();
        //sao chep tat ca node trong tree vao mang
        createInOrder(myTree.root);
        ArrayList<Node> n = new ArrayList<Node>();
        for (int i = 0; i < list.size(); i++) {
           Node newNode = new Node(list.get(i));
           n.add(newNode);
        }
        //xoa cay
        myTree.root = null;
        //su dung cay can bang
        myTree.balance(n, 0, n.size() - 1);
    }

    //Depth-first search
    public static void depthFirstSearch() throws IOException {
        FileReader f = new FileReader("D:\\netbreans\\Project\\CSD201x-AS3\\src\\matran.txt");

        BufferedReader bf = new BufferedReader(f);

        String line;
        int matrix[][] = new int[10][10];
        String[] lineData;
        int i = 0;
        int j = 0;

        while ((line = bf.readLine()) != null) {
            lineData = line.split("\\s");
            for (int k = 0; k < lineData.length; k++) {
                int data = Integer.parseInt(lineData[k]);
                matrix[i][j] = data;
                j++;
            }
            j = 0;
            i++;
        }
        System.out.println("\tA\tB\tC\tD\tE\tF\tG");
        char a = 'A';
        for (int u = 0; u < 7; u++) {
            System.out.printf("%s\t", a);
            for (int v = 0; v < 7; v++) {
                System.out.print(matrix[u][v] + "\t");
            }
            a++;
            System.out.println("");
        }

        //Khai bao
        MyStack stack = new MyStack();
        MyStack stackList = new MyStack();
        NodeGraph e1 = new NodeGraph(0, "A");
        NodeGraph e2 = new NodeGraph(1, "B");
        NodeGraph e3 = new NodeGraph(2, "C");
        NodeGraph e4 = new NodeGraph(3, "D");
        NodeGraph e5 = new NodeGraph(4, "E");
        NodeGraph e6 = new NodeGraph(5, "F");
        NodeGraph e7 = new NodeGraph(6, "G");
        ArrayList<NodeGraph> listNode = new ArrayList<NodeGraph>();
        listNode.add(e1);
        listNode.add(e2);
        listNode.add(e3);
        listNode.add(e4);
        listNode.add(e5);
        listNode.add(e6);
        listNode.add(e7);

        //KHOI TAO
        stack.push(listNode.get(0));
        //dung de duyet cac dinh
        stackList.push(listNode.get(0));

        //Duyet theo stack
        while (!stack.isEmpty()) {
            NodeGraph node = stack.pop();
            System.out.print(node.label + "->");

            for (int v = 0; v < matrix.length; v++) {
                if (matrix[node.id][v] != 0 && matrix[node.id][v] != 9999 && stackList.checkList(listNode.get(v).label) == false) {
                    stackList.push(listNode.get(v));
                    stack.push(listNode.get(v));

                }
            }
        }

    }

    //tim duong di ngan nhat
    public static void dijstrak() throws IOException {
        FileReader f = new FileReader("D:\\netbreans\\Project\\CSD201x-AS3\\src\\matran.txt");

        BufferedReader bf = new BufferedReader(f);

        String line;
        int matrix[][] = new int[10][10];
        String[] lineData;
        int i = 0;
        int j = 0;

        //doc tung dong
        while ((line = bf.readLine()) != null) {
            lineData = line.split("\\s");
            for (int k = 0; k < lineData.length; k++) {
                int data = Integer.parseInt(lineData[k]);
                matrix[i][j] = data;
                j++;
            }
            j = 0;
            i++;
        }
        System.out.println("\tA\tB\tC\tD\tE\tF\tG");
        char a = 'A';
        for (int u = 0; u < 7; u++) {
            System.out.printf("%s\t", a);
            for (int v = 0; v < 7; v++) {
                System.out.print(matrix[u][v] + "\t");
            }
            a++;
            System.out.println("");
        }

        //Khai bao cac dinh va khoang cach
        NodeGraph e1 = new NodeGraph(0, "A");
        NodeGraph e2 = new NodeGraph(1, "B");
        NodeGraph e3 = new NodeGraph(2, "C");
        NodeGraph e4 = new NodeGraph(3, "D");
        NodeGraph e5 = new NodeGraph(4, "E");
        NodeGraph e6 = new NodeGraph(5, "F");
        NodeGraph e7 = new NodeGraph(6, "G");
        ArrayList<NodeGraph> listNode = new ArrayList<NodeGraph>();
        listNode.add(e1);
        listNode.add(e2);
        listNode.add(e3);
        listNode.add(e4);
        listNode.add(e5);
        listNode.add(e6);
        listNode.add(e7);

        //so dinh
        int n = 7;
        //mang de duyet cac dinh da xet
        MyStack visited = new MyStack();
        //khoang cach tu dinh dau 
        int[] distance = new int[n];
        int[] parent = new int[n]; 
        String[] label = new String[n];
        
        label[0] = "A";
        label[1] = "B";
        label[2] = "C";
        label[3] = "D";
        label[4] = "E";
        label[5] = "F";
        label[6] = "G";
        
        int start = 0;
        int finish = 6;
        int inf = 9999;

        //khoi tao khoang cach, mac dinh ban dau deu la inf=999
        for (i = 0; i < 7; i++) {
            distance[i] = inf;
        }

        //khoang cach tu 1 diem den chinh no thi = 0, mac dinh A = 0
        distance[start] = 0;
        //duyet dinh
        //visited == stack
        while (visited.size() < n) {
            //xet đỉnh chưa duyet co khoang cach nho nhat
            NodeGraph select = null;
            int minDist = inf;
            for (i = 0; i < n; i++) {
                if (visited.checkList(listNode.get(i).label) == false && distance[i] < minDist) {
                    minDist = distance[i];
                    select = listNode.get(i);
                }
            }
            System.out.println("");
            //duyet cac dinh ke chua duyet tu dinh dang xet
            visited.push(select);
            for (i = 0; i < n; i++) {
                //System.out.print("("+matrix[select.id][i]+","+ select.label+")");
                
                if (visited.checkList(listNode.get(i).label) == false && matrix[select.id][i] != 0 && matrix[select.id][i] != inf) {
                    //cap nhat quang duong moi
                    int newDist = distance[select.id] + matrix[select.id][i];
                    if (newDist < distance[i]) {
                        distance[i] = newDist;
                        parent[i] = select.id;
                    }  
                }
                

            }
            //danh dau dinh da duyet
            
                for(int k=visited.size()-1;k>=0;k--) {
                    System.out.print(visited.show(k));
                }
                System.out.print(" ");
                for(int k=0;k<n;k++){
                    if(!visited.checkList(label[k])){
                        System.out.print("("+distance[k]+","+label[parent[k]]+")");
                    }
                }
            
            if(visited.checkList(label[4])){
                break;
            }
            
        }
        System.out.println("");
        System.out.println("Khoang cach nho nhat tu dinh tu A den E la: " + distance[4]);
        System.out.println("duong di la: ");
        int s=4;
        ArrayList<String> top = new ArrayList<String>();
        top.add("E");
        while(s!=0) {
            s=parent[s];
            top.add(label[s]);
        }
        System.out.println("");
        for(int k=top.size()-1;k>=0;k--){
            if(k==0) {
                System.out.print(top.get(k));
                break;
            }
            System.out.print(top.get(k)+"->");
        }
       
    }

}
