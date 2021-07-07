interface Attachment {
    val type: String
}

class Attachments {
    private var attachments = emptyArray<Attachment>()

    fun add(attachment: Attachment): Attachment {
        attachments += attachment
        return attachments.last()
    }

    fun printAttachments() {
        for (attachment in attachments)
            println(attachment)
    }
}

data class Video (val id: Int, val data: Long, val title: String, val description: String, val duration: Int)

data class VideoAttachment(override val type: String = "video", val video: Video) : Attachment

data class Audio (val id: Int, val ownerId: Int, val artist: String, val title: String, val duration: Int)

data class AudioAttachment(override val type: String = "audio", val audio: Audio) : Attachment

data class Photo (val id: Int, val albumId: Int, val ownerId: Int, val text: String, val date: Long)

data class PhotoAttachment (override val type: String = "photo", val photo: Photo) : Attachment

data class Document(val id: Int, val ownerId: Int, val title: String, val size: Int, val ext: String,
               val url: String, val date: Long)

data class DocumentAttachment(override val type: String = "document", val document: Document) : Attachment

data class Sticker(val productId: Int, val stickerId: Int, val animationUrl: String, val isAllowed: Boolean)

data class StickerAttachment(override val type: String = "sticker", val sticker: Sticker) : Attachment