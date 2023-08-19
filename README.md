# survival

This project is inspired by such libraries as [kyori/adventure](https://github.com/KyoriPowered/adventure) and [unnamed/creative](https://github.com/unnamed/creative). It aims to standardize commonly used objects such as World, Player, CommandSender in cross-platform plugins.

### Gradle example

```kts
repositories {
    maven("https://maven.melonhell.ru/public/")
}

dependencies {
    implementation("ru.melonhell.survival:api:0.0.1")
    implementation("ru.melonhell.survival:platform-bukkit:0.0.1")
}
```
