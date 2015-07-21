/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.dvdlibraryv3;

import com.swcguild.dvdlibrary.dao.DvdLibraryDao;
import com.swcguild.dvdlibrary.dto.Dvd;
import com.swcguild.dvdlibrary.dto.SearchTerms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


/**
 *
 * @author apprentice
 */
public class DvdLibraryDaoDKImpl implements DvdLibraryDao {
    
    //static int counter = 0; //add this to test multiple items in hash
    
    private final HashMap<Integer, Dvd> dvds = new HashMap<>();
    //static int counter; //adding a counter in the Impl
    
    //single source of truth is our methods, not our HashMap

    @Override
    public void add(Dvd dvd) {
        //++counter;      //put counter into Dan's--he had in controller, like I had in DTO
        //dvd.setId(counter); //we both needed it in Impl!
        dvds.put(dvd.getId(), dvd);
    }

    @Override
    public void remove(int id) {
        dvds.remove(id);
    }

    @Override
    public List<Dvd> listAll() {
        if (dvds.keySet().size() == 0) {
            return null;
        }
        List list = new ArrayList(dvds.values());
        return list;
    }

    @Override
    public Dvd getById(int id) {
        if (dvds.keySet().size() == 0) {
            return null;
        }
        return dvds.get(id);
    }

    @Override
    public List<Dvd> getByTitle(String title) {
        if (dvds.keySet().size() == 0) {
            return null;
        }
        return dvds.values()
                .stream()
                .filter(t -> t.getTitle().equalsIgnoreCase(title))
                .collect(Collectors.toList());
    }

    @Override
    public List<Dvd> getByRating(String rating) {
        if (dvds.keySet().size() == 0){
            return null;
        }
        return dvds.values()
                .stream()
                .filter(r -> r.getMpaaRating().equalsIgnoreCase(rating))
                .collect(Collectors.toList());
    }

    @Override
    public List<Dvd> getByStudio(String studio) {
        if (dvds.keySet().size()==0) {
            return null;
        }
        return dvds.values()
                .stream()
                .filter(s -> s.getStudio().equalsIgnoreCase(studio))
                .collect(Collectors.toList());
    }
    
        //
    @Override
    public void update(Dvd dvd) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Dvd> searchDvds(Map<SearchTerms, String> criteria) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
