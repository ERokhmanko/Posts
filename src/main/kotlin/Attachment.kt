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

class Video (val id: Int, val data: Long, val title: String, val description: String, val duration: Int) {
    override fun toString(): String {
        return "Video(id=$id, data=$data, title='$title', description='$description', duration=$duration)"
    }
}

class VideoAttachment(override val type: String = "video", val video: Video) : Attachment {
    override fun toString(): String {
        return "VideoAttachment(type='$type', video=$video)"
    }
}

class Audio (val id: Int, val ownerId: Int, val artist: String, val title: String, val duration: Int) {
    override fun toString(): String {
        return "Audio(id=$id, ownerId=$ownerId, artist='$artist', title='$title', duration=$duration)"
    }
}

class AudioAttachment(override val type: String = "audio", val audio: Audio) : Attachment{
    override fun toString(): String {
        return "AudioAttachment(type='$type', audio=$audio)"
    }
}

class Photo (val id: Int, val albumId: Int, val ownerId: Int, val text: String, val date: Long){
    override fun toString(): String {
        return "Photo(id=$id, albumId=$albumId, ownerId=$ownerId, text='$text', date=$date)"
    }
}

class PhotoAttachment (override val type: String = "photo", val photo: Photo) : Attachment {
    override fun toString(): String {
        return "PhotoAttachment(type='$type', photo=$photo)"
    }
}

class Document(val id: Int, val ownerId: Int, val title: String, val size: Int, val ext: String,
               val url: String, val date: Long){
    override fun toString(): String {
        return "Document(id=$id, ownerId=$ownerId, title='$title', size=$size, ext='$ext', url='$url', date=$date)"
    }
}

class DocumentAttachment(override val type: String = "document", val document: Document) : Attachment{
    override fun toString(): String {
        return "DocumentAttachment(type='$type')"
    }
}

class Sticker(val productId: Int, val stickerId: Int, val animationUrl: String, val isAllowed: Boolean){
    override fun toString(): String {
        return "Sticker(productId=$productId, stickerId=$stickerId, animationUrl='$animationUrl', isAllowed=$isAllowed)"
    }
}
class StickerAttachment(override val type: String = "sticker", val sticker: Sticker) : Attachment{
    override fun toString(): String {
        return "StickerAttachment(type='$type', sticker=$sticker)"
    }
}