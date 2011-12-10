package cz.janstefl.tasksync.persistence.ical;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Entity implementation class for Entity: Vevent
 * 
 * <pre>
 * Component/Property  Presence
 * ------------------- ----------------------------------------------
 *     DTSTAMP         1
 *     DTSTART         1
 *     ORGANIZER       1
 *     SEQUENCE        1      MUST be greater than 0
 *     SUMMARY         1      Can be null
 *     UID             1      MUST match that of the original event
 * 
 *     ATTACH          0+
 *     ATTENDEE        0+
 *     CATEGORIES      0 or 1 This property MAY contain a list of values
 *     CLASS           0 or 1
 *     COMMENT         0 or 1
 *     CONTACT         0+
 *     CREATED         0 or 1
 *     DESCRIPTION     0 or 1  Can be null
 *     DTEND           0 or 1  if present DURATION MUST NOT be present
 *     DURATION        0 or 1  if present DTEND MUST NOT be present
 *     EXDATE          0+
 *     EXRULE          0+
 *     GEO             0 or 1
 *     LAST-MODIFIED   0 or 1
 *     LOCATION        0 or 1
 *     PRIORITY        0 or 1
 *     RDATE           0+
 *     RELATED-TO      0+
 *     RESOURCES       0 or 1  This property MAY contain a list of values
 *     RRULE           0+
 *     STATUS          0 or 1  MAY be one of TENTATIVE/CONFIRMED
 *     TRANSP          0 or 1
 *     URL             0 or 1
 *     X-PROPERTY      0+
 * 
 *     RECURRENCE-ID   0
 *     REQUEST-STATUS  0
 * </pre>
 * 
 */
@Entity
public class VEventItem implements ICalendarItem {

  @Id
  private String uid;
  
  private String dtstamp;
  private String dtstart;
  private String organizer;
  private String sequence;
  private String summary;

  private String attach;
  private String attendee;
  private String categories;
  private String clazz;
  private String comment;
  private String contact;
  private String created;
  private String description;
  private String dtend;
  private String duration;
  private String exdate;
  private String exrule;
  private String geo;
  private String lastModified;
  private String location;
  private String priority;
  private String rdate;
  private String relatedTo;
  private String resources;
  private String rrule;
  private String status;
  private String transp;
  private String url;
  private String xProperty;

  private String recurrenceId;
  private String requestStatus;

  public VEventItem() {
    super();
  }

  public String getDtstamp() {
    return dtstamp;
  }

  public void setDtstamp(String dtstamp) {
    this.dtstamp = dtstamp;
  }

  public String getDtstart() {
    return dtstart;
  }

  public void setDtstart(String dtstart) {
    this.dtstart = dtstart;
  }

  public String getOrganizer() {
    return organizer;
  }

  public void setOrganizer(String organizer) {
    this.organizer = organizer;
  }

  public String getSequence() {
    return sequence;
  }

  public void setSequence(String sequence) {
    this.sequence = sequence;
  }

  public String getSummary() {
    return summary;
  }

  public void setSummary(String summary) {
    this.summary = summary;
  }

  public String getUid() {
    return uid;
  }

  public void setUid(String uid) {
    this.uid = uid;
  }

  public String getAttach() {
    return attach;
  }

  public void setAttach(String attach) {
    this.attach = attach;
  }

  public String getAttendee() {
    return attendee;
  }

  public void setAttendee(String attendee) {
    this.attendee = attendee;
  }

  public String getCategories() {
    return categories;
  }

  public void setCategories(String categories) {
    this.categories = categories;
  }

  public String getClazz() {
    return clazz;
  }

  public void setClazz(String clazz) {
    this.clazz = clazz;
  }

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public String getContact() {
    return contact;
  }

  public void setContact(String contact) {
    this.contact = contact;
  }

  public String getCreated() {
    return created;
  }

  public void setCreated(String created) {
    this.created = created;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getDtend() {
    return dtend;
  }

  public void setDtend(String dtend) {
    this.dtend = dtend;
  }

  public String getDuration() {
    return duration;
  }

  public void setDuration(String duration) {
    this.duration = duration;
  }

  public String getExdate() {
    return exdate;
  }

  public void setExdate(String exdate) {
    this.exdate = exdate;
  }

  public String getExrule() {
    return exrule;
  }

  public void setExrule(String exrule) {
    this.exrule = exrule;
  }

  public String getGeo() {
    return geo;
  }

  public void setGeo(String geo) {
    this.geo = geo;
  }

  public String getLastModified() {
    return lastModified;
  }

  public void setLastModified(String lastModified) {
    this.lastModified = lastModified;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public String getPriority() {
    return priority;
  }

  public void setPriority(String priority) {
    this.priority = priority;
  }

  public String getRdate() {
    return rdate;
  }

  public void setRdate(String rdate) {
    this.rdate = rdate;
  }

  public String getRelatedTo() {
    return relatedTo;
  }

  public void setRelatedTo(String relatedTo) {
    this.relatedTo = relatedTo;
  }

  public String getResources() {
    return resources;
  }

  public void setResources(String resources) {
    this.resources = resources;
  }

  public String getRrule() {
    return rrule;
  }

  public void setRrule(String rrule) {
    this.rrule = rrule;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getTransp() {
    return transp;
  }

  public void setTransp(String transp) {
    this.transp = transp;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getxProperty() {
    return xProperty;
  }

  public void setxProperty(String xProperty) {
    this.xProperty = xProperty;
  }

  public String getRecurrenceId() {
    return recurrenceId;
  }

  public void setRecurrenceId(String recurrenceId) {
    this.recurrenceId = recurrenceId;
  }

  public String getRequestStatus() {
    return requestStatus;
  }

  public void setRequestStatus(String requestStatus) {
    this.requestStatus = requestStatus;
  }

}
