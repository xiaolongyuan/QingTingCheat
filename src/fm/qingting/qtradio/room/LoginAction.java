package fm.qingting.qtradio.room;

public class LoginAction extends Action
{
  private int roomType;
  private UserInfo user;

  public LoginAction()
  {
    this.actionType = 3;
  }

  public int getActionType()
  {
    return this.actionType;
  }

  public int getRoomType()
  {
    return this.roomType;
  }

  public UserInfo getUserInfo()
  {
    return this.user;
  }

  public void setUserInfo(UserInfo paramUserInfo, int paramInt)
  {
    this.user = paramUserInfo;
    this.roomType = paramInt;
  }
}

/* Location:           /Users/zhangxun-xy/Downloads/qingting2/classes_dex2jar.jar
 * Qualified Name:     fm.qingting.qtradio.room.LoginAction
 * JD-Core Version:    0.6.2
 */