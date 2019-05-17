package cn.springmvc.test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
  public static void main(String[] args) throws MalformedURLException {
    Pattern p = Pattern.compile("^[a-zA-Z]\\w{4,15}$");
    //进行匹配，并将匹配结果放在Matcher对象中
    Matcher m = p.matcher("aaaa");
   System.out.println( m.matches());
  }
}
