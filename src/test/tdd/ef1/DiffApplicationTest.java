package tdd.ef1;

import org.junit.jupiter.api.*;
import sg.edu.nus.comp.cs4218.Environment;
import sg.edu.nus.comp.cs4218.exception.DiffException;
import sg.edu.nus.comp.cs4218.impl.app.DiffApplication;
import sg.edu.nus.comp.cs4218.impl.util.FileSystemUtils;
import sg.edu.nus.comp.cs4218.impl.util.StringUtils;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;
import static sg.edu.nus.comp.cs4218.impl.util.ErrorConstants.*;
import static sg.edu.nus.comp.cs4218.impl.util.StringUtils.STRING_NEWLINE;

/**
 * Tests for diff command.
 *
 * Negative test cases:
 * - Invalid file
 * - Invalid directory
 * - Directory without files
 *
 * Positive test cases:
 * - No flag used + Files/stdin with same content
 * - "-s" flag used + Files/stdin with same content
 * - "-B" flag used + Files/stdin with same content
 * - "-sB" flags used + Files with same content
 * - No flag used + Directories containing Files with same content
 * - "-s" flag used + Directories containing Files with same content
 *
 * - No flag used + Files/stdin with different content
 * - "-q" flag used + Files/stdin with different content
 * - "-Bq" flags used + Files/stdin with different content
 * - "sBq" flags used + Files/stdin with different content
 * - No flag used + Directories containing Files with different content
 * - "-q" flag used + Directories containing Files with different content
 */
public class DiffApplicationTest { // NOPMD
    private static DiffApplication diffApp;
    private static final String ORIGINAL_DIR = Environment.currentDirectory;
    private static final String DIFF_TEST_DIR = ORIGINAL_DIR
                    + StringUtils.fileSeparator()+ "src"
                            + StringUtils.fileSeparator()+ "test"
                            + StringUtils.fileSeparator()+ "tdd"
                            + StringUtils.fileSeparator() +"util"
                            + StringUtils.fileSeparator() +"dummyTestFolder"
                            + StringUtils.fileSeparator() + "DiffTestFolder";
    private static OutputStream stdout;

    private static final String DIFF1_FILE = "diff1.txt";
    private static final String DIFF1_IDENTICAL_FILE = "diff1-identical.txt"; // NOPMD
    private static final String DIFF1_BLANK_LINES_FILE = "diff1-blank-lines.txt"; // NOPMD
    private static final String DIFF2_FILE = "diff2.txt";

    private static final String DIFFDIR1 = "diffDir1";
    private static final String DIFFDIR1_IDENTICAL = "diffDir1-identical"; // NOPMD
    private static final String DIFFDIR1_DIFF = "diffDir1-diff";
    private static final String DIFFDIR2 = "diffDir2";
    private static final String DIFFALPHA = "diffDir-alpha";
    private static final String DIFFBETA = "diffDir-beta";
    private static final String dummyDIR = "dummyDir";

