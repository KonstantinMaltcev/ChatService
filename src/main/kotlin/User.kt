 class User(val userId: Int, val name: String) {
    override fun toString(): String {
        return "User$userId: name = $name"
    }
}