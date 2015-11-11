package fm.qingting.qtradio.view.chatroom;

import android.content.Context;
import android.view.View.MeasureSpec;
import fm.qingting.framework.view.ButtonViewElement;
import fm.qingting.framework.view.QtView;
import fm.qingting.qtradio.manager.SkinManager;

public class FlowerNumberView extends QtView
{
  private ButtonViewElement mButtonViewElement;

  public FlowerNumberView(Context paramContext)
  {
    super(paramContext);
    this.mButtonViewElement = new ButtonViewElement(paramContext);
    this.mButtonViewElement.setBackgroundColor(-824195, -824195);
    this.mButtonViewElement.setRoundCorner(true);
    this.mButtonViewElement.setTextColor(SkinManager.getBackgroundColor());
    addElement(this.mButtonViewElement);
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = View.MeasureSpec.getSize(paramInt1);
    int j = View.MeasureSpec.getSize(paramInt2);
    this.mButtonViewElement.measure(0, 0, i, j);
    this.mButtonViewElement.setRoundCornerRadius(j / 2);
    this.mButtonViewElement.setTextSize(SkinManager.getInstance().getSubTextSize());
    setMeasuredDimension(i, j);
  }

  public void update(String paramString, Object paramObject)
  {
    if (paramString.equalsIgnoreCase("setNumber"))
    {
      i = ((Integer)paramObject).intValue();
      this.mButtonViewElement.setText(String.valueOf(i));
      invalidate();
    }
    while (!paramString.equalsIgnoreCase("setData"))
    {
      int i;
      return;
    }
    this.mButtonViewElement.setText(String.valueOf(FlowerInfo.getFlowerCnt()));
  }
}

/* Location:           /Users/zhangxun-xy/Downloads/qingting2/classes_dex2jar.jar
 * Qualified Name:     fm.qingting.qtradio.view.chatroom.FlowerNumberView
 * JD-Core Version:    0.6.2
 */