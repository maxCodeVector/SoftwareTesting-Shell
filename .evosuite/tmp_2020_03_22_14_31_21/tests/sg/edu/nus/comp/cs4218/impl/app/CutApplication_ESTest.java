/*
 * This file was automatically generated by EvoSuite
 * Sun Mar 22 06:33:33 GMT 2020
 */

package sg.edu.nus.comp.cs4218.impl.app;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.shaded.org.mockito.Mockito.*;
import static org.evosuite.runtime.EvoAssertions.*;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.SequenceInputStream;
import java.util.Enumeration;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.evosuite.runtime.ViolatedAssumptionAnswer;
import org.evosuite.runtime.mock.java.io.MockFile;
import org.evosuite.runtime.mock.java.io.MockFileInputStream;
import org.evosuite.runtime.mock.java.io.MockFileOutputStream;
import org.evosuite.runtime.mock.java.io.MockPrintStream;
import org.junit.runner.RunWith;
import sg.edu.nus.comp.cs4218.impl.app.CutApplication;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true, useJEE = true) 
public class CutApplication_ESTest extends CutApplication_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
      CutApplication cutApplication0 = new CutApplication();
      Boolean boolean0 = Boolean.FALSE;
      Boolean boolean1 = new Boolean("");
      File file0 = MockFile.createTempFile("\"*;8EfU", "\"*;8EfU");
      MockFileInputStream mockFileInputStream0 = new MockFileInputStream(file0);
      String string0 = cutApplication0.cutFromStdin(boolean0, boolean0, boolean1, (-1), 0, mockFileInputStream0);
      assertEquals("", string0);
  }

  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
      CutApplication cutApplication0 = new CutApplication();
      Boolean boolean0 = new Boolean(false);
      byte[] byteArray0 = new byte[1];
      ByteArrayInputStream byteArrayInputStream0 = new ByteArrayInputStream(byteArray0);
      String string0 = cutApplication0.cutFromStdin(boolean0, boolean0, boolean0, 226, 260, byteArrayInputStream0);
      assertEquals("\u0000", string0);
  }

  @Test(timeout = 4000)
  public void test02()  throws Throwable  {
      CutApplication cutApplication0 = new CutApplication();
      Boolean boolean0 = new Boolean(true);
      byte[] byteArray0 = new byte[6];
      ByteArrayInputStream byteArrayInputStream0 = new ByteArrayInputStream(byteArray0, (byte) (-115), (byte)31);
      try { 
        cutApplication0.cutFromStdin(boolean0, boolean0, boolean0, 92, 92, byteArrayInputStream0);
        fail("Expecting exception: ArrayIndexOutOfBoundsException");
      
      } catch(ArrayIndexOutOfBoundsException e) {
      }
  }

  @Test(timeout = 4000)
  public void test03()  throws Throwable  {
      CutApplication cutApplication0 = new CutApplication();
      Boolean boolean0 = Boolean.valueOf("");
      PipedInputStream pipedInputStream0 = new PipedInputStream();
      try { 
        cutApplication0.cutFromStdin(boolean0, boolean0, boolean0, 445, 2408, pipedInputStream0);
        fail("Expecting exception: IOException");
      
      } catch(IOException e) {
         //
         // Pipe not connected
         //
         verifyException("java.io.PipedInputStream", e);
      }
  }

  @Test(timeout = 4000)
  public void test04()  throws Throwable  {
      CutApplication cutApplication0 = new CutApplication();
      Boolean boolean0 = Boolean.TRUE;
      Enumeration<BufferedInputStream> enumeration0 = (Enumeration<BufferedInputStream>) mock(Enumeration.class, new ViolatedAssumptionAnswer());
      doReturn(false, false).when(enumeration0).hasMoreElements();
      SequenceInputStream sequenceInputStream0 = new SequenceInputStream(enumeration0);
      Boolean boolean1 = Boolean.FALSE;
      String string0 = cutApplication0.cutFromStdin(boolean1, boolean0, boolean0, 62, 62, sequenceInputStream0);
      assertEquals("", string0);
  }

  @Test(timeout = 4000)
  public void test05()  throws Throwable  {
      CutApplication cutApplication0 = new CutApplication();
      Boolean boolean0 = Boolean.valueOf(true);
      byte[] byteArray0 = new byte[5];
      ByteArrayInputStream byteArrayInputStream0 = new ByteArrayInputStream(byteArray0);
      try { 
        cutApplication0.cutFromStdin(boolean0, (Boolean) null, (Boolean) null, (-2824), (-2824), byteArrayInputStream0);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("sg.edu.nus.comp.cs4218.impl.app.CutApplication", e);
      }
  }

  @Test(timeout = 4000)
  public void test06()  throws Throwable  {
      CutApplication cutApplication0 = new CutApplication();
      Boolean boolean0 = Boolean.valueOf(true);
      String[] stringArray0 = new String[0];
      String string0 = cutApplication0.cutFromFiles(boolean0, boolean0, boolean0, (-1), (-1), stringArray0);
      assertEquals("", string0);
  }

  @Test(timeout = 4000)
  public void test07()  throws Throwable  {
      CutApplication cutApplication0 = new CutApplication();
      String[] stringArray0 = new String[2];
      try { 
        cutApplication0.run(stringArray0, (InputStream) null, (OutputStream) null);
        fail("Expecting exception: Exception");
      
      } catch(Exception e) {
         //
         // cut: Null Pointer Exception
         //
         verifyException("sg.edu.nus.comp.cs4218.impl.app.CutApplication", e);
      }
  }

  @Test(timeout = 4000)
  public void test08()  throws Throwable  {
      CutApplication cutApplication0 = new CutApplication();
      PipedInputStream pipedInputStream0 = new PipedInputStream();
      BufferedInputStream bufferedInputStream0 = new BufferedInputStream(pipedInputStream0);
      PipedOutputStream pipedOutputStream0 = new PipedOutputStream();
      try { 
        cutApplication0.run((String[]) null, bufferedInputStream0, pipedOutputStream0);
        fail("Expecting exception: Exception");
      
      } catch(Exception e) {
         //
         // cut: Null arguments
         //
         verifyException("sg.edu.nus.comp.cs4218.impl.app.CutApplication", e);
      }
  }

  @Test(timeout = 4000)
  public void test09()  throws Throwable  {
      CutApplication cutApplication0 = new CutApplication();
      File file0 = MockFile.createTempFile("\"*;8EfU", "\"*;8EfU");
      MockFileInputStream mockFileInputStream0 = new MockFileInputStream(file0);
      String[] stringArray0 = new String[4];
      MockFileOutputStream mockFileOutputStream0 = new MockFileOutputStream(file0, true);
      MockPrintStream mockPrintStream0 = new MockPrintStream(mockFileOutputStream0, false);
      try { 
        cutApplication0.run(stringArray0, mockFileInputStream0, mockPrintStream0);
        fail("Expecting exception: Exception");
      
      } catch(Exception e) {
         //
         // cut: null
         //
         verifyException("sg.edu.nus.comp.cs4218.impl.app.CutApplication", e);
      }
  }

  @Test(timeout = 4000)
  public void test10()  throws Throwable  {
      CutApplication cutApplication0 = new CutApplication();
      Boolean boolean0 = Boolean.TRUE;
      try { 
        cutApplication0.cutFromStdin(boolean0, boolean0, boolean0, 0, (-735), (InputStream) null);
        fail("Expecting exception: Exception");
      
      } catch(Exception e) {
         //
         // cut: Null Pointer Exception
         //
         verifyException("sg.edu.nus.comp.cs4218.impl.app.CutApplication", e);
      }
  }

  @Test(timeout = 4000)
  public void test11()  throws Throwable  {
      CutApplication cutApplication0 = new CutApplication();
      Boolean boolean0 = Boolean.TRUE;
      Enumeration<InputStream> enumeration0 = (Enumeration<InputStream>) mock(Enumeration.class, new ViolatedAssumptionAnswer());
      doReturn(false, false).when(enumeration0).hasMoreElements();
      SequenceInputStream sequenceInputStream0 = new SequenceInputStream(enumeration0);
      try { 
        cutApplication0.cutFromStdin(boolean0, boolean0, boolean0, 0, 1, sequenceInputStream0);
        fail("Expecting exception: Exception");
      
      } catch(Exception e) {
         //
         // Out of range
         //
         verifyException("sg.edu.nus.comp.cs4218.impl.app.CutApplication", e);
      }
  }

  @Test(timeout = 4000)
  public void test12()  throws Throwable  {
      CutApplication cutApplication0 = new CutApplication();
      Boolean boolean0 = Boolean.valueOf("");
      String[] stringArray0 = new String[9];
      stringArray0[0] = "ui$DB]";
      try { 
        cutApplication0.cutFromFiles(boolean0, (Boolean) null, boolean0, 2527, 942, stringArray0);
        fail("Expecting exception: Exception");
      
      } catch(Exception e) {
         //
         // cut: No such file or directory
         //
         verifyException("sg.edu.nus.comp.cs4218.impl.app.CutApplication", e);
      }
  }

  @Test(timeout = 4000)
  public void test13()  throws Throwable  {
      CutApplication cutApplication0 = new CutApplication();
      Boolean boolean0 = new Boolean(false);
      String[] stringArray0 = new String[6];
      stringArray0[0] = "";
      try { 
        cutApplication0.cutFromFiles(boolean0, boolean0, boolean0, 0, 0, stringArray0);
        fail("Expecting exception: Exception");
      
      } catch(Exception e) {
         //
         // cut: This is a directory
         //
         verifyException("sg.edu.nus.comp.cs4218.impl.app.CutApplication", e);
      }
  }

  @Test(timeout = 4000)
  public void test14()  throws Throwable  {
      CutApplication cutApplication0 = new CutApplication();
      Boolean boolean0 = Boolean.valueOf(".Ayo$Pz2'xt6/(r?+j");
      String[] stringArray0 = new String[0];
      try { 
        cutApplication0.cutFromFiles(boolean0, boolean0, boolean0, 0, 0, stringArray0);
        fail("Expecting exception: Exception");
      
      } catch(Exception e) {
         //
         // Out of range
         //
         verifyException("sg.edu.nus.comp.cs4218.impl.app.CutApplication", e);
      }
  }

  @Test(timeout = 4000)
  public void test15()  throws Throwable  {
      CutApplication cutApplication0 = new CutApplication();
      Boolean boolean0 = new Boolean(false);
      try { 
        cutApplication0.cutFromFiles(boolean0, (Boolean) null, boolean0, 1415, 1415, (String[]) null);
        fail("Expecting exception: Exception");
      
      } catch(Exception e) {
         //
         // cut: Null arguments
         //
         verifyException("sg.edu.nus.comp.cs4218.impl.app.CutApplication", e);
      }
  }

  @Test(timeout = 4000)
  public void test16()  throws Throwable  {
      CutApplication cutApplication0 = new CutApplication();
      Boolean boolean0 = Boolean.valueOf("");
      String[] stringArray0 = new String[9];
      try { 
        cutApplication0.cutFromFiles(boolean0, (Boolean) null, boolean0, 2527, 942, stringArray0);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
      }
  }
}
