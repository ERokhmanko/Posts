import WallService as WallService

data class Post(
    val id: Int = 0,
    val ownerId: Int,
    val fromId: Int,
    val createdBy: Int,
    val date: Long,
    val text: String,
    val replyOwnerId: Int,
    val replyPostId: Int,
    val friendsOnly: Boolean,
    val postType: String,
    val signerId: Int,
    val canPin: Boolean,
    val canDelete: Boolean,
    val canEdit: Boolean,
    val isPinned: Boolean,
    val markedAsAds: Boolean,
    val isFavorite: Boolean,
    val postponedId: Int,
)

fun main() {
    val post = Post(
        ownerId = 2,
        fromId = 3,
        createdBy = 4,
        date = 123456,
        text = "Какой-то пост",
        replyOwnerId = 5,
        replyPostId = 6,
        friendsOnly = true,
        postType = "reply",
        signerId = 7,
        canPin = true,
        canDelete = true,
        canEdit = false,
        isPinned = false,
        markedAsAds = false,
        isFavorite = true,
        postponedId = 8
    )

    val post2 = Post(
        ownerId = 3,
        fromId = 4,
        createdBy = 5,
        date = 7890123,
        text = "Еще какой-то пост",
        replyOwnerId = 5,
        replyPostId = 6,
        friendsOnly = true,
        postType = "reply",
        signerId = 7,
        canPin = true,
        canDelete = true,
        canEdit = false,
        isPinned = false,
        markedAsAds = false,
        isFavorite = true,
        postponedId = 8
    )

    val post3 = Post(
        ownerId = 3,
        fromId = 4,
        createdBy = 5,
        date = 7890123,
        text = "Третий пост",
        replyOwnerId = 5,
        replyPostId = 6,
        friendsOnly = true,
        postType = "reply",
        signerId = 7,
        canPin = true,
        canDelete = true,
        canEdit = false,
        isPinned = false,
        markedAsAds = false,
        isFavorite = true,
        postponedId = 8
    )
    val service = WallService()
    val addPost = service.add(post)
    val addPost2 = service.add(post2)
    val addPost3 = service.add(post3)

    println(service.update(addPost))

    service.printPost()

}