package com.taobao.munion.base.utdid.c;

import com.taobao.munion.base.utdid.a.a.a;
import com.taobao.munion.base.utdid.a.a.b;
import java.util.Random;

public class e
{
  private static Random b = new Random();
  private String a = "XwYp8WL8bm6S4wu6yEYmLGy4RRRdJDIhxCBdk3CiNZTwGoj1bScVZEeVp9vBiiIsgwDtqZHP8QLoFM6o6MRYjW8QqyrZBI654mqoUk5SOLDyzordzOU5QhYguEJh54q3K1KqMEXpdEQJJjs1Urqjm2s4jgPfCZ4hMuIjAMRrEQluA7FeoqWMJOwghcLcPVleQ8PLzAcaKidybmwhvNAxIyKRpbZlcDjNCcUvsJYvyzEA9VUIaHkIAJ62lpA3EE3H";

  public static String a()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    for (int i = 0; i < 24; i++)
      localStringBuffer.append((char)(65 + b.nextInt(25)));
    return localStringBuffer.toString();
  }

  public String a(String paramString)
  {
    return a.a(this.a, paramString);
  }

  public String a(byte[] paramArrayOfByte)
  {
    String str = b.b(paramArrayOfByte, 2);
    return a.a(this.a, str);
  }

  public String b(String paramString)
  {
    return a.b(this.a, paramString);
  }
}

/* Location:           /Users/zhangxun-xy/Downloads/qingting2/classes_dex2jar.jar
 * Qualified Name:     com.taobao.munion.base.utdid.c.e
 * JD-Core Version:    0.6.2
 */