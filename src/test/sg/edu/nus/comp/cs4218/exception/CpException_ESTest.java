/*
 * This file was automatically generated by EvoSuite
 * Sun Mar 22 06:41:05 GMT 2020
 */

package sg.edu.nus.comp.cs4218.exception;

import org.junit.Test;
import static org.junit.Assert.*;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;
import sg.edu.nus.comp.cs4218.exception.CpException;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true, useJEE = true) 
public class CpException_ESTest extends CpException_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      CpException cpException0 = new CpException("");
  }
}
