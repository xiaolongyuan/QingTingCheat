package fm.qingting.qtradio.view.dragdrop;

import android.view.View;

public abstract class DragDropAdapter2
{
  private final int COLUMN_COUNT = 5;

  public int getColumnCount()
  {
    return 5;
  }

  public abstract int getCount();

  public abstract View instantiateItem(int paramInt);

  public abstract boolean isFixed(int paramInt);
}

/* Location:           /Users/zhangxun-xy/Downloads/qingting2/classes_dex2jar.jar
 * Qualified Name:     fm.qingting.qtradio.view.dragdrop.DragDropAdapter2
 * JD-Core Version:    0.6.2
 */