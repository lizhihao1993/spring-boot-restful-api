package com.ideabook.controller;

import com.ideabook.entity.City;
import com.ideabook.service.RestfulService;
import com.ideabook.util.result.BaseResp;
import com.ideabook.util.result.ResultStatus;
import io.swagger.annotations.*;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author: lzh
 * @Description: 1.restful是一种接口命名风格
 *               2.swagger2上传测试,将上传文件的接收变量，从swagger的注释中去掉，即可进行在线上传测试
 *               3.swagger2 注释
 *               名称	解释
                 @Api()	            将类标记为一种Swagger资源。
                 @ApiOperation()	描述针对特定路径的操作或通常是 http 方法。
                 @ApiImplicitParams	允许多个 ApiImplicitParam 对象列表的包装。
                 @ApiImplicitParam	表示 api 操作中的单个参数。
                 @ApiResponses	    允许多个 ApiResponse 对象列表的包装。
                 @ApiResponse	    描述操作的可能响应。
 *              more: https://github.com/swagger-api/swagger-core/wiki/Annotations#apimodel
 * @Date: Created in 2017/8/7 14:41
 */
@RestController
@RequestMapping("/api")
@Api(value = "api",description = "restful风格APi的文档") // Swagger UI 对应api的标题描述
public class MyRestfulController {

    @Value("${hello}")
    private String hello;

    public void say(){
        System.out.println("----------------------------------------");
        System.out.println(hello);
    }

    @Autowired
    private RestfulService restfulService;

    @ApiOperation(value = "新增单个城市信息(路径传参)",notes = "新增单个城市信息(路径传参)")
    @ApiImplicitParams({
            @ApiImplicitParam(name="city",dataType="City",required=true,value="城市实体")
    })
    @ApiResponses({
            @ApiResponse(code=400,message="请求参数没填好"),
            @ApiResponse(code=404,message="请求路径没有或页面跳转路径不对"),
    })
    @RequestMapping(value = "/city",method = RequestMethod.POST)
    public BaseResp<City> saveCity(@RequestBody City city){
        return new BaseResp(ResultStatus.SUCCESS,restfulService.saveCity(city));
    }

    @ApiOperation("修改单个城市信息(路径传参)")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="path",name="id",dataType="Long",required=true,value="id",defaultValue="1"),
            @ApiImplicitParam(paramType="path",name="name",dataType="String",required=true,value="城市名称",defaultValue="石家庄")
    })
    @ApiResponses({
            @ApiResponse(code=400,message="请求参数没填好"),
            @ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")
    })
    @RequestMapping(value = "/city/{id}/{name}",method = RequestMethod.PUT)
    public BaseResp<Integer> saveCity(@PathVariable Long id,
                                   @PathVariable String name){
        return new BaseResp(ResultStatus.SUCCESS,restfulService.updateCity(id,name));
    }

    @ApiOperation("删除单个城市信息(路径传参)")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="path",name="id",dataType="Long",required=true,value="id",defaultValue="1")
    })
    @ApiResponses({
            @ApiResponse(code=400,message="请求参数没填好"),
            @ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")
    })
    @RequestMapping(value = "/city/{id}",method = RequestMethod.DELETE)
    public BaseResp<String> deleteCity(@PathVariable Long id){
        restfulService.deleteCity(id);
        return new BaseResp(ResultStatus.SUCCESS);
    }

    @ApiOperation("获取单个城市信息(路径传参)")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="path",name="id",dataType="Long",required=true,value="id",defaultValue="1")
    })
    @ApiResponses({
            @ApiResponse(code=400,message="请求参数没填好"),
            @ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")
    })
    @RequestMapping(value = "/city/{id}",method = RequestMethod.GET)
    public BaseResp<City> getCity(@PathVariable Long id){
        return new BaseResp(ResultStatus.SUCCESS,restfulService.getCity(id));
    }

    @ApiOperation("获取城市信息列表")
    @ApiResponses({
            @ApiResponse(code=400,message="请求参数没填好"),
            @ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")
    })
    @RequestMapping(value = "/city",method = RequestMethod.GET)
    public BaseResp<List<City>> getCity(){
        return new BaseResp(ResultStatus.SUCCESS,restfulService.listCity());
    }


    @ApiOperation("获取城市信息分页列表(路径传参)")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="path",name="pages",dataType="Integer",required=true,value="页码",defaultValue="0"),
            @ApiImplicitParam(paramType="path",name="size",dataType="Integer",required=true,value="大小",defaultValue="1"),
    })
    @ApiResponses({
            @ApiResponse(code=400,message="请求参数没填好"),
            @ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")
    })
    @RequestMapping(value = "/city/{pages}/{size}",method = RequestMethod.GET)
    public BaseResp<Page<City>> getCity(@PathVariable Integer pages,
                                        @PathVariable Integer size){
        return new BaseResp(ResultStatus.SUCCESS,restfulService.listCity(pages, size));
    }

    @ApiOperation("上传文件")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="path",name="typeId",dataType="Integer",required=true,value="类型id",defaultValue="0")
    })
    @ApiResponses({
            @ApiResponse(code=400,message="请求参数没填好"),
            @ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")
    })
    @RequestMapping(value = "/upload/{typeId}")
    public BaseResp<String> uploadFile(@PathVariable Integer typeId,
                                       @RequestParam("file") MultipartFile file){
        if (null != file){
            System.out.println(typeId +"  -------------------------------");
            System.out.println(file.getOriginalFilename());
        }
        return new BaseResp(ResultStatus.SUCCESS);
    }

}
