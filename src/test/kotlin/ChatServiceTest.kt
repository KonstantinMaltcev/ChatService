import org.junit.Assert.*
import org.junit.Test

class ChatServiceTest {
    private val chatService = ChatService()
    private val chatsTest = mutableListOf<Chat>()

    @Test
    fun getUsers() {
    }

    @Test
    fun createUser() {
        chatService.createUser("Anya")
        val result = chatService.users.map { it.userId }[0]
        assertEquals(1, result)
    }

    @Test
    fun addNewMessageTrue() {
        val result = chatService.addNewMessage(1, 2, "Hoi")
        assertTrue(result)
    }

    @Test
    fun addedNewMessageFalse() {
        chatService.addNewChat(1, 2, "Text")
        val result = chatService.addNewMessage(1, 2, "Hoi")
        assertFalse(result)
    }

    @Test
    fun addedNewChatTrue() {
        val result = chatService.addNewChat(1, 2, "test")
        assertTrue(result)
    }

    @Test
    fun addedNewChatFalse() {
        chatService.addNewChat(2, 4, "1")
        val result = chatService.addNewChat(2, 4, "2")
        assertFalse(result)
    }

    @Test
    fun deletedChatTrue() {
        chatService.addNewChat(1, 2, "Delete")
        val result = chatService.deleteChat(1)
        assertTrue(result)
    }

    @Test
    fun deletedChatFalse() {
        chatService.addNewChat(1, 2, "Delete")
        val result = chatService.deleteChat(10000)
        assertFalse(result)
    }

    @Test
    fun deletedMessageTrue() {
        chatService.addNewMessage(1, 2, "delete message")
        val result = chatService.deleteMessage(2, 1)
        assertTrue(result)
    }

    @Test
    fun deleteMessageFalse() {
        chatService.addNewMessage(1, 2, "delete message")
        val result = chatService.deleteMessage(12, 11)
        assertFalse(result)
    }

    @Test
    fun updatedMessageTrue() {
        chatService.addNewMessage(1, 2, "message")
        val result = chatService.updateMessage(2, 1, "update message")
        assertTrue(result)
    }

    @Test
    fun updatedMessageFalseMessageError() {
        chatService.addNewMessage(1, 2, "message")
        val result = chatService.updateMessage(2, 1000, "update message")
        assertFalse(result)
    }

    @Test
    fun updatedMessageFalseUserError() {
        chatService.addNewMessage(1, 2, "message")
        val result = chatService.updateMessage(200, 1, "update message")
        assertFalse(result)
    }

    @Test
    fun getMessagesByMessageIdTrue() {
        chatService.addNewMessage(1, 2, "Fist message")
        val result = chatService.getMessagesByMessageId(1, 1)
        assertTrue(result)
    }

    @Test
    fun getMessagesByMessageIdFalseChatError() {
        chatService.addNewMessage(1, 2, "Fist message")
        val result = chatService.getMessagesByMessageId(1000, 1)
        assertFalse(result)
    }

    @Test
    fun getMessagesByMessageIdFalseMessageError() {
        chatService.addNewMessage(1, 2, "Fist message")
        val result = chatService.getMessagesByMessageId(1, 1000)
        assertFalse(result)
    }

    @Test
    fun getMessagesByCountTrue() {
        chatService.addNewMessage(1, 2, "Fist message")
        chatService.addNewMessage(1, 2, "Second message")
        chatService.addNewMessage(1, 2, "Third message")
        val result = chatService.getMessagesByCount(1, 2)
        assertTrue(result)
    }

    @Test
    fun getMessagesByCountFalse() {
        chatService.addNewMessage(1, 2, "Fist message")
        chatService.addNewMessage(1, 2, "Second message")
        chatService.addNewMessage(1, 2, "Third message")
        val result = chatService.getMessagesByCount(10, 2)
        assertFalse(result)
    }

    @Test
    fun getMessagesByChatIdTrue() {
        chatService.addNewMessage(1, 2, "Fist message")
        chatService.addNewMessage(1, 2, "Second message")
        chatService.addNewMessage(1, 2, "Third message")
        val result = chatService.getMessagesByChatId(1)
        assertTrue(result)
    }

    @Test
    fun getMessagesByChatIdFalse() {
        chatService.addNewMessage(1, 2, "Fist message")
        chatService.addNewMessage(1, 2, "Second message")
        chatService.addNewMessage(1, 2, "Third message")
        val result = chatService.getMessagesByChatId(10000)
        assertFalse(result)
    }

    @Test
    fun getCountUnreadMessageTrue() {
        chatService.addNewMessage(11, 1, "1")
        chatService.addNewMessage(11, 2, "2")
        chatService.addNewMessage(11, 3, "3")
        chatService.addNewMessage(11, 4, "4")
        chatService.addNewMessage(11, 5, "5")
        chatService.addNewMessage(11, 6, "6")
        val result = chatService.getCountUnreadMessage(11)
        assertEquals(6, result)
    }

}