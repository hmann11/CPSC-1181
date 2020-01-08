
public class Message {
	private String who;
	private String content;
	public Message(String who,String content) {
		this.who=who;
		this.content=content;
	}
	public String getMessageAuthor() {
		return this.who;
	}
	
	public String getMessageContent() {
		return this.content;
	}
}
