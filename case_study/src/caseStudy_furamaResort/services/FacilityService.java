package caseStudy_furamaResort.services;

import caseStudy_furamaResort.models.Facility;

import java.util.LinkedHashMap;

public interface FacilityService extends Service{
    LinkedHashMap<Facility, Integer> readFile(String filePath);
    void writeFile(Facility facility, String filePath);
}
