package com.example.stuartbryce.blackjack;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static org.mockito.Mockito.*;



/**
 * Created by stuartbryce on 2017-06-23.
 */

public class PlayerTest {

    User user;
    User spyUser;
    ArrayList<Integer> scores;

    @Before
    public void before(){
        user = new User();
        spyUser = Mockito.spy(user);
        scores = new ArrayList<Integer>();
    }

    @Test
    public void testBestScore(){
        scores.add(12);
        scores.add(17);
        scores.add(25);
        Mockito.when(spyUser.possibleScores()).thenReturn(scores);
        assertEquals(17, user.bestScore());

    }
}
