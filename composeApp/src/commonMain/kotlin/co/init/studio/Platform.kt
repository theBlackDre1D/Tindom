package co.init.studio

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform