package fm.qingting.qtradio.ad;

public class AdsCenter
{
  private static AdsCenter _instance = null;

  public static AdsCenter getInstance()
  {
    if (_instance == null)
      _instance = new AdsCenter();
    return _instance;
  }
}

/* Location:           /Users/zhangxun-xy/Downloads/qingting2/classes_dex2jar.jar
 * Qualified Name:     fm.qingting.qtradio.ad.AdsCenter
 * JD-Core Version:    0.6.2
 */