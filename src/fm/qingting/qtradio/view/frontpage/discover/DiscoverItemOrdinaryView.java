package fm.qingting.qtradio.view.frontpage.discover;

import android.content.Context;
import android.view.View.MeasureSpec;
import fm.qingting.framework.view.ButtonViewElement;
import fm.qingting.framework.view.ImageViewElement;
import fm.qingting.framework.view.NetImageViewElement;
import fm.qingting.framework.view.QtView;
import fm.qingting.framework.view.TextViewElement;
import fm.qingting.framework.view.TextViewElement.VerticalAlignment;
import fm.qingting.framework.view.ViewElement;
import fm.qingting.framework.view.ViewElement.OnElementClickListener;
import fm.qingting.framework.view.ViewLayout;
import fm.qingting.qtradio.controller.ControllerManager;
import fm.qingting.qtradio.manager.SkinManager;
import fm.qingting.qtradio.model.Node;
import fm.qingting.qtradio.model.ProgramNode;
import fm.qingting.qtradio.model.RecommendItemNode;
import fm.qingting.qtradio.model.SpecialTopicNode;
import fm.qingting.qtradio.view.playview.LineElement;
import fm.qingting.utils.TimeUtil;
import java.util.Calendar;
import java.util.Locale;

public class DiscoverItemOrdinaryView extends QtView
  implements ViewElement.OnElementClickListener
{
  private static final String JUST = "刚刚更新";
  private static final String MODEL_HOUR = "%d小时前";
  private static final String MODEL_MINUTE = "%d分钟前";
  private static final long ONEHOUR = 3600000L;
  private static final long TENMINUTE = 600000L;
  private static final long THREEHOUR = 10800000L;
  private final ViewLayout avatarLayout = this.itemLayout.createChildLT(116, 116, 25, 26, ViewLayout.SCALE_FLAG_SLTCW);
  private final ViewLayout heatLayout = this.itemLayout.createChildLT(22, 22, 166, 117, ViewLayout.SCALE_FLAG_SLTCW);
  private final ViewLayout hostLabelLayout = this.itemLayout.createChildLT(22, 22, 344, 117, ViewLayout.SCALE_FLAG_SLTCW);
  private final ViewLayout hostTextLayout = this.itemLayout.createChildLT(130, 45, 368, 105, ViewLayout.SCALE_FLAG_SLTCW);
  private final ViewLayout indentationLayout = this.itemLayout.createChildLT(17, 18, 0, 0, ViewLayout.SCALE_FLAG_SLTCW);
  private final ViewLayout infoLayout = this.itemLayout.createChildLT(300, 45, 190, 105, ViewLayout.SCALE_FLAG_SLTCW);
  private final ViewLayout itemLayout = ViewLayout.createViewLayoutWithBoundsLT(720, 168, 720, 168, 0, 0, ViewLayout.SCALE_FLAG_SLTCW);
  private final ViewLayout lineLayout = this.itemLayout.createChildLT(670, 1, 25, 0, ViewLayout.SCALE_FLAG_SLTCW);
  private NetImageViewElement mAvatarElement;
  private ButtonViewElement mBg;
  private ImageViewElement mHeatElement;
  private ImageViewElement mHostLabelElement;
  private TextViewElement mHostTextElement;
  private RecommendItemNode mInfo;
  private TextViewElement mInfoElement;
  private LineElement mLineElement;
  private TextViewElement mTimeElement;
  private TextViewElement mTitleElement;
  private final ViewLayout timeLayout = this.itemLayout.createChildLT(280, 45, 166, 105, ViewLayout.SCALE_FLAG_SLTCW);
  private final ViewLayout titleLayout = this.itemLayout.createChildLT(540, 40, 166, 18, ViewLayout.SCALE_FLAG_SLTCW);

  public DiscoverItemOrdinaryView(Context paramContext, int paramInt)
  {
    super(paramContext);
    this.mBg = new ButtonViewElement(paramContext);
    this.mBg.setBackgroundColor(0, SkinManager.getCardColor());
    addElement(this.mBg);
    this.mBg.setOnElementClickListener(this);
    this.mAvatarElement = new NetImageViewElement(paramContext);
    this.mAvatarElement.setDefaultImageRes(2130837902);
    this.mAvatarElement.setBoundColor(SkinManager.getDividerColor());
    addElement(this.mAvatarElement, paramInt);
    this.mTitleElement = new TextViewElement(paramContext);
    this.mTitleElement.setColor(SkinManager.getTextColorNormal());
    this.mTitleElement.setVerticalAlignment(TextViewElement.VerticalAlignment.CENTER);
    this.mTitleElement.setMaxLineLimit(2);
    addElement(this.mTitleElement);
    this.mHeatElement = new ImageViewElement(paramContext);
    this.mHeatElement.setImageRes(2130837744);
    this.mInfoElement = new TextViewElement(paramContext);
    this.mInfoElement.setColor(SkinManager.getTextColorHeat());
    this.mInfoElement.setMaxLineLimit(1);
    addElement(this.mInfoElement);
    this.mHostLabelElement = new ImageViewElement(paramContext);
    this.mHostLabelElement.setImageRes(2130837745);
    this.mHostTextElement = new TextViewElement(paramContext);
    this.mHostTextElement.setColor(SkinManager.getTextColorThirdLevel());
    this.mHostTextElement.setMaxLineLimit(1);
    this.mTimeElement = new TextViewElement(paramContext);
    this.mTimeElement.setColor(SkinManager.getTextColorThirdLevel());
    this.mTimeElement.setMaxLineLimit(1);
    addElement(this.mTimeElement);
    this.mLineElement = new LineElement(paramContext);
    this.mLineElement.setOrientation(1);
    this.mLineElement.setColor(SkinManager.getDividerColor());
    addElement(this.mLineElement);
  }

  private String getName()
  {
    if (this.mInfo.mNode == null);
    do
    {
      return null;
      if (this.mInfo.mNode.nodeName.equalsIgnoreCase("program"))
      {
        String str = ((ProgramNode)this.mInfo.mNode).getChannelName();
        if (str == null)
          str = this.mInfo.belongName;
        return "【" + str + "】" + this.mInfo.name;
      }
      if (this.mInfo.mNode.nodeName.equalsIgnoreCase("channel"))
        return "【" + this.mInfo.name + "】";
    }
    while (!this.mInfo.mNode.nodeName.equalsIgnoreCase("specialtopic"));
    return "【" + ((SpecialTopicNode)this.mInfo.mNode).title + "】" + this.mInfo.name;
  }

  private String getUpdateTime()
  {
    if (this.mInfo.mNode == null);
    do
    {
      return null;
      if (this.mInfo.mNode.nodeName.equalsIgnoreCase("program"))
        return standardizeTime(((ProgramNode)this.mInfo.mNode).getUpdateTime());
    }
    while ((this.mInfo.mNode.nodeName.equalsIgnoreCase("channel")) || (!this.mInfo.mNode.nodeName.equalsIgnoreCase("specialtopic")));
    return standardizeTime(((SpecialTopicNode)this.mInfo.mNode).getUpdateTime());
  }

  private String standardizeTime(long paramLong)
  {
    long l1 = System.currentTimeMillis();
    Calendar localCalendar = Calendar.getInstance();
    int i = localCalendar.get(1);
    int j = localCalendar.get(6);
    localCalendar.setTimeInMillis(paramLong);
    int k = localCalendar.get(1);
    int m = localCalendar.get(6);
    if ((i == k) && (j == m));
    for (int n = 1; ; n = 0)
    {
      if (n != 0)
      {
        long l2 = l1 - paramLong;
        if (l2 < 600000L)
          return "刚刚更新";
        if (l2 < 3600000L)
        {
          Locale localLocale2 = Locale.CHINESE;
          Object[] arrayOfObject2 = new Object[1];
          arrayOfObject2[0] = Integer.valueOf((int)(l2 / 1000L));
          return String.format(localLocale2, "%d分钟前", arrayOfObject2);
        }
        if (l2 < 10800000L)
        {
          Locale localLocale1 = Locale.CHINESE;
          Object[] arrayOfObject1 = new Object[1];
          arrayOfObject1[0] = Integer.valueOf((int)(l2 / 1000L / 60L));
          return String.format(localLocale1, "%d小时前", arrayOfObject1);
        }
      }
      else
      {
        return TimeUtil.msToDate5(paramLong);
      }
      return null;
    }
  }

  public void onElementClick(ViewElement paramViewElement)
  {
    ControllerManager.getInstance().openControllerByRecommendNode(this.mInfo);
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    this.itemLayout.scaleToBounds(View.MeasureSpec.getSize(paramInt1), View.MeasureSpec.getSize(paramInt2));
    this.avatarLayout.scaleToBounds(this.itemLayout);
    this.titleLayout.scaleToBounds(this.itemLayout);
    this.infoLayout.scaleToBounds(this.itemLayout);
    this.lineLayout.scaleToBounds(this.itemLayout);
    this.timeLayout.scaleToBounds(this.itemLayout);
    this.heatLayout.scaleToBounds(this.itemLayout);
    this.hostLabelLayout.scaleToBounds(this.itemLayout);
    this.hostTextLayout.scaleToBounds(this.itemLayout);
    this.indentationLayout.scaleToBounds(this.itemLayout);
    this.mBg.measure(this.itemLayout);
    this.mAvatarElement.measure(this.avatarLayout);
    this.mAvatarElement.setBoundLineWidth(this.lineLayout.height);
    this.mTitleElement.measure(this.titleLayout);
    this.mHeatElement.measure(this.heatLayout);
    this.mInfoElement.measure(this.infoLayout);
    this.mTimeElement.measure(this.timeLayout);
    this.mLineElement.measure(this.lineLayout.leftMargin, this.itemLayout.height - this.lineLayout.height, this.lineLayout.getRight(), this.itemLayout.height);
    this.mTitleElement.setTextSize(SkinManager.getInstance().getNormalTextSize());
    this.mInfoElement.setTextSize(SkinManager.getInstance().getRecommendTextSize());
    this.mTitleElement.setExactFirstIndentation(-this.indentationLayout.width);
    this.mTimeElement.setTextSize(SkinManager.getInstance().getRecommendTextSize());
    this.mHostLabelElement.measure(this.hostLabelLayout);
    this.mHostTextElement.measure(this.hostTextLayout);
    this.mHostTextElement.setTextSize(SkinManager.getInstance().getRecommendTextSize());
    setMeasuredDimension(this.itemLayout.width, this.itemLayout.height);
  }

  public void update(String paramString, Object paramObject)
  {
    if (paramString.equalsIgnoreCase("content"))
    {
      this.mInfo = ((RecommendItemNode)paramObject);
      this.mAvatarElement.setImageUrl(this.mInfo.getApproximativeThumb(116, 116));
      this.mTitleElement.setText(getName(), false);
      this.mTimeElement.setText(getUpdateTime());
    }
    while (!paramString.equalsIgnoreCase("nbl"))
      return;
    boolean bool = ((Boolean)paramObject).booleanValue();
    LineElement localLineElement = this.mLineElement;
    int i = 0;
    if (bool);
    while (true)
    {
      localLineElement.setVisible(i);
      return;
      i = 4;
    }
  }
}

/* Location:           /Users/zhangxun-xy/Downloads/qingting2/classes_dex2jar.jar
 * Qualified Name:     fm.qingting.qtradio.view.frontpage.discover.DiscoverItemOrdinaryView
 * JD-Core Version:    0.6.2
 */