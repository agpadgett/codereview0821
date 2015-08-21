import java.util.ArrayList;

public class Definition{

  private static ArrayList<Definition> instances = new ArrayList<Definition>();
  private int mId;
  private String mEntry;

  public Definition(String entry){
    instances.add(this);
    mId = instances.size();
    mEntry = entry;
  }

  public String getEntry(){
    return mEntry;
  }

  public int getId(){
    return mId;
  }

  public static ArrayList<Definition> all (){
    return instances;
  }

  public static Definition find(int id) {
    try {
      return instances.get(id -1);
    } catch (IndexOutOfBoundsException e){
      return null;
    }
  }

  public static void clear(){
    instances.clear();
  }

}
