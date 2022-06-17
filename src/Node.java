
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Administrator
 */
public class Node {

    public Person info;
    public Node left;
    public Node right;

    public Node() {

    }

    public Node(Person info) {
        this.info = info;
        this.left = null;
        this.right = null;
    }

    public Person getInfo() {
        return info;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

//    public void insert(Node node) {
//        if (node.getInfo().ID.compareTo(this.getInfo().ID) < 0) {
//            if (this.left == null) {
//                this.left = node;
//            } else {
//                this.left.insert(node);
//            }
//        } else if(node.getInfo().ID.compareTo(this.getInfo().ID) > 0){
//            if (this.right == null) {
//                this.right = node;
//            } else {
//                this.right.insert(node);
//            }
//
//        }
//    }
}
