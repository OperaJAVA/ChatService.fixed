class Chat() {
    val messages: MutableList<Message> = mutableListOf()

    fun readMessages() {
        for (message in this.messages)
            message.isRead = true
    }

    fun unreadMessagesB(): Boolean {
        return messages.filter { !it.isRead }.isEmpty()
    }

    override fun toString(): String {
        var result: String = "[ chat "
        messages.onEach { message ->
            result += " $message"
        }
        return result + "]"
    }
}