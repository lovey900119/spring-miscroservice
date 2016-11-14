package com.becool.order;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    private final Logger logger = Logger.getLogger(getClass());

    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value = "/get/{id}" ,method = RequestMethod.GET)
    public String get(@PathVariable Integer id) {
        ServiceInstance instance = client.getLocalServiceInstance();
        logger.info("/get, host:" + instance.getHost() + ", service_id:" + instance.getServiceId() + ", result:" + id);
        return "From service-order, Result is " + id;
    }

}