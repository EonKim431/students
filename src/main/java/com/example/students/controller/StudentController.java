package com.example.students.controller;

import com.example.students.constant.Cal;
import com.example.students.dto.SearchDto;
import com.example.students.repo.service.ScoreService;
import com.example.students.repo.service.StudentService;
import com.example.students.dto.ScoreDto;
import com.example.students.dto.StudentDto;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller @RequestMapping("students") @Slf4j
public class StudentController {
    private final StudentService stService;
    private final ScoreService scService;

    public StudentController(StudentService stService, ScoreService scService) {
        this.stService = stService;
        this.scService = scService;
    }


    @GetMapping("main")
    public String test(){
        return "students/main";
    }
    @GetMapping("findAll")
    public String findAll(Model model){
        List<StudentDto> list = stService.findAll();
        model.addAttribute("list",list);
        return "students/findAll";
    }
    @GetMapping("input")
    public String input(Model model){
        model.addAttribute("dto", new ScoreDto());
        model.addAttribute("list",stService.searchId());
        return "students/input";
    }
    @PostMapping("input")
    public String input(@Valid @ModelAttribute("dto")ScoreDto dto,
                        BindingResult bindingResult,
                        Model model){
        if (bindingResult.hasErrors()){
            model.addAttribute("list",stService.searchId());
            return "students/input";
        }
        scService.save(dto);
        return "redirect:main";
    }
    @GetMapping("showAll")
    public String showAll(Model model){
        List<SearchDto> dtos =  stService.search();
        model.addAttribute("list",dtos);
        model.addAttribute("cal",new Cal(dtos));
        return "students/showAll";
    }

}
