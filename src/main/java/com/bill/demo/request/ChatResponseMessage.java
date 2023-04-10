package com.bill.demo.request;

public class ChatResponseMessage {
    String role;
    String content;

    String type;

    String question;
    public void setQuestion(String question) {
        this.question = question;
    }

    public String getQuestion() {
        return this.question;
    }
    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return this.type;
    }
    public String getRole() {
        return this.role;
    }

    public String getContent() {
        return this.content;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof com.theokanning.openai.completion.chat.ChatMessage)) {
            return false;
        } else {
            com.theokanning.openai.completion.chat.ChatMessage other = (com.theokanning.openai.completion.chat.ChatMessage)o;
            if (!other.equals(this)) {
                return false;
            } else {
                Object this$role = this.getRole();
                Object other$role = other.getRole();
                if (this$role == null) {
                    if (other$role != null) {
                        return false;
                    }
                } else if (!this$role.equals(other$role)) {
                    return false;
                }

                Object this$content = this.getContent();
                Object other$content = other.getContent();
                if (this$content == null) {
                    if (other$content != null) {
                        return false;
                    }
                } else if (!this$content.equals(other$content)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof com.theokanning.openai.completion.chat.ChatMessage;
    }

    public int hashCode() {
        boolean PRIME = true;
        int result = 1;
        Object $role = this.getRole();
        result = result * 59 + ($role == null ? 43 : $role.hashCode());
        Object $content = this.getContent();
        result = result * 59 + ($content == null ? 43 : $content.hashCode());
        return result;
    }

    public String toString() {
        return "ChatMessage(role=" + this.getRole() + ", content=" + this.getContent() + ")";
    }

    public ChatResponseMessage() {
    }

    public ChatResponseMessage(String role, String content) {
        this.role = role;
        this.content = content;
    }
}
