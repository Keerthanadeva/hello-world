package com.example.Controller;

import com.example.Model.Company;
import com.example.Service.CompanyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * Created by jeeva on 02-12-2016.
 */
@RestController
@RequestMapping("/company")
public class CompanyRestController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CompanyRestController.class);
    
    @Autowired
    private CompanyService companyService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    Company create(@RequestBody Company company) throws Exception {
        LOGGER.info("Creating Company ", company);
        company = companyService.saveCompany(company);
        LOGGER.info("Created Company ", company);

        return company;
    }
}
