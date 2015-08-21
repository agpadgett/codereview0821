import org.junit.*;
import static org.junit.Assert.*;

public class DefinitionTest{

  @Test
  public void definition_instantiatesCorrectly_true(){
    Definition testDefinition = new Definition("define the thing");
    assertEquals(true, testDefinition instanceof Definition);
  }

  @Test
  public void getEntry_instantiatesWithDef_true(){
    Definition testDefinition = new Definition("define the thing");
    assertEquals("define the thing", testDefinition.getEntry());
  }

  @Test
  public void getId_returnsDefId() {
    Definition testDefinition = new Definition("define the thing");
    assertTrue(Definition.all().size() == testDefinition.getId());
  }

  @Test
  public void all_returnsAllInstancesOfDef_true() {
    Definition testDef1 = new Definition("define the thing");
    Definition testDef2 = new Definition("define the thing other ways");
    assertTrue(Definition.all().contains(testDef1));
    assertTrue(Definition.all().contains(testDef2));
  }


  @Test
  public void find_returnsNullWhenNoDefFound_null() {
    assertTrue(Definition.find(400) == null);
  }

 @Test
 public void find_returnsDefWithSameId_secondTask() {
   Definition testDef1 = new Definition("define the thing");
   Definition testDef2 = new Definition("define the thing other ways");
   assertEquals(Definition.find(testDef2.getId()), testDef2);
 }

 @Test
 public void clear_removesAllDefsFromInstances() {
   Definition testDef = new Definition("define the thing");
   Definition.clear();
   assertEquals(Definition.all().size(), 0);
 }


}
