package com.taobao.newxp.common.a.a;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class p
{
  String a;

  private p(String paramString)
  {
    this.a = paramString;
  }

  public static p a(String paramString)
  {
    return new p(paramString);
  }

  public String a()
    throws UnsupportedEncodingException
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a);
    return URLEncoder.encode(localStringBuilder.toString(), "UTF-8");
  }
}

/* Location:           /Users/zhangxun-xy/Downloads/qingting2/classes_dex2jar.jar
 * Qualified Name:     com.taobao.newxp.common.a.a.p
 * JD-Core Version:    0.6.2
 */