package com.umeng.analytics.onlineconfig;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.umeng.analytics.AnalyticsConfig;
import com.umeng.analytics.f;
import java.util.Iterator;
import org.json.JSONObject;
import u.aly.bi;
import u.aly.bj;
import u.aly.bo;
import u.aly.bp;
import u.aly.bv;

public class a
{
  public static final String a = "type";
  public static final String b = "package";
  public static final String c = "channel";
  public static final String d = "idmd5";
  public static final String e = "version_code";
  public static final String f = "appkey";
  public static final String g = "sdk_version";
  private final String h = "last_config_time";
  private final String i = "report_policy";
  private final String j = "online_config";
  private UmengOnlineConfigureListener k = null;
  private c l = null;
  private long m = 0L;

  private void a(Context paramContext, b paramb)
  {
    SharedPreferences.Editor localEditor = f.a(paramContext).g().edit();
    if (!TextUtils.isEmpty(paramb.e))
    {
      localEditor.putString("umeng_last_config_time", paramb.e);
      localEditor.commit();
    }
    if (paramb.c != -1)
      f.a(paramContext).a(paramb.c, paramb.d);
  }

  private void a(JSONObject paramJSONObject)
  {
    if (this.k != null)
      this.k.onDataReceived(paramJSONObject);
  }

  private JSONObject b(Context paramContext)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      getClass();
      localJSONObject.put("type", "online_config");
      localJSONObject.put("appkey", AnalyticsConfig.getAppkey(paramContext));
      localJSONObject.put("version_code", bi.c(paramContext));
      localJSONObject.put("package", bi.u(paramContext));
      localJSONObject.put("sdk_version", "5.2.4");
      localJSONObject.put("idmd5", bv.b(bi.f(paramContext)));
      localJSONObject.put("channel", AnalyticsConfig.getChannel(paramContext));
      localJSONObject.put("report_policy", f.a(paramContext).a()[0]);
      localJSONObject.put("last_config_time", c(paramContext));
      return localJSONObject;
    }
    catch (Exception localException)
    {
      bj.b("MobclickAgent", "exception in onlineConfigInternal");
    }
    return null;
  }

  private void b(Context paramContext, b paramb)
  {
    if ((paramb.a == null) || (paramb.a.length() == 0))
      return;
    SharedPreferences.Editor localEditor = f.a(paramContext).g().edit();
    JSONObject localJSONObject;
    try
    {
      localJSONObject = paramb.a;
      Iterator localIterator = localJSONObject.keys();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localEditor.putString(str, localJSONObject.getString(str));
      }
    }
    catch (Exception localException)
    {
      bj.c("MobclickAgent", "save online config params", localException);
      return;
    }
    localEditor.commit();
    bj.a("MobclickAgent", "get online setting params: " + localJSONObject);
  }

  private String c(Context paramContext)
  {
    return f.a(paramContext).g().getString("umeng_last_config_time", "");
  }

  public void a()
  {
    this.k = null;
  }

  public void a(Context paramContext)
  {
    if (paramContext == null);
    try
    {
      bj.b("MobclickAgent", "unexpected null context in updateOnlineConfig");
      return;
      if ((bj.a) && (bi.w(paramContext)))
      {
        new Thread(new b(paramContext.getApplicationContext())).start();
        return;
      }
    }
    catch (Exception localException)
    {
      bj.b("MobclickAgent", "exception in updateOnlineConfig");
      return;
    }
    long l1 = System.currentTimeMillis();
    if (l1 - this.m > 3600000L)
    {
      this.m = l1;
      new Thread(new b(paramContext.getApplicationContext())).start();
    }
  }

  public void a(UmengOnlineConfigureListener paramUmengOnlineConfigureListener)
  {
    this.k = paramUmengOnlineConfigureListener;
  }

  public void a(c paramc)
  {
    this.l = paramc;
  }

  public void b()
  {
    this.l = null;
  }

  public class a extends bp
  {
    private JSONObject e;

    public a(JSONObject arg2)
    {
      super();
      Object localObject;
      this.e = localObject;
    }

    public JSONObject a()
    {
      return this.e;
    }

    public String b()
    {
      return this.d;
    }
  }

  public class b extends bo
    implements Runnable
  {
    Context a;

    public b(Context arg2)
    {
      Object localObject;
      this.a = localObject.getApplicationContext();
    }

    private void b()
    {
      JSONObject localJSONObject = a.a(a.this, this.a);
      a.a locala = new a.a(a.this, localJSONObject);
      String[] arrayOfString = com.umeng.analytics.a.g;
      int i = 0;
      b localb = null;
      while (true)
      {
        if (i < arrayOfString.length)
        {
          locala.a(arrayOfString[i]);
          localb = (b)a(locala, b.class);
          if (localb == null);
        }
        else
        {
          if (localb != null)
            break;
          a.a(a.this, null);
          return;
        }
        i++;
      }
      if (localb.b)
      {
        if (a.a(a.this) != null)
          a.a(a.this).a(localb.c, localb.d);
        a.a(a.this, this.a, localb);
        a.b(a.this, this.a, localb);
        a.a(a.this, localb.a);
        return;
      }
      a.a(a.this, null);
    }

    public boolean a()
    {
      return false;
    }

    public void run()
    {
      try
      {
        b();
        return;
      }
      catch (Exception localException)
      {
        a.a(a.this, null);
        bj.c("MobclickAgent", "reques update error", localException);
      }
    }
  }
}

/* Location:           /Users/zhangxun-xy/Downloads/qingting2/classes_dex2jar.jar
 * Qualified Name:     com.umeng.analytics.onlineconfig.a
 * JD-Core Version:    0.6.2
 */