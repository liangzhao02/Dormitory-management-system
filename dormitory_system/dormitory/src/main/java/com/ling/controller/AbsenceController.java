package com.ling.controller;

import com.github.pagehelper.PageInfo;
import com.ling.entity.Absence;
import com.ling.entity.Dormitory;
import com.ling.entity.Student;
import com.ling.service.AbsenceService;
import com.ling.service.DormitoryService;
import com.ling.service.StudentService;
import com.ling.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/absence")
public class AbsenceController {

    @Autowired
    private AbsenceService absenceService;
    @Autowired
    private StudentService studentService;

    @Autowired
    private DormitoryService dormitoryService;

    @PostMapping("create")
    public Result create(@RequestBody Absence absence){
        int flag = absenceService.create(absence);
        if(flag>0){
            return Result.ok();
        }else{
            return Result.fail();
        }
    }

    @GetMapping("delete")
    public Result delete(String ids){
        int flag = absenceService.delete(ids);
        if(flag>0){
            return Result.ok();
        }else{
            return Result.fail();
        }
    }

    @PostMapping("update")
    public Result update(@RequestBody Absence absence){
        int flag = absenceService.updateSelective(absence);
        if(flag>0){
            return Result.ok();
        }else{
            return Result.fail();
        }
    }

    @GetMapping("detail")
    public Absence detail(Integer id){
        return absenceService.detail(id);
    }

    @PostMapping("query")
    public Map<String,Object> query(@RequestBody  Absence absence){
        PageInfo<Absence> pageInfo = new PageInfo<>();
        if(absence.getName() != null){
            Student detailId = studentService.detailByName(absence.getName());
            if(detailId != null){
                absence.setStudentId(detailId.getId());
            }else{
                pageInfo.setList(null);
                pageInfo.setSize(0);
                return Result.ok(pageInfo);
            }
        }
        pageInfo = absenceService.query(absence);
        pageInfo.getList().forEach(entity->{
            Student detail = studentService.detail(entity.getStudentId());
            entity.setStudent(detail);
            Dormitory dormitory = dormitoryService.detail(entity.getDormitoryId());
            entity.setDormitory(dormitory);
        });
        return Result.ok(pageInfo);
    }

}
