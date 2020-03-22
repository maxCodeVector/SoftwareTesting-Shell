/*
 * This file was automatically generated by EvoSuite
 * Sun Mar 22 06:41:21 GMT 2020
 */

package sg.edu.nus.comp.cs4218.impl;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.shaded.org.mockito.Mockito.*;
import static org.evosuite.runtime.EvoAssertions.*;
import java.io.OutputStream;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.evosuite.runtime.System;
import org.evosuite.runtime.ViolatedAssumptionAnswer;
import org.evosuite.runtime.util.SystemInUtil;
import org.junit.runner.RunWith;
import sg.edu.nus.comp.cs4218.Environment;
import sg.edu.nus.comp.cs4218.impl.ShellImpl;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true, useJEE = true) 
public class ShellImpl_ESTest extends ShellImpl_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      ShellImpl shellImpl0 = new ShellImpl();
      OutputStream outputStream0 = mock(OutputStream.class, new ViolatedAssumptionAnswer());
      shellImpl0.parseAndEvaluate("v;J-", outputStream0);
  }

  @Test(timeout = 4000)
  public void test1()  throws Throwable  {
      String[] stringArray0 = new String[7];
      Environment.currentDirectory = null;
      ShellImpl.main(stringArray0);
      assertEquals(7, stringArray0.length);
  }

  @Test(timeout = 4000)
  public void test2()  throws Throwable  {
      String[] stringArray0 = new String[5];
      SystemInUtil.addInputLine("[O-c;BYiW");
      ShellImpl.main(stringArray0);
      assertEquals(5, stringArray0.length);
  }

  @Test(timeout = 4000)
  public void test3()  throws Throwable  {
      SystemInUtil.addInputLine("exit");
      // Undeclared exception!
      try { 
        ShellImpl.main((String[]) null);
        fail("Expecting exception: System.SystemExitException");
      
      } catch(System.SystemExitException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("org.evosuite.runtime.System", e);
      }
  }

  @Test(timeout = 4000)
  public void test4()  throws Throwable  {
      SystemInUtil.addInputLine("!e\"!q^GKTm");
      String[] stringArray0 = new String[1];
      ShellImpl.main(stringArray0);
      assertEquals(1, stringArray0.length);
  }

  @Test(timeout = 4000)
  public void test5()  throws Throwable  {
      String[] stringArray0 = new String[8];
      ShellImpl.main(stringArray0);
      assertEquals(8, stringArray0.length);
  }

  @Test(timeout = 4000)
  public void test6()  throws Throwable  {
      SystemInUtil.addInputLine("");
      String[] stringArray0 = new String[1];
      ShellImpl.main(stringArray0);
      assertEquals(1, stringArray0.length);
  }

  @Test(timeout = 4000)
  public void test7()  throws Throwable  {
      ShellImpl shellImpl0 = new ShellImpl();
      try { 
        shellImpl0.parseAndEvaluate("I{LkDp-L.OuV/+&Vc", (OutputStream) null);
        fail("Expecting exception: Exception");
      
      } catch(Exception e) {
         //
         // shell: I{LkDp-L.OuV/+&Vc: Invalid app
         //
         verifyException("sg.edu.nus.comp.cs4218.impl.util.ApplicationRunner", e);
      }
  }
}
