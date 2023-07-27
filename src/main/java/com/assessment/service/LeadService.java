package com.assessment.service;

import com.assessment.model.Lead;
import com.assessment.utility.FileUploadUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LeadService {

    @Autowired
    FileUploadUtility fileUploadUtility;

    public List<Lead> process(InputStream inputStream) {
        List<Lead> leads = fileUploadUtility.processCsvRow(inputStream);

        leads.forEach(el -> System.out.println(el.getId() + " " + el.getName() + " " + el.getEmail()));

        return leads;
    }

}
