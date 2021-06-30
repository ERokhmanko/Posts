class WallService {

    private var posts = emptyArray<Post>()

    fun add(post: Post): Post {
        posts += post

        for ((index, post) in posts.withIndex())
            posts[index] = post.copy(id = post.id + 1)

        return posts.last()
    }

    fun update(post: Post): Boolean {
        for ((index, value) in posts.withIndex())
            if (value.id == post.id) {
                posts[index] = post.copy(
                    id = post.id,
                    ownerId = post.ownerId,
                    fromId = post.fromId,
                    createdBy = post.createdBy,
                    text = "Обновлено",
                    replyOwnerId = post.replyOwnerId,
                    replyPostId = post.replyPostId,
                    friendsOnly = post.friendsOnly,
                    postType = post.postType,
                    signerId = post.signerId,
                    canPin = post.canPin,
                    canDelete = post.canDelete,
                    canEdit = post.canEdit,
                    isPinned = post.isPinned,
                    markedAsAds = post.markedAsAds,
                    isFavorite = post.isFavorite,
                    postponedId = post.postponedId)
                return true
            }
        return false
    }

    fun printPost() {
        for (post in posts)
            println(post)
    }
}