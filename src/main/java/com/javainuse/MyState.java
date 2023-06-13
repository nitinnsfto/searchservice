package com.javainuse;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class MyState
{
	Long maxKlid = 0l;

  public synchronized Long getAndIncr() {
	//save();
    return maxKlid++;
  }

}