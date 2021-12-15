/**
 * 
 */
package cs1302.hw06;
import java.time.LocalDate;
/**
 * @author Moffatt
 *
 */
public class Email {

	private String recipient;
	private String sender;
	private LocalDate sendDate;
	private String contents;
	public Email (String recipient, String sender, LocalDate sendDate, String contents) {
		checkNull("Email Constructor", contents, sendDate, recipient, sender);
		checkEmpty("Email Constructor", recipient, sender, contents);
		checkAddress("Email Constructor", recipient, sender);
		
		this.sender = sender;
		this.recipient = recipient;
		this.sendDate = sendDate;
		this.contents = contents;
	}
	public LocalDate getDateSent() {
		return sendDate;
	}
	public String getRecipient() {
		return recipient;
	}
	public String getSender() {
		return sender;
	}
	public String getContents() {
		return contents;
	}
	private void checkNull(String method, Object ...o) {
		for (Object obj: o) {
			if ( o == null) {
				throw new NullPointerException(method + ": Null Argument Provided");
			}
		}
	}
	private void checkEmpty(String method, String...s) {
		for (String str: s) {
			if (str.equals("")) {
				throw new IllegalArgumentException(method+": Empty String Provided");
			}
		}
	}
	private void checkAddress(String method, String ...s) {
		for (String str: s) {
			int index = str.indexOf("@");
			if ((index == -1)|| !(str.substring(index).contains("."))) {
				throw new IllegalArgumentException(method + ": Invalid Email Address");
			}
		}
	}

}
