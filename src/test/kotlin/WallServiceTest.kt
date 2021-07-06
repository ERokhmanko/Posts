import org.junit.Test

import org.junit.Assert.*

class WallServiceTest {

    @Test
    fun addPost() {
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

        val result = WallService().add(post = post)


        assertEquals(
            Post(
                id = 1,
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
            ),
            result
        )
    }

    @Test
    fun updateExisting() {
        // создаём целевой сервис
        val service = WallService()
        // заполняем несколькими постами
        service.add(
            Post(
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
        )

        service.add(
            Post(
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
                reposts = Reposts(count = 6, userReposted = null),
                attachment = null
            )
        )

        service.add(
            Post(
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
                attachment = null
            )
        )

        // создаём информацию об обновлении
        val update1 = Post(
            id = 3,
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
            attachment = null
        )

        // выполняем целевое действие
        val result = service.update(update1)

        // проверяем результат (используйте assertTrue или assertFalse)
        assertTrue(result)
    }

    @Test
    fun updateNonExisting() {// создаём целевой сервис
        val service = WallService()
        // заполняем несколькими постами
        service.add(
            Post(
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
        )

        service.add(
            Post(
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
                reposts = Reposts(count = 6, userReposted = null),
                attachment = null
            )
        )

        service.add(
            Post(
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
                attachment = null
            )
        )

        // создаём информацию об обновлении
        val update1 = Post(
            id = 5,
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
            attachment = null
        )

        // выполняем целевое действие
        val result = service.update(update1)

        // проверяем результат (используйте assertTrue или assertFalse)
        assertFalse(result)
    }

    @Test(expected = PostNotFoundException::class)
    fun shouldThrow() {
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

        val service = WallService()
        service.add(post)

        val comment = Comment(ownerId = 1, postId = 7, fromGroup = 1, message = "бла бла")

        service.createComment(comment)
    }
}