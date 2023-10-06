package com.example.student_management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.student_management.dto.markDto;
import com.example.student_management.response.GeneralResponse;
import com.example.student_management.service.mark.MarkServiceService;

@RestController
@RequestMapping("/api")
public class MarkController {
	 @Autowired
	    private MarkServiceService markService;

	    @PostMapping("/mark/{userId}")
	    public GeneralResponse addMark(@RequestBody markDto MarkDto, @PathVariable Long userId) {
	        GeneralResponse response = new GeneralResponse();
	        try {
	            return markService.addMark(userId, MarkDto);
	        } catch (Exception e) {
	            response.setStatus(HttpStatus.BAD_REQUEST);
	            response.setMessage("Something went wrong!");
	        }
	        return response;
	    }
	    
	    @GetMapping("/marks")
	    public GeneralResponse getResult(){
	        GeneralResponse response = new GeneralResponse();
	        try {
	            response.setData(markService.getResult());
	            response.setStatus(HttpStatus.OK);
	            response.setMessage("Teachers fetched successfully!");
	        } catch (Exception e) {
	            response.setStatus(HttpStatus.BAD_REQUEST);
	            response.setMessage("Something went wrong!");
	        }
	        return response;
	    }

}
