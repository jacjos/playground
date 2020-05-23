package com.jacjos.playground.utils;

import java.util.LinkedHashMap;
import java.util.Map;

public class SimpleUtil {
    
    public Exception findMappedObject(String expMsg){

        if(expMsg == null){
            return new Exception("Exception Message Null");
        }
        
        Map<String, Exception> codeExpMap = new LinkedHashMap<>();
        codeExpMap.put("ORA-1", new Exception("Exp with ORA-1"));
        codeExpMap.put("ORA-2", new Exception("Exp with ORA-2"));
        codeExpMap.put("ORA-3", new Exception("Exp with ORA-3"));
        
        String expKey = codeExpMap.keySet().stream()
                                            .filter(expMsg::contains)
                                            .findFirst()
                                            .orElse("key-that-is-not-present-in-codeExpMap");
        return codeExpMap.getOrDefault(expKey, new Exception("Default Exp"));
    }

    
}