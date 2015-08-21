import java.util.ArrayList;

public class Word{

  private static ArrayList<Word> instances = new ArrayList<Word>();
  private ArrayList<Definition> mDefinitions;
  private int mId;
  private String mTerm;

  public Word (String term){
    mTerm = term;
    instances.add(this);
    mId = instances.size();
    mDefinitions = new ArrayList<Definition>();
  }

  public int getId(){
    return mId;
  }

  public String getTerm(){
    return mTerm;
  }

  public ArrayList<Definition> getDefinitions(){
    return mDefinitions;
  }

  public static ArrayList<Word> all(){
    return instances;
  }

  public static Word find(int id) {
    try {
      return instances.get(id -1);
    } catch (IndexOutOfBoundsException e){
      return null;
    }
  }

  public void addDefinition(Definition definition){
    mDefinitions.add(definition);
  }

  // public void removeDefinition(Definition definition){
  //   mDefinitions.remove(definition);
  // }
  //Add this if you finish early

  public static void clear(){
    instances.clear();
  }
}
