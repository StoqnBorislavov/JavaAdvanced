package IteratorsAndComparators.Exercise.ListyIterator_01;

import java.util.List;

public class ListyIterator {
    private List<String> data;
    private int index;

    public ListyIterator(List<String> data){
        this.data = data;
        if(this.data.size() != 0){
            this.index = 0;
        } else {
            this.index = -1;
        }
    }

    public boolean move(){
        if(this.index < this.data.size() - 1) {
            this.index++;
            return true;
        }
        return false;
    }

    public boolean hasNext(){
        return this.index < this.data.size() -1;
    }

    public void print() throws Exception {
        if(!this.data.isEmpty()){
            System.out.println(this.data.get(index));
        } else {
            System.out.println("Invalid Operation!");
        }
    }


}
