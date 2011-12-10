package cz.janstefl.tasksync.persistence.ical;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Entity implementation class for Entity: VAlarm VALARM ACTION 1 ATTACH 0+
 * DESCRIPTION 0 or 1 DURATION 0 or 1 if present REPEAT MUST be present REPEAT 0
 * or 1 if present DURATION MUST be present SUMMARY 0 or 1 TRIGGER 1 X-PROPERTY
 * 0+
 */
@Entity
public class VAlarmItem implements ICalendarItem {

  @Id
  @GeneratedValue
  private int id;
  private String action;
  private String attach;
  private String description;
  private String duration;
  private String repeat;
  private String summary;
  private String trigger;
  private String xProperty;

  public VAlarmItem() {
    super();
  }

  public VAlarmItem(int id, String action, String attach, String description,
      String duration, String repeat, String summary, String trigger,
      String xProperty) {
    super();
    this.id = id;
    this.action = action;
    this.attach = attach;
    this.description = description;
    this.duration = duration;
    this.repeat = repeat;
    this.summary = summary;
    this.trigger = trigger;
    this.xProperty = xProperty;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getAction() {
    return action;
  }

  public void setAction(String action) {
    this.action = action;
  }

  public String getAttach() {
    return attach;
  }

  public void setAttach(String attach) {
    this.attach = attach;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getDuration() {
    return duration;
  }

  public void setDuration(String duration) {
    this.duration = duration;
  }

  public String getRepeat() {
    return repeat;
  }

  public void setRepeat(String repeat) {
    this.repeat = repeat;
  }

  public String getSummary() {
    return summary;
  }

  public void setSummary(String summary) {
    this.summary = summary;
  }

  public String getTrigger() {
    return trigger;
  }

  public void setTrigger(String trigger) {
    this.trigger = trigger;
  }

  public String getxProperty() {
    return xProperty;
  }

  public void setxProperty(String xProperty) {
    this.xProperty = xProperty;
  }

}