    @BeforeAll
    static void setupAll() {
        Environment.currentDirectory = DIFF_TEST_DIR;
        File testFolder = new File(FileSystemUtils.getAbsolutePathName(dummyDIR));
        try {
            testFolder.mkdirs();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @BeforeEach
    void setUp() {
        diffApp = new DiffApplication();
        stdout = new ByteArrayOutputStream();
    }

    @AfterEach
    void tearDown() throws IOException {
        stdout.flush();
    }

    @AfterAll
    static void reset() {
        try {
            FileSystemUtils.deleteFileRecursive(new File(FileSystemUtils.getAbsolutePathName(dummyDIR)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        Environment.currentDirectory = ORIGINAL_DIR;
    }

    @Test
    public void testFailsWithNullFile() {
        Exception expectedException = assertThrows(DiffException.class, () -> diffApp.diffTwoFiles(null, null, false, false, false));
        assertTrue(expectedException.getMessage().contains(ERR_NULL_ARGS));
    }

    @Test
    public void testFailsWithInvalidFile() {
        Exception expectedException = assertThrows(DiffException.class, () -> diffApp.diffTwoFiles("invalidFile.txt", "invalidFile.txt", false, false, false));
        assertTrue(expectedException.getMessage().contains(ERR_FILE_NOT_FOUND));
    }

    @Test
    public void testFailsWithInvalidDir() {
        Exception expectedException = assertThrows(DiffException.class, () -> diffApp.diffTwoFiles("invalidDir", "invalidDir", false, false, false));
        assertTrue(expectedException.getMessage().contains(ERR_FILE_NOT_FOUND));
    }

    @Test
    public void testDiffFilesWithSameContent() {
        try {
            String result = diffApp.diffTwoFiles(DIFF1_FILE, DIFF1_IDENTICAL_FILE, false, false, false);
            assertEquals("", result); // No message represents a successful diff
        } catch (DiffException e) {
            fail("should not fail: " + e.getMessage()); // NOPMD
        }
    }

    @Test
    public void testDiffFileAndStdinWithSameContent() throws DiffException {
        try {
            InputStream inputStream = new FileInputStream(new File(DIFF_TEST_DIR + StringUtils.CHAR_FILE_SEP + DIFF1_FILE)); //NOPMD
            String result = diffApp.diffFileAndStdin(DIFF1_FILE, inputStream, false, false, false);
            assertEquals("", result); // No message represents a successful diff
        } catch (IOException e) {
            fail("should not fail: " + e.getMessage());
        }
    }

    @Test
    public void testDiffFilesWithSameContentUsingFlagS() {
        try {
            String result = diffApp.diffTwoFiles(DIFF1_FILE, DIFF1_IDENTICAL_FILE, true, false, false);
            assertEquals("Files " + DIFF1_FILE + " " + DIFF1_IDENTICAL_FILE + " are identical", result); // NOPMD
        } catch (DiffException e) {
            fail("should not fail: " + e.getMessage());
        }
    }

    @Test
    public void testDiffFileAndStdinWithSameContentUsingFlagS() throws DiffException {
        try {
            InputStream inputStream = new FileInputStream(new File(DIFF_TEST_DIR + StringUtils.CHAR_FILE_SEP + DIFF1_FILE)); //NOPMD
            String result = diffApp.diffFileAndStdin(DIFF1_FILE, inputStream, true, false, false);
            assertEquals("Files " + DIFF1_FILE + " - are identical",result);
        } catch (IOException e) {
            fail("should not fail: " + e.getMessage());
        }
    }

    @Test
    public void testDiffFilesWithSameContentUsingFlagB() {
        try {
            String result = diffApp.diffTwoFiles(DIFF1_FILE, DIFF1_BLANK_LINES_FILE, false, true, false);
            assertEquals("", result); // No message represents a successful diff
        } catch (DiffException e) {
            fail("should not fail: " + e.getMessage());
        }
    }

    @Test
    public void testDiffFileAndStdinWithSameContentUsingFlagB() throws DiffException {
        try {
            InputStream inputStream = new FileInputStream(new File(DIFF_TEST_DIR + StringUtils.CHAR_FILE_SEP + DIFF1_BLANK_LINES_FILE)); //NOPMD
            String result = diffApp.diffFileAndStdin(DIFF1_FILE, inputStream, false, true, false);
            assertEquals("", result); // No message represents a successful diff
        } catch (IOException e) {
            fail("should not fail: " + e.getMessage());
        }
    }

    @Test
    public void testDiffFilesWithSameContentUsingFlagSB() {
        try {
            String result = diffApp.diffTwoFiles(DIFF1_FILE, DIFF1_BLANK_LINES_FILE, true, true, false);
            assertEquals("Files " + DIFF1_FILE + " " + DIFF1_BLANK_LINES_FILE + " are identical",result);
        } catch (DiffException e) {
            fail("should not fail: " + e.getMessage());
        }
    }

    @Test
    public void testDiffDirContainFilesWithSameContent() {
        try {
            String result = diffApp.diffTwoDir(DIFFDIR1, DIFFDIR1_IDENTICAL, false, false, false);
            assertEquals("", result); // No message represents a successful diff
        } catch (DiffException e) {
            fail("should not fail: " + e.getMessage());
        }
    }

    @Test
    public void testDiffDirContainFilesWithSameContentUsingFlagS() {
        try {
            String result = diffApp.diffTwoDir(DIFFDIR1, DIFFDIR1_IDENTICAL, true, false, false);
            assertEquals("Files "  + DIFFDIR1 + StringUtils.CHAR_FILE_SEP + DIFF1_IDENTICAL_FILE + " "
                                            + DIFFDIR1_IDENTICAL + StringUtils.CHAR_FILE_SEP + DIFF1_IDENTICAL_FILE
                                            + " are identical" + STRING_NEWLINE + "Files "
                                            + DIFFDIR1 + StringUtils.CHAR_FILE_SEP + DIFF1_FILE + " "
                                            + DIFFDIR1_IDENTICAL + StringUtils.CHAR_FILE_SEP + DIFF1_FILE  + " are identical"
                    ,result);
        } catch (DiffException e) {
            fail("should not fail: " + e.getMessage());
        }
    }

    @Test
    public void testDiffFilesWithDifferentContent() {
        try {
            String result = diffApp.diffTwoFiles(DIFF1_FILE, DIFF2_FILE, false, false, false);
            assertEquals("< test A" + STRING_NEWLINE +
                    "< test B" + STRING_NEWLINE +
                    "< test C" + STRING_NEWLINE +
                    "> test D" + STRING_NEWLINE +
                    "> test E" + STRING_NEWLINE +
                    "> test F", result);
        } catch (DiffException e) {
            fail("should not fail: " + e.getMessage());
        }
    }

    @Test
    public void testDiffFileAndStdinWithDifferentContent() throws DiffException {
        try {
            InputStream inputStream = new FileInputStream(new File(DIFF_TEST_DIR + StringUtils.fileSeparator() + DIFF2_FILE)); //NOPMD
            String result = diffApp.diffFileAndStdin(DIFF1_FILE, inputStream, false, false, false);
            assertEquals("< test A" + STRING_NEWLINE +
                    "< test B" + STRING_NEWLINE +
                    "< test C" + STRING_NEWLINE +
                    "> test D" + STRING_NEWLINE +
                    "> test E" + STRING_NEWLINE +
                    "> test F", result);
        } catch (IOException e) {
            fail("should not fail: " + e.getMessage());
        }
    }

    @Test
    public void testDiffFilesWithDifferentContentUsingFlagQ() {
        try {
            String result = diffApp.diffTwoFiles(DIFF1_FILE, DIFF2_FILE, false, false, true);
            assertEquals("Files " + DIFF1_FILE + " " + DIFF2_FILE + " differ", result); // NOPMD
        } catch (DiffException e) {
            fail("should not fail: " + e.getMessage());
        }
    }

    @Test
    public void testDiffFileAndStdinWithDifferentContentUsingFlagQ() throws DiffException {
        try {
            InputStream inputStream = new FileInputStream(new File(DIFF_TEST_DIR + StringUtils.CHAR_FILE_SEP + DIFF2_FILE)); //NOPMD
            String result = diffApp.diffFileAndStdin(DIFF1_FILE, inputStream, false, false, true);
            assertEquals("Files " + DIFF1_FILE + " - differ", result);
        } catch (IOException e) {
            fail("should not fail: " + e.getMessage());
        }
    }

    @Test
    public void testDiffFilesWithDifferentContentUsingFlagBQ() {
        try {
            String result = diffApp.diffTwoFiles(DIFF2_FILE, DIFF1_BLANK_LINES_FILE, false, true, true);
            assertEquals("Files " + DIFF2_FILE + " " + DIFF1_BLANK_LINES_FILE + " differ",result);
        } catch (DiffException e) {
            fail("should not fail: " + e.getMessage());
        }
    }

    @Test
    public void testDiffFileAndStdinWithDifferentContentUsingFlagBQ() throws DiffException {
        try {
            InputStream inputStream = new FileInputStream(new File(DIFF_TEST_DIR + StringUtils.CHAR_FILE_SEP + DIFF1_BLANK_LINES_FILE)); //NOPMD
            String result = diffApp.diffFileAndStdin(DIFF2_FILE, inputStream, false, true, true);
            assertEquals("Files " + DIFF2_FILE + " - differ",result);
        } catch (IOException e) {
            fail("should not fail: " + e.getMessage());
        }
    }

    @Test
    public void testDiffFilesWithDifferentContentUsingFlagSBQ() {
        try {
            String result = diffApp.diffTwoFiles(DIFF2_FILE, DIFF1_BLANK_LINES_FILE, true, true, true);
            assertEquals("Files " + DIFF2_FILE + " " + DIFF1_BLANK_LINES_FILE + " differ",result);
        } catch (DiffException e) {
            fail("should not fail: " + e.getMessage());
        }
    }

    @Test
    public void testDiffFileAndStdinWithDifferentContentUsingFlagSBQ() throws DiffException {
        try {
            InputStream inputStream = new FileInputStream(new File(DIFF_TEST_DIR + StringUtils.CHAR_FILE_SEP + DIFF1_BLANK_LINES_FILE)); //NOPMD
            String result = diffApp.diffFileAndStdin(DIFF2_FILE, inputStream, true, true, true);
            assertEquals("Files " + DIFF2_FILE + " - differ",result);
        } catch (IOException e) {
            fail("should not fail: " + e.getMessage());
        }
    }

    @Test
    public void testDiffDirContainFilesWithDifferentContent() {
        try {
            String result = diffApp.diffTwoDir(DIFFDIR1, DIFFDIR1_DIFF, false, false, false);
            assertEquals(
                    "diff diffDir1" + StringUtils.CHAR_FILE_SEP + "diff1-identical.txt diffDir1-diff" +
                            StringUtils.CHAR_FILE_SEP + "diff1-identical.txt" + STRING_NEWLINE +
                    "> test D" + STRING_NEWLINE +
                    "> test E" + STRING_NEWLINE +
                    "diff diffDir1" + StringUtils.CHAR_FILE_SEP + "diff1.txt diffDir1-diff" + StringUtils.CHAR_FILE_SEP +
                            "diff1.txt" + STRING_NEWLINE +
                    "< test B" + STRING_NEWLINE +
                    "> test D" + STRING_NEWLINE +
                    "> test E" + STRING_NEWLINE +
                    "> test F", result);
        } catch (DiffException e) {
            fail("should not fail: " + e.getMessage());
        }
    }

    @Test
    public void testDiffDirContainFilesWithDiffAlpha() {
        try {
            String result = diffApp.diffTwoDir(DIFFALPHA, DIFFBETA, false, false, false);
            assertEquals("Only in diffDir-alpha: a.txt" + STRING_NEWLINE +
                    "Only in diffDir-beta: bb.txt" + STRING_NEWLINE +
                    "Only in diffDir-beta: c.txt" + STRING_NEWLINE +
                    "Only in diffDir-alpha: d.txt", result);
        } catch (DiffException e) {
            fail("should not fail: " + e.getMessage());
        }
    }

    @Test
    public void testDiffDirContainFilesWithDifferentContentUsingFlagQ() {
        try {
            String result = diffApp.diffTwoDir(DIFFDIR1, DIFFDIR1_DIFF, false, false, true);
            assertEquals("Files "  + DIFFDIR1 + StringUtils.CHAR_FILE_SEP + DIFF1_IDENTICAL_FILE + " "
                            + DIFFDIR1_DIFF + StringUtils.CHAR_FILE_SEP + DIFF1_IDENTICAL_FILE
                            + " differ" + STRING_NEWLINE + "Files "
                            + DIFFDIR1 + StringUtils.CHAR_FILE_SEP + DIFF1_FILE + " "
                            + DIFFDIR1_DIFF + StringUtils.CHAR_FILE_SEP + DIFF1_FILE  + " differ"
                    ,result);
        } catch (DiffException e) {
            fail("should not fail: " + e.getMessage());
        }
    }
}
