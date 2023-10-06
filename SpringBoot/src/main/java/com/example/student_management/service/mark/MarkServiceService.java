package com.example.student_management.service.mark;

import java.util.List;

import com.example.student_management.dto.markDto;
import com.example.student_management.response.GeneralResponse;

public interface MarkServiceService {
	GeneralResponse addMark(Long userId, markDto MarkDto);
	List<markDto> getResult();
}
