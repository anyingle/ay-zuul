package com.ay.config;

import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.Server;
import com.netflix.niws.loadbalancer.DiscoveryEnabledServer;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Slf4j
public class ZuulAdvance implements IRule {

    public static final int CONNECT_ENDPOINT_RETRY_NUMBER = 10;
    private final AtomicInteger nextServerCyclicCounter;
    private ILoadBalancer loadBalancer;

    public ZuulAdvance() {
        nextServerCyclicCounter = new AtomicInteger(0);
    }

    private int incrementAndGetModulo(int modulo) {
        for (; ; ) {
            int current = nextServerCyclicCounter.get();
            int next = (current + 1) % modulo;
            if (nextServerCyclicCounter.compareAndSet(current, next)) {
                return next;
            }
        }
    }

    @Override
    public ILoadBalancer getLoadBalancer() {
        return this.loadBalancer;
    }

    @Override
    public void setLoadBalancer(ILoadBalancer iLoadBalancer) {
        this.loadBalancer = iLoadBalancer;
    }

    @Override
    public Server choose(Object key) {
        ILoadBalancer lb = this.getLoadBalancer();
        List<Server> servers = this.loadBalancer.getAllServers();
        log.info("server size now have {}", servers.size());
        for (Server server : servers) {
            DiscoveryEnabledServer se = (DiscoveryEnabledServer) server;
            log.info(se.toString());
        }
        if (lb == null) {
            log.info("no load balancer");
            return null;
        }
        Server server;
        int count = 0;
        while (count++ < CONNECT_ENDPOINT_RETRY_NUMBER) {
            List<Server> reachableServers = lb.getReachableServers();
            List<Server> allServers = lb.getAllServers();
            List<Server> preferredServers = allServers.parallelStream().filter(r -> r.getPort() % 2 == 8081 % 2).collect(Collectors.toList());
            if (!preferredServers.isEmpty()) {
                allServers = preferredServers;
            }
            int upCount = reachableServers.size();
            int serverCount = allServers.size();
            if ((upCount == 0) || (serverCount == 0)) {
                log.info("no up servers available from load balancer: " + lb);
                return null;
            }
            int nextServerIndex = this.incrementAndGetModulo(serverCount);
            log.info("region index {}", nextServerIndex);
            server = allServers.get(nextServerIndex);
            if (server == null) {
                Thread.yield();
                continue;
            }
            if (server.isAlive() && (server.isReadyToServe())) {
                return server;
            }
        }
        if (count >= CONNECT_ENDPOINT_RETRY_NUMBER) {
            log.info("no available alive servers after 10 tries from load balancer: " + lb);
        }
        return null;
    }
}
