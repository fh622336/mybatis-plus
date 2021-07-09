package com.linkpal.controller;


import com.linkpal.domain.entity.Image;
import com.linkpal.mapper.ImageMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author yuan
 * @since 2021-07-01
 */
@RestController
public class ImageController {
    @Autowired
    private ImageMapper imageMapper;
    @GetMapping("list")
    @ApiOperation(value = "查询发票列表")
    public List<Image> imageList() {
        List<Image> images = imageMapper.selectList(null);
        return images;
    }
}
