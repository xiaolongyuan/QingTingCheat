package fm.qingting.qtradio.view.pinnedsection;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import fm.qingting.framework.adapter.ILayoutParamsBuilder;
import fm.qingting.framework.adapter.IReusableCollection;
import fm.qingting.framework.event.IEventHandler;
import fm.qingting.framework.view.IView;
import java.util.List;

public class PinnedSectionAdapter extends BaseAdapter
  implements PinnedSectionListAdapter
{
  protected ILayoutParamsBuilder builder;
  protected List<PinnedItem> data;
  protected IEventHandler eventHandler;
  protected IPinnedAdapterIViewFactory factory;
  protected String idKey;

  public PinnedSectionAdapter(List<PinnedItem> paramList, IPinnedAdapterIViewFactory paramIPinnedAdapterIViewFactory)
  {
    this.data = paramList;
    this.factory = paramIPinnedAdapterIViewFactory;
  }

  public void addItem(PinnedItem paramPinnedItem)
  {
    if (this.data != null)
      this.data.add(paramPinnedItem);
  }

  public void addItems(List<PinnedItem> paramList)
  {
    if (this.data != null)
      for (int i = 0; i < paramList.size(); i++)
        addItem((PinnedItem)paramList.get(i));
  }

  public void build(List<PinnedItem> paramList, IPinnedAdapterIViewFactory paramIPinnedAdapterIViewFactory)
  {
    this.factory = paramIPinnedAdapterIViewFactory;
    setData(paramList);
  }

  public void clear()
  {
    this.data.clear();
    notifyDataSetChanged();
  }

  public int getCount()
  {
    if (this.data == null)
      return 0;
    try
    {
      int i = this.data.size();
      return i;
    }
    catch (Exception localException)
    {
    }
    return 1;
  }

  public List<PinnedItem> getData()
  {
    return this.data;
  }

  public PinnedItem getItem(int paramInt)
  {
    if (this.data == null);
    while (this.data.size() <= paramInt)
      return null;
    return (PinnedItem)this.data.get(paramInt);
  }

  public long getItemId(int paramInt)
  {
    return paramInt;
  }

  public int getItemViewType(int paramInt)
  {
    PinnedItem localPinnedItem = getItem(paramInt);
    if (localPinnedItem == null)
      return 0;
    return localPinnedItem.type;
  }

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    PinnedItem localPinnedItem = getItem(paramInt);
    if (paramView == null)
      if ((paramViewGroup == null) || (!(paramViewGroup instanceof IReusableCollection)))
        break label167;
    label167: for (IView localIView = (IView)((IReusableCollection)paramViewGroup).getReusableItem(null); ; localIView = null)
    {
      if (localIView == null)
        localIView = this.factory.createView(localPinnedItem.type);
      paramView = localIView.getView();
      paramView.setTag(localIView);
      while (true)
      {
        localIView.setEventHandler(null);
        if (localPinnedItem != null)
        {
          localIView.update("content", localPinnedItem.data);
          if (localPinnedItem.type == 0)
            localIView.update("position", Integer.valueOf(localPinnedItem.listPosition));
        }
        if (this.builder != null)
        {
          ViewGroup.LayoutParams localLayoutParams = this.builder.getLayoutParams();
          if (localLayoutParams != null)
            paramView.setLayoutParams(localLayoutParams);
        }
        return paramView;
        localIView = (IView)paramView.getTag();
      }
    }
  }

  public int getViewTypeCount()
  {
    return 2;
  }

  public boolean isItemViewTypePinned(int paramInt)
  {
    return paramInt == 1;
  }

  public void setData(List<PinnedItem> paramList)
  {
    this.data = paramList;
    notifyDataSetChanged();
  }

  public void setEventHandler(IEventHandler paramIEventHandler)
  {
    this.eventHandler = paramIEventHandler;
  }

  public void setFactory(IPinnedAdapterIViewFactory paramIPinnedAdapterIViewFactory)
  {
    this.factory = paramIPinnedAdapterIViewFactory;
  }

  public void setIDKey(String paramString)
  {
    this.idKey = paramString;
  }

  public void setLayoutParamsBuilder(ILayoutParamsBuilder paramILayoutParamsBuilder)
  {
    this.builder = paramILayoutParamsBuilder;
  }

  public void updateValue(int paramInt, String paramString, PinnedItem paramPinnedItem)
  {
    updateValue(paramInt, paramString, paramPinnedItem, true);
  }

  public void updateValue(int paramInt, String paramString, PinnedItem paramPinnedItem, boolean paramBoolean)
  {
    if (paramInt >= this.data.size());
    do
    {
      return;
      this.data.set(paramInt, paramPinnedItem);
    }
    while (!paramBoolean);
    notifyDataSetChanged();
  }
}

/* Location:           /Users/zhangxun-xy/Downloads/qingting2/classes_dex2jar.jar
 * Qualified Name:     fm.qingting.qtradio.view.pinnedsection.PinnedSectionAdapter
 * JD-Core Version:    0.6.2
 */