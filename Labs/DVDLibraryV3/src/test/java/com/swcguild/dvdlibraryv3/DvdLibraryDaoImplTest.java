/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.dvdlibraryv3; //this is the name space
                                   //when we swap out files we will need to import somebody elses package

import com.swcguild.dvdlibrary.dao.DvdLibraryDao;
import com.swcguild.dvdlibrary.dto.Dvd;
import java.util.List;
import org.junit.After;
import org.junit.Assert;
//import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author apprentice
 */
public class DvdLibraryDaoImplTest {
    
    ApplicationContext ctx; // we need our context here in order to test 
    DvdLibraryDao dao; // we also need an instance of this interface that we are depending on
    
    Dvd dvd1;
    Dvd dvd2;

    public DvdLibraryDaoImplTest() {
    }

    @Before
    public void setUp() {
        ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        dao = ctx.getBean("dvdLibraryDao", DvdLibraryDao.class); //not our impl, but the actual dao interface -- here's where we are importing it
          //this allows us to get the interace as a package and let Maven deal with it--there is in implementation file in 
                                         //we cast it to the dao interface
                                         //this way we don't have to change our tests to run tests
                                         //we can just comment out our other bean in the application context file and swap in our other impl
        dvd1 = new Dvd();
        dvd2 = new Dvd();
        
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of add method, of class DvdLibraryDaoImpl.
     */
    @Test 
        public void addGetRemove(){
            //set
            //act
            //assert
    
    }
    
            @Test
    public void testAdd() {
        System.out.println("add");
        //Dvd dvd = null;//this is null so we can't set a property on it
        //we'll need to instatiate a DVD object to add!!
        
        dvd1.setTitle("TestDVD1"); //this is 
        
        dao.add(dvd1);
        List<Dvd> testList = dao.listAll();
        String result = testList.get(0).getTitle();
        Assert.assertEquals("TestDVD1", result);

    }

    /**
     * Test of remove method, of class DvdLibraryDaoImpl.
     */
    @Test
    public void testRemove() {
        System.out.println("remove");

        Dvd dvd1 = new Dvd();
        dvd1.setTitle("TestDVD1"); //this is 
        dvd1.setId(0);

        DvdLibraryDaoImpl instance = new DvdLibraryDaoImpl();
        instance.add(dvd1);
        instance.remove(0);

        boolean result = instance.getDvdCollection().isEmpty();
        Assert.assertTrue(result);

    }

    /**
     * Test of listAll method, of class DvdLibraryDaoImpl.
     */
    @Test
    public void testListAll() {
        System.out.println("listAll");
       
        dvd1.setTitle("Apples are Free");
        dvd1.setId(0);
        dao.add(dvd1);

        dvd2.setTitle("Babies are Cute");
        dvd2.setId(1);
        dao.add(dvd2);

        List<Dvd> testList = dao.listAll();
        int result = testList.size();
        assertEquals(2, result);

    }

    /**
     * Test of getById method, of class DvdLibraryDaoImpl.
     */
    @Test
    public void testGetById() {
        System.out.println("getById");
        
        dvd1.setTitle("Apples are Free");
        dvd1.setId(0);
        dao.add(dvd1);

        dvd2.setTitle("Babies are Cute");
        dvd2.setId(1);
        dao.add(dvd2);
        
        Dvd first = dao.getById(0);
        String result = first.getTitle();
        assertEquals("Apples are Free", result);

    }

    /**
     * Test of getByTitle method, of class DvdLibraryDaoImpl.
     */
    @Test
    public void testGetByTitle() {
        System.out.println("getByTitle");
        
        dvd1.setTitle("Apples are Free");
        dvd1.setId(0);
        dao.add(dvd1);

        dvd2.setTitle("Babies are Cute");
        dvd2.setId(1);
        dao.add(dvd2);
    
        //List<Dvd> testList = dao.listAll();
        
        String title = "Apples";
        
        List<Dvd> result = dao.getByTitle(title); //should return a list of titles, this title has one match
                                                //list size shoudl equal one or string shoudl match
        int num = (result.size());
        Assert.assertEquals(1, num);

    }

    /**
     * Test of getByRating method, of class DvdLibraryDaoImpl.
     */
    @Test
    public void testGetByRating() {
        System.out.println("getByRating");
        String rating = "R"; //already set ratings for two dvds to R in field for test
        
        dvd1.setTitle("Apples are Free");
        dvd1.setId(0);
        dvd1.setMpaaRating("R");
        dao.add(dvd1);

        dvd2.setTitle("Babies are Cute");
        dvd2.setId(1);
         dvd2.setMpaaRating("R");
        dao.add(dvd2);
        List<Dvd> listResult = dao.getByRating(rating);
        int sizeList = listResult.size();
        assertEquals(2, sizeList);
    }
    /**
     * Test of getByStudio method, of class DvdLibraryDaoImpl.
     */
    @Test
    public void testGetByStudio() {
        System.out.println("getByStudio");
        
        dvd1.setTitle("Apples are Free");
        dvd1.setId(0);
        dvd1.setStudio("Fox");
        dao.add(dvd1);
        
        dvd2.setTitle("Babies are Cute");
        dvd2.setId(1);
        dvd2.setStudio("independent");
        dao.add(dvd2);
        
        String aStudio = "Fox"; //set dvd1 to fox in field area
    
        List<Dvd> resultList = dao.getByStudio(aStudio);
        
        boolean numberWStudio = resultList.isEmpty();
        assertFalse(numberWStudio);
        
    }
    
   } 
    //------------OLD TESTS BEFORE DAO CTX----------------------------
//    @Test
//    public void testAdd() {
//        System.out.println("add");
//        //Dvd dvd = null;//this is null so we can't set a property on it
//        //we'll need to instatiate a DVD object to add!!
//        Dvd dvdTestObj1 = new Dvd();
//        dvdTestObj1.setTitle("TestDVD1"); //this is 
//        DvdLibraryDaoImpl instance = new DvdLibraryDaoImpl();
//        instance.add(dvdTestObj1);
//        List<Dvd> testList = instance.listAll();
//        String result = testList.get(0).getTitle();
//        Assert.assertEquals("TestDVD1", result);
//
//    }

