package co.init.tindom

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform