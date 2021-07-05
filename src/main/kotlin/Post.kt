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
    val comments: Comments,
    val likes: Likes,
    val reposts: Reposts

    )

class Comments(
    val count: Int, //количество комментариев.//
    val canPost: Boolean, // информация о том, может ли текущий пользователь комментировать запись
    val groupsCanPost: Boolean, //информация о том, могут ли сообщества комментировать запись
    val canClose: Boolean, // может ли текущий пользователь закрыть комментарии к записи
    val canOpen: Boolean //может ли текущий пользователь открыть комментарии к записи.
)

class Likes(
    val count: Int, //число пользователей, которым понравилась запись
    val userLikes: Boolean, // наличие отметки «Мне нравится» от текущего пользователя
    val canLike: Boolean, // информация о том, может ли текущий пользователь поставить отметку «Мне нравится»
    val canPublish: Boolean // информация о том, может ли текущий пользователь сделать репост записи
)

class Reposts(
    val count: Int, // число пользователей, скопировавших запись
    val userReposted: Post?  // есть ли оригинальный пост, null - если пост оригинальный
) {
    override fun toString(): String {
        return "Reposts(count=$count, userReposted=$userReposted)"
    }
}



