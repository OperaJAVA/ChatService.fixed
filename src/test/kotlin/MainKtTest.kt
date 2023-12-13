import junit.framework.TestCase.assertNotNull
import junit.framework.TestCase.assertTrue
import org.junit.Test


class MainKtTest {

    @Test
    fun addMessageNewChat() {
        val service = ChatService()
        val chatNew = service.addMessage(listOf(123, 456), Message(text = "message1"))
        assertNotNull(chatNew)
    }

    @Test
    fun addMessageExistChat() {
        val service = ChatService()
        service.addMessage(listOf(123, 456), Message(text = "message1"))
        service.addMessage(listOf(123, 456), Message(text = "message2"))
        val countMessage = service.chats.filter { entry -> entry.key.containsAll(listOf(123, 456)) }.values.size
        assertNotNull(countMessage == 2)
    }

    @Test
    fun deleteChat() {
        val service = ChatService()
        service.addMessage(listOf(123, 456), Message(text = "message1"))
        val result = service.deleteChat(listOf(123, 456))
        assertTrue(result)
    }

    @Test
    fun readChat() {
        val service = ChatService()
        service.addMessage(listOf(123, 456), Message(text = "message1"))
        service.addMessage(listOf(123, 456), Message(text = "message2"))
        service.addMessage(listOf(123, 456), Message(text = "message3"))
        val result = service.readChat(listOf(123, 456))
        assertTrue(result)
    }
}