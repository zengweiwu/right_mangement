package com.zww.ssm.controller;

import com.zww.ssm.domain.Product;
import com.zww.ssm.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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
     * 查询所有产品
     * @return
     * @throws Exception
     */
    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Product> ps = productService.findAll();
        mv.addObject("productList",ps);
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
}
