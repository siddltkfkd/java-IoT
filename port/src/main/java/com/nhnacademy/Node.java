package com.nhnacademy;

import lombok.extern.slf4j.Slf4j;
import ch.qos.logback.classic.Logger;

@Slf4j
public abstract class Node {
    Logger logger;
    String id;
    int count;

    Node() {
        count++;
        id = String.format("%s-%02d", getClass().getSimpleName(), count);
        logger.trace("create node : {}", id);
    }

    public String getId() {
        return id;
    }

    public abstract String getName();

    public abstract void setName(String name);

    public int getCount() {
        return count;
    }
}
