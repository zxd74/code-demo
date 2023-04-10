package com.dongle.demo.netty.controller;

import com.dongle.demo.netty.annotation.Controller;
import com.dongle.demo.netty.annotation.GetMapping;
import com.dongle.demo.netty.annotation.PostMapping;
import com.dongle.demo.netty.annotation.RequestMapping;
import com.dongle.demo.netty.core.RequestMethod;

@Controller()
@RequestMapping("/")
public class IndexController {

    @GetMapping("index")
    public String index(){
        return null;
    }

    @PostMapping("index")
    public String indexP(){
        return null;
    }

    @RequestMapping(value = "home",method = RequestMethod.GET)
    public String home(){
        return null;
    }
}
