package fm.qingting.qtradio.room;

public class GetOnlineUsersAction extends Action
{
  private String roomId;
  private int roomType;

  public GetOnlineUsersAction()
  {
    this.actionType = 11;
  }

  public int getActionType()
  {
    return this.actionType;
  }

  public String getRoomId()
  {
    return this.roomId;
  }

  public int getRoomType()
  {
    return this.roomType;
  }

  public void setConnectRoomId(String paramString, int paramInt)
  {
    this.roomId = paramString;
    this.roomType = paramInt;
  }
}

/* Location:           /Users/zhangxun-xy/Downloads/qingting2/classes_dex2jar.jar
 * Qualified Name:     fm.qingting.qtradio.room.GetOnlineUsersAction
 * JD-Core Version:    0.6.2
 */