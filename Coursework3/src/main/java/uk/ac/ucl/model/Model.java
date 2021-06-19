package uk.ac.ucl.model;

import uk.ac.ucl.data.DataFrame;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Model {
  // The example code in this class should be replaced by your Model class code.
  // The data should be stored in a DataFrame.
  private DataFrame frame = new DataFrame();
  private ArrayList<String> TableHead = new ArrayList<String>();

  public int getSize() {
    return frame.getSize();
  }

  public ArrayList<String> getEntryNames() {
    return frame.getEntryNames();
  }

  public ArrayList<String> getEntry(String index) {
    int i = Integer.parseInt(index);
    return frame.getEntry(i);
  }

  public void readFile(File file) {
    try {
      String line = "";
      String splitBy = ",";
      BufferedReader br = new BufferedReader(new FileReader(file));
      line = br.readLine();
      String[] Headers = line.split(splitBy);
      for (String head : Headers) {
        TableHead.add(head);
      }
      while ((line = br.readLine()) != null) {
        String[] entry = line.split(splitBy);
        frame.addEntry(entry[0]);
        for (int i = 0; i < Arrays.stream(entry).count(); i++) {
          frame.addFieldLast(TableHead.get(i), entry[i]);
        }
        int i = (int) Arrays.stream(entry).count();
        while (i < TableHead.size()) {
          frame.addFieldLast(TableHead.get(i), "");
          i++;
        }
      }
    } catch (IOException ignored) {
    }
  }

  public void addEntry(String name) {
    frame.addEntry(name);
  }

  public void addEntry(String name, int i) {
    frame.addEntry(name, i);
  }

  public void addNewEntry(int i, String category, String element) {
    frame.addField(i, category, element);
  }

  public void updateField(int x, int y, String element) {
    frame.updateField(x, y, element);
  }

  public void updateEntryName(int i, String new_name) {
    frame.changeEntryName(i, new_name);
  }

  public void removeEntry(int i) {
    frame.removeEntry(i);
  }

  public void removeField(int i, int j) {
    frame.removeField(i, j);
  }

  public String getField(int i, int j) {
    String field = frame.getEntry(j).get(i);
    return field;
  }

  public ArrayList<String> getTableHeads() {
    return TableHead;
  }

  public ArrayList<String> getAllID() {
    ArrayList<String> ID = new ArrayList<String>();
    int i;
    for (i = 0; i < frame.getSize(); i++) {
      ID.add(frame.getEntry(i).get(0));
    }
    return ID;
  }

  public String getID() {
    return TableHead.get(0);
  }

  public ArrayList<ArrayList<String>> getData() {
    ArrayList<ArrayList<String>> data = new ArrayList<ArrayList<String>>();
    int i;
    for (i = 0; i < frame.getSize(); i++)
      data.add(frame.getEntry(i));
    return data;
  }

  public ArrayList<String> searchFor(String keyword) {
    return frame.search(keyword);
  }

  public ArrayList<Integer> searchForInt(String keyword) {
    return frame.searchInt(keyword);
  }

  public void Print() {
    BufferedWriter bw = null;
    try {
      File file = new File("autosave.csv");
      if (!file.exists()) {
        file.createNewFile();
      }
      FileWriter fw = new FileWriter(file);
      bw = new BufferedWriter(fw);
      String firstline = new String();
      for (String it : TableHead) {
        firstline = firstline + it + ",";
      }
      firstline = firstline + "\n";
      bw.write(firstline);
      ArrayList<String> line = new ArrayList<String>();
      String lineStr = new String();
      int i;
      for (i = 0; i < frame.getSize(); i++) {
        line = frame.getEntry(i);
        for (String it : line) {
          lineStr = lineStr + it + ",";
        }
        lineStr=lineStr+"\n";
        bw.write(lineStr);
        lineStr="";
      }
    } catch (IOException ioe) {
      ioe.printStackTrace();
    }
    try {
      if (bw != null)
        bw.close();
    } catch (Exception ex) {
      System.out.println("Error in closing the BufferedWriter" + ex);
    }
  }

  public void PrintOnClick() {
    BufferedWriter bw = null;
    try {
      File file = new File("lastsave.csv");
      if (!file.exists()) {
        file.createNewFile();
      }
      FileWriter fw = new FileWriter(file);
      bw = new BufferedWriter(fw);
      String firstline = new String();
      for (String it : TableHead) {
        firstline = firstline + it + ",";
      }
      firstline = firstline + "\n";
      bw.write(firstline);
      ArrayList<String> line = new ArrayList<String>();
      String lineStr = new String();
      int i;
      for (i = 0; i < frame.getSize(); i++) {
        line = frame.getEntry(i);
        for (String it : line) {
          lineStr = lineStr + it + ",";
        }
        lineStr=lineStr+"\n";
        bw.write(lineStr);
        lineStr="";
      }
    } catch (IOException ioe) {
      ioe.printStackTrace();
    }
    try {
      if (bw != null)
        bw.close();
    } catch (Exception ex) {
      System.out.println("Error in closing the BufferedWriter" + ex);
    }
  }
}
