package fm.qingting.qtradio.view.virtualchannellist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View.MeasureSpec;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshBase.OnRefreshListener;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.tendcloud.tenddata.TCAgent;
import com.umeng.analytics.MobclickAgent;
import fm.qingting.framework.adapter.CustomizedAdapter;
import fm.qingting.framework.adapter.IAdapterIViewFactory;
import fm.qingting.framework.utils.BitmapResourceCache;
import fm.qingting.framework.view.IView;
import fm.qingting.framework.view.ViewGroupViewImpl;
import fm.qingting.framework.view.ViewLayout;
import fm.qingting.qtradio.helper.ChannelHelper;
import fm.qingting.qtradio.manager.SkinManager;
import fm.qingting.qtradio.model.InfoManager;
import fm.qingting.qtradio.model.InfoManager.DataExceptionStatus;
import fm.qingting.qtradio.model.InfoManager.ISubscribeEventListener;
import fm.qingting.qtradio.model.SpecialTopicNode;
import fm.qingting.qtradio.view.MiniPlayerView;
import fm.qingting.qtradio.view.moreContentView.CustomSectionView;
import fm.qingting.utils.ListUtils;
import java.util.ArrayList;
import java.util.List;

public class SpecialTopicView extends ViewGroupViewImpl
  implements InfoManager.ISubscribeEventListener
{
  private CustomizedAdapter mAdapter;
  private IAdapterIViewFactory mFactory;
  private HeaderView mHeaderView;
  private LinearLayout mLinearLayout;
  private PullToRefreshListView mListView;
  private SpecialTopicNode mNode;
  private MiniPlayerView mPlayerView;
  private final ViewLayout miniLayout = this.standardLayout.createChildLT(720, 110, 0, 0, ViewLayout.SCALE_FLAG_SLTCW);
  private final ViewLayout standardLayout = ViewLayout.createViewLayoutWithBoundsLT(720, 1200, 720, 1200, 0, 0, ViewLayout.FILL);

  public SpecialTopicView(Context paramContext)
  {
    super(paramContext);
    final int i = hashCode();
    setBackgroundColor(SkinManager.getBackgroundColor());
    this.mFactory = new IAdapterIViewFactory()
    {
      public IView createView(int paramAnonymousInt)
      {
        return new SpecialTopicItemView(SpecialTopicView.this.getContext(), i);
      }
    };
    this.mAdapter = new CustomizedAdapter(new ArrayList(), this.mFactory);
    this.mLinearLayout = ((LinearLayout)LayoutInflater.from(paramContext).inflate(2130903040, null));
    this.mListView = ((PullToRefreshListView)this.mLinearLayout.findViewById(2131230731));
    this.mListView.setVerticalScrollBarEnabled(false);
    this.mListView.setVerticalFadingEdgeEnabled(false);
    this.mListView.setSelector(17170445);
    this.mHeaderView = new HeaderView(paramContext);
    this.mListView.addListHeaderView(this.mHeaderView);
    this.mListView.addListHeaderView(new CustomSectionView(paramContext));
    this.mListView.setAdapter(this.mAdapter);
    addView(this.mLinearLayout);
    this.mListView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener()
    {
      public void onRefresh(PullToRefreshBase<ListView> paramAnonymousPullToRefreshBase)
      {
        if (SpecialTopicView.this.mNode != null)
          InfoManager.getInstance().loadSpecialTopicNode(SpecialTopicView.this.mNode, SpecialTopicView.this);
      }
    });
    this.mPlayerView = new MiniPlayerView(paramContext);
    addView(this.mPlayerView);
    MobclickAgent.onEvent(paramContext, "enterTopicView");
    TCAgent.onEvent(paramContext, "enterTopicView");
  }

  public void close(boolean paramBoolean)
  {
    this.mPlayerView.destroy();
    BitmapResourceCache.getInstance().clearResourceCacheOfOne(this, 0);
    super.close(paramBoolean);
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mLinearLayout.layout(0, 0, this.standardLayout.width, this.standardLayout.height - this.miniLayout.height);
    this.mPlayerView.layout(0, this.standardLayout.height - this.miniLayout.height, this.standardLayout.width, this.standardLayout.height);
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    this.standardLayout.scaleToBounds(View.MeasureSpec.getSize(paramInt1), View.MeasureSpec.getSize(paramInt2));
    this.miniLayout.scaleToBounds(this.standardLayout);
    this.miniLayout.measureView(this.mPlayerView);
    this.mLinearLayout.measure(this.standardLayout.getWidthMeasureSpec(), View.MeasureSpec.makeMeasureSpec(this.standardLayout.height - this.miniLayout.height, 1073741824));
    setMeasuredDimension(this.standardLayout.width, this.standardLayout.height);
  }

  public void onNotification(String paramString)
  {
    if (paramString.equalsIgnoreCase("RECV_SPECIAL_TOPIC_CHANNELS"))
    {
      List localList = ChannelHelper.getInstance().getLstChannelsByKey(this.mNode.getKey());
      if ((localList != null) && (localList.size() > 0))
      {
        this.mAdapter.setData(ListUtils.convertToObjectList(localList));
        this.mListView.onRefreshComplete();
      }
    }
  }

  public void onRecvDataException(String paramString, InfoManager.DataExceptionStatus paramDataExceptionStatus)
  {
  }

  public void update(String paramString, Object paramObject)
  {
    List localList;
    if (paramString.equalsIgnoreCase("setData"))
    {
      this.mNode = ((SpecialTopicNode)paramObject);
      this.mHeaderView.update(paramString, paramObject);
      localList = ChannelHelper.getInstance().getLstChannelsByKey(this.mNode.getKey());
      if (localList == null)
        this.mListView.setRefreshing();
    }
    else
    {
      return;
    }
    this.mAdapter.setData(ListUtils.convertToObjectList(localList));
    this.mListView.onRefreshComplete();
  }
}

/* Location:           /Users/zhangxun-xy/Downloads/qingting2/classes_dex2jar.jar
 * Qualified Name:     fm.qingting.qtradio.view.virtualchannellist.SpecialTopicView
 * JD-Core Version:    0.6.2
 */