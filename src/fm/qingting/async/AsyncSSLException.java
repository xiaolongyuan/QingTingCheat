package fm.qingting.async;

import javax.net.ssl.SSLPeerUnverifiedException;

public class AsyncSSLException extends SSLPeerUnverifiedException
{
  private boolean mIgnore = false;

  public AsyncSSLException()
  {
    super("Peer not trusted by any of the system trust managers.");
  }

  public boolean getIgnore()
  {
    return this.mIgnore;
  }

  public void setIgnore(boolean paramBoolean)
  {
    this.mIgnore = paramBoolean;
  }
}

/* Location:           /Users/zhangxun-xy/Downloads/qingting2/classes_dex2jar.jar
 * Qualified Name:     fm.qingting.async.AsyncSSLException
 * JD-Core Version:    0.6.2
 */