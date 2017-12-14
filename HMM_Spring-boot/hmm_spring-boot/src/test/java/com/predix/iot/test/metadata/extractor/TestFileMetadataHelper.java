/*package com.predix.iot.test.metadata.extractor;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.io.File;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import com.predix.iot.metadata.extractor.model.FileMetadata;
import com.predix.iot.metadata.extractor.service.FileMetadataService;
import com.predix.iot.store.forward.entity.FileMetadataEntity;
import com.predix.iot.store.forward.service.StoreForwardService;

@RunWith(SpringRunner.class)
@SpringBootTest
@Import(TestConfig.class)
public class TestFileMetadataHelper {
	
	@Autowired
	private FileMetadataService testMetadataService;
	
	@MockBean
	private StoreForwardService storeAndFoward;
	
	File[] testFileArray;
	
	@Before
	public void setup(){
    	File testDirectory = new File("E:\\TEST_ADAPTOR\\test_folder");
    	testFileArray = testDirectory.listFiles();
    	
    	when(storeAndFoward.getMetadata("firstFile.txt")).thenReturn(null);
    	when(storeAndFoward.getMetadata("secondFile.rtf")).thenReturn(null);
    	when(storeAndFoward.getMetadata("thirdFile.xlsx")).thenReturn(null);
    	when(storeAndFoward.getMetadata("fourFile.rtf")).thenReturn(new FileMetadataEntity());
	}
	
	@Test
	public void testGenerateMetadataWithFilePatternAndIsDelete(){
		List<FileMetadata> metadataList = testMetadataService.generateMetadata(testFileArray, ".*\\.rtf", false);
		
		assertEquals(metadataList.size(), 1);
		assertEquals(metadataList.get(0).getFileName(), "secondFile.rtf");
	}
	
	@Test
	public void testGenerateMetadataWithFilePatternAndWithoutDelete(){
		List<FileMetadata> metadataList = testMetadataService.generateMetadata(testFileArray, ".*\\.rtf", true);
		
		assertEquals(metadataList.size(), 2);
		assertEquals(metadataList.get(0).getFileName(), "fourFile.rtf");
		assertEquals(metadataList.get(1).getFileName(), "secondFile.rtf");
	}
}
*/