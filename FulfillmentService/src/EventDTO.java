
public class EventDTO {
	private int event_pId;
	private int event_pAmount;

	public EventDTO(int event_pId, int event_pAmount) {
		this.event_pId = event_pId;
		this.event_pAmount = event_pAmount;
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

	@Override
	public String toString() {
		return "EventDTO [event_pId=" + event_pId + ", event_pAmount=" + event_pAmount + "]";
	}

}
