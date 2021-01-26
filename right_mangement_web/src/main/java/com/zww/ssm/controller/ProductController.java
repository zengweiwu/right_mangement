package com.zww.ssm.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zww.ssm.domain.Product;
import com.zww.ssm.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.nio.charset.Charset;
import java.util.List;

/**
 * 产品的前端控制器
 */
@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductService productService;

    /**
     * 查询所有产品 分页 模糊查询
     * @return
     * @throws Exception
     */
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page",required = true,defaultValue = "1")Integer page, @RequestParam(name = "size",required = true,defaultValue = "4")Integer size,@RequestParam(name = "fuzzyName",required = false)String fuzzyName) throws Exception {
        //判断是乱码 (GBK包含全部中文字符；UTF-8则包含全世界所有国家需要用到的字符。)
        //这里如果前台参数没有传（key和value都没有）则findAll方法的fuzzname参数为null，如果有key则fuzzname=“”
        //这里进行字符串编码的原因是前端传过来的中文用的是gbk编码经过tomcat之后用ISO-8859-1编码，再传达前端时会出现乱码
        //所以这里需要转换成utf-8编码
        if (fuzzyName != null){
            if (!(Charset.forName("GBK").newEncoder().canEncode(fuzzyName))) {
                //转码UTF8
                fuzzyName = new String(fuzzyName.getBytes("ISO-8859-1"), "utf-8");
            }
        }
        ModelAndView mv = new ModelAndView();
        //使用分页插件
        PageHelper.startPage(page,size);
        List<Product> ps = productService.findAll(fuzzyName);
        PageInfo<Product> pageInfo = new PageInfo<>(ps);
        //回显到搜索
        mv.addObject("fuzzyName",fuzzyName);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("product-list");
        return mv;
    }

    /**
     * 保存产品
     * @param product
     * @return
     * @throws Exception
     */
    @RequestMapping("/save.do")
    public String save(Product product) throws Exception{
        productService.save(product);
        return "redirect:findAll.do";
    }

    /**
     * 删除产品
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping("/deleteById.do")
    public String deleteById(@RequestParam(name = "id",required = true)String id)throws Exception{
        System.out.println(id);
        productService.deleteById(id);
        return "redirect:findAll.do";
    }

    /**
     * 根据id查询产品
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping("findById.do")
    public ModelAndView findById(@RequestParam(name = "id",required = true)String id) throws Exception{
        ModelAndView mv = new ModelAndView();
        Product product = productService.findById(id);
        mv.addObject("product",product);
        mv.setViewName("product-update");
        return mv;
    }

    //产品更新
    @RequestMapping("/productUpdate.do")
    public String productUpdate(Product product) throws Exception{
        Boolean isUpdate = productService.updateProduct(product);
        return "redirect:findAll.do";
    }

    //批量删除
    @RequestMapping("/deleteByIdStr.do")
    public String deleteByIdStr(@RequestParam(name = "idStr",required = true)String idStr) throws Exception{
        System.out.println(idStr);
        String substring = idStr.substring(0, idStr.length() - 1);
        productService.deleteByIdStr(substring);
        return "redirect:findAll.do";
    }
}