    /**
     * Test of remove method, of class DvdLibraryDaoImpl.
     */
//    @Test
//    public void testRemove() {
//        System.out.println("remove");
//
//        Dvd dvdTestObj1 = new Dvd();
//        dvdTestObj1.setTitle("TestDVD1"); //this is 
//        dvdTestObj1.setId(0);
//
//        DvdLibraryDaoImpl instance = new DvdLibraryDaoImpl();
//        instance.add(dvdTestObj1);
//        instance.remove(0);
//
//        boolean result = instance.getDvdCollection().isEmpty();
//        Assert.assertTrue(result);
//
//    }

    /**
     * Test of listAll method, of class DvdLibraryDaoImpl.
     */
//    @Test
//    public void testListAll() {
//        System.out.println("listAll");
//        DvdLibraryDaoImpl instance = new DvdLibraryDaoImpl();
//
//        Dvd dvdTestObj = new Dvd();
//        dvdTestObj.setTitle("Apples are Free");
//        dvdTestObj.setId(0);
//        instance.add(dvdTestObj);
//
//        Dvd dvdTestObj1 = new Dvd();
//        dvdTestObj1.setTitle("Babies are Cute");
//        dvdTestObj1.setId(1);
//        instance.add(dvdTestObj1);
//
//        List<Dvd> testList = instance.listAll();
//        int result = testList.size();
//        assertEquals(2, result);
//
//    }

    /**
     * Test of getById method, of class DvdLibraryDaoImpl.
     */
//    @Test
//    public void testGetById() {
//        System.out.println("getById");
//        DvdLibraryDaoImpl instance = new DvdLibraryDaoImpl();
//
//        Dvd dvdTestObj = new Dvd();
//        dvdTestObj.setTitle("Apples are Free");
//        dvdTestObj.setId(0);
//        instance.add(dvdTestObj);
//
//        Dvd dvdTestObj1 = new Dvd();
//        dvdTestObj1.setTitle("Babies are Cute");
//        dvdTestObj1.setId(1);
//        instance.add(dvdTestObj1);
//
//        Dvd first = instance.getById(0);
//        String result = first.getTitle();
//        assertEquals("Apples are Free", result);
//
//    }

    /**
     * Test of getByTitle method, of class DvdLibraryDaoImpl.
     */
//    @Test
//    public void testGetByTitle() {
//        System.out.println("getByTitle");
//
//        DvdLibraryDaoImpl instance = new DvdLibraryDaoImpl();
//
//        Dvd dvdTestObj = new Dvd();
//        dvdTestObj.setTitle("Apples are Free");
//        dvdTestObj.setId(0);
//        instance.add(dvdTestObj);
//
//        Dvd dvdTestObj1 = new Dvd();
//        dvdTestObj1.setTitle("Babies are Cute");
//        dvdTestObj1.setId(1);
//        instance.add(dvdTestObj1);
//
//        List<Dvd> testList = instance.listAll();
//        
//        String title = "Apples";
//        List<Dvd> result = instance.getByTitle(title);
//        int num = result.indexOf(result);
//        assertEquals(num, result);
//
//    }

//    /**
//     * Test of getByRating method, of class DvdLibraryDaoImpl.
//     */
//    @Test
//    public void testGetByRating() {
//        System.out.println("getByRating");
//        String rating = "";
//        DvdLibraryDaoImpl instance = new DvdLibraryDaoImpl();
//        List<Dvd> expResult = null;
//        List<Dvd> result = instance.getByRating(rating);
//        assertEquals(expResult, result);
//        
//    }

//    /**
//     * Test of getByStudio method, of class DvdLibraryDaoImpl.
//     */
//    @Test
//    public void testGetByStudio() {
//        System.out.println("getByStudio");
//        String studio = "";
//        DvdLibraryDaoImpl instance = new DvdLibraryDaoImpl();
//        List<Dvd> expResult = null;
//        List<Dvd> result = instance.getByStudio(studio);
//        assertEquals(expResult, result);
//        
//    }
//    

