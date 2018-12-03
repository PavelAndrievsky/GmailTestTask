package gmail.entities;

public class Message {

    private String recipient;
    private String topic;
    private String text;
    private String date;

    public Message() {}

    public Message(String make, String model, String year) {
        this.recipient = make;
        this.topic = model;
        this.text = year;
    }

    public Message(String make, String model, String year, String date) {
        this.recipient = make;
        this.topic = model;
        this.text = year;
        this.date = date;
    }

    public String getRecipient() {
        return recipient;
    }

    public String getTopic() {
        return topic;
    }

    public String getText() {
        return text;
    }

    public String getDate() {
        return date;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) return false;
        if (this == obj) return true;

        if(obj instanceof Message) {
            Message message = (Message) obj;

            return this.recipient.equals(message.recipient) &&
                    this.topic.equals(message.topic) &&
                    this.text.equals(message.text);
        }
        else
            return false;
    }

    @Override
    public int hashCode() {
        int result = this.recipient.hashCode();
        result = 31 * result + this.topic.hashCode();
        result = 31 * result + this.text.hashCode();
        result = 31 * result + this.date.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Message{" +
                "recipient='" + recipient + '\'' +
                ", topic='" + topic + '\'' +
                ", text=" + text +
                ", date='" + date + '\'' +
                '}';
    }

}
