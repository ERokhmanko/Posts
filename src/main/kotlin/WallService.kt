class WallService {

    private var posts = emptyArray<Post>()

    fun add(post: Post): Post {
        posts += post.copy(id = if (posts.isNotEmpty()) posts.last().id + 1 else 1)
        return posts.last()
    }

    fun update(post: Post): Boolean {
        for ((index, value) in posts.withIndex())
            if (value.id == post.id) {
                posts[index] = post.copy(id = posts[index].id, ownerId = posts[index].ownerId, date = posts[index].date)
                return true
            }
        return false
    }

    fun isRepost(post: Post) : Boolean {
        return post.reposts?.userReposted != null
    }

    fun printPost() {
        for (post in posts)
            println(post)
    }
}