package uk.ac.ucl.data;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class DataFrame {
    private ArrayList<Entry> dataset;
    private String main;

    public DataFrame(){
        this.dataset=new ArrayList<>();
    }

    public void addEntry(String name){
        Entry new_entry = new Entry(name);
        dataset.add(new_entry);
    }

    public void addEntry(String name, int i){
        Entry new_entry = new Entry(name,i);
        dataset.add(new_entry);
    }

    public void setMain(String main){
        this.main=main;
    }

    public void addFieldLast(String category, String element){
        int n=dataset.size();
        Entry adding = dataset.get(n-1);
        adding.add(category,element);
    }

    public void addField(int i, String category, String element){
        int n=dataset.size();
        Entry adding = dataset.get(i);
        adding.add(category,element);
    }

    public void removeEntry(int i){
        dataset.remove(i);
    }

    public void removeField(int i, int j){
        dataset.get(j).delete(i);
    }

    public String getField(int i,int j){return dataset.get(j).getField(i);}

    public ArrayList<String> getEntry(int i){
        Entry currentEntry= dataset.get(i);
        ArrayList<String> stringEntry = new ArrayList<String>();
        int j;
        for(j=0;j<currentEntry.Size();j++)
            stringEntry.add(currentEntry.getField(j));
        return stringEntry;
    }

    public ArrayList<String> getEntryNames(){
        ArrayList<String> entry_names = new ArrayList<String>();
        for (Entry entry : dataset){
            entry_names.add(entry.getEntry_name());
        }
        return entry_names;
    }

    public void updateField(int i, int j, String element){
        Entry modify = dataset.get(j);
        modify.modifyFieldElement(i,element);
    }

    public void changeEntryName(int j,String new_name) {
        Entry modify = dataset.get(j);
        modify.modifyName(new_name);
    }

    public int getSize(){
        return dataset.size();
    }

    public ArrayList<String> search(String searching){
        ArrayList<String> answers = new ArrayList<String>();
        for(Entry it : dataset){
            ArrayList<String> found = it.search(searching);
                answers.addAll(found);
        }
        return answers;
    }

    public ArrayList<Integer> searchInt(String searching){
        ArrayList<Integer> answers = new ArrayList<Integer>();
        Integer i=0;
        for(Entry it : dataset){
            ArrayList<String> found = it.search(searching);
            for (int k=0;k<found.size();k++)
                answers.add(i);
            i++;
        }
        return answers;
    }
}
