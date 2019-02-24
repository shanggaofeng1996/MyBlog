package com.sgf.controller.admin;


import com.sgf.entity.Blog;
import com.sgf.entity.BlogType;
import com.sgf.entity.Blogger;
import com.sgf.entity.Link;
import com.sgf.service.BlogService;
import com.sgf.service.BlogTypeService;
import com.sgf.service.BloggerService;
import com.sgf.service.LinkService;
import com.sgf.util.ResponseUtil;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/admin/system")
public class SystemAdminController {

    @Resource
    private BloggerService bloggerService;

    @Resource
    private BlogTypeService blogTypeService;

    @Resource
    private LinkService linkService;

    @Resource
    private BlogService blogService;

    @RequestMapping("/refreshSystem")
    public String refresh(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ServletContext application= RequestContextUtils.getWebApplicationContext(request).getServletContext();

        Blogger blogger=bloggerService.find(); // 获取博主信息
        blogger.setPassword(null);
        application.setAttribute("blogger", blogger);

        List<Link> linkList=linkService.list(null); // 查询所有的友情链接信息
        application.setAttribute("linkList", linkList);

        List<BlogType> blogTypeCountList=blogTypeService.countList(); // 查询博客类别以及博客的数量
        application.setAttribute("blogTypeCountList", blogTypeCountList);

        List<Blog> blogCountList=blogService.countList(); // 根据日期分组查询博客
        application.setAttribute("blogCountList", blogCountList);

        JSONObject result=new JSONObject();
        result.put("success", true);
        ResponseUtil.write(response, result);
        return null;


    }


}
