package com.jacjos.playground.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class SimpleUtilTest {

    SimpleUtil simpleUtilCUT;

    @BeforeEach
    public void setup(){
        simpleUtilCUT = new SimpleUtil();
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3"})
    public void findMappedObject_whenMessageHasAMapping(String expCode){
        
        Exception result = simpleUtilCUT.findMappedObject("This message has ORA-"+expCode+" in it");
        assertNotNull(result);
        assertEquals("Exp with ORA-"+expCode, result.getMessage());
    }

    @Test
    public void findMappedObject_whenMessageDoesNotHaveAMapping(){
        Exception result = simpleUtilCUT.findMappedObject("This message does not have a match");
        assertNotNull(result);
        assertEquals("Default Exp", result.getMessage());
    }

    @Test
    public void findMappedObject_whenMessageIsNull(){
        Exception result = simpleUtilCUT.findMappedObject(null);
        assertNotNull(result);
        assertEquals("Exception Message Null", result.getMessage());
    }
    
}