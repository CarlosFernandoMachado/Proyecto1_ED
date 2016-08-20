/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_1;

/**
 *
 * @author carlos
 */
public abstract class ADTList {
    protected int size;

    public ADTList(int size) {
        this.size = size;
    }

    public ADTList() {
        size = 0;
    }
    
    abstract boolean insert(Object element,int position);
    
    abstract Object first();
    
    abstract Object last();
    
    public int Size(){
        return size;
    }
    abstract int capacity();
    
    abstract Object remove(int position);
    
    public boolean isEmpty(){
        if (size == 0) {
            return true;
        } else {
            return false;
        }
    }
    
    abstract boolean isFull();
    
    abstract int indexOf(Object element);
    
    abstract Object get(int position);
    
    abstract void clear();
}
