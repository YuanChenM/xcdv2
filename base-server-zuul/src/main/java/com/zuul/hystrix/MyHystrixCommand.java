//package com.zuul.hystrix;
//
//import com.netflix.hystrix.HystrixCommand;
//import com.netflix.hystrix.HystrixCommandGroupKey;
//
///**
// * Created by mao_yejun on 2016/10/24.
// */
//public class MyHystrixCommand extends HystrixCommand<String> {
//
//    private String name;
//
//    MyHystrixCommand(String name) {
//        super(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"));
//        this.name = name;
//    }
//
//    @Override
//    protected String run() throws Exception {
//        return null;
//    }
//}
