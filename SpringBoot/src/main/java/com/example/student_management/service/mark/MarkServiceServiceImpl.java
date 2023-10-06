package com.example.student_management.service.mark;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.student_management.dto.markDto;
import com.example.student_management.model.Mark;

import com.example.student_management.model.User;
import com.example.student_management.repository.MarkRepository;
import com.example.student_management.repository.UserRepo;
import com.example.student_management.response.GeneralResponse;
import com.example.student_management.service.mark.MarkServiceService;

@Service
public class MarkServiceServiceImpl implements MarkServiceService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private MarkRepository markRepository;

    @Override
    public GeneralResponse addMark(Long userId, markDto MarkDto) {
        GeneralResponse response = new GeneralResponse();
        Optional<User> optionalUser = userRepo.findById(userId);
        if (optionalUser.isPresent()) {
            Mark mark = new Mark();
            mark.setName(MarkDto.getName());
            mark.setRollno(MarkDto.getRollno());
            mark.setEnglish(MarkDto.getEnglish());
            mark.setHindi(MarkDto.getHindi());
            mark.setMaths(MarkDto.getMaths());
            mark.setScience(MarkDto.getScience());
            mark.setSocial(MarkDto.getSocial());
            mark.setUser(optionalUser.get());
            markRepository.save(mark);
            response.setStatus(HttpStatus.CREATED);
            response.setMessage("Teacher is created.");
        } else {
            response.setMessage("User not exist");
            response.setStatus(HttpStatus.NOT_FOUND);
        }
        return response;
    }

    @Override
    public List<markDto> getResult() {
        return markRepository.findAll().stream().map(Mark::getmarkDto).collect(Collectors.toList());
    }  
}
