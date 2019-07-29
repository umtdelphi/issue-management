package com.umtk.issuemanagement.api;

import com.umtk.issuemanagement.util.ApiPaths;
import io.swagger.annotations.ApiOperation;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
//import org.springframework.boot.json.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import java.time.LocalDate;
import java.util.Date;
import java.util.Map;

@RestController
@RequestMapping("/ver")

public class ProjectVersions {

    private static final String filePath = "C:\\Users\\ukarakas\\Desktop\\jsonTestFile.json";

    @GetMapping(value = "/{id}")
    @ApiOperation(value = "Get By ID Operation")
//    localhost:8000/ver/1?version=5&startDate=2019-10-31&endDate=2019-10-31

    public ResponseEntity<String> umt1(@PathVariable("id") Long id ,@RequestParam("version") String version_  ,
                                       @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                                       @RequestParam("startDate") LocalDate startDate,
                                       @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                                           @RequestParam("endDate") LocalDate endDate)
    {
        String version_text =  "version :" + version_  + " -- " +startDate + " -- " +endDate;

        return  ResponseEntity.ok(version_text);
    }

    @GetMapping(value = "/query/{id}")
    @ApiOperation(value = "Get By ID Operation")
    public ResponseEntity<String> umt2(@PathVariable("id") Long id,@RequestParam("version") String query_ ){

        String version_text =  query_;

        try {

                JSONParser jsonParser = new JSONParser();
                JSONObject map = (JSONObject) jsonParser.parse(query_);
            if (!map.isEmpty()) {
                String id_ = (String) map.get("id");
                String firstName_ = (String) map.get("isim");
                String lastName_ = (String) map.get("soyisim");
                version_text = firstName_ + " / " + lastName_  + map.toString();
            }
        } catch (Exception ex) {
            throw new IllegalArgumentException("json Parse çözülemedi! " + query_);
        }

        return  ResponseEntity.ok(version_text);
    }


    @GetMapping(value = "/file/{id}")
    @ApiOperation(value = "Get By ID Operation")
    public ResponseEntity<String> umt3(@PathVariable("id") Long id,@RequestParam("version") String query_ ){
        String version_text =  "";
        try {
            FileReader reader = new FileReader(filePath);
            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
            version_text = jsonObject.toString();
    // get a String from the JSON object
    String firstName = (String) jsonObject.get("firstname");
            version_text=version_text+("The first name is: " + firstName);

    // get a number from the JSON object
    Long id_ =  (long) jsonObject.get("id");
            version_text=version_text+("The id is: " + id_);

    // get an array from the JSON object
    JSONArray lang= (JSONArray) jsonObject.get("languages");

    // take the elements of the json array
            for(int i=0; i<lang.size(); i++){
                version_text = version_text+ ("The " + i + " element of the array: "+lang.get(i));
    }
    Iterator i = lang.iterator();

    // take each value from the json array separately
            while (i.hasNext()) {
        JSONObject innerObj = (JSONObject) i.next();
                version_text = version_text+("language "+ innerObj.get("lang") +
                " with level " + innerObj.get("knowledge"));
    }
    // handle a structure into the json object
    JSONObject structure = (JSONObject) jsonObject.get("job");
            version_text=version_text+("Into job structure, name: " + structure.get("name"));


        } catch (Exception ex) {
            throw new IllegalArgumentException("json Parse çözülemedi! " + version_text);
        }

        return  ResponseEntity.ok(version_text);
    }


//    @GetMapping(value = "/query",params = "version")
//    @ApiOperation(value = "Get By ID Operation")
//    public ResponseEntity<String> umt2(@PathVariable("id") Long id,@RequestParam("version") String query_ ){
//        String version_text =  "";
//        return  ResponseEntity.ok(version_text);
//    }




}
