package com.ling.controller;

import com.github.pagehelper.PageInfo;
import com.ling.entity.SelectionJoiner;
import com.ling.service.SelectionJoinerService;
import com.ling.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/selectionJoiner")
public class SelectionJoinerController {

    @Autowired
    private SelectionJoinerService selectionJoinerService;

    @PostMapping("create")
    public Result create(@RequestBody SelectionJoiner selectionJoiner){
        int flag = selectionJoinerService.create(selectionJoiner);
        if(flag>0){
            return Result.ok();
        }else{
            return Result.fail();
        }
    }

    @GetMapping("delete")
    public Result delete(String ids){
        int flag = selectionJoinerService.delete(ids);
        if(flag>0){
            return Result.ok();
        }else{
            return Result.fail();
        }
    }

    @PostMapping("update")
    public Result update(@RequestBody SelectionJoiner selectionJoiner){
        int flag = selectionJoinerService.update(selectionJoiner);
        if(flag>0){
            return Result.ok();
        }else{
            return Result.fail();
        }
    }

    @GetMapping("detail")
    public SelectionJoiner detail(Integer id){
        return selectionJoinerService.detail(id);
    }

    @PostMapping("query")
    public Map<String,Object> query(@RequestBody  SelectionJoiner selectionJoiner){
        PageInfo<SelectionJoiner> pageInfo = selectionJoinerService.query(selectionJoiner);
        return Result.ok(pageInfo);
    }

}
