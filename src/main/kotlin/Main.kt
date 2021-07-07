import WallService as WallService

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
        postponedId = 8,
        comments = Comments(count = 1, canPost = true, groupsCanPost = true, canClose = false, canOpen = true),
        likes = Likes(count = 6, userLikes = true, canLike = true, canPublish = true),
        reposts = Reposts(count = 6, userReposted = null),
        attachment = null
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
        postponedId = 8,
        comments = Comments(count = 1, canPost = true, groupsCanPost = true, canClose = false, canOpen = true),
        likes = Likes(count = 6, userLikes = true, canLike = true, canPublish = true),
        reposts = Reposts(count = 6, userReposted = post),
        attachment = null
    )

    val video = Video(id = 1, data = 2L, title = "какое-то крутое видео", description = "бла бла бла", duration = 222)
    val video2 = Video(2, 3L, "ахахах, лол, смотреть всем",description = "бла бла бла", duration = 345)

    val videoAttachment = VideoAttachment(video = video)
    val videoAttachment2 = VideoAttachment(video = video2)

    val attachments = Attachments()

    attachments.add(videoAttachment)
    attachments.add(videoAttachment2)

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
        postponedId = 8,
        comments = Comments(count = 1, canPost = true, groupsCanPost = true, canClose = false, canOpen = true),
        likes = Likes(count = 6, userLikes = true, canLike = true, canPublish = true),
        reposts = Reposts(count = 6, userReposted = null),
        attachment = Attachments().add(videoAttachment)
    )
    val service = WallService()

    val addPost = service.add(post)
    val addPost2 = service.add(post2)
    val addPost3 = service.add(post3)

    println(service.update(addPost))
    println(service.isRepost(addPost2))
    println(service.isRepost(addPost3))

    service.printPost()

    attachments.printAttachments()

}