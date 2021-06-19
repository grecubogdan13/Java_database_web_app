package uk.ac.ucl.data;

import java.util.ArrayList;
import java.util.Arrays;

public class Field {
    private String Category;
    private String element;

    public Field(String category, String element){
        this.Category=category;
        this.element=element;
    }
    public String getCategory(){
        return this.Category;
    }

    public String getElement(){
        return this.element;
    }

    public ArrayList<String> makeList(){
        String itemString= this.element.toString();
        return new ArrayList<>(Arrays.asList(Category,itemString));
    }

    public void delete(){
        this.element="";
    }

    public void modifyElement(String element){
        this.element=element;
    }
}
