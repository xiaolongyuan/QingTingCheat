package fm.qingting.qtradio.im;

import android.util.Log;
import fm.qingting.qtradio.model.RootNode.IInfoUpdateEventListener;
import fm.qingting.qtradio.social.UserProfile;
import java.util.HashMap;
import java.util.Map;

public class UserProfileManager
{
  private static UserProfileManager _instance;
  private Map<String, UserProfile> mapUser = new HashMap();

  public static UserProfileManager getInstance()
  {
    if (_instance == null)
      _instance = new UserProfileManager();
    return _instance;
  }

  private void log(String paramString)
  {
    Log.e("UserProfileManager", paramString);
  }

  public UserProfile getUserProfile(String paramString)
  {
    if (paramString == null)
      return null;
    return (UserProfile)this.mapUser.get(paramString);
  }

  public void loadUserInfo(String paramString, RootNode.IInfoUpdateEventListener paramIInfoUpdateEventListener)
  {
    if (paramString == null);
    while (this.mapUser.get(paramString) != null)
      return;
    UserProfile localUserProfile = new UserProfile();
    localUserProfile.setUserKey(paramString);
    localUserProfile.loadUserInfo(paramString, paramIInfoUpdateEventListener);
    this.mapUser.put(paramString, localUserProfile);
  }
}

/* Location:           /Users/zhangxun-xy/Downloads/qingting2/classes_dex2jar.jar
 * Qualified Name:     fm.qingting.qtradio.im.UserProfileManager
 * JD-Core Version:    0.6.2
 */