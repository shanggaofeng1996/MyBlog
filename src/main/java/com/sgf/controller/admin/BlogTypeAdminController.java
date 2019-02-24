package com.sgf.controller.admin;


import com.sgf.entity.BlogType;
import com.sgf.entity.PageBean;
import com.sgf.service.BlogService;
import com.sgf.service.BlogTypeService;
import com.sgf.util.ResponseUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin/blogType")
public class BlogTypeAdminController {
    @Resource
    private BlogTypeService blogTypeService;
    @Resource
    private BlogService blogService;

    @RequestMapping("/list")
    public String list(@RequestParam(value = "page",required = false) String page, @RequestParam(value = "rows",required = false) String rows, HttpServletResponse response) throws Exception {
        PageBean pageBean=new PageBean(Integer.parseInt(page),Integer.parseInt(rows));
        Map<String,Object> map=new HashMap<>();
        map.put("start",pageBean.getStart());
        map.put("size",pageBean.getPageSize());
        List<BlogType> blogTypeList=blogTypeService.list(map);
        Long total=blogTypeService.getTotal(map);
        JSONObject result=new JSONObject();
        JSONArray jsonArray=JSONArray.fromObject(blogTypeList);
        result.put("rows",jsonArray);
        result.put("total",total);
        ResponseUtil.write(response,result);
        return null;
    }

    /**
     * 添加或者修改博客类别信息
     * @param blogType
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping("/save")
    public String addBlogType(BlogType blogType ,HttpServletResponse response) throws Exception {
        int resultTotal=0;
        if(blogType.getId()==null){
            resultTotal=blogTypeService.addBlogType(blogType);
        }else{
            resultTotal=blogTypeService.updateBlogType(blogType);
        }
        JSONObject result=new JSONObject();

        if(resultTotal>0){
            result.put("success", true);
        }else{
            result.put("success", false);
        }


        ResponseUtil.write(response,result);
        return null;
    }
    @RequestMapping("/delete")
    public String deleteBlogType(@RequestParam(value = "ids",required = false) String ids,HttpServletResponse response ) throws Exception {
        String []idsStr=ids.split(",");
        JSONObject result=new JSONObject();
        for(int i=0;i<idsStr.length;i++){
            if(blogService.getBlogByTypeId(Integer.parseInt(idsStr[i]))>0){
                result.put("exist", "请先删除该类型下的所有博客！");
            }else{
                blogTypeService.deleteBlogType(Integer.parseInt(idsStr[i]));
            }
        }
        result.put("success", true);
        ResponseUtil.write(response, result);
        return null;
    }
}
