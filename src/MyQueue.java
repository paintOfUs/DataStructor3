
import java.util.LinkedList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Administrator
 */
public class MyQueue {
    LinkedList<Node> list = new LinkedList<Node>();
    public MyQueue() {
        LinkedList list = new LinkedList();
    }
    //them vao cuoi
    public void enqueue(Node node){
        this.list.add(node);
    }
    //kiem tra queue co trong khong
    public boolean isEmpty() {
        return list.isEmpty() ;
    }
    
    //xoa phan tu dau tien trong hang doi
    public Object dequeue() {
            Node item = (Node) front();
            this.list.remove(0);   
            return item;   
    }
    //lay gia trị dau tien trong hang doi
    public Object front() {
        return list.get(0);
    }
}
