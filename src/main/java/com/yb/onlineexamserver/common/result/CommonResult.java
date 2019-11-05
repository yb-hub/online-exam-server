package com.yb.onlineexamserver.common.result;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.github.pagehelper.Page;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.List;

/**
 * @Auther: Yang
 * @Date: 2019/11/04 20:05
 * @Description: 统一返回类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {
    private int code;
    private String message;
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    private T data;

    public CommonResult(int code,String message){
        this.code = code;
        this.message =message;
    }


    public static CommonResult success(){
        return new CommonResult(200,"成功");
    }

    public static <T> CommonResult<T> success(T data) {
        return new CommonResult<T>(200, "成功", data);
    }

    public static <T> CommonResult<T> successList(List<T> list){
        HashMap<String, Object> map = new HashMap<>();
        if(list instanceof Page){
            Page page = (Page) list;
            map.put("total", page.getTotal());
            map.put("pageNum",page.getPageNum());
            map.put("pageSize",page.getPageSize());
            map.put("pages", page.getPages());
            map.put("data",list);
            return new CommonResult(200,"成功",map);
        }else{
            return new CommonResult(200, "成功", list);
        }

    }


    public static CommonResult fail(int code,String message){
        return new CommonResult(code,message);
    }

}
