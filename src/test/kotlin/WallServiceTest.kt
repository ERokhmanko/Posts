import org.junit.Test

import org.junit.Assert.*
import org.junit.jupiter.api.Assertions

class WallServiceTest {

    @Test
    fun addPost() {
        val post : Post = Post(
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

        val result = WallService().add(post = post)


        assertEquals(Post(id = 1, ownerId = 3, fromId = 4, createdBy = 5, date = 7890123,
            text = "Третий пост", replyOwnerId = 5, replyPostId = 6, friendsOnly = true, postType = "reply", signerId = 7,
            canPin = true, canDelete = true, canEdit = false, isPinned = false, markedAsAds = false, isFavorite = true,
            postponedId = 8), result)
    }

    @Test
    fun updateExisting() {
        // создаём целевой сервис
        val service = WallService()
        // заполняем несколькими постами
        service.add(Post(
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
            postponedId = 8))

        service.add(Post(ownerId = 3,
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
            postponedId = 8))

        service.add(Post(ownerId = 2,
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
            postponedId = 8))

        // создаём информацию об обновлении
        val update1 = Post(
            id = 3,
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
            postponedId = 8)

        // выполняем целевое действие
        val result = service.update(update1)

        // проверяем результат (используйте assertTrue или assertFalse)
        assertTrue(result)
    }

    @Test
    fun updateNonExisting() {
        // создаём целевой сервис
        val service = WallService()
        // заполняем несколькими постами
        service.add(Post(
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
            postponedId = 8))

        service.add(Post(ownerId = 3,
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
            postponedId = 8))

        service.add(Post(ownerId = 2,
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
            postponedId = 8))

        // создаём информацию об обновлении
        val update1 = Post(
            id = 5,
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
            postponedId = 8)

        // выполняем целевое действие
        val result = service.update(update1)

        // проверяем результат (используйте assertTrue или assertFalse)
        assertFalse(result)
    }
}