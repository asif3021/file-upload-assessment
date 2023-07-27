package com.assessment.utility;

import com.assessment.model.Lead;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FileUploadUtility {
    public List<Lead> processCsvRow(InputStream inputStream) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        // Read each line using parallel
        List<Lead> leads = reader.lines()
                .parallel()
                .map(el -> new Lead(el.split(",")[0], el.split(",")[1], el.split(",")[2]))
                .collect(Collectors.toList());

        return leads;
    }
}
