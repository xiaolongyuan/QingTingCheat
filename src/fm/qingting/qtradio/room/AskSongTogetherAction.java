package fm.qingting.qtradio.room;

public class AskSongTogetherAction extends Action
{
  private String roomId;
  private int roomType;

  public AskSongTogetherAction()
  {
    this.actionType = 15;
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

  public void setContentInfo(int paramInt, String paramString)
  {
    this.roomType = paramInt;
    this.roomId = paramString;
  }
}

/* Location:           /Users/zhangxun-xy/Downloads/qingting2/classes_dex2jar.jar
 * Qualified Name:     fm.qingting.qtradio.room.AskSongTogetherAction
 * JD-Core Version:    0.6.2
 */