package com.jd.design.pattern;

import java.io.OutputStream;

class ConsoleLog implements ILog {
  @Override
  public void log(OutputStream out) {
    System.out.println("ConsoleLog...");
  }
}