package com.jd.design.pattern;

import java.io.OutputStream;

/**
 * @author: gaohongbin5
 * @date: 2020/11/27 18:39:19
 * @description: ILog
 */
public interface ILog {
  enum Type{
    LOW,MEDIUM,HIGH
  }

  interface InitLog{
    void initLog();
  }

  default void init(){
    Type t = Type.HIGH;
    System.out.println(t.ordinal());
  }

  static void OS(){
    System.out.println(System.getProperty("os.name", "linux"));
  }
  void log(OutputStream out);

}
