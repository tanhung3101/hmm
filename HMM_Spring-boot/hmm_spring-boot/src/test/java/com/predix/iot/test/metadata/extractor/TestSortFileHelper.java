/*package com.predix.iot.test.metadata.extractor;

import static org.junit.Assert.assertEquals;

import java.io.File;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.predix.iot.metadata.extractor.helper.SortFilesHelper;

@RunWith(SpringRunner.class)
public class TestSortFileHelper {
	
	File[] testFileArray;

	SortFilesHelper mockSortFileHelper;
	
    @Before
    public void setUp() {
    	File testDirectory = new File("E:\\TEST_ADAPTOR\\test_folder");
    	testFileArray = testDirectory.listFiles();
    }
	
    @Test
    public void testSortByName() throws Exception {
    	SortFilesHelper.sortFilesByName(testFileArray);
    	assertEquals(testFileArray[0].getName(), "firstFile.txt");
    	assertEquals(testFileArray[1].getName(), "secondFile.rtf");
    	assertEquals(testFileArray[2].getName(), "thirdFile.xlsx");
    }
    
    @Test
    public void testSortBySize() throws Exception {
    	SortFilesHelper.sortFilesBySize(testFileArray);
    	assertEquals(testFileArray[0].getName(), "firstFile.txt");
    	assertEquals(testFileArray[1].getName(), "thirdFile.xlsx");
    	assertEquals(testFileArray[2].getName(), "secondFile.rtf");
    }
    
    @Test
    public void testSortLastModifiedTime() throws Exception {
    	SortFilesHelper.sortFilesByDate(testFileArray);
    	assertEquals(testFileArray[0].getName(), "secondFile.rtf");
    	assertEquals(testFileArray[1].getName(), "firstFile.txt");
    	assertEquals(testFileArray[2].getName(), "thirdFile.xlsx");
    }
}
*/