package com.sina.weibo.sdk.api.share;

import android.content.Context;
import android.os.Bundle;
import com.sina.weibo.sdk.WeiboAppManager.WeiboInfo;

public class ProvideMessageForWeiboRequest extends BaseRequest
{
  public ProvideMessageForWeiboRequest()
  {
  }

  public ProvideMessageForWeiboRequest(Bundle paramBundle)
  {
    fromBundle(paramBundle);
  }

  final boolean check(Context paramContext, WeiboAppManager.WeiboInfo paramWeiboInfo, VersionCheckHandler paramVersionCheckHandler)
  {
    return true;
  }

  public int getType()
  {
    return 2;
  }
}

/* Location:           /Users/zhangxun-xy/Downloads/qingting2/classes_dex2jar.jar
 * Qualified Name:     com.sina.weibo.sdk.api.share.ProvideMessageForWeiboRequest
 * JD-Core Version:    0.6.2
 */