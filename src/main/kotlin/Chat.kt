open class Chat(
    val to: Int,
    val from: Int,
    val id: Int = 0,
    var message: MutableList<Message> = mutableListOf<Message>(),
) {

    override fun toString(): String {
        return "Chat$id(From = $from, To = $to, id=$id,\n" +
                "| messages=${message.joinToString (separator = ",\n"){ it.text }} ||\n" +
                "|__________|__________|__________|__________|\n"
    }


}