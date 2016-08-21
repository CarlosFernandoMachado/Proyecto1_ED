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
public class FSAList extends ADTList{
    protected Object data[];

    public FSAList() {
        size = 0;
        data = new Object[5];
        for (int i = 0; i < data.length; i++) {
            data[i] = null;
        }
    }
    
    private void resize(){
        Object temp[] = new Object[data.length+5];
        for (int i = 0; i < data.length; i++) {
            temp[i] = data[i];
        }
        for (int i = data.length; i < temp.length; i++) {
            temp[i] = null;
        }
        data = temp;
    }
    @Override
    boolean insert(Object element, int position) {
        if (position < 0 || position > size) {
            return false;
        }
        if (size == data.length) {
            resize();
        }
        if (position == size) {
            data[position] = element;
        }else{
            for (int i = size; i > position; i--) {
                data[i] = data[i-1];
            }
            data[position] = element;
        }
        size++;
        return true;
    }
    
    public void add(Object element){
        if (size == data.length) {
            resize();
        }
        data[size] = element;
        size++;
    }
    
    @Override
    Object first() {
        return data[0];
    }

    @Override
    Object last() {
        return data[size-1];
    }

    @Override
    int capacity() {
        return data.length;
    }

    @Override
    Object remove(int position) {
        if (position > size || position < 0) {
            return null;
        }
        Object temp = data[position];
        if (data[position+1] != null) {
            for (int i = position; i < data.length-1; i++) {
                data[i] = data[i+1];
            }
            data[data.length-1] = null;
        }else{
            data[position] = null;
        }
        size--;
        return temp;
    }

    @Override
    boolean isFull() {
        if (size == data.length) {
            return true;
        }
        return false;
    }

    @Override
    int indexOf(Object element) {
        for (int i = 0; i < data.length; i++) {
            if (data[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    Object get(int position) {
        return data[position];
    }

    @Override
    void clear() {
        for (int i = 0; i < data.length; i++) {
            data[i] = null;
        }
    }
    
}
