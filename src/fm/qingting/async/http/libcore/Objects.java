package fm.qingting.async.http.libcore;

public final class Objects
{
  public static boolean equal(Object paramObject1, Object paramObject2)
  {
    return (paramObject1 == paramObject2) || ((paramObject1 != null) && (paramObject1.equals(paramObject2)));
  }

  public static int hashCode(Object paramObject)
  {
    if (paramObject == null)
      return 0;
    return paramObject.hashCode();
  }
}

/* Location:           /Users/zhangxun-xy/Downloads/qingting2/classes_dex2jar.jar
 * Qualified Name:     fm.qingting.async.http.libcore.Objects
 * JD-Core Version:    0.6.2
 */