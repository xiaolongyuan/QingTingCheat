package fm.qingting.qtradio.im;

public class IMUtil
{
  public static boolean isSetBlack(String paramString)
  {
    if (paramString == null);
    while (!"setblack".equalsIgnoreCase(paramString))
      return false;
    return true;
  }

  public static boolean isUnSetBlack(String paramString)
  {
    if (paramString == null);
    while (!"unsetblack".equalsIgnoreCase(paramString))
      return false;
    return true;
  }
}

/* Location:           /Users/zhangxun-xy/Downloads/qingting2/classes_dex2jar.jar
 * Qualified Name:     fm.qingting.qtradio.im.IMUtil
 * JD-Core Version:    0.6.2
 */