package fm.qingting.qtradio.view.im.profile;

import android.content.Context;
import fm.qingting.framework.view.LinearLayoutViewImpl;
import fm.qingting.qtradio.im.info.GroupInfo;

class GroupProfileDetailView extends LinearLayoutViewImpl
{
  private MutipleMemberItemsView mCollectionView;
  private GroupMembersView mGroupView;
  private GroupInfoView mPersonalProfileView;
  private GroupDescView mWhatsupView;

  public GroupProfileDetailView(Context paramContext)
  {
    super(paramContext);
    setOrientation(1);
    this.mPersonalProfileView = new GroupInfoView(paramContext);
    addView(this.mPersonalProfileView);
    this.mWhatsupView = new GroupDescView(paramContext);
    addView(this.mWhatsupView);
    this.mWhatsupView.update("needfillline", null);
    this.mGroupView = new GroupMembersView(paramContext);
    addView(this.mGroupView);
    this.mGroupView.update("needfillline", null);
    this.mCollectionView = new MutipleMemberItemsView(paramContext);
    addView(this.mCollectionView);
  }

  public void close(boolean paramBoolean)
  {
    this.mPersonalProfileView.close(paramBoolean);
    this.mWhatsupView.close(paramBoolean);
    this.mGroupView.close(paramBoolean);
    this.mCollectionView.close(paramBoolean);
    super.close(paramBoolean);
  }

  public void update(String paramString, Object paramObject)
  {
    if (paramString.equalsIgnoreCase("setData"))
    {
      this.mPersonalProfileView.update(paramString, paramObject);
      this.mWhatsupView.update(paramString, paramObject);
      localGroupInfo = (GroupInfo)paramObject;
      this.mCollectionView.update(paramString, localGroupInfo.lstAdmins);
      this.mGroupView.update("setCnt", Integer.valueOf(localGroupInfo.userCnt));
    }
    while (!paramString.equalsIgnoreCase("setUsers"))
    {
      GroupInfo localGroupInfo;
      return;
    }
    this.mGroupView.update("setData", paramObject);
  }
}

/* Location:           /Users/zhangxun-xy/Downloads/qingting2/classes_dex2jar.jar
 * Qualified Name:     fm.qingting.qtradio.view.im.profile.GroupProfileDetailView
 * JD-Core Version:    0.6.2
 */