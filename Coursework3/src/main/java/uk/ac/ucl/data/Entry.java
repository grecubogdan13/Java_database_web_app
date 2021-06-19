package uk.ac.ucl.data;

import java.util.ArrayList;

public class Entry {
    private ArrayList<Field> Information = new ArrayList<>();
    private String Entry_name;

    public ArrayList<ArrayList<String>> getEntry(){
        ArrayList<ArrayList<String>> stringEntry= new ArrayList<ArrayList<String>>();
        for (Field fields : Information){
            ArrayList<String> stringField=fields.makeList();
            stringEntry.add(stringField);
        }
        return stringEntry;
    }

    public int Size(){return Information.size();}

    public Entry(String name){
        this.Entry_name =name;
    }

    public Entry(String name, int i){
        this.Entry_name =name;
        Field field= new Field("",name);
        this.Information.add(field);
        for (int j=1;j<i;j++)
        {
            Field empty_field= new Field("","");
            this.Information.add(empty_field);
        }
    }

    public String getField(int j) {return (String) this.Information.get(j).getElement();}

    public String getEntry_name() {
        return Entry_name;
    }

    public void modifyName(String name){
        this.Entry_name=name;
    }

    public void add(String name, String element){
        Field field = new Field(name,element);
        Information.add(field);
    }

    public void delete(int index){
        Information.get(index).delete();
    }

    public void modifyFieldElement(int index, String new_element) {
        Field modify=Information.get(index);
        modify.modifyElement(new_element);
    }

    public int element_index(Object search){
        int ok=0;
        for(int i=0;i<Information.size();i++) {
            if(Information.get(i).getElement()==search){
                ok=1;
                return i;
            }
        }
        if(ok==0)
            return -1;
        return 0;
    }

    public ArrayList<String> search(String searching){
        ArrayList<String> answers = new ArrayList<String>();
        for(Field it : Information) {
            String found = it.getElement();
            if (found.contains(searching))
            answers.add(found);
        }
        return answers;
    }
}
