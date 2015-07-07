/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.swcguild.dvdlamdbas.DVDLibraryFileImpl;
import junit.framework.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author apprentice
 */
public class DVDLambaTests {

    
    public DVDLambaTests() {
    }
    
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
//    @Test
//    public void testDVDageDays() {
//        DVDLibraryFileImpl testObject = new DVDLibraryFileImpl();
//        int result = testObject.getDVD(5).getDVDageDays();
//        Assert.assertEquals(16425, result);
//        
//    }
    
    @Test
    public void testDVDageDays() {
        DVDLibraryFileImpl testObject = new DVDLibraryFileImpl();
        int result = testObject.getDVD(5).getDVDageDays();
        Assert.assertEquals(16425, result);

    }
}
