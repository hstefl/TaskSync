package cz.janstefl.tasksync.persistence.ical;

import javax.persistence.Embeddable;

/**
 * Entity implementation class for Entity: VFreeBusy
 * 
 */
@Embeddable
public class CalendarPropertiesItem {

  private String calscale;
  private String method;
  private String prodid;
  private String version;
  
  public CalendarPropertiesItem() {
    super();
  }

  public CalendarPropertiesItem(String calscale, String method, String prodid,
      String version) {
    super();
    this.calscale = calscale;
    this.method = method;
    this.prodid = prodid;
    this.version = version;
  }

  public String getCalscale() {
    return calscale;
  }

  public void setCalscale(String calscale) {
    this.calscale = calscale;
  }

  public String getMethod() {
    return method;
  }

  public void setMethod(String method) {
    this.method = method;
  }

  public String getProdid() {
    return prodid;
  }

  public void setProdid(String prodid) {
    this.prodid = prodid;
  }

  public String getVersion() {
    return version;
  }

  public void setVersion(String version) {
    this.version = version;
  }
  
}
