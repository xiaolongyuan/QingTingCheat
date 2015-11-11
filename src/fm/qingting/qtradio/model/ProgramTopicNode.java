package fm.qingting.qtradio.model;

import fm.qingting.utils.TimeUtil;

public class ProgramTopicNode extends Node
{
  public String channelId = "";
  public long endTime;
  public String mid;
  public String platform;
  public String programId = "";
  public long startTime;
  public String topic;
  public String type;

  public ProgramTopicNode()
  {
    this.nodeName = "programtopic";
  }

  private boolean isValid(long paramLong)
  {
    long l1 = TimeUtil.absoluteTimeToRelative(System.currentTimeMillis() / 1000L);
    long l2 = TimeUtil.absoluteTimeToRelative(paramLong);
    long l3 = TimeUtil.absoluteTimeToRelative(this.startTime);
    long l4 = TimeUtil.absoluteTimeToRelative(this.endTime);
    return (l3 <= l2) && (l2 <= l4) && (l3 <= l1) && (l1 <= l4);
  }

  public Node cloneNode()
  {
    ProgramTopicNode localProgramTopicNode = new ProgramTopicNode();
    localProgramTopicNode.type = this.type;
    localProgramTopicNode.platform = this.platform;
    localProgramTopicNode.mid = this.mid;
    localProgramTopicNode.topic = this.topic;
    localProgramTopicNode.startTime = this.startTime;
    localProgramTopicNode.endTime = this.endTime;
    localProgramTopicNode.programId = this.programId;
    localProgramTopicNode.channelId = this.channelId;
    return localProgramTopicNode;
  }

  public int getScore()
  {
    if ((this.type.equalsIgnoreCase("program")) || (this.type.equalsIgnoreCase("ondemandprogram")))
      return 3;
    if ((this.type.equalsIgnoreCase("channel")) || (this.type.equalsIgnoreCase("program")))
      return 2;
    if (this.type.equalsIgnoreCase("global"))
      return 1;
    return 0;
  }

  public boolean isValid(String paramString, long paramLong)
  {
    if (paramString == null);
    while ((!isValid(paramLong)) || (this.channelId == null) || (!paramString.equalsIgnoreCase(this.channelId)))
      return false;
    return true;
  }

  public boolean isValid(String paramString1, String paramString2, long paramLong)
  {
    if ((paramString1 == null) || (paramString2 == null));
    do
    {
      do
      {
        do
        {
          do
            return false;
          while (!isValid(paramLong));
          if ((!this.type.equalsIgnoreCase("channel")) && (!this.type.equalsIgnoreCase("album")))
            break;
        }
        while ((this.channelId == null) || (!paramString1.equalsIgnoreCase(this.channelId)));
        return true;
        if ((!this.type.equalsIgnoreCase("program")) && (!this.type.equalsIgnoreCase("ondemandprogram")))
          break;
      }
      while ((this.programId == null) || (!this.programId.equalsIgnoreCase(paramString2)));
      return true;
    }
    while (!this.type.equalsIgnoreCase("global"));
    return true;
  }

  public boolean updateTopicInfo(Node paramNode)
  {
    if (paramNode == null);
    ProgramTopicNode localProgramTopicNode;
    do
    {
      do
        return false;
      while (!paramNode.nodeName.equalsIgnoreCase("programtopic"));
      localProgramTopicNode = (ProgramTopicNode)paramNode;
    }
    while ((!localProgramTopicNode.type.equalsIgnoreCase(this.type)) || (!localProgramTopicNode.channelId.equalsIgnoreCase(this.channelId)) || (!localProgramTopicNode.programId.equalsIgnoreCase(this.programId)));
    if (this.startTime < localProgramTopicNode.startTime)
    {
      this.startTime = localProgramTopicNode.startTime;
      this.endTime = localProgramTopicNode.endTime;
      this.topic = localProgramTopicNode.topic;
    }
    return true;
  }
}

/* Location:           /Users/zhangxun-xy/Downloads/qingting2/classes_dex2jar.jar
 * Qualified Name:     fm.qingting.qtradio.model.ProgramTopicNode
 * JD-Core Version:    0.6.2
 */