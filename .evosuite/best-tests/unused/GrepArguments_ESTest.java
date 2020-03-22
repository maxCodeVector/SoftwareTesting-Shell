/*
 * This file was automatically generated by EvoSuite
 * Sun Mar 22 06:36:57 GMT 2020
 */

package unused;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import java.util.List;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;
import unused.GrepArguments;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true, useJEE = true) 
public class GrepArguments_ESTest extends GrepArguments_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
      try { 
        GrepArguments.validate("CWj wF$@#=,Ef4)X");
        fail("Expecting exception: Exception");
      
      } catch(Exception e) {
         //
         // Invalid regular expression supplied
         //
         verifyException("unused.GrepArguments", e);
      }
  }

  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
      GrepArguments grepArguments0 = new GrepArguments();
      assertFalse(grepArguments0.isCountOfLinesOnly());
      
      String[] stringArray0 = new String[8];
      stringArray0[0] = "-c";
      stringArray0[1] = "57Ce>X";
      stringArray0[2] = "57Ce>X";
      stringArray0[3] = "";
      stringArray0[4] = "57Ce>X";
      stringArray0[5] = "57Ce>X";
      stringArray0[6] = "57Ce>X";
      stringArray0[7] = "57Ce>X";
      grepArguments0.parse(stringArray0);
      boolean boolean0 = grepArguments0.isCountOfLinesOnly();
      assertTrue(boolean0);
  }

  @Test(timeout = 4000)
  public void test02()  throws Throwable  {
      GrepArguments grepArguments0 = new GrepArguments();
      assertFalse(grepArguments0.isCaseInsensitive());
      
      String[] stringArray0 = new String[6];
      stringArray0[0] = "-i";
      stringArray0[1] = "";
      stringArray0[2] = "";
      stringArray0[3] = "";
      stringArray0[4] = "";
      stringArray0[5] = "MRmY=wxV3@zp.lp8uvH";
      grepArguments0.parse(stringArray0);
      boolean boolean0 = grepArguments0.isCaseInsensitive();
      assertTrue(boolean0);
  }

  @Test(timeout = 4000)
  public void test03()  throws Throwable  {
      GrepArguments grepArguments0 = new GrepArguments();
      assertFalse(grepArguments0.isCaseInsensitive());
      
      String[] stringArray0 = new String[6];
      stringArray0[0] = "-i";
      stringArray0[1] = "";
      stringArray0[2] = "";
      stringArray0[3] = "";
      stringArray0[4] = "";
      stringArray0[5] = "MRmY=wxV3@zp.lp8uvH";
      grepArguments0.parse(stringArray0);
      grepArguments0.getPattern();
      assertTrue(grepArguments0.isCaseInsensitive());
  }

  @Test(timeout = 4000)
  public void test04()  throws Throwable  {
      GrepArguments grepArguments0 = new GrepArguments();
      String[] stringArray0 = new String[3];
      stringArray0[0] = "%=hq~!%q/dl5";
      stringArray0[1] = "%=hq~!%q/dl5";
      stringArray0[2] = "";
      grepArguments0.parse(stringArray0);
      List<String> list0 = grepArguments0.getFiles();
      assertFalse(grepArguments0.isCountOfLinesOnly());
      assertFalse(grepArguments0.isCaseInsensitive());
      assertEquals(1, list0.size());
  }

  @Test(timeout = 4000)
  public void test05()  throws Throwable  {
      GrepArguments grepArguments0 = new GrepArguments();
      String[] stringArray0 = new String[7];
      stringArray0[0] = "-c";
      stringArray0[1] = "-`";
      try { 
        grepArguments0.parse(stringArray0);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
      }
  }

  @Test(timeout = 4000)
  public void test06()  throws Throwable  {
      GrepArguments grepArguments0 = new GrepArguments();
      String[] stringArray0 = new String[4];
      stringArray0[0] = "";
      stringArray0[1] = "";
      stringArray0[2] = "";
      stringArray0[3] = "-c";
      try { 
        grepArguments0.parse(stringArray0);
        fail("Expecting exception: Exception");
      
      } catch(Exception e) {
         //
         // Null arguments
         //
         verifyException("unused.GrepArguments", e);
      }
  }

  @Test(timeout = 4000)
  public void test07()  throws Throwable  {
      GrepArguments grepArguments0 = new GrepArguments();
      String[] stringArray0 = new String[0];
      try { 
        grepArguments0.parse(stringArray0);
        fail("Expecting exception: Exception");
      
      } catch(Exception e) {
         //
         // No regular expression supplied
         //
         verifyException("unused.GrepArguments", e);
      }
  }

  @Test(timeout = 4000)
  public void test08()  throws Throwable  {
      GrepArguments grepArguments0 = new GrepArguments();
      try { 
        grepArguments0.parse((String[]) null);
        fail("Expecting exception: Exception");
      
      } catch(Exception e) {
         //
         // Null arguments
         //
         verifyException("unused.GrepArguments", e);
      }
  }

  @Test(timeout = 4000)
  public void test09()  throws Throwable  {
      try { 
        GrepArguments.validate("");
        fail("Expecting exception: Exception");
      
      } catch(Exception e) {
         //
         // Regular expression cannot be empty
         //
         verifyException("unused.GrepArguments", e);
      }
  }

  @Test(timeout = 4000)
  public void test10()  throws Throwable  {
      try { 
        GrepArguments.validate((String) null);
        fail("Expecting exception: Exception");
      
      } catch(Exception e) {
         //
         // Null arguments
         //
         verifyException("unused.GrepArguments", e);
      }
  }

  @Test(timeout = 4000)
  public void test11()  throws Throwable  {
      GrepArguments.validate("RmR;");
  }

  @Test(timeout = 4000)
  public void test12()  throws Throwable  {
      GrepArguments grepArguments0 = new GrepArguments();
      boolean boolean0 = grepArguments0.isCountOfLinesOnly();
      assertFalse(grepArguments0.isCaseInsensitive());
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test13()  throws Throwable  {
      GrepArguments grepArguments0 = new GrepArguments();
      grepArguments0.getPattern();
      assertFalse(grepArguments0.isCaseInsensitive());
      assertFalse(grepArguments0.isCountOfLinesOnly());
  }

  @Test(timeout = 4000)
  public void test14()  throws Throwable  {
      GrepArguments grepArguments0 = new GrepArguments();
      grepArguments0.getFiles();
      assertFalse(grepArguments0.isCountOfLinesOnly());
      assertFalse(grepArguments0.isCaseInsensitive());
  }

  @Test(timeout = 4000)
  public void test15()  throws Throwable  {
      GrepArguments grepArguments0 = new GrepArguments();
      boolean boolean0 = grepArguments0.isCaseInsensitive();
      assertFalse(boolean0);
      assertFalse(grepArguments0.isCountOfLinesOnly());
  }
}
