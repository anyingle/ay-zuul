package com.ay.config;

import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.Server;
import com.netflix.niws.loadbalancer.DiscoveryEnabledServer;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class ZuulAdvance implements IRule {

    private ILoadBalancer loadBalancer;

    @Override
    public void setLoadBalancer(ILoadBalancer iLoadBalancer) {
        this.loadBalancer=iLoadBalancer;
    }

    @Override
    public ILoadBalancer getLoadBalancer() {
        return this.loadBalancer;
    }

    @Override
    public Server choose(Object key) {
        String region = "bj";

        if (loadBalancer == null) {
            log.warn("no load balancer");
            return null;
        }

        List<Server> servers= loadBalancer.getAllServers();

        List<DiscoveryEnabledServer> instance = new ArrayList<>();

        for (Server server : servers) {
            DiscoveryEnabledServer se = (DiscoveryEnabledServer) server;
            instance.add(se);
        }

        return servers.get(0);
    }
}
