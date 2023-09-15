package com.nhnacademy.nhnmart.threadlocal;

import java.util.HashMap;
import java.util.Map;

public class UserStore {
    private final Map<Integer, String> userMap = new HashMap();

    public UserStore() {
        userMap.put(1, "user");
        userMap.put(2, "유저");
    }

    public String getUserNameForUserID(Integer userID) {
        return userMap.get(userID); // tostring
    }

}
