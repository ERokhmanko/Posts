import java.lang.RuntimeException

class PostNotFoundException(message: String) : RuntimeException(message)

class CommentNotFoundException(message: String) : RuntimeException(message)

class ReportNotFoundException(message: String) : RuntimeException(message)

class WallService {

    private var posts = emptyArray<Post>()
    private var comments = emptyArray<Comment>()
    private var reports = emptyArray<Report>()

    fun add(post: Post): Post {
        posts += post.copy(id = if (posts.isNotEmpty()) posts.last().id + 1 else 1)
        return posts.last()
    }

    fun createComment(comment: Comment) {
        for (post in posts)
            if (post.id == comment.postId) {
                comments += comment
                return
            }
        throw PostNotFoundException("Вы не можете добавить комментарий к этому посту. " +
                "Поста с id ${comment.postId} не существует")

    }

    fun reportComment(report: Report) {
        for (comment in comments)
            if (comment.id == report.commentId){
                if (report.reason in 0..8)
                    reports += report
                else throw ReportNotFoundException("Тип жалобы не существует")
            return}
        throw CommentNotFoundException("Комментарий, на который Вы оставляете жалобу, не существует")
    }

    fun update(post: Post): Boolean {
        for ((index, value) in posts.withIndex())
            if (value.id == post.id) {
                posts[index] = post.copy(id = posts[index].id, ownerId = posts[index].ownerId, date = posts[index].date)
                return true
            }
        return false
    }

    fun isRepost(post: Post): Boolean {
        return post.reposts?.userReposted != null
    }

    fun printPost() {
        for (post in posts)
            println(post)
    }
}