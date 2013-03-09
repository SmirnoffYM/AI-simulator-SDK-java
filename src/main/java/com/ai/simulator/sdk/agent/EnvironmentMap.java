package com.ai.simulator.sdk.agent;

public class EnvironmentMap {

    private Integer[][] map;

    public EnvironmentMap(int width, int height) {
        // just for now - to check if the map point has been already known,
        // you must check array value for not being null
        map = new Integer[width][height];
    }
}
