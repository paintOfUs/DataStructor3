
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Administrator
 */
public class MyBSTree {

    public Node root;

    public MyBSTree() {
        root = null;
    }

    //Node trai cung
    public Node findLeftNode(Node root) {
        if (root == null) {
            return null;
        }
        Node leftNode = root;
        while (leftNode.left != null) {
            leftNode = leftNode.left;
        }
        return leftNode;
    }

    //xoa mot node bat ki
    public Node delete(Node root, String ID) {
        if (root == null) {
            return null;
        }
        if (ID.compareTo(root.info.ID) < 0) {
            root.left = delete(root.left, ID);
        } else if (ID.compareTo(root.info.ID) > 0) {
            root.right = delete(root.right, ID);
        } else {//root.info.ID = key
            //TH1: node leaf
            if (root.left == null && root.right == null) {
                return null;
            }
            //TH2: chi co 1 node con
            /* co 1 node con ben trai */
            if (root.left != null && root.right == null) {
                return root.left;
            }
            /* co 1 node con ben phai */
            if (root.left == null && root.right != null) {
                return root.right;
            }
            //TH3: co 2 node con
            //tim node trai cung cua node con ben phai
            Node lefNode = findLeftNode(root.right);
            root.info.ID = lefNode.info.ID;
            root.right = delete(root.right, lefNode.info.ID);
        }
        return root;
    }

    //duyet cay theo thu tu inorder: left-root-right
    public void inOrder(Node node) {
        if (node == null) {
            return;
        }
        //duyet ben trai
        inOrder(node.left);
        System.out.println(node.info.toString() + " ");
        //duyet ben phai
        inOrder(node.right);
    }
    

    //them node
    public void insert(Node node) {
        if (root == null) {
            root = node;
            return;
        } else {
            Node current = root;
            while (current != null) {

                if (node.getInfo().ID.compareTo(current.getInfo().ID) < 0) {
                    if (current.left == null) {
                        current.left = node;
                        return;
                    } else {
                        current = current.left;
                    }
                } else {
                    if (node.getInfo().ID.compareTo(current.getInfo().ID) > 0) {
                        if (current.right == null) {
                            current.right = node;
                            return;
                        } else {
                            current = current.right;
                        }
                    } else {
                        System.out.println("Error!");
                    }
                }
            }
        }
    }

    public Node searchBSTree(Node node, String key) {
        if (node == null) {
            return null;
        }
        if (key.compareTo(node.info.ID) < 0) {
            return searchBSTree(node.left, key);
        } else if (key.compareTo(node.info.ID) > 0) {
            return searchBSTree(node.right, key);
        } else { // node.info.ID = key
            System.out.println(node.info.toString());
            return node;
        }
    }

    //cay can bang
    public void balance(ArrayList<Node> mylist, int first, int last) {
        if (first <= last) {
            int middle = (first + last) / 2;
            insert(mylist.get(middle));
            balance(mylist, first, middle - 1);
            balance(mylist, middle + 1, last);
        }
    }

}
