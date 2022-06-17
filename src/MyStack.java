
import java.util.LinkedList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Administrator
 */
public class MyStack {

    LinkedList<NodeGraph> list = new LinkedList<NodeGraph>();
    int size;
    
    MyStack() {
        LinkedList list = new LinkedList();
    }

    boolean isEmpty() {
        return list.isEmpty();
    }

    //them 1 phan tu vao dau
    void push(NodeGraph node) {
        list.add(0, node);
    }

    public NodeGraph pop() {
        if (isEmpty()) {
            System.out.println("List is Empty");
            return null;
        }
        NodeGraph a = list.remove(0);
        return a;

    }
    public String show(int i) {
        return list.get(i).label;
    }
    
    
    public int size() {
        return list.size();
    }

    //ham kiem tra xem trong mang co bi trung khong
    public boolean checkList(String v) {
        for (NodeGraph x : list) {
            if (v.equals(x.label)) {
                return true;
            }
        }
        return false;
    }

}
