package fm.qingting.qtradio.model;

import java.util.ArrayList;

public class SubCategoryInfo
{
  private ArrayList<SubCategoryElement> lstSubCategoryElements = new ArrayList();
  public String title = null;

  public void addSubCategoryElement(SubCategoryElement paramSubCategoryElement)
  {
    this.lstSubCategoryElements.add(paramSubCategoryElement);
  }

  public ArrayList<SubCategoryElement> getSubCategoryList()
  {
    return this.lstSubCategoryElements;
  }

  public String getTitle()
  {
    return this.title;
  }

  public void setTitle(String paramString)
  {
    this.title = paramString;
  }
}

/* Location:           /Users/zhangxun-xy/Downloads/qingting2/classes_dex2jar.jar
 * Qualified Name:     fm.qingting.qtradio.model.SubCategoryInfo
 * JD-Core Version:    0.6.2
 */