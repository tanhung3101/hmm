/*package com.predix.iot.test.metadata.extractor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import java.io.File;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import com.predix.iot.file.river.model.FileMetadata;
import com.predix.iot.file.river.service.FileRiverService;
import com.predix.iot.metadata.extractor.FileCollector;
import com.predix.iot.metadata.extractor.config.EdgeConfig;
import com.predix.iot.store.forward.entity.FileMetadataEntity;
import com.predix.iot.store.forward.service.StoreForwardService;

@RunWith(SpringRunner.class)
@SpringBootTest
@Import(TestConfig.class)
public class TestFileCollector {

	@Autowired
	private FileCollector testFileCollector;
	
	@Autowired
	private StoreForwardService storeAndForward;
	
	@MockBean
	private FileRiverService fileRiver;
	
	@Before
	public void setup(){
		when(fileRiver.sentFile(any(Integer.class), any(FileMetadata.class))).thenReturn(true);
	}
	
	@Test
	public void testPickUpFileWithoutDelete(){
		testFileCollector.pickupFile();
		FileMetadataEntity metadataEntity = storeAndForward.getMetadata("firstFile.txt");
		
		assertNotNull(metadataEntity);
	}
	
	@Test
	public void testPickUpFileWithDelete(){
		testFileCollector.pickupFile();
		File testDeleteFile = new File("E:\\TEST_ADAPTOR\\test_folder\\firstFile.txt");
		
		assertEquals(testDeleteFile.exists(),false);
	}
}
*/