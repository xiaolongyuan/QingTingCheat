package com.taobao.newxp.view.common;

import android.app.Dialog;
import android.content.Context;
import android.os.Build.VERSION;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.webkit.WebSettings;
import android.webkit.WebSettings.LayoutAlgorithm;
import android.webkit.WebSettings.PluginState;
import android.webkit.WebView;
import com.taobao.newxp.common.ExchangeConstants;
import java.lang.reflect.Method;

public abstract class BaseUMBrowser extends Dialog
{
  public Context mContext;
  public WebView mWebView;

  public BaseUMBrowser(Context paramContext)
  {
  }

  public BaseUMBrowser(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    this.mContext = paramContext;
    WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
    localLayoutParams.height = -1;
    localLayoutParams.width = -1;
    localLayoutParams.gravity = 17;
    getWindow().setAttributes(localLayoutParams);
  }

  public void dismiss()
  {
    super.dismiss();
    this.mWebView.destroy();
  }

  public abstract void initContent();

  public void initWebview(WebView paramWebView)
  {
    WebSettings localWebSettings = paramWebView.getSettings();
    localWebSettings.setJavaScriptEnabled(true);
    if (Build.VERSION.SDK_INT > 7)
      localWebSettings.setPluginState(WebSettings.PluginState.ON);
    localWebSettings.setSupportZoom(true);
    localWebSettings.setBuiltInZoomControls(true);
    localWebSettings.setAllowFileAccess(true);
    localWebSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NORMAL);
    localWebSettings.setUseWideViewPort(true);
    if (Build.VERSION.SDK_INT >= 8)
    {
      localWebSettings.setLoadWithOverviewMode(true);
      localWebSettings.setDatabaseEnabled(true);
      localWebSettings.setDomStorageEnabled(true);
      localWebSettings.setGeolocationEnabled(true);
      localWebSettings.setAppCacheEnabled(true);
    }
    if (Build.VERSION.SDK_INT >= 11);
    try
    {
      Class[] arrayOfClass = new Class[1];
      arrayOfClass[0] = Boolean.TYPE;
      Method localMethod = WebSettings.class.getDeclaredMethod("setDisplayZoomControls", arrayOfClass);
      localMethod.setAccessible(true);
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Boolean.valueOf(false);
      localMethod.invoke(localWebSettings, arrayOfObject);
      return;
    }
    catch (Exception localException)
    {
      com.taobao.newxp.common.Log.e(ExchangeConstants.LOG_TAG, "", localException);
    }
  }

  public abstract void onLoadUrl();

  public void show()
  {
    try
    {
      super.show();
      initContent();
      if (this.mWebView == null)
        throw new NullPointerException("the webview is null.");
    }
    catch (Exception localException)
    {
      android.util.Log.e(ExchangeConstants.LOG_TAG, "open browser failed.", localException);
      return;
    }
    initWebview(this.mWebView);
    onLoadUrl();
  }
}

/* Location:           /Users/zhangxun-xy/Downloads/qingting2/classes_dex2jar.jar
 * Qualified Name:     com.taobao.newxp.view.common.BaseUMBrowser
 * JD-Core Version:    0.6.2
 */