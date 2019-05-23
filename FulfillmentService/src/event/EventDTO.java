package event;

public class EventDTO {
	private int event_pId;
	private int event_pAmount;
	private String event_executeAt;

	public EventDTO(int event_pId, int event_pAmount, String event_executeAt) {
		this.event_pId = event_pId;
		this.event_pAmount = event_pAmount;
		this.event_executeAt = event_executeAt;
	}

	public EventDTO() {
	}

	public int getEvent_pId() {
		return event_pId;
	}

	public void setEvent_pId(int event_pId) {
		this.event_pId = event_pId;
	}

	public int getEvent_pAmount() {
		return event_pAmount;
	}

	public void setEvent_pAmount(int event_pAmount) {
		this.event_pAmount = event_pAmount;
	}

	public String getEvent_executeAt() {
		return event_executeAt;
	}

	public void setEvent_executeAt(String event_executeAt) {
		this.event_executeAt = event_executeAt;
	}

	@Override
	public String toString() {
		return "EventDTO [event_pId=" + event_pId + ", event_pAmount=" + event_pAmount + ", event_executeAt="
				+ event_executeAt + "]";
	}

}
