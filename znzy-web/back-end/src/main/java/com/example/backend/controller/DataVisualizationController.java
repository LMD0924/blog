package com.example.backend.controller;

import com.example.backend.entity.RestBean;
import com.example.backend.service.DataVisualizationService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * @Author:总会落叶
 * @Date:2025/11/26
 * @Description:
 */
@RestController
@RequestMapping("api/dataVisualization")
public class DataVisualizationController {
    @Resource
    DataVisualizationService dataVisualizationService;
    @RequestMapping("/getArticleCount")
    public RestBean<Integer> getArticleCount(HttpServletRequest request){
        int userId=(Integer) request.getAttribute("id");
        int articleCount=dataVisualizationService.getArticleCount(userId);
        if(articleCount<0) return RestBean.failure(404, "获取文章数量失败");
        return RestBean.success("获取成功",articleCount);
    }
}
