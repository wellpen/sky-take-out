package com.sky.controller.admin;

import com.sky.dto.CategoryDTO;
import com.sky.dto.CategoryPageQueryDTO;
import com.sky.entity.Category;
import com.sky.result.PageResult;
import com.sky.result.Result;
import com.sky.service.CategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/category")
@Api(tags = "分類相關接口")
@Slf4j
public class CategoryController {

    @Autowired
    private CategoryService categoryService;


    @PostMapping
    @ApiOperation("新增分類")
    public Result<String> save(@RequestBody CategoryDTO categoryDTO) {
        log.info("新增分類: {}", categoryDTO);
        categoryService.save(categoryDTO);
        return Result.success();
    }

    @GetMapping("/page")
    @ApiOperation("分類分頁查詢")
    public Result<PageResult> page(CategoryPageQueryDTO categoryPageQueryDTO) {
        log.info("分頁查詢: {}", categoryPageQueryDTO);
        PageResult pageResult = categoryService.pageQuery(categoryPageQueryDTO);
        return Result.success(pageResult);
    }

    @DeleteMapping
    @ApiOperation("刪除分類")
    public Result<String> deleteById(Long id){
        log.info("刪除分類: {}",id);
        categoryService.deleteById(id);
        return Result.success();
    }


    @PutMapping
    @ApiOperation("修改分類")
    public Result<String> update(@RequestBody CategoryDTO categoryDTO) {
        log.info("修改分類: {}", categoryDTO);
        categoryService.update(categoryDTO);
        return Result.success();
    }

    @PostMapping("/status/{status}")
    @ApiOperation("啟用禁用分類")
    public Result<String> startOrStop(@PathVariable("status") Integer status, Long id) {
        log.info("啟用禁用分類:{},{}", status, id);
        categoryService.startOrStop(status, id);
        return Result.success();
    }


    @GetMapping("/list")
    @ApiOperation("根據類型查詢分類")
    public Result<List<Category>> list(Integer type) {
        List<Category> list = categoryService.list(type);
        return Result.success(list);
    }


}

