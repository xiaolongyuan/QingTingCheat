package fm.qingting.qtradio.controller;

import android.content.Context;
import android.graphics.drawable.Drawable;
import fm.qingting.framework.controller.ViewController;
import fm.qingting.qtradio.view.playview.PlayListView;

public class PlayListController extends ViewController
{
  private PlayListView mainView;

  public PlayListController(Context paramContext)
  {
    super(paramContext);
    this.mainView = new PlayListView(paramContext);
    attachView(this.mainView);
  }

  public void config(String paramString, Object paramObject)
  {
    if (paramString.equalsIgnoreCase("setBackground"))
      this.mainView.setBackgroundDrawable((Drawable)paramObject);
    while (!paramString.equalsIgnoreCase("setData"))
      return;
    this.mainView.update(paramString, paramObject);
  }
}

/* Location:           /Users/zhangxun-xy/Downloads/qingting2/classes_dex2jar.jar
 * Qualified Name:     fm.qingting.qtradio.controller.PlayListController
 * JD-Core Version:    0.6.2
 */