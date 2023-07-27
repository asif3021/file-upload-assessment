package com.assessment.controller;

import com.assessment.model.Lead;
import com.assessment.service.LeadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping(value = "/api")
public class LeadController {

    @Autowired
    public LeadService leadService;

    @RequestMapping(value = "/hello", method = RequestMethod.POST)
    public String uploadFile() {
        System.out.println("Hello new springboot project");
        return "Ok";
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public ResponseEntity<String> uploadCSV(@RequestParam("file") MultipartFile file) throws IOException, ExecutionException, InterruptedException {
            List<Lead> leads = leadService.process(file.getInputStream());

            return ResponseEntity.ok("Uploaded " + leads.size() + " leads successfully!");
    }


}
