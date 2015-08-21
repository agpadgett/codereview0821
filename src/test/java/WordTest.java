import java.util.ArrayList;

import org.junit.*;
import static org.junit.Assert.*;

public class WordTest{

  @Test
  public void word_instantiatesCorrectly_True(){
    Word testWord = new Word("thing");
    assertEquals(true, testWord instanceof Word);
  }

  @Test
  public void getId_returnsWordId() {
    Word testWord = new Word("thing");
    assertTrue(Word.all().size() == testWord.getId());
  }

  @Test
  public void getTerm_returnsTerm(){
    Word testWord = new Word("thing");
    assertEquals("thing", testWord.getTerm());
  }

  @Test
  public void getDefinitions_containsArrayList_Array(){
    Word testWord = new Word("thing");
    assertTrue(testWord.getDefinitions() instanceof ArrayList);
  }
  //Test if getdef array is empty?
  @Test
  public void addDefinition_addsDefinition(){
    Word testWord = new Word("thing");
    Definition testDef = new Definition("a thing's definition");
    testWord.addDefinition(testDef);
    assertTrue(testWord.getDefinitions().contains(testDef));
  }

  @Test
  public void all_returnsAllWords(){
    Word testWord1 = new Word("thing1");
    Word testWord2 = new Word("thing2");
    assertTrue(Word.all().contains(testWord1));
    assertTrue(Word.all().contains(testWord2));
  }

  @Test
  public void find_returnsNullWhenNoWordFound_null() {
    assertTrue(Word.find(400) == null);
  }

 @Test
 public void find_returnsWordWithSameId_secondTask() {
   Word testWord1 = new Word("thing1");
   Word testWord2 = new Word("thing2");
   assertEquals(Word.find(testWord2.getId()), testWord2);
 }

 @Test
 public void addDefinition_addsDefToWord(){
   Word testWord = new Word("thing");
   Definition testDef = new Definition ("a thing's definition");
   testWord.addDefinition(testDef);
   assertTrue(testWord.getDefinitions().contains(testDef));
 }

 @Test
 public void clear_removesAllWordsFromInstanceArray() {
   Word testWord = new Word("thing");
   Word.clear();
   assertEquals(Word.all().size(), 0);
 }

}
